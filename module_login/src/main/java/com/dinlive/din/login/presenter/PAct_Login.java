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
import com.dinlive.din.login.LoginActivity;
import com.dinlive.din.login.view.IVAct_Login;

import java.util.Map;

public class PAct_Login extends BasePresenter<IVAct_Login> {
    private LoginActivity context;

    public PAct_Login(LoginActivity loginActivity) {
        super();
        this.context = loginActivity;
    }

    public void login(String accountStr, String passwordtStr) {
        Map<String, String> map = ParmsUtils.getParmsMap();
        map.put("username", accountStr);
        map.put("password", passwordtStr);
        map.put("from", "android");
        ServiceManager
                .getApiService()
                .login(map)
                .compose(context.<HttpRespResult<User>>bindToLifecycle())
                .compose(TransformerHelper.<User>transformer())
                .compose(new DialogTransformer(context).<HttpRespResult<User>>showDialog())
                .subscribe(new CommonObserver<User>() {

                    @Override
                    protected void onSuccess(User user) {
                        getView().login(user);
                    }

                    @Override
                    protected void onError(ResultException exception) {

                    }
                });
    }
}
