package com.dinlive.din.presenter;


import com.dinlive.din.baselib.Base.BasePresenter;
import com.dinlive.din.HomeFragment;
import com.dinlive.din.view.IVFrg_Home;

public class PFrg_Home extends BasePresenter<IVFrg_Home> {
    private HomeFragment context;

    public PFrg_Home(HomeFragment homeFragment) {
        super();
        this.context = homeFragment;
    }


}
