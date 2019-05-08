package com.dinlive.din.app;

import android.app.Application;
import android.content.Context;


import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;


/**
 * Created by superman on 2018/4/9.
 */
public class MyAppliction extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        initRefrenshLayout();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    private void initRefrenshLayout() {

        SmartRefreshLayout.setDefaultRefreshHeaderCreator(new DefaultRefreshHeaderCreator() {//设置全局的Header构建器
            @Override
            public RefreshHeader createRefreshHeader(Context context, RefreshLayout layout) {
                return new ClassicsHeader(context)
                        .setDrawableSize(14)
                        .setTextSizeTitle(12)
                        .setAccentColor(0xffb5b5b5)//文字提示颜色
                        .setPrimaryColor(0xfffafafa)//全局设置主题颜色
                        .setEnableLastTime(false);//.setTimeFormat(new DynamicTimeFormat("更新于 %s"));//指定为经典Header，默认是 贝塞尔雷达Header
            }
        });

        SmartRefreshLayout.setDefaultRefreshFooterCreator(new DefaultRefreshFooterCreator() { //设置全局的Footer构建器
            @Override
            public RefreshFooter createRefreshFooter(Context context, RefreshLayout layout) {
                return new ClassicsFooter(context) //指定为经典Footer，默认是 BallPulseFooter
                        .setDrawableSize(14)
                        .setTextSizeTitle(12)
                        .setAccentColor(0xffb5b5b5)//文字提示颜色
                        .setPrimaryColor(0xfffafafa);//全局设置主题颜色
            }
        });
    }
}
