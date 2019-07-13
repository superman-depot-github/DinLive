package com.dinlive.din.login.view;

import com.dinlive.din.baselib.Base.IBaseView;

public interface IVFrg_Register extends IBaseView {
    void RefrenshCode();
    void checkSmsCodeSuccess(String mobile, String sms_code);
}
