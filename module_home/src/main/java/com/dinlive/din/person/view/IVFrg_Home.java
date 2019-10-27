package com.dinlive.din.person.view;

import com.dinlive.din.baselib.base.IBaseView;
import com.dinlive.din.baselib.model.NewsDetailedBean;
import com.dinlive.din.baselib.net.rxjava.converter.ResultException;

public interface IVFrg_Home extends IBaseView {
    void recommendListSuccess(int loadType, NewsDetailedBean newsDetailedBean);

    void recommendListFaild(int loadType, ResultException exception);
}
