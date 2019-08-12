package com.dinlive.din.baselib.net.service;

import com.dinlive.din.baselib.model.NewsDetailedBean;
import com.dinlive.din.baselib.model.SpecialListBean;
import com.dinlive.din.baselib.model.User;
import com.dinlive.din.baselib.model.VideoListBean;
import com.dinlive.din.baselib.net.result.HttpRespResult;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;

/**
 * Created by superman on 2019/6/28.
 */
public interface ApiService {
    String BASEURL_DEBUG = "http://192.168.1.5:8080/";
    String BASEURL_DEV = "http://test.cmsino.com/";
    @FormUrlEncoded
    @POST("login")
    @Headers("Content-Type:application/json;charset=utf-8")
//    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    Observable<HttpRespResult<User>> login(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("api/sms/sendsms")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    Observable<HttpRespResult<String>> getCode(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("api/sms/checksmscode")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    Observable<HttpRespResult<String>> checkSmsCode(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("api/user/register")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    Observable<HttpRespResult<User>> register(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("api/user/smslogin")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    Observable<HttpRespResult<User>> checkSmslogin(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("api/user/editnickname")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    Observable<HttpRespResult<User>> editNickName(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("api/user/editpassword")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    Observable<HttpRespResult<String>> editPassword(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("api/user/editemail")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    Observable<HttpRespResult<User>> editEmail(@FieldMap Map<String, String> map);

    @FormUrlEncoded
    @POST("api/user/editmobile")
    @Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    Observable<HttpRespResult<User>> editMobile(@FieldMap Map<String, String> map);

    @Multipart
    @POST("api/user/uploadhead")
        //@Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    Observable<HttpRespResult<User>> uploadHead(@PartMap Map<String, RequestBody> map, @Part MultipartBody.Part parts);

    @GET("api/article/speciallist")
        //@Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    Observable<HttpRespResult<SpecialListBean>> specialList(@QueryMap Map<String, String> map);

    @GET("api/article/videolist")
        //@Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    Observable<HttpRespResult<VideoListBean>> videoList(@QueryMap Map<String, String> map);

//    @GET("api/column/columnlist")
//        //@Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
//    Observable<HttpRespResult<ChannelListBean>> columnList(@QueryMap Map<String, String> map);

    @GET("api/article/recommendlist")
        //@Headers("Content-Type:application/x-www-form-urlencoded; charset=utf-8")
    Observable<HttpRespResult<NewsDetailedBean>> recommendList(@QueryMap Map<String, String> map);
}
