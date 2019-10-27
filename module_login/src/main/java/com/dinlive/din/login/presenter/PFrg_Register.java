package com.dinlive.din.login.presenter;


import com.dinlive.din.baselib.base.BasePresenter;
import com.dinlive.din.baselib.net.result.HttpRespResult;
import com.dinlive.din.baselib.net.rxjava.converter.ResultException;
import com.dinlive.din.baselib.net.rxjava.observable.DialogTransformer;
import com.dinlive.din.baselib.net.rxjava.observable.TransformerHelper;
import com.dinlive.din.baselib.net.rxjava.observer.CommonObserver;
import com.dinlive.din.baselib.net.service.ParmsUtils;
import com.dinlive.din.baselib.net.service.ServiceManager;
import com.dinlive.din.login.RegisterFragment;
import com.dinlive.din.login.view.IVFrg_Register;

import java.util.Map;

public class PFrg_Register extends BasePresenter<IVFrg_Register> {
    private RegisterFragment context;

    public PFrg_Register(RegisterFragment fragment) {
        super();
        this.context = fragment;
    }


    public void getCode(String mobile) {
        Map<String, String> map = ParmsUtils.getParmsMap();
        map.put("mobile", mobile);
        map.put("type", "1");
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

    public void checkSmsCode(final String mobile, final String sms_code) {
        Map<String, String> map = ParmsUtils.getParmsMap();
        map.put("mobile", mobile);
        map.put("sms_code", sms_code);
        map.put("type", "1");
        ServiceManager
                .getApiService()
                .checkSmsCode(map)
                .compose(context.<HttpRespResult<String>>bindToLifecycle())
                .compose(TransformerHelper.<String>transformer())
                .compose(new DialogTransformer(context.getContext()).<HttpRespResult<String>>showDialog())
                .subscribe(new CommonObserver<String>() {
                    @Override
                    public void onSuccess(String user) {
                        getView().checkSmsCodeSuccess(mobile, sms_code);
                    }

                    @Override
                    public void onError(ResultException exception) {

                    }
                });
    }

}
