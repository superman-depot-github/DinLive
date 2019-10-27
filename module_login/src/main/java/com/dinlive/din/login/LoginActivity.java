package com.dinlive.din.login;


import android.widget.RelativeLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dinlive.din.baselib.base.BaseActivity;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.dinlive.din.login.presenter.PAct_Login;
import com.dinlive.din.login.view.IVAct_Login;

import butterknife.BindView;
import me.yokeyword.fragmentation.anim.DefaultHorizontalAnimator;
import me.yokeyword.fragmentation.anim.FragmentAnimator;

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

    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        //setFragmentAnimator(new DefaultVerticalAnimator());//默认fragment转场动画   从下到上
        //setFragmentAnimator(new DefaultNoAnimator());//默认fragment转场动画  快闪
        return new DefaultHorizontalAnimator();//默认fragment转场动画  从左到右
    }
}
