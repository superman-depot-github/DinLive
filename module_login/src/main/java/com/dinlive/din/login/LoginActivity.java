package com.dinlive.din.login;


import android.widget.RelativeLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dinlive.din.baselib.Base.BaseActivity;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.dinlive.din.login.presenter.PAct_Login;
import com.dinlive.din.login.view.IVAct_Login;

import butterknife.BindView;

@Route(path = ARouterHub.LOGIN_ACTIVITY, name = "登陆接界面")
public class LoginActivity extends BaseActivity<IVAct_Login, PAct_Login> implements IVAct_Login {
    @BindView(R2.id.llContentView)
    RelativeLayout llContentView;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected PAct_Login createPresenter() {
        return new PAct_Login(this);
    }

    @Override
    protected void initView() {
        loadRootFragment(R.id.llContentView, AccountLoginFragment.newInstance());
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
