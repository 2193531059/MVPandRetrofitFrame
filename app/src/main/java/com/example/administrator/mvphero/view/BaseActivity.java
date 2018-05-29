package com.example.administrator.mvphero.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.administrator.mvphero.R;

public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = "BaseActivity";
    private Fragment mFragment;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity_layout);
        Log.e(TAG, "onCreate: --------------------");
        if (mFragment == null) {
            mFragment = createFragment();
            if (mFragment != null) {
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_base, mFragment).commit();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }

    public abstract Fragment createFragment();
}
