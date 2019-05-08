package com.dinlive.din.UI.Base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;
import com.trello.rxlifecycle2.components.support.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseFragment<V, P extends BasePresenter<V>> extends RxFragment implements IBaseView {
    protected RxAppCompatActivity mActivity;
    protected View mRootView;
    protected P mPresenter;
    protected Unbinder unBinder;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (RxAppCompatActivity) context;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);//因为之后所有的子类都要实现对应的View接口
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mRootView = inflater.inflate(getLayoutId(), container, false);
        unBinder = ButterKnife.bind(this, mRootView);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        initListener();
    }

    protected abstract int getLayoutId();

    protected abstract P createPresenter();

    protected abstract void initView();

    protected abstract void initListener();

    protected abstract void initData();


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
}
