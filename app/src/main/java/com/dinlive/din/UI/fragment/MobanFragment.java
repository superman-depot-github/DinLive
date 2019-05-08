package com.dinlive.din.UI.fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dinlive.din.R;
import com.dinlive.din.UI.Base.BaseFragment;
import com.dinlive.din.UI.fragment.model.RoomInfoBean;
import com.dinlive.din.UI.fragment.presenter.PFrg_Moban;
import com.dinlive.din.UI.fragment.view.IVFrg_Moban;
import com.dinlive.din.UI.wiget.GridItemDecoration;
import com.dinlive.din.utils.GlideUtils;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.shehuan.niv.NiceImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MobanFragment extends BaseFragment<IVFrg_Moban, PFrg_Moban> implements IVFrg_Moban {
    @BindView(R.id.refreshLayout)
    SmartRefreshLayout refreshLayout;
    @BindView(R.id.rv)
    RecyclerView rv;

    private GeneralAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.fg_moban;
    }

    @Override
    protected PFrg_Moban createPresenter() {
        return new PFrg_Moban(this);
    }

    @Override
    protected void initView() {
        refreshLayout.setOnRefreshListener(this);
        refreshLayout.setOnLoadMoreListener(this);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        rv.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        rv.setAdapter(adapter = new GeneralAdapter(getActivity()));
        GridItemDecoration divider = new GridItemDecoration.Builder(getActivity())
                .setHorizontalSpan(R.dimen.padding_common)
                .setVerticalSpan(R.dimen.padding_common)
                .setColorResource(R.color.transparent)
                .setShowLastLine(true)
                .build();
        rv.addItemDecoration(divider);
        mPresenter.findAll();
    }

    @Override
    public void onRefresh(RefreshLayout refreshlayout) {
        super.onRefresh(refreshlayout);

        refreshlayout.finishRefresh(2000);
    }

    @Override
    public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
        super.onLoadMore(refreshLayout);
        refreshLayout.finishLoadMore(2000);
    }

    @Override
    public void showData(List<RoomInfoBean> roomInfoBeans) {
        adapter.setDatas(roomInfoBeans);
    }

    public class GeneralAdapter extends RecyclerView.Adapter<GeneralAdapter.MyViewHolder> {

        Context context;
        List<RoomInfoBean> roomInfoBeans;

        public void setDatas(List<RoomInfoBean> roomInfoBeans) {
            this.roomInfoBeans = roomInfoBeans;
            notifyDataSetChanged();
        }

        public GeneralAdapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(context).inflate(R.layout.itme_mobanlist_layout, parent, false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            holder.describe.setText(roomInfoBeans.get(position).getDescribe());
            holder.name.setText(roomInfoBeans.get(position).getName());
            GlideUtils.loadImageViewCache(getActivity(), roomInfoBeans.get(position).getPoster(), holder.poster);
        }

        @Override
        public int getItemCount() {
            return (roomInfoBeans != null) ? roomInfoBeans.size() : -1;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            @BindView(R.id.poster)
            NiceImageView poster;
            @BindView(R.id.describe)
            TextView describe;
            @BindView(R.id.name)
            TextView name;

            public MyViewHolder(View itemView) {
                super(itemView);
                ButterKnife.bind(this, itemView);
            }
        }
    }
}

