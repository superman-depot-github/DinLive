package com.dinlive.din.UI.fragment;


import com.dinlive.din.R;
import com.dinlive.din.UI.Base.BaseFragment;
import com.dinlive.din.UI.fragment.presenter.PFrg_Favorite;
import com.dinlive.din.UI.fragment.view.IVFrg_Favorite;

public class FavoriteFragment extends BaseFragment<IVFrg_Favorite, PFrg_Favorite> {

    protected int getLayoutId() {
        return R.layout.fragment_favorite;
    }

    @Override
    protected PFrg_Favorite createPresenter() {
        return new PFrg_Favorite();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

}
