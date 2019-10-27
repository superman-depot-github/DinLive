package com.dinlive.din.login.presenter;


import com.dinlive.din.baselib.base.BasePresenter;
import com.dinlive.din.login.LoginActivity;
import com.dinlive.din.login.view.IVAct_Login;

public class PAct_Login extends BasePresenter<IVAct_Login> {
    private LoginActivity context;

    public PAct_Login(LoginActivity loginActivity) {
        super();
        this.context = loginActivity;
    }
}
