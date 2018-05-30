package com.example.administrator.mvphero.login.view;

import android.support.v4.app.Fragment;

import com.example.administrator.mvphero.BaseActivity;

public class LoginActivity extends BaseActivity {
    private static final String TAG = "LoginActivity";
    private LoginFragment fragment;

    @Override
    public Fragment createFragment() {
        fragment = new LoginFragment();
        return fragment;
    }
}
