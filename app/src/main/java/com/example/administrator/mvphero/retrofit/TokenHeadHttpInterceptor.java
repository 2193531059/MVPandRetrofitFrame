package com.example.administrator.mvphero.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/5/29.
 */

public class TokenHeadHttpInterceptor implements Interceptor{
    private String token;

    public void setToken(String token){
        this.token = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        Request request = builder
                .addHeader("Content-type", "application/json")
                .addHeader("Accept", "application/json")
                .addHeader("authorization", "Token " + token)
                .build();
        return chain.proceed(request);
    }
}
