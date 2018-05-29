package com.example.administrator.mvphero.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.example.administrator.mvphero.R;
import com.example.administrator.mvphero.presenter.BasePresenter;

public abstract class BaseFragment<V, P extends BasePresenter<V>> extends Fragment{
    private P mPresenter;
    protected Activity mActivity;
    protected View mRootView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(setLayoutId(), null, false);
        }
        mActivity.setTheme(R.style.Theme_AppCompat_Light_NoActionBar);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = mActivity.getWindow();
            window.setStatusBarColor(getResources().getColor(R.color.action_bar_blue));
        }

        initData();

        initView();

        setListener();

        return mRootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = getActivity();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }

    public abstract int setLayoutId();
    public abstract P createPresenter();
    public abstract void initView();
    public abstract void initData();
    public abstract void setListener();
}
