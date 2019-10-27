package com.dinlive.din.login.view;

import com.dinlive.din.baselib.base.IBaseView;
import com.dinlive.din.baselib.model.User;

public interface IVFrg_PhoneQuickLogin extends IBaseView {
    void RefrenshCode();
    void checkSmsloginSuccess(String mobile, String sms_code,User user);
    void gotoLoginSeeting(String mobile, String sms_code);
}
