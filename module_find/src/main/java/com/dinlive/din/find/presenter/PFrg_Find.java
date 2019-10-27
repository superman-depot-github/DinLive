package com.dinlive.din.find.presenter;

import com.dinlive.din.baselib.Base.BasePresenter;
import com.dinlive.din.find.Fragment_Find;
import com.dinlive.din.find.view.IVFrg_Find;

public class PFrg_Find extends BasePresenter<IVFrg_Find> {
    private Fragment_Find context;

    public PFrg_Find(Fragment_Find fragment) {
        context = fragment;
    }
}
