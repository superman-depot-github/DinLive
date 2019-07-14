package com.dinlive.din.home;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dinlive.din.baselib.Base.BaseFragment;
import com.dinlive.din.baselib.model.NewsDetailedBean;
import com.dinlive.din.baselib.net.rxjava.converter.ResultException;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.dinlive.din.baselib.wiget.PowerfulRecyclerView;
import com.dinlive.din.baselib.wiget.stateview.StateView;
import com.dinlive.din.baselib.wiget.stateview.TipView;
import com.dinlive.din.home.adapter.NewsAdapter;
import com.dinlive.din.home.presenter.PFrg_Home;
import com.dinlive.din.home.view.IVFrg_Home;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Route(path = ARouterHub.HOME_FRAGMENT_HOME, name = "首页")
public class Fragment_home extends BaseFragment<IVFrg_Home, PFrg_Home> implements IVFrg_Home {
    @BindView(R2.id.tip_view)
    TipView mTipView;
    @BindView(R2.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R2.id.StateView)
    StateView stateView;
    @BindView(R2.id.rv_news)
    PowerfulRecyclerView mRvNews;
    private boolean hasMore = true;//true是有更多数据
    private int start = 0;//懒加载默第一页数据

    private List<NewsDetailedBean.NewsBean> mNewsList = new ArrayList<>();
    protected BaseQuickAdapter mNewsAdapter;

    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected PFrg_Home createPresenter() {
        return new PFrg_Home(this);
    }

    @Override
    protected void initView(View v) {
        centerTitle.setText("首页");
    }

    @Override
    protected void initListener() {
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setOnLoadMoreListener(this);
        mNewsAdapter = new NewsAdapter(mActivity, mNewsList);
        mRvNews.setAdapter(mNewsAdapter);
        mNewsAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

            }
        });
    }

    @Override
    protected void initData() {
    }

    @Override
    protected void onFragmentFirstVisible() {
        //当第一次可见的时候，加载数据
        stateView.showLoading();
        mPresenter.recommendList(FIRSTLOAD, start);
    }

    @Override
    public void onLoadMore(RefreshLayout refreshLayout) {
        stateView.showLoading();
        mPresenter.recommendList(LOADMORER, start);
    }

    @Override
    public void onRefresh(RefreshLayout refreshLayout) {
        //重置默认数据
        hasMore = true;
        start = 0;
        mNewsList.clear();
        mPresenter.recommendList(REFRENSH, start);
    }

    @Override
    public void recommendListSuccess(int loadType, NewsDetailedBean newsDetailedBean) {
        mNewsList.addAll(newsDetailedBean.getArticle_list());
        mNewsAdapter.notifyDataSetChanged();
        mNewsAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);//条目加载动画
        hasMore = newsDetailedBean.getMore() == 0 ? false : true;
        start = newsDetailedBean.getStart();
        changeSmartRefreshLayout(loadType, true, hasMore);
    }

    @Override
    public void recommendListFaild(int loadType, ResultException exception) {
        changeSmartRefreshLayout(loadType, false, hasMore);
    }

    private void changeSmartRefreshLayout(int loadType, boolean isSuccess, boolean hasMore) {
        switch (loadType) {
            case FIRSTLOAD:
                if (isSuccess) {
                    stateView.showContent();
                    mTipView.show("加载数据成功");
                } else {
                    stateView.showEmpty();
                }
                break;
            case LOADMORER:
                refreshLayout.finishLoadMore();
                break;
            case REFRENSH:
                refreshLayout.finishRefresh();
                break;
        }

        if (hasMore) {
            refreshLayout.setNoMoreData(!hasMore);
        } else {
            refreshLayout.setNoMoreData(hasMore);
        }
    }
}
