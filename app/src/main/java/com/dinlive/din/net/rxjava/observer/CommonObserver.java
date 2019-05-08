package com.dinlive.din.net.rxjava.observer;


import com.dinlive.din.net.result.ExceptionHandle;
import com.dinlive.din.net.result.HttpRespResult;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

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
        //e.printStackTrace();
        onError(ExceptionHandle.handleException(e));
    }

    @Override
    public void onComplete() {

    }

    protected abstract void onSuccess(D d);

    protected abstract void onError(ExceptionHandle.ResponseException exception);
}
