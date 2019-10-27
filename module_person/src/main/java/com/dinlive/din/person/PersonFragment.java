package com.dinlive.din.person;


import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ToastUtils;
import com.dinlive.din.baselib.base.BaseFragment;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.dinlive.din.baselib.utils.UserLoginUtils;
import com.dinlive.din.person.presenter.PFrg_Favorite;
import com.dinlive.din.person.view.IVFrg_Favorite;
import com.flyco.roundview.RoundTextView;
import com.jeremyliao.liveeventbus.LiveEventBus;

import butterknife.BindView;
import butterknife.OnClick;

// 在支持路由的页面上添加注解(必选)
// 这里的路径需要注意的是至少需要有两级，/xx/xx
@Route(path = ARouterHub.PERSON_FRAGMENT, name = "个人")
public class PersonFragment extends BaseFragment<IVFrg_Favorite, PFrg_Favorite> {
    @BindView(R2.id.login)
    RoundTextView tologin;

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


    @OnClick({R2.id.login, R2.id.userIcon, R2.id.toTimeUtils, R2.id.toDropDownMenu, R2.id.toBanner})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.login || i == R.id.login) {
            if (UserLoginUtils.getUser() != null) {
                ToastUtils.showShort("当前已经登陆");
            } else {
                ARouter.getInstance()
                        .build(ARouterHub.LOGIN_ACTIVITY)
                        .navigation(getActivity());
            }
        } else if (i == R.id.userIcon) {
            ToastUtils.showShort("hahahhahha");
        } else if (i == R.id.toTimeUtils) {
            ARouter.getInstance()
                    .build(ARouterHub.PERSON_TIMEUTILS_ACTIVITY)
                    .navigation(getActivity());
        } else if (i == R.id.toDropDownMenu) {
            ARouter.getInstance()
                    .build(ARouterHub.PERSON_DROPDOWNMENU_ACTIVITY)
                    .navigation(getActivity());
        } else if (i == R.id.toBanner) {
            ARouter.getInstance()
                    .build(ARouterHub.PERSON_BANNERS_ACTIVITY)
                    .navigation(getActivity());
        }
    }
}
