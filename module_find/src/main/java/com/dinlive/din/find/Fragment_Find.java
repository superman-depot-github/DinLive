package com.dinlive.din.find;

import android.Manifest;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dinlive.din.baselib.base.AgentWebActivity;
import com.dinlive.din.baselib.base.BaseFragment;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.dinlive.din.find.presenter.PFrg_Find;
import com.dinlive.din.find.view.IVFrg_Find;
import com.jakewharton.rxbinding2.view.RxView;

@Route(path = ARouterHub.FIND_FRAGMENT, name = "发现")
public class Fragment_Find extends BaseFragment<IVFrg_Find, PFrg_Find> implements IVFrg_Find {
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
                        AgentWebActivity.start(getActivity(),"https://www.imooc.com",false);
                    }
                });

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
