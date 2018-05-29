package com.example.administrator.mvphero.retrofit.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/29.
 */

public class PhoneLoginRequestBean implements Serializable{
    private long mobile;
    @SerializedName("login-type")
    private int loginType = 0;
    private String password;
    @SerializedName("country-code")
    private int countryCode;

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(int countryCode) {
        this.countryCode = countryCode;
    }
}
