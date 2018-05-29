package com.example.administrator.mvphero.retrofit.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/5/29.
 */

public class PhoneLoginResponseBean extends ResponseBean{
    private UserInfo data;

    public UserInfo getData() {
        return data;
    }

    public void setData(UserInfo data) {
        this.data = data;
    }

    public class UserInfo{
        public String description;
        public String email;
        public String name;
        public String city;
        public Object icon;
        @SerializedName("icon-url")
        public String icon_url;
        @SerializedName("reg-type")
        public int reg_type;
        public String token;
        public String id;
        public long mobile;
        public String province;
        public String country;

        public int sex = -1;
        public int age;
    }
}
