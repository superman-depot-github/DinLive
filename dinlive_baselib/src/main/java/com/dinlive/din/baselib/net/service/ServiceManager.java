package com.dinlive.din.baselib.net.service;


import com.dinlive.din.baselib.net.retrofit.RetrofitHelper;

/**
 * Created by superman on 2019/6/28.
 */
public class ServiceManager {
    public static ApiService getApiService(){
        return  RetrofitHelper.getRetrofit().create(ApiService.class);
    }
}
