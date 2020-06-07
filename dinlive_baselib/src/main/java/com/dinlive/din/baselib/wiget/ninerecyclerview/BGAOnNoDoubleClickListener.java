package com.dinlive.din.baselib.wiget.ninerecyclerview;

import android.view.View;

/**
 * @author daifalin
 * @date 2019-11-01 17:03
 * @ClassName BGAOnNoDoubleClickListener
 * @Description
 */

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:16/11/13 上午11:41
 * 描述:
 */
public abstract class BGAOnNoDoubleClickListener implements View.OnClickListener {
    private int mThrottleFirstTime = 1000;
    private long mLastClickTime = 0;

    public BGAOnNoDoubleClickListener() {
    }

    public BGAOnNoDoubleClickListener(int throttleFirstTime) {
        mThrottleFirstTime = throttleFirstTime;
    }

    @Override
    public void onClick(View v) {
        long currentTime = System.currentTimeMillis();
        if (currentTime - mLastClickTime > mThrottleFirstTime) {
            mLastClickTime = currentTime;
            onNoDoubleClick(v);
        }
    }

    public abstract void onNoDoubleClick(View v);
}
