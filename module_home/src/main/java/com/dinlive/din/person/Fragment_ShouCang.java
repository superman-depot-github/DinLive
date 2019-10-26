package com.dinlive.din.person;

import android.Manifest;
import android.view.View;
import android.widget.Button;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ToastUtils;
import com.dinlive.din.baselib.Base.BaseFragment;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.dinlive.din.person.presenter.PFrg_ShouCang;
import com.dinlive.din.person.view.IVFrg_ShouCang;
import com.jakewharton.rxbinding2.view.RxView;

import butterknife.BindView;

@Route(path = ARouterHub.HOME_FRAGMENT_SHOUCANG, name = "收藏")
public class Fragment_ShouCang extends BaseFragment<IVFrg_ShouCang, PFrg_ShouCang> implements IVFrg_ShouCang {
    @BindView(R2.id.msg)
    Button msg;

    protected int getLayoutId() {
        return R.layout.fragment_shoucang;
    }

    @Override
    protected PFrg_ShouCang createPresenter() {
        return new PFrg_ShouCang(this);
    }

    @Override
    protected void initView(View v) {
        RxView.clicks(v.findViewById(R.id.msg))
                .compose(rxPermissions.ensure(Manifest.permission.CAMERA))
                .subscribe(granted -> {
                    if (granted){
                        ToastUtils.showShort("hhahah");
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
