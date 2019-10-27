package com.dinlive.din.person;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ToastUtils;
import com.dinlive.din.baselib.base.BaseActivity;
import com.dinlive.din.baselib.base.BasePresenter;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.dinlive.din.person.widget.loopview.DataWheelView;

import butterknife.BindView;

@Route(path = ARouterHub.PERSON_TIMEUTILS_ACTIVITY, name = "时间类工具")
public class TimeUtilsActivity extends BaseActivity {
    @BindView(R2.id.startLoopViewData)
    DataWheelView startLoopViewData;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_timeutils;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        setTitle("时间类工具");
        startLoopViewData.setTitleName("开始日期");
        startLoopViewData.setTitleColor(0xffff0000);
        //startLoopViewData.setTitleBackground(color);
        //startLoopViewData.setNotLoop();   //设置时间不可循环重复滚动
        startLoopViewData.showDescribe(false);
        startLoopViewData.setListenerOKClick(new DataWheelView.OnListenerOKClick() {
            @Override
            public void selectData(String dataString) {
                ToastUtils.showShort(dataString);
            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
