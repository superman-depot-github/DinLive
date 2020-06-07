package com.dinlive.din.baselib.wiget.ninerecyclerview;

import android.view.View;
import android.view.ViewGroup;

/**
 * @author daifalin
 * @date 2019-11-01 16:44
 * @ClassName BGAOnRVItemLongClickListener
 * @Description RecyclerView的item长按事件监听器
 */
public interface BGAOnRVItemLongClickListener {
    boolean onRVItemLongClick(ViewGroup parent, View itemView, int position);
}