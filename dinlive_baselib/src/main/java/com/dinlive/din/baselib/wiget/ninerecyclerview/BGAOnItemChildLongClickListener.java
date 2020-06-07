package com.dinlive.din.baselib.wiget.ninerecyclerview;

import android.view.View;
import android.view.ViewGroup;

/**
 * @author daifalin
 * @date 2019-11-01 16:47
 * @ClassName AdapterView和RecyclerView的item中子控件长按事件监听器
 * @Description
 */
public interface BGAOnItemChildLongClickListener {
    boolean onItemChildLongClick(ViewGroup parent, View childView, int position);
}
