package com.dinlive.din.baselib.net.retrofit;


import com.dinlive.din.baselib.BuildConfig;
import com.dinlive.din.baselib.net.okhttp.OkHttpHelper;
import com.dinlive.din.baselib.net.rxjava.converter.ResponseConverterFactory;
import com.dinlive.din.baselib.net.service.ApiService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

/**
 * Created by superman on 2019/6/28.
 */
public class RetrofitHelper {
    private static Retrofit retrofit;

    static {
        retrofit = new Retrofit
                .Builder()
                .baseUrl(BuildConfig.IS_DEBUG==true?ApiService.BASEURL_DEBUG:ApiService.BASEURL_DEV)
                .addConverterFactory(ResponseConverterFactory.create())
//                .addConverterFactory(CustomGsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(OkHttpHelper.getOkHttpClient())
                .build();
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }
}
