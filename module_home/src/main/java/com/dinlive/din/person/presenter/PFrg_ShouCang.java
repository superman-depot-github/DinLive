package com.dinlive.din.person.presenter;


import com.dinlive.din.baselib.Base.BasePresenter;
import com.dinlive.din.person.Fragment_ShouCang;
import com.dinlive.din.person.view.IVFrg_ShouCang;

public class PFrg_ShouCang extends BasePresenter<IVFrg_ShouCang> {
    private Fragment_ShouCang context;

    public PFrg_ShouCang(Fragment_ShouCang fragment) {
        context = fragment;
    }
}
