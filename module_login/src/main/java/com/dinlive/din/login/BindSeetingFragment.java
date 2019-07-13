package com.dinlive.din.login;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dinlive.din.baselib.Base.BaseFragment;
import com.dinlive.din.baselib.model.User;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.dinlive.din.baselib.utils.ToastUtils;
import com.dinlive.din.baselib.utils.UserLoginUtils;
import com.dinlive.din.login.presenter.PFrg_BindSeeting;
import com.dinlive.din.login.view.IVFrg_BindSeeting;
import com.flyco.roundview.RoundTextView;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = ARouterHub.LOGIN_BINDSEETING_FRAGMENT, name = "绑定界面")
public class BindSeetingFragment extends BaseFragment<IVFrg_BindSeeting, PFrg_BindSeeting> implements IVFrg_BindSeeting {
    @BindView(R2.id.onwpassword)
    EditText onwpassword;
    @BindView(R2.id.twopassword)
    EditText twopassword;
    @BindView(R2.id.register)
    RoundTextView register;
    @BindView(R2.id.toregister)
    RoundTextView toregister;
    @BindView(R2.id.iseyesonwpassword)
    ImageView cleanonwpassword;
    @BindView(R2.id.iseyestwopassword)
    ImageView iseyestwopassword;
    @BindView(R2.id.hint)
    TextView hint;



    @Autowired
    String mobile;
    @Autowired
    String sms_code;
    private boolean isEyesOnw = true;//默认为密码模式
    private boolean isEyesTwo = true;//默认为密码模式

    public static BindSeetingFragment newInstance(String mobile, String sms_code) {
        return (BindSeetingFragment) ARouter.getInstance()
                .build(ARouterHub.LOGIN_BINDSEETING_FRAGMENT)
                .withString("mobile", mobile)
                .withString("sms_code", sms_code)
                .navigation();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_bindseeting;
    }

    @Override
    protected PFrg_BindSeeting createPresenter() {
        return new PFrg_BindSeeting(this);
    }

    @Override
    protected void initView(View mRootView) {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R2.id.onwpassword, R2.id.twopassword, R2.id.register, R2.id.toregister, R2.id.iseyesonwpassword, R2.id.iseyestwopassword})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.onwpassword) {
        } else if (i == R.id.twopassword) {
        } else if (i == R.id.register) {
            String accountStr = onwpassword.getText().toString();
            String passwordtStr = twopassword.getText().toString();

            if (!accountStr.isEmpty()) {
                if (!passwordtStr.isEmpty()) {
                    mPresenter.register(mobile, sms_code, accountStr, passwordtStr);
                } else {
                    ToastUtils.show("请设置确认密码");
                }
            } else {
                ToastUtils.show("请设置密码");
            }


        } else if (i == R.id.toregister) {
            start(RegisterFragment.newInstance());

        } else if (i == R.id.iseyesonwpassword) {
            if (isEyesOnw) {
                onwpassword.setInputType(128);
                isEyesOnw = false;
            } else {
                onwpassword.setInputType(129);
                isEyesOnw = true;
            }

        } else if (i == R.id.iseyestwopassword) {
            if (isEyesTwo) {
                twopassword.setInputType(128);
                isEyesTwo = false;
            } else {
                twopassword.setInputType(129);
                isEyesTwo = true;
            }

        }
    }

    @Override
    public void registerSuccess(User user) {
        UserLoginUtils.upDateUser(user);
        pop();
    }
}
