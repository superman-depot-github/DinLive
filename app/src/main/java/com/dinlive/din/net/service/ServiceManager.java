package com.dinlive.din.net.service;


import com.dinlive.din.net.retrofit.RetrofitHelper;

public class ServiceManager {
    public static ApiService getApiService(){
        return  RetrofitHelper.getRetrofit().create(ApiService.class);
    }
}
