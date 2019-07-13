package com.dinlive.din.baselib.Base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dinlive.din.baselib.R;
import com.dinlive.din.baselib.wiget.stateview.StateView;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.jessyan.autosize.internal.CustomAdapt;

public abstract class BaseFragment<V, P extends BasePresenter<V>> extends MySupportFragment implements CustomAdapt, IBaseView {
    Toolbar toolbar;
    TextView mBarTitle;
    TextView mBarRight;

    protected RxAppCompatActivity mActivity;
    protected View mRootView;
    protected P mPresenter;
    protected Unbinder unBinder;
    protected StateView mStateView;//用于显示加载中、网络异常，空布局、内容布局

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (RxAppCompatActivity) context;
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

    /**
     * 初始化ToolBar
     */
    private void initToolBar() {
        toolbar = mRootView.findViewById(R.id.toolbar);
        mBarTitle = mRootView.findViewById(R.id.bar_title);
        mBarRight = mRootView.findViewById(R.id.bar_right);
        //判断是否有Toolbar,并默认显示返回按钮
        if (null != toolbar) {
            toolbar.setNavigationOnClickListener(v -> {
                setNavigationOnClickListener();
            });
        }
    }

    public void setNavigationOnClickListener() {
        getActivity().finish();
    }

    @Override
    public void gotoAct(Intent intent) {
        startActivity(intent);
    }

    @Override
    public void gotoActAndFinish(Intent intent) {
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void gotoAct(Class activity) {
        Intent intent = new Intent(getActivity(), activity);
        startActivity(intent);
    }

    @Override
    public void gotoActAndFinish(Class activity) {
        Intent intent = new Intent(getActivity(), activity);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void gotoActAndClearTask(Class activity) {
        Intent intent = new Intent(getActivity(), activity);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void gotoActAndClearTop(Class activity) {
        Intent intent = new Intent(getActivity(), activity);
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
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }

        if (unBinder != null) {
            unBinder.unbind();
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
