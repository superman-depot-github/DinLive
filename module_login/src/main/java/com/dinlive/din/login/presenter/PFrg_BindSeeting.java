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
import com.dinlive.din.login.BindSeetingFragment;
import com.dinlive.din.login.view.IVFrg_BindSeeting;

import java.util.Map;

public class PFrg_BindSeeting extends BasePresenter<IVFrg_BindSeeting> {
    private BindSeetingFragment context;

    public PFrg_BindSeeting(BindSeetingFragment fragment) {
        super();
        this.context = fragment;
    }

    public void register(String mobile, String sms_code, String password, String affirm_password) {
        Map<String, String> map = ParmsUtils.getParmsMap();
        map.put("mobile", mobile);
        //map.put("sms_code", sms_code);
        map.put("password", password);
        map.put("affirm_password", affirm_password);
        map.put(" from", "android");
        ServiceManager
                .getApiService()
                .register(map)
                .compose(context.<HttpRespResult<User>>bindToLifecycle())
                .compose(TransformerHelper.<User>transformer())
                .compose(new DialogTransformer(context.getContext()).<HttpRespResult<User>>showDialog())
                .subscribe(new CommonObserver<User>() {
                    @Override
                    public void onSuccess(User user) {
//                        MyActivityLifecycleCallbacks activityLifecycleCallbacks = MyAppliction.getActivityLifecycleCallbacks();
//                        if (activityLifecycleCallbacks.isFront()) {//如果应用处于前台做某些操作（一般此时，收到通知和点击通知栏做相同的操作）
//                            if (activityLifecycleCallbacks.instanceoActivity(LoginActivity.class)) {//如果当前Activity是要跳转的Activity，做某些操作，一般不跳转，可用EventBus
//                                activityLifecycleCallbacks.removeActivity(LoginActivity.class);
//                            }
//                            if (activityLifecycleCallbacks.instanceoActivity(RegisterActivity.class)) {
//                                activityLifecycleCallbacks.removeActivity(RegisterActivity.class);
//                            }
//
//                            if (activityLifecycleCallbacks.instanceoActivity(RegisterActivity.class)) {
//                                activityLifecycleCallbacks.removeActivity(RegisterActivity.class);
//                            }
//
//                            if (activityLifecycleCallbacks.instanceoActivity(MsgLoginActivity.class)) {
//                                activityLifecycleCallbacks.removeActivity(RegisterActivity.class);
//                            }
//                        }
                        getView().registerSuccess(user);
                    }

                    @Override
                    public void onError(ResultException exception) {

                    }
                });
    }

}
