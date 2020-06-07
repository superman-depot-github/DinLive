package com.dinlive.din.baselib.wiget.ninerecyclerview;

import android.view.View;
import android.view.ViewGroup;

/**
 * @author daifalin
 * @date 2019-11-01 16:34
 * @ClassName BGAOnItemChildClickListener
 * @Description AdapterView和RecyclerView的item中子控件点击事件监听器
 */
public interface BGAOnItemChildClickListener {
    void onItemChildClick(ViewGroup parent, View childView, int position);
}
