package com.dinlive.din.UI.activity;


import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.dinlive.din.R;
import com.dinlive.din.UI.Base.BaseActivity;
import com.dinlive.din.UI.activity.presenter.PAct_Login;
import com.dinlive.din.UI.activity.view.IVAct_Login;
import com.dinlive.din.utils.ToastUtils;
import com.flyco.roundview.RoundTextView;

import butterknife.BindView;
import butterknife.OnClick;


public class LoginActivity extends BaseActivity<IVAct_Login, PAct_Login> implements IVAct_Login {

    @BindView(R.id.account)
    EditText account;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login)
    RoundTextView login;
    @BindView(R.id.register)
    RoundTextView register;
    @BindView(R.id.activity_login)
    RelativeLayout activityLogin;

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

    @OnClick({R.id.account, R.id.password, R.id.login, R.id.register, R.id.activity_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.account:
                break;
            case R.id.password:
                break;
            case R.id.login:
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
                break;
            case R.id.register:
                break;
            case R.id.activity_login:
                break;
        }
    }
}
