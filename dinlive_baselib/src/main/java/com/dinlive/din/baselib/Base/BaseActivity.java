package com.dinlive.din.baselib.Base;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.BarUtils;
import com.dinlive.din.baselib.R;
import com.dinlive.din.baselib.event.EventTags;
import com.dinlive.din.baselib.net.rxjava.converter.ResultException;
import com.dinlive.din.baselib.utils.ActTaskUtil;
import com.jeremyliao.liveeventbus.LiveEventBus;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.jessyan.autosize.internal.CustomAdapt;
import xyz.bboylin.universialtoast.UniversalToast;

public abstract class BaseActivity<V, P extends BasePresenter<V>> extends MySupportActivity implements CustomAdapt, IBaseView {
    Toolbar toolbar;
    TextView mBarTitle;
    TextView mBarRight;
    protected P mPresenter;
    protected Unbinder unBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        setContentView(getLayoutId());
        unBinder = ButterKnife.bind(this);
        ActTaskUtil.getInstance().push(this);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }
        setPortraitScreen();
        initStatusBar();
        initToolBar();

        initView();
        initListener();
        initData();

        initNetEceptionListener();
    }

    protected abstract int getLayoutId();

    protected abstract P createPresenter();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initData();

    protected void initNetEceptionListener() {
        LiveEventBus.get()
                .with(EventTags.NET_EXCEPTION, ResultException.class)
                .observe(this, e -> {
                    switch (e.getCode()) {
                        case 3://需要从新登陆
                            UniversalToast.makeText(BaseActivity.this, e.getMessage(), UniversalToast.LENGTH_SHORT,
                                    UniversalToast.EMPHASIZE).showWarning();
                            break;
                        case 4://需要完善用户信息
                            UniversalToast.makeText(BaseActivity.this, e.getMessage(), UniversalToast.LENGTH_SHORT).setGravity(Gravity.BOTTOM, 0, 50).showWarning();
                            break;

                        default:
                            UniversalToast.makeText(BaseActivity.this, e.getMessage(), UniversalToast.LENGTH_SHORT).setGravity(Gravity.BOTTOM, 0, 50).showWarning();
                            break;
                    }
                });
    }

    @Override
    public void gotoAct(Intent intent) {
        startActivity(intent);
    }

    @Override
    public void gotoActAndFinish(Intent intent) {
        startActivity(intent);
        finish();
    }

    @Override
    public void gotoAct(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    @Override
    public void gotoActAndFinish(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
        finish();
    }

    @Override
    public void gotoActAndClearTask(Class activity) {
        Intent intent = new Intent(this, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void gotoActAndClearTop(Class activity) {
        Intent intent = new Intent(this, activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

    }

    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }

        if (unBinder != null) {
            unBinder.unbind();
        }

        ActTaskUtil.getInstance().pop(this);
    }

    /**
     * 更新状态栏颜色和状态栏透明度
     */
    public void initStatusBar() {
        BarUtils.setStatusBarLightMode(this, true);
    }

    /**
     * 初始化ToolBar
     */
    private void initToolBar() {
        toolbar = findViewById(R.id.toolbar);
        mBarTitle = findViewById(R.id.bar_title);
        mBarRight = findViewById(R.id.bar_right);
        //判断是否有Toolbar,并默认显示返回按钮
        if (null != toolbar) {
            toolbar.setNavigationOnClickListener(v -> this.finish());
        }
    }


    /**
     * 设置屏幕方向
     */
    public void setPortraitScreen() {
        if (isPortraitScreen()) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        } else {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    /**
     * 是否按照宽度进行等比例适配 (为了保证在高宽比不同的屏幕上也能正常适配, 所以只能在宽度和高度之中选一个作为基准进行适配)
     *
     * @return {@code true} 为按照宽度适配, {@code false} 为按照高度适配
     */
    @Override
    public boolean isBaseOnWidth() {
        return isPortraitScreen();
    }

    /**
     * 返回设计图上的设计尺寸, 单位 dp
     * {@link #getSizeInDp} 须配合 {@link #isBaseOnWidth()} 使用, 规则如下:
     * 如果 {@link #isBaseOnWidth()} 返回 {@code true}, {@link #getSizeInDp} 则应该返回设计图的总宽度
     * 如果 {@link #isBaseOnWidth()} 返回 {@code false}, {@link #getSizeInDp} 则应该返回设计图的总高度
     * 如果您不需要自定义设计图上的设计尺寸, 想继续使用在 AndroidManifest 中填写的设计图尺寸, {@link #getSizeInDp} 则返回 {@code 0}
     *
     * @return
     */
    @Override
    public float getSizeInDp() {
        return 0;
    }

    /**
     * Activity是否屏幕竖向显示
     *
     * @return true：竖向 flase：横向
     */
    public boolean isPortraitScreen() {
        return true;
    }
}
