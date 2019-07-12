package com.dinlive.din.presenter;


import com.dinlive.din.HomeActivity;
import com.dinlive.din.baselib.Base.BasePresenter;
import com.dinlive.din.view.IVAct_Home;

public class PAct_Home extends BasePresenter<IVAct_Home> {
    private HomeActivity context;

    public PAct_Home(HomeActivity homeActivity) {
        super();
        this.context = homeActivity;
        
    }
}
