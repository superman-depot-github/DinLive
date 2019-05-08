package com.dinlive.din.net.okhttp;


import com.dinlive.din.utils.LogUtil;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.FormBody;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;


public class OkHttpHelper {
    private static OkHttpClient okHttpClient;
    static {
        okHttpClient = new OkHttpClient()
                .newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .addInterceptor(new LogInterceptor())
                .build();
    }

    public static OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    public static class LogInterceptor implements Interceptor {

        public static String TAG = "LogInterceptor";

        @Override
        public okhttp3.Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            long startTime = System.currentTimeMillis();
            okhttp3.Response response = chain.proceed(chain.request());
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            okhttp3.MediaType mediaType = response.body().contentType();
            String content = response.body().string();
            LogUtil.i("------------------Start------------------");
            LogUtil.i(request.toString());
            String method = request.method();
            if ("POST".equals(method)) {
                StringBuilder sb = new StringBuilder();
                if (request.body() instanceof FormBody) {
                    FormBody body = (FormBody) request.body();
                    for (int i = 0; i < body.size(); i++) {
                        sb.append(body.encodedName(i) + "=" + body.encodedValue(i) + ",");
                    }
                    sb.delete(sb.length() - 1, sb.length());
                    LogUtil.i("RequestParams:{" + sb.toString() + "}");
                }
            }
            LogUtil.i("Response:" + content);
            LogUtil.i("End:" + duration + "毫秒");
            LogUtil.i("-------------------End-------------------");
            return response.newBuilder().body(okhttp3.ResponseBody.create(mediaType, content)).build();
        }
    }
}
