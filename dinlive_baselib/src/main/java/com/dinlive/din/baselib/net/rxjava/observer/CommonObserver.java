package com.dinlive.din.baselib.net.rxjava.observer;


import android.net.ParseException;

import com.dinlive.din.baselib.event.EventTags;
import com.dinlive.din.baselib.net.result.HttpRespResult;
import com.dinlive.din.baselib.net.rxjava.converter.ResultException;
import com.google.gson.JsonParseException;
import com.jeremyliao.liveeventbus.LiveEventBus;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by superman on 2019/6/28.
 */
public abstract class CommonObserver<D> implements Observer<HttpRespResult<D>> {


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(HttpRespResult<D> dHttpRespResult) {
        onSuccess(dHttpRespResult.getData());
    }

    @Override
    public void onError(Throwable e) {
        ResultException resultException;
        if (e instanceof ResultException) {
            resultException = (ResultException) e;//服务器分发下来的异常
        } else if (e instanceof JsonParseException || e instanceof JSONException || e instanceof ParseException) {
            resultException = new ResultException(-4, "数据解析错误");
        } else if (e instanceof ConnectException || e instanceof SocketTimeoutException || e instanceof UnknownHostException) {
            resultException = new ResultException(-3, "网络连接失败");

        } else if (e instanceof javax.net.ssl.SSLHandshakeException) {
            resultException = new ResultException(-2, "证书验证失败");
        } else {
            resultException = new ResultException(-1, "未知错误");
        }
        LiveEventBus.get().with(EventTags.NET_EXCEPTION).post(resultException);
        onError(resultException);
        e.printStackTrace();
    }

    @Override
    public void onComplete() {

    }

    protected abstract void onSuccess(D d);

    protected abstract void onError(ResultException exception);
}
