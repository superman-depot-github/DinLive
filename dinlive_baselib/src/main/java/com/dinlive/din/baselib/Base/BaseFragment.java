package com.dinlive.din.baselib.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.launcher.ARouter;
import com.dinlive.din.baselib.R;
import com.dinlive.din.baselib.utils.EventBusUtils;
import com.dinlive.din.baselib.wiget.stateview.StateView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.tbruyelle.rxpermissions2.RxPermissions;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.jessyan.autosize.internal.CustomAdapt;

public abstract class BaseFragment<V, P extends BasePresenter<V>> extends MySupportFragment implements CustomAdapt, OnRefreshListener, OnLoadMoreListener {
    private TextView mBarTitle;
    private TextView mBarRight;
    protected RxAppCompatActivity mActivity;
    protected View mRootView;
    protected P mPresenter;
    protected Unbinder unBinder;
    protected StateView mStateView;//用于显示加载中、网络异常，空布局、内容布局
    protected  RxPermissions rxPermissions;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (RxAppCompatActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        rxPermissions = new RxPermissions(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mPresenter = createPresenter();
        mRootView = inflater.inflate(getLayoutId(), container, false);
        unBinder = ButterKnife.bind(this, mRootView);
        if (mPresenter != null) {
            mPresenter.attachView((V) this);//因为之后所有的子类都要实现对应的View接口
        } else {
            mPresenter = createPresenter();
        }
        mStateView = StateView.inject(mRootView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initToolBar();
        initView(mRootView);
        initListener();
        initData();
    }

    protected abstract int getLayoutId();

    protected abstract P createPresenter();

    protected abstract void initView(View mRootView);

    protected abstract void initListener();

    protected abstract void initData();
//*****************************************EventBus事件分发子类*********************************************
    /**
     * 是否订阅Bus事件
     * 你的activity 或者fragment 想要收到外界发送的消息 就得实现该方法并返回true
     *
     * @return
     */
    protected boolean isRegisterEvent() {
        return false;
    }

    /**
     * EventBus 接收事件并分发给子类
     *
     * @return
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Object event) {
        eventBusHandle(event);
    }

    /**
     * 子类实现
     *
     * @param event
     */
    protected void eventBusHandle(Object event) {

    }

    //*****************************************屏幕尺寸和方向************************************************

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

    //*****************************************状态栏和ToolBar************************************************

    /**
     * 初始化ToolBar
     */
    private void initToolBar() {
        mBarTitle = mRootView.findViewById(R.id.bar_title);
        mBarRight = mRootView.findViewById(R.id.bar_right);
        //判断是否有Toolbar,并默认显示返回按钮
        if (null != getToolbar() && isShowBacking()) {
            setNavigationIcon(R.drawable.vector_back);
            getToolbar().setNavigationOnClickListener(v -> {
                setNavigationOnClickListener();
            });
        }
    }

    /**
     * 后退按钮图片
     */
    public void setNavigationIcon(@DrawableRes int resId) {
        getToolbar().setNavigationIcon(resId);
    }


    /**
     * 是否显示后退按钮,默认显示,可在子类重写该方法.
     *
     * @return
     */
    public boolean isShowBacking() {
        return true;
    }

    /**
     * this Activity of tool bar.
     * 获取头部.
     *
     * @return support.v7.widget.Toolbar.
     */
    public Toolbar getToolbar() {
        return mRootView.findViewById(R.id.toolbar);
    }

    public void setNavigationOnClickListener() {
        getActivity().finish();
    }

    /**
     * 设置头部标题
     *
     * @param title
     */
    public void setBarTitle(CharSequence title) {
        if (null != mBarTitle) {
            mBarTitle.setText(title);
        }
    }

    /**
     * 设置右边的文字和颜色
     *
     * @return
     */
    public void setBarTitle(CharSequence title, @ColorInt int colorInt) {
        if (null != mBarTitle) {
            mBarTitle.setText(title);
            mBarTitle.setTextColor(colorInt);
        }
    }

    /**
     * 设置右边的文字
     *
     * @return
     */
    public void setBarRightText(CharSequence subTitle) {
        if (null != mBarRight) {
            mBarRight.setText(subTitle);
        }
    }

    /**
     * 设置右边的文字和颜色
     *
     * @return
     */
    public void setBarRightText(CharSequence subTitle, @ColorInt int colorInt) {
        if (null != mBarRight) {
            mBarRight.setText(subTitle);
            mBarRight.setTextColor(colorInt);
        }
    }

    /**
     * 设置右边的文字的点击监听
     *
     * @param listener
     */
    public void setOnClickRightTextListener(View.OnClickListener listener) {
        if (null != mBarRight && null != listener) {
            mBarRight.setOnClickListener(listener);
        }
    }

    //*****************************************下拉刷新和上拉加载更多************************************************

    /**
     * 加载更多
     *
     * @param refreshLayout
     */
    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {

    }

    /**
     * 下拉刷新
     *
     * @param refreshLayout
     */
    @Override
    public void onRefresh(@NonNull RefreshLayout refreshLayout) {

    }

    //*****************************************生命周期相关*********************************************

    /**
     * 界面可见之前
     */
    @Override
    public void onStart() {
        super.onStart();
        if (isRegisterEvent()) {
            EventBusUtils.register(this);
        }
    }

    /**
     * 界面停止处于后台
     */
    @Override
    public void onStop() {
        super.onStop();
        if (isRegisterEvent()) {
            EventBusUtils.unregister(this);
        }
    }

    /**
     * 界面销毁释放资源
     */
    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }

        if (unBinder != null) {
            unBinder.unbind();
        }

        if (mStateView != null) {
            mStateView = null;
        }
    }
}
