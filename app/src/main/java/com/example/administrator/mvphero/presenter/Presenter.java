package com.example.administrator.mvphero.presenter;

import android.content.Context;
import android.util.Log;

import com.example.administrator.mvphero.model.DataHandler;
import com.example.administrator.mvphero.model.DataHandlerImpl;
import com.example.administrator.mvphero.retrofit.ExceptionHandler;
import com.example.administrator.mvphero.retrofit.RetrofitAPI;
import com.example.administrator.mvphero.retrofit.RetrofitManager;
import com.example.administrator.mvphero.retrofit.bean.PhoneLoginRequestBean;
import com.example.administrator.mvphero.retrofit.bean.PhoneLoginResponseBean;
import com.example.administrator.mvphero.sqlite.bean.User;
import com.example.administrator.mvphero.view.ViewHandler;

import java.util.Date;
import java.util.Random;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class Presenter extends BasePresenter {
    private DataHandler dataHandler;
    private ViewHandler viewHandler;

    public Presenter(Context context, ViewHandler viewHandler) {
        this.viewHandler = viewHandler;
        dataHandler = new DataHandlerImpl(context);
    }

    public void loginByPhone(long phoneNum, final String password, int countryCode){
        showLoginDialog();
        PhoneLoginRequestBean bean = new PhoneLoginRequestBean();
        bean.setCountryCode(countryCode);
        bean.setMobile(phoneNum);
        bean.setPassword(password);

        RetrofitAPI api = RetrofitManager.getRetrofit().create(RetrofitAPI.class);
        api.phoneLogin(bean)
                .subscribeOn(Schedulers.newThread())
                .observeOn(Schedulers.io())
                .doOnNext(new Action1<PhoneLoginResponseBean>() {
                    @Override
                    public void call(PhoneLoginResponseBean phoneLoginResponseBean) {
                        saveData(userCreat(phoneLoginResponseBean, password));
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<PhoneLoginResponseBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        dissmissLoginDialog();
                        ExceptionHandler handler = new ExceptionHandler(e.getMessage());
                        loginError(handler);
                    }

                    @Override
                    public void onNext(PhoneLoginResponseBean phoneLoginResponseBean) {
                        dissmissLoginDialog();
                        if (phoneLoginResponseBean.getCode() != 0) {
                            ExceptionHandler handler = new ExceptionHandler(phoneLoginResponseBean.getMessage());
                            loginError(handler);
                        } else {
                            loginFinish();
                        }
                    }
                });

    }

    private void showLoginDialog(){
        if (viewHandler != null) {
            viewHandler.showLoginDialog();
        }
    }

    private void dissmissLoginDialog(){
        if (viewHandler != null) {
            viewHandler.dissmissLoginDialog();
        }
    }

    private void loginFinish(){
        if (viewHandler != null) {
            viewHandler.loginFinish();
        }
    }

    private void loginError(ExceptionHandler handler){
        if (viewHandler != null) {
            viewHandler.loginError(handler);
        }
    }

    private void saveData(User user){
        if (dataHandler != null) {
            dataHandler.saveUserData(user);
        }
    }

    public User getLocalUser(String id){
        User user = null;
        if (dataHandler != null) {
            user = dataHandler.getLocalUser(id);
        }
        return user;
    }

    private User userCreat(PhoneLoginResponseBean loginPhoneResponseStorer, final String password){
        PhoneLoginResponseBean.UserInfo userData = loginPhoneResponseStorer.getData();

        User user = new User();
        String userName = userData.name;
        long mobile = userData.mobile;
        String userID = userData.id;
        String email = userData.email;
        String country = userData.country;
        String province = userData.province;
        String city = userData.city;
        int regType = userData.reg_type;
        String token = userData.token;
        String iconUrl = userData.icon_url;
        Random random = new Random();
        int rand = random.nextInt(1000);
        iconUrl += "?" + rand;

        user.setId(userID);
        user.setUsername(userName);
        user.setMobile(mobile);
        user.setEmail(email);
        user.setCountry(country);
        user.setProvince(province);
        user.setCity(city);
        user.setRegtype(regType);
        user.setToken(token);
        user.setHeadPhoto(iconUrl);
        if (password != null) {
            user.setPassword(password);
        }
        return user;
    }
}
