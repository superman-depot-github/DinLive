package com.dinlive.din.UI.fragment;


import com.dinlive.din.R;
import com.dinlive.din.UI.Base.BaseFragment;
import com.dinlive.din.UI.fragment.presenter.PFrg_Person;
import com.dinlive.din.UI.fragment.view.IVFrg_Person;

public class PersonFragment extends BaseFragment<IVFrg_Person, PFrg_Person> {

    protected int getLayoutId() {
        return R.layout.fragment_person;
    }

    @Override
    protected PFrg_Person createPresenter() {
        return new PFrg_Person();
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
