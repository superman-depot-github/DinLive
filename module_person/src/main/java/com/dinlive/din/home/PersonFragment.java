package com.dinlive.din.home;


import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dinlive.din.baselib.Base.BaseFragment;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.dinlive.din.home.presenter.PFrg_Favorite;
import com.dinlive.din.home.view.IVFrg_Favorite;
import com.jeremyliao.liveeventbus.LiveEventBus;

import butterknife.BindView;
import butterknife.OnClick;

// 在支持路由的页面上添加注解(必选)
// 这里的路径需要注意的是至少需要有两级，/xx/xx
@Route(path = ARouterHub.PERSON_FRAGMENT, name = "个人")
public class PersonFragment extends BaseFragment<IVFrg_Favorite, PFrg_Favorite> {

    @BindView(R2.id.tologin)
    TextView tologin;

    protected int getLayoutId() {
        return R.layout.fragment_person;
    }

    @Override
    protected PFrg_Favorite createPresenter() {
        return new PFrg_Favorite();
    }

    @Override
    protected void initView(View mRootView) {

    }

    @Override
    protected void initListener() {
        LiveEventBus.get()
                .with("key_name", String.class)
                .observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(@Nullable String s) {
                        tologin.setText(s);
                    }
                });
    }

    @Override
    protected void initData() {

    }



    @OnClick(R2.id.tologin)
    public void onViewClicked() {
        ARouter.getInstance()
                .build(ARouterHub.LOGIN_ACTIVITY)
                .navigation(getActivity());
    }
}
