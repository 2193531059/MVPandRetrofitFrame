package com.example.administrator.mvphero.retrofit;

import com.example.administrator.mvphero.retrofit.bean.PhoneLoginRequestBean;
import com.example.administrator.mvphero.retrofit.bean.PhoneLoginResponseBean;

import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

public interface RetrofitAPI {

    @POST("/accounts/signin")
    Observable<PhoneLoginResponseBean> phoneLogin(@Body PhoneLoginRequestBean bean);
}
