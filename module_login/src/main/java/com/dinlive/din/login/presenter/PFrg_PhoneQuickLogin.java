package com.dinlive.din.login.presenter;


import com.dinlive.din.baselib.Base.BasePresenter;
import com.dinlive.din.baselib.model.User;
import com.dinlive.din.baselib.net.result.HttpRespResult;
import com.dinlive.din.baselib.net.rxjava.converter.ResultException;
import com.dinlive.din.baselib.net.rxjava.observable.DialogTransformer;
import com.dinlive.din.baselib.net.rxjava.observable.TransformerHelper;
import com.dinlive.din.baselib.net.rxjava.observer.CommonObserver;
import com.dinlive.din.baselib.net.service.ParmsUtils;
import com.dinlive.din.baselib.net.service.ServiceManager;
import com.dinlive.din.baselib.utils.ToastUtils;
import com.dinlive.din.login.PhoneQuickLoginFragment;
import com.dinlive.din.login.view.IVFrg_PhoneQuickLogin;

import java.util.Map;

public class PFrg_PhoneQuickLogin extends BasePresenter<IVFrg_PhoneQuickLogin> {
    private PhoneQuickLoginFragment context;

    public PFrg_PhoneQuickLogin(PhoneQuickLoginFragment fragment) {
        super();
        this.context = fragment;
    }

    public void getCode(String mobile) {
        Map<String, String> map = ParmsUtils.getParmsMap();
        map.put("mobile", mobile);
        map.put("type", "4");
        ServiceManager
                .getApiService()
                .getCode(map)
                .compose(context.<HttpRespResult<String>>bindToLifecycle())
                .compose(TransformerHelper.<String>transformer())
                .compose(new DialogTransformer(context.getContext()).<HttpRespResult<String>>showDialog())
                .subscribe(new CommonObserver<String>() {
                    @Override
                    public void onSuccess(String user) {
                        getView().RefrenshCode();
                    }

                    @Override
                    public void onError(ResultException exception) {

                    }
                });
    }

    public void checkSmslogin(final String mobile, final String sms_code) {
        Map<String, String> map = ParmsUtils.getParmsMap();
        map.put("mobile", mobile);
        map.put("sms_code", sms_code);
        map.put("from", "android");
        ServiceManager
                .getApiService()
                .checkSmslogin(map)
                .compose(context.<HttpRespResult<User>>bindToLifecycle())
                .compose(TransformerHelper.<User>transformer())
                .compose(new DialogTransformer(context.getContext()).<HttpRespResult<User>>showDialog())
                .subscribe(new CommonObserver<User>() {
                    @Override
                    public void onSuccess(User user) {
                        getView().checkSmsloginSuccess(mobile, sms_code, user);
                    }

                    @Override
                    public void onError(ResultException exception) {
                        if (exception.getCode() == 4) {
                            getView().gotoLoginSeeting(mobile, sms_code);
                        } else {
                            ToastUtils.show(exception.getMessage());
                        }
                    }
                });
    }
}
