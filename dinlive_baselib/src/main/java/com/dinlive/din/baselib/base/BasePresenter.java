package com.dinlive.din.baselib.base;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public class BasePresenter<V> {
    private Reference<V> mViewRef;
    public void attachView( V view) {
        mViewRef = new WeakReference<V>(view);
    }

    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    public V getView() {
        return mViewRef != null ? mViewRef.get() : null;
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }
}
