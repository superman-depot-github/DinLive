package com.dinlive.din.UI.fragment;


import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dinlive.din.R;
import com.dinlive.din.UI.Base.BaseFragment;
import com.dinlive.din.UI.fragment.presenter.PFrg_Home;
import com.dinlive.din.UI.fragment.view.IVFrg_Home;
import com.shehuan.niv.NiceImageView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HomeFragment extends BaseFragment<IVFrg_Home, PFrg_Home> implements IVFrg_Home, ViewPager.OnPageChangeListener {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.userIcon)
    NiceImageView userIcon;
    @BindView(R.id.gotoVedio)
    ImageView gotoVedio;

    private List<BaseFragment> fragments;
    private List<String> titles;
    private MyAdapter mAdapter;

    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected PFrg_Home createPresenter() {
        return new PFrg_Home(this);
    }

    @Override
    protected void initView() {
        fragments = new ArrayList<>();
        titles = new ArrayList<>();
        fragments.add(new MobanFragment());
        fragments.add(new MobanFragment());
        fragments.add(new MobanFragment());
        fragments.add(new MobanFragment());
        fragments.add(new MobanFragment());
        fragments.add(new MobanFragment());
        fragments.add(new MobanFragment());
        fragments.add(new MobanFragment());
        fragments.add(new MobanFragment());
        fragments.add(new MobanFragment());
        fragments.add(new MobanFragment());

        titles.add("分类");
        titles.add("推荐");
        titles.add("全部");
        titles.add("LOL");
        titles.add("绝地求生");
        titles.add("王者荣耀");
        titles.add("堡垒之夜");
        titles.add("主机游戏");
        titles.add("DAOTA2");
        titles.add("刺激战场");
        titles.add("DNF");

        viewPager.setAdapter(mAdapter = new MyAdapter(getActivity().getSupportFragmentManager()));
        viewPager.addOnPageChangeListener(this);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                updateTabView(tab, true);//定义方法，判断是否选中
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                updateTabView(tab, false); //定义方法，判断是否选中
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
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
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private void updateTabView(TabLayout.Tab tab, boolean isSelect) {
        if (isSelect) {
            try {
                java.lang.reflect.Field fieldView = tab.getClass().getDeclaredField("mView");
                fieldView.setAccessible(true);
                View view = (View) fieldView.get(tab);
                java.lang.reflect.Field fieldTxt = view.getClass().getDeclaredField("mTextView");
                fieldTxt.setAccessible(true);
                TextView tabSelect = (TextView) fieldTxt.get(view);
                tabSelect.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                tabSelect.setText(tab.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                java.lang.reflect.Field fieldView = tab.getClass().getDeclaredField("mView");
                fieldView.setAccessible(true);
                View view = (View) fieldView.get(tab);
                java.lang.reflect.Field fieldTxt = view.getClass().getDeclaredField("mTextView");
                fieldTxt.setAccessible(true);
                TextView tabSelect = (TextView) fieldTxt.get(view);
                tabSelect.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
                tabSelect.setText(tab.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }

}
