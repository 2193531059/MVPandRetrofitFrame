package com.example.administrator.mvphero.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.mvphero.MainActivity;
import com.example.administrator.mvphero.R;
import com.example.administrator.mvphero.custom.EditTextWithDel;
import com.example.administrator.mvphero.presenter.BasePresenter;
import com.example.administrator.mvphero.presenter.Presenter;
import com.example.administrator.mvphero.retrofit.ExceptionHandler;
import com.example.administrator.mvphero.util.PreferenceUtil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dmax.dialog.SpotsDialog;

public class LoginFragment extends BaseFragment implements ViewHandler, View.OnClickListener{
    private static final String TAG = "LoginFragment";
    private Presenter presenter;
    private SpotsDialog mSpotsDialog;
    private EditTextWithDel mobile_text, password_text;
    private Button login_button;

    @Override
    public int setLayoutId() {
        Log.e(TAG, "setLayoutId: -----------------");
        return R.layout.login_fragment_layout;
    }

    @Override
    public BasePresenter createPresenter() {
        presenter = new Presenter(mActivity, this);
        return presenter;
    }

    @Override
    public void initView() {
        if (mRootView == null) {
            return;
        }
        mobile_text = mRootView.findViewById(R.id.mobile_text);
        password_text = mRootView.findViewById(R.id.password_text);
        login_button = mRootView.findViewById(R.id.login_button);

        mSpotsDialog = new SpotsDialog(mActivity, getString(R.string.logining));
    }

    @Override
    public void initData() {

    }

    @Override
    public void setListener() {
        login_button.setOnClickListener(this);
    }

    @Override
    public void showLoginDialog() {
        mSpotsDialog.show();
    }

    @Override
    public void dissmissLoginDialog() {
        if (mSpotsDialog.isShowing()) {
            mSpotsDialog.dismiss();
        }
    }

    @Override
    public void loginFinish() {
        PreferenceUtil util = new PreferenceUtil(mActivity);
        String username = presenter.getLocalUser(util.getUid()).getUsername();
        Intent intent = new Intent(mActivity, MainActivity.class);
        intent.putExtra("username", username);
        startActivity(intent);
        mActivity.finish();
    }

    @Override
    public void loginError(ExceptionHandler handler) {
        Toast.makeText(mActivity, handler.getMessage() == null ? "未知错误" : handler.getMessage(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                String phoneNum = mobile_text.getText().toString();
                if (!isMobile(phoneNum)) {
                    Toast.makeText(mActivity, "电话号码错误!", Toast.LENGTH_SHORT).show();
                    return;
                }
                String password = password_text.getText().toString();
                presenter.loginByPhone(Long.parseLong(phoneNum), password, 86);
                break;
        }
    }

    private boolean isMobile(String mobiles){
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }
}
