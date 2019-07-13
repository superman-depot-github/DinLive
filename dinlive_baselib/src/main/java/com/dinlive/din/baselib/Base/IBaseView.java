package com.dinlive.din.baselib.Base;

import android.content.Intent;

import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

/**
 * Created by superman on 2018/3/11.
 */

public interface IBaseView extends OnRefreshListener, OnLoadMoreListener {
    public static final int FIRSTLOAD = 0;
    public static final int LOADMORER = 1;
    public static final int REFRENSH = -1;

    void gotoAct(Intent intent);

    void gotoActAndFinish(Intent intent);

    void gotoAct(Class activity);

    void gotoActAndFinish(Class activity);

    void gotoActAndClearTask(Class activity);

    void gotoActAndClearTop(Class activity);
}
