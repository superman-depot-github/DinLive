package com.dinlive.din.UI.Base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.dinlive.din.utils.ActTaskUtil;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<V, P extends BasePresenter<V>> extends RxAppCompatActivity implements IBaseView {
    protected P mPresenter;
    protected Unbinder unBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        unBinder = ButterKnife.bind(this);
        ActTaskUtil.getInstance().push(this);
        mPresenter = createPresenter();
        if (mPresenter != null) {
            mPresenter.attachView((V) this);
        }

        initView();
        initListener();
        initData();
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
}
