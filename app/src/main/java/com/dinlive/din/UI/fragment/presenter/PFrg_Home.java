package com.dinlive.din.UI.fragment.presenter;


import com.dinlive.din.UI.Base.BasePresenter;
import com.dinlive.din.UI.fragment.HomeFragment;
import com.dinlive.din.UI.fragment.view.IVFrg_Home;

public class PFrg_Home extends BasePresenter<IVFrg_Home> {
    private HomeFragment context;

    public PFrg_Home(HomeFragment homeFragment) {
        super();
        this.context = homeFragment;
    }


}
