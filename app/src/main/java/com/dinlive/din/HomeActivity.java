package com.dinlive.din;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.launcher.ARouter;
import com.dinlive.din.baselib.Base.BaseActivity;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.dinlive.din.baselib.wiget.NoScrollViewPager;
import com.dinlive.din.baselib.wiget.bottomview.BotBean;
import com.dinlive.din.baselib.wiget.bottomview.BottomView;
import com.dinlive.din.presenter.PAct_Home;
import com.dinlive.din.view.IVAct_Home;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class HomeActivity extends BaseActivity<IVAct_Home, PAct_Home> implements IVAct_Home {
    @BindView(R.id.messageView)
    FrameLayout messageView;
    @BindView(R.id.bottom)
    BottomView bottomView;
    @BindView(R.id.vp_content)
    NoScrollViewPager mVpContent;

    private List<Fragment> fragments = new ArrayList<>();
    private RecyclerView recyclerView;
    private ArrayList<BotBean> itemIcon = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected PAct_Home createPresenter() {
        return new PAct_Home(this);
    }

    @Override
    protected void initView() {
        //设置StatusBar 显示模式(黑色或者白色)
        fragments.add((Fragment) ARouter.getInstance().build(ARouterHub.HOME_FRAGMENT_HOME).navigation());
        fragments.add((Fragment) ARouter.getInstance().build(ARouterHub.HOME_FRAGMENT_HOME).navigation());
        fragments.add((Fragment) ARouter.getInstance().build(ARouterHub.PERSON_FRAGMENT).navigation());
        itemIcon.add(new BotBean("首页", R.drawable.normal_home, R.drawable.select_home));
        itemIcon.add(new BotBean("收藏", R.drawable.normal_favorite, R.drawable.select_favorite));
        itemIcon.add(new BotBean("个人", R.drawable.normal_person, R.drawable.select_person));
        mVpContent.setAdapter(new FragmentAdapter(getSupportFragmentManager()));
        bottomView.setViewPager(mVpContent, itemIcon, new BottomView.BottomPageChangeListener() {
            @Override
            public void onBottomPageChangeListener(int position) {
            }
        });
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    class FragmentAdapter extends FragmentPagerAdapter {

        public FragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
