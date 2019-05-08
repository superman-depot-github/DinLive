package com.dinlive.din.net.rxjava.observable;


import com.dinlive.din.net.result.ExceptionHandle;
import com.dinlive.din.net.result.HttpRespResult;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class TransformerHelper {

    public static <T> ObservableTransformer<HttpRespResult<T>, HttpRespResult<T>> transformer() {
        return new ObservableTransformer<HttpRespResult<T>, HttpRespResult<T>>() {
            @Override
            public ObservableSource<HttpRespResult<T>> apply(Observable<HttpRespResult<T>> upstream) {
                return upstream
                        .concatMap(TransformerHelper.<T>checkCode())
                        .compose(TransformerHelper.<HttpRespResult<T>>schedulerTransf());
            }
        };
    }

    public static <T> Function<HttpRespResult<T>, ObservableSource<? extends HttpRespResult<T>>> checkCode() {
        return new Function<HttpRespResult<T>, ObservableSource<? extends HttpRespResult<T>>>() {
            @Override
            public ObservableSource<? extends HttpRespResult<T>> apply(HttpRespResult<T> tHttpRespResult) throws Exception {
                if (tHttpRespResult.getCode() != 200) {
                    return Observable.error(new ExceptionHandle.ServerException(new Throwable(tHttpRespResult.getMessage())
                            , tHttpRespResult.getMessage(), tHttpRespResult.getCode()));
                }
                return Observable.just(tHttpRespResult);
            }
        };
    }

    public static <T> ObservableTransformer<T, T> schedulerTransf() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }
}
