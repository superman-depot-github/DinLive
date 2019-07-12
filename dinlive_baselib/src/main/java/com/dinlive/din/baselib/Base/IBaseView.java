package com.dinlive.din.baselib.Base;

import android.content.Intent;

import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * Created by superman on 2018/3/11.
 */

public interface IBaseView extends OnRefreshListener, OnLoadMoreListener {

    void gotoAct(Intent intent);

    void gotoActAndFinish(Intent intent);

    void gotoAct(Class activity);

    void gotoActAndFinish(Class activity);

    void gotoActAndClearTask(Class activity);

    void gotoActAndClearTop(Class activity);
}
