package com.dinlive.din.home;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dinlive.din.baselib.Base.BaseFragment;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.dinlive.din.baselib.utils.ToastUtils;
import com.dinlive.din.baselib.wiget.PowerfulRecyclerView;
import com.dinlive.din.baselib.wiget.stateview.StateView;
import com.dinlive.din.baselib.wiget.stateview.TipView;
import com.dinlive.din.home.presenter.PFrg_Home;
import com.dinlive.din.home.view.IVFrg_Home;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import butterknife.BindView;

@Route(path = ARouterHub.HOME_FRAGMENT_HOME, name = "首页")
public class Fragment_home extends BaseFragment<IVFrg_Home, PFrg_Home> implements IVFrg_Home {
    @BindView(R2.id.tip_view)
    TipView mTipView;
    @BindView(R2.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R2.id.rv_news)
    PowerfulRecyclerView rv;
    @BindView(R2.id.StateView)
    StateView stateView;

    protected int getLayoutId() {
        return R.layout.fragment_favorite;
    }

    @Override
    protected PFrg_Home createPresenter() {
        return new PFrg_Home();
    }

    @Override
    protected void initView(View v) {

    }

    @Override
    protected void initListener() {
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setOnLoadMoreListener(this);
        stateView.setOnRetryClickListener(new StateView.OnRetryClickListener() {
            @Override
            public void onRetryClick() {
                ToastUtils.show("hahahhaa");
                ARouter.getInstance()
                        .build(ARouterHub.LOGIN_ACTIVITY)
                        .navigation(getActivity());
            }
        });

        stateView.setOnEmptyClickListener(new StateView.OnEmptyClickListener() {
            @Override
            public void onEmptyClick() {
                ToastUtils.show("hahahhaa");
                ARouter.getInstance()
                        .build(ARouterHub.LOGIN_ACTIVITY)
                        .navigation(getActivity());
            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        //网络不可用弹出提示
        mTipView.show();
        refreshLayout.finishLoadMore(2000);
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        stateView.showRetry();
        refreshLayout.finishRefresh(2000);
    }
}
