package com.dinlive.din.baselib.wiget.ninerecyclerview;

import android.view.View;
import android.view.ViewGroup;

/**
 * @author daifalin
 * @date 2019-11-01 16:35
 * @ClassName BGAOnRVItemClickListener
 * @Description RecyclerView的item点击事件监听器
 */
public interface BGAOnRVItemClickListener {
    void onRVItemClick(ViewGroup parent, View itemView, int position);
}