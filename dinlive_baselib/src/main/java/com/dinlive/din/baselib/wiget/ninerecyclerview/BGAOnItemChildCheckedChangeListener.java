package com.dinlive.din.baselib.wiget.ninerecyclerview;

import android.view.ViewGroup;
import android.widget.CompoundButton;

/**
 * @author daifalin
 * @date 2019-11-01 16:47
 * @ClassName BGAOnItemChildCheckedChangeListener
 * @Description AdapterView和RecyclerView的item中子控件选中状态变化事件监听器
 */
public interface BGAOnItemChildCheckedChangeListener {
    void onItemChildCheckedChanged(ViewGroup parent, CompoundButton childView, int position, boolean isChecked);
}
