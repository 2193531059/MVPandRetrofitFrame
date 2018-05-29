package com.example.administrator.mvphero.view;

import com.example.administrator.mvphero.retrofit.ExceptionHandler;

/**
 * Created by Administrator on 2018/5/29.
 */

public interface ViewHandler {
    void showLoginDialog();
    void dissmissLoginDialog();
    void loginFinish();
    void loginError(ExceptionHandler handler);
}
