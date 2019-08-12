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
import com.dinlive.din.login.AccountLoginFragment;
import com.dinlive.din.login.view.IVFrg_AccountLogin;

import java.util.Map;

public class PFrg_AccountLogin extends BasePresenter<IVFrg_AccountLogin> {
    private AccountLoginFragment context;

    public PFrg_AccountLogin(AccountLoginFragment fragment) {
        super();
        this.context = fragment;
    }

    public void login(String accountStr, String passwordtStr) {
        Map<String, String> map = ParmsUtils.getParmsMap();
        map.put("username", accountStr);
        map.put("password", passwordtStr);
        ServiceManager
                .getApiService()
                .login(map)
                .compose(context.<HttpRespResult<User>>bindToLifecycle())
                .compose(TransformerHelper.<User>transformer())
                .compose(new DialogTransformer(context.getContext()).<HttpRespResult<User>>showDialog())
                .subscribe(new CommonObserver<User>() {

                    @Override
                    protected void onSuccess(User user) {
                       // getView().loginSuccess(user);
                        ToastUtils.show("");
                    }

                    @Override
                    protected void onError(ResultException exception) {

                    }
                });
    }
}
