package com.example.administrator.mvphero.retrofit;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HttpInterceptor implements Interceptor{
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        Request request = builder.addHeader("Content-type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        return chain.proceed(request);
    }
}
