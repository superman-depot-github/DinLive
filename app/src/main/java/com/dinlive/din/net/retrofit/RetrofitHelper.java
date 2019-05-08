package com.dinlive.din.net.retrofit;


import com.dinlive.din.net.okhttp.OkHttpHelper;
import com.dinlive.din.net.service.ApiService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static Retrofit retrofit;

    static {
        retrofit = new Retrofit
                .Builder()
                .baseUrl(ApiService.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OkHttpHelper.getOkHttpClient())
                .build();
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }
}
