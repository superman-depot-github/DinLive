package com.dinlive.din.UI.activity;


import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.dinlive.din.R;
import com.dinlive.din.UI.Base.BaseActivity;
import com.dinlive.din.UI.activity.presenter.PAct_Home;
import com.dinlive.din.UI.activity.view.IVAct_Home;
import com.dinlive.din.UI.fragment.FavoriteFragment;
import com.dinlive.din.UI.fragment.PersonFragment;
import com.dinlive.din.UI.fragment.HomeFragment;
import com.next.easynavigation.constant.Anim;
import com.next.easynavigation.view.EasyNavigationBar;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


public class HomeActivity extends BaseActivity<IVAct_Home, PAct_Home> implements IVAct_Home {

    @BindView(R.id.messageView)
    FrameLayout messageView;
    @BindView(R.id.bottomBar)
    EasyNavigationBar bottomBar;

    private List<Fragment> fragments = new ArrayList<>();

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
        fragments.add(new HomeFragment());
        fragments.add(new FavoriteFragment());
        fragments.add(new PersonFragment());
        bottomBar.titleItems(new String[]{"首页", "收藏", "个人"})
                .normalIconItems(new int[]{R.drawable.normal_home, R.drawable.normal_favorite, R.drawable.normal_person})
                .selectIconItems(new int[]{R.drawable.select_home, R.drawable.select_favorite, R.drawable.select_person})
                .fragmentList(fragments)
                .fragmentManager(getSupportFragmentManager())
                .onTabClickListener(new EasyNavigationBar.OnTabClickListener() {
                    @Override
                    public boolean onTabClickEvent(View view, int position) {
                        if (position == 4) {
                            Toast.makeText(HomeActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                            //return true则拦截事件、不进行页面切换
                            return true;
                        } else if (position == 2) {

                        }
                        return false;
                    }
                })
                .canScroll(false)
                .anim(Anim.ZoomIn)
                .build();
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
