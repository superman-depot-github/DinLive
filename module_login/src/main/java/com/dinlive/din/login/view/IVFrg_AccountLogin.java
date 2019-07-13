package com.dinlive.din.login.view;

import com.dinlive.din.baselib.Base.IBaseView;
import com.dinlive.din.baselib.model.User;

public interface IVFrg_AccountLogin extends IBaseView {
    void loginSuccess(User user);
}
