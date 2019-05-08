package com.dinlive.din.UI.activity.presenter;


import com.dinlive.din.UI.Base.BasePresenter;
import com.dinlive.din.UI.activity.LoginActivity;
import com.dinlive.din.UI.activity.model.User;
import com.dinlive.din.UI.activity.view.IVAct_Login;
import com.dinlive.din.net.result.ExceptionHandle;
import com.dinlive.din.net.result.HttpRespResult;
import com.dinlive.din.net.rxjava.observable.DialogTransformer;
import com.dinlive.din.net.rxjava.observable.TransformerHelper;
import com.dinlive.din.net.rxjava.observer.CommonObserver;
import com.dinlive.din.net.service.ServiceManager;
import com.dinlive.din.utils.SPUtil;
import com.dinlive.din.utils.ToastUtils;

import java.util.HashMap;
import java.util.Map;

public class PAct_Login extends BasePresenter<IVAct_Login> {
    private LoginActivity context;

    public PAct_Login(LoginActivity loginActivity) {
        super();
        this.context = loginActivity;
    }

    public void login(String accountStr, String passwordtStr) {
        Map<String, String> map = new HashMap();
        map.put("vector_account", accountStr);
        map.put("vector_password", passwordtStr);
        ServiceManager
                .getApiService()
                .login(map)
                .compose(context.<HttpRespResult<User>>bindToLifecycle())
                .compose(TransformerHelper.<User>transformer())
                .compose(new DialogTransformer(context).<HttpRespResult<User>>showDialog())
                .subscribe(new CommonObserver<User>() {
                    @Override
                    public void onSuccess(User user) {
                        SPUtil.getInstance().putData("user", user);
                        getView().gotoActAndClearTop(LoginActivity.class);
                    }

                    @Override
                    public void onError(ExceptionHandle.ResponseException exception) {
                        ToastUtils.show(exception.getMessage());
                    }
                });
    }
}
