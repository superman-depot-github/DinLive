package com.dinlive.din.login;


import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dinlive.din.baselib.Base.BaseActivity;
import com.dinlive.din.baselib.model.User;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.dinlive.din.baselib.utils.ToastUtils;
import com.dinlive.din.login.presenter.PAct_Login;
import com.dinlive.din.login.view.IVAct_Login;
import com.flyco.roundview.RoundTextView;
import com.jeremyliao.liveeventbus.LiveEventBus;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = ARouterHub.LOGIN_ACTIVITY, name = "登陆接界面")
public class LoginActivity extends BaseActivity<IVAct_Login, PAct_Login> implements IVAct_Login {
    @BindView(R2.id.account)
    EditText account;
    @BindView(R2.id.password)
    EditText password;
    @BindView(R2.id.login)
    RoundTextView login;
    @BindView(R2.id.msglogin)
    RoundTextView msglogin;
    @BindView(R2.id.register)
    RoundTextView register;
    @BindView(R2.id.clean)
    ImageView clean;
    private boolean isEyes = true;//默认为密码模式

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected PAct_Login createPresenter() {
        return new PAct_Login(this);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R2.id.account, R2.id.password, R2.id.login, R2.id.register, R2.id.msglogin, R2.id.clean, R2.id.eyes})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.account) {

        } else if (i == R.id.password) {

        } else if (i == R.id.login) {
            String accountStr = account.getText().toString();
            String passwordtStr = password.getText().toString();
            if (accountStr.isEmpty()) {
                ToastUtils.show("请输入账号");
                return;
            }
            if (passwordtStr.isEmpty()) {
                ToastUtils.show("请输入密码");
                return;
            }
            mPresenter.login(accountStr, passwordtStr);

        } else if (i == R.id.register) {//gotoAct(RegisterActivity.class);

        } else if (i == R.id.msglogin) {//gotoAct(MsgLoginActivity.class);

        } else if (i == R.id.clean) {
            account.setText("");
        } else if (i == R.id.eyes) {
            if (isEyes) {
                password.setInputType(128);
                isEyes = false;
            } else {
                password.setInputType(129);
                isEyes = true;
            }

        }
    }

    @Override
    public void login(User user) {
        LiveEventBus.get()
                .with("key_name")
                .post(user.toString());
        finish();
    }
}
