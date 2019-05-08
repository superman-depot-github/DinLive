package com.dinlive.din.UI.activity.presenter;


import com.dinlive.din.UI.Base.BasePresenter;
import com.dinlive.din.UI.activity.HomeActivity;
import com.dinlive.din.UI.activity.view.IVAct_Home;

public class PAct_Home extends BasePresenter<IVAct_Home> {
    private HomeActivity context;

    public PAct_Home(HomeActivity homeActivity) {
        super();
        this.context = homeActivity;
    }
}
