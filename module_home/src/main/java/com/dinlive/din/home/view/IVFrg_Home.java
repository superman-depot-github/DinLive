package com.dinlive.din.home.view;

import com.dinlive.din.baselib.Base.IBaseView;
import com.dinlive.din.baselib.model.NewsDetailedBean;
import com.dinlive.din.baselib.net.rxjava.converter.ResultException;

public interface IVFrg_Home extends IBaseView {
    void recommendListSuccess(int loadType, NewsDetailedBean newsDetailedBean);

    void recommendListFaild(int loadType, ResultException exception);
}
