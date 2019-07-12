package com.dinlive.din.login.presenter;


import com.dinlive.din.baselib.Base.BasePresenter;
import com.dinlive.din.login.LoginActivity;
import com.dinlive.din.login.view.IVAct_Login;

public class PAct_Login extends BasePresenter<IVAct_Login> {
    private LoginActivity context;

    public PAct_Login(LoginActivity loginActivity) {
        super();
        this.context = loginActivity;
    }

    public void login(String accountStr, String passwordtStr) {
//        Map<String, String> map = new HashMap();
//        map.put("vector_account", accountStr);
//        map.put("vector_password", passwordtStr);
//        ServiceManager
//                .getApiService()
//                .login(map)
//                .compose(context.<HttpRespResult<User>>bindToLifecycle())
//                .compose(TransformerHelper.<User>transformer())
//                .compose(new DialogTransformer(context).<HttpRespResult<User>>showDialog())
//                .subscribe(new CommonObserver<User>() {
//                    @Override
//                    public void onSuccess(User user) {
//                        SPUtil.getInstance().putData("user", user);
//                        getView().gotoActAndClearTop(LoginActivity.class);
//                    }
//
//                    @Override
//                    public void onError(ExceptionHandle.ResponseException exception) {
//                        ToastUtils.show(exception.getMessage());
//                    }
//                });
    }
}
