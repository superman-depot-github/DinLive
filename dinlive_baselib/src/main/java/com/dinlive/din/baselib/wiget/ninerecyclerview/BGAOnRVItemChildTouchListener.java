package com.dinlive.din.baselib.wiget.ninerecyclerview;

import android.view.MotionEvent;
import android.view.View;

/**
 * @author daifalin
 * @date 2019-11-01 16:48
 * @ClassName RecyclerView的item中子控件触摸事件监听器
 * @Description
 */
public interface BGAOnRVItemChildTouchListener {
    boolean onRvItemChildTouch(BGARecyclerViewHolder holder, View childView, MotionEvent event);
}