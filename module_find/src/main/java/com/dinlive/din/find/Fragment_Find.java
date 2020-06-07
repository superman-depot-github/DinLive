package com.dinlive.din.find;

import android.Manifest;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ToastUtils;
import com.dinlive.din.baselib.base.AgentWebActivity;
import com.dinlive.din.baselib.base.BaseFragment;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.dinlive.din.baselib.wiget.ninerecyclerview.BGASortableNinePhotoLayout;
import com.dinlive.din.find.adapter.CardsAdapter;
import com.dinlive.din.find.model.CardBean;
import com.dinlive.din.find.presenter.PFrg_Find;
import com.dinlive.din.find.view.IVFrg_Find;
import com.jakewharton.rxbinding2.view.RxView;

import java.util.ArrayList;

import butterknife.BindView;

@Route(path = ARouterHub.FIND_FRAGMENT, name = "发现")
public class Fragment_Find extends BaseFragment<IVFrg_Find, PFrg_Find> implements IVFrg_Find {
    @BindView(R2.id.snpl_moment_add_photos)
    BGASortableNinePhotoLayout mPhotosSnpl;
    @BindView(R2.id.recyclerView)
    RecyclerView recyclerView;

    protected int getLayoutId() {
        return R.layout.fragment_find;
    }

    @Override
    protected PFrg_Find createPresenter() {
        return new PFrg_Find(this);
    }

    @Override
    protected void initView(View v) {
        RxView.clicks(v.findViewById(R.id.msg))
                .compose(rxPermissions.ensure(Manifest.permission.CAMERA))
                .subscribe(granted -> {
                    if (granted) {
                        AgentWebActivity.start(getActivity(), "https://www.imooc.com", false);
                    }
                });

        ArrayList<String> list = new ArrayList();
        list.add("https://www.baidu.com/img/dongd_36a8aab08b12ba911d74444058393b08.gif");
        list.add("https://www.baidu.com/img/dongd_36a8aab08b12ba911d74444058393b08.gif");
        list.add("https://www.baidu.com/img/dongd_36a8aab08b12ba911d74444058393b08.gif");
        mPhotosSnpl.setData(list);
//        mPhotosSnpl.addMoreData(list);
//        mPhotosSnpl.setSortable(true);//是否支持拖拽排序  true支持
//        mPhotosSnpl.setPlusEnable(true);//是否显示添加按钮 true显示
//        mPhotosSnpl.setEditable(true);//是否编辑 true编辑状态
//
//        mPhotosSnpl.setData(null);
//        mPhotosSnpl.setMaxItemCount(1);
//        mPhotosSnpl.setMaxItemCount(9);
//        mPhotosSnpl.removeItem(0);
//        mPhotosSnpl.getMaxItemCount();
//        mPhotosSnpl.getItemCount();


        mPhotosSnpl.setDelegate(new BGASortableNinePhotoLayout.Delegate() {
            @Override
            public void onClickAddNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, ArrayList<String> models) {
                ToastUtils.showShort("添加");
            }

            @Override
            public void onClickDeleteNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
                ToastUtils.showShort("删除");
            }

            @Override
            public void onClickNinePhotoItem(BGASortableNinePhotoLayout sortableNinePhotoLayout, View view, int position, String model, ArrayList<String> models) {
                ToastUtils.showShort("你点击了" + position);
            }

            @Override
            public void onNinePhotoItemExchanged(BGASortableNinePhotoLayout sortableNinePhotoLayout, int fromPosition, int toPosition, ArrayList<String> models) {
                ToastUtils.showShort("你将图片从" + fromPosition + "拖动到" + toPosition);
            }
        });// 设置拖拽排序控件的代理

        ArrayList<CardBean> datas = new ArrayList();
        datas.add(new CardBean("https://www.baidu.com/img/baidu_resultlogo@2.png", "1"));
        datas.add(new CardBean("https://www.baidu.com/img/baidu_resultlogo@2.png", "2"));
        datas.add(new CardBean("https://www.baidu.com/img/baidu_resultlogo@2.png", "2"));
        datas.add(new CardBean("https://www.baidu.com/img/baidu_resultlogo@2.png", "2"));
        datas.add(new CardBean("https://www.baidu.com/img/baidu_resultlogo@2.png", "2"));
        datas.add(new CardBean("https://www.baidu.com/img/baidu_resultlogo@2.png", "2"));
        datas.add(new CardBean("https://www.baidu.com/img/baidu_resultlogo@2.png", "2"));
        datas.add(new CardBean("https://www.baidu.com/img/baidu_resultlogo@2.png", "2"));
        datas.add(new CardBean("https://www.baidu.com/img/baidu_resultlogo@2.png", "2"));
        datas.add(new CardBean("https://www.baidu.com/img/baidu_resultlogo@2.png", "2"));
        datas.add(new CardBean("https://www.baidu.com/img/baidu_resultlogo@2.png", "2"));
        datas.add(new CardBean("https://www.baidu.com/img/baidu_resultlogo@2.png", "2"));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(new CardsAdapter(R.layout.rv_adapter_itme_card, datas));
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onFragmentFirstVisible() {

    }
}
