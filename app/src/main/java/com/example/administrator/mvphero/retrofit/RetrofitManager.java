package com.example.administrator.mvphero.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/5/29.
 */

public class RetrofitManager {
    private static final String APP_BASE_URL = "http://app.nighthero.net";
    private static final String WECHAT_BASE_URL = "https://api.weixin.qq.com";
    private static final String SINA_BASE_URL = "https://api.weibo.com";

    public static Retrofit getRetrofit(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(new HttpInterceptor());

        return new Retrofit.Builder()
                .baseUrl(APP_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
    }

    public static Retrofit getWeChatRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(WECHAT_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getSinaRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(SINA_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Retrofit getTokenHeadRetrofit(String token){
        TokenHeadHttpInterceptor interceptor = new TokenHeadHttpInterceptor();
        interceptor.setToken(token);
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(interceptor);

        return new Retrofit.Builder()
                .baseUrl(APP_BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();
    }
}
