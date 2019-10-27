package com.dinlive.din.baselib.base;


import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dinlive.din.baselib.R;
import com.dinlive.din.baselib.utils.ARouterHub;

@Route(path = ARouterHub.BASE_ACTIVITY_AGENTWEB, name = "AgentWeb_Activity界面")
public class AgentWebActivity extends BaseActivity {
    @Autowired(name = "Url", desc = "链接")
    public String Url;

    @Autowired(name = "hideShare", desc = "是否开启分享")
    public boolean hideShare;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_agentweb;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        loadRootFragment(R.id.llContentView, AgentWebFragment.newInstance(Url, hideShare));
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    public static void start(Context context, String url, boolean hideShare) {
        ARouter.getInstance()
                .build(ARouterHub.BASE_ACTIVITY_AGENTWEB)
                .withString("Url", url)
                .withBoolean("hideShare", hideShare)
                .navigation(context);
    }
}
