package com.dinlive.din.baselib.net.rxjava.observable;


import com.dinlive.din.baselib.net.result.HttpRespResult;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by superman on 2019/6/28.
 */
public class TransformerHelper {

    public static <T> ObservableTransformer<HttpRespResult<T>, HttpRespResult<T>> transformer() {
        return new ObservableTransformer<HttpRespResult<T>, HttpRespResult<T>>() {
            @Override
            public ObservableSource<HttpRespResult<T>> apply(Observable<HttpRespResult<T>> upstream) {
                return upstream
                        .compose(TransformerHelper.<HttpRespResult<T>>schedulerTransf());
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
