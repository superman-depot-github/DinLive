package com.dinlive.din.net.service;


import com.dinlive.din.UI.activity.model.User;
import com.dinlive.din.UI.fragment.model.RoomInfoBean;
import com.dinlive.din.net.result.HttpRespResult;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ApiService {
    String BASEURL = "http://192.168.3.73:8080/";

    @GET("login?")
    Observable<HttpRespResult<User>> login(@QueryMap Map<String, String> map);

    @GET("findAll")
    Observable<HttpRespResult<List<RoomInfoBean>>> findAll();

}
