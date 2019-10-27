package com.dinlive.din.login;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.blankj.utilcode.util.ToastUtils;
import com.dinlive.din.baselib.base.BaseFragment;
import com.dinlive.din.baselib.model.User;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.dinlive.din.baselib.utils.UserLoginUtils;
import com.dinlive.din.login.presenter.PFrg_AccountLogin;
import com.dinlive.din.login.view.IVFrg_AccountLogin;
import com.flyco.roundview.RoundTextView;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = ARouterHub.LOGIN_ACCOUNTLOGIN_FRAGMENT, name = "账号登陆")
public class AccountLoginFragment extends BaseFragment<IVFrg_AccountLogin, PFrg_AccountLogin> implements IVFrg_AccountLogin {
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

    public static AccountLoginFragment newInstance() {
        return (AccountLoginFragment) ARouter.getInstance()
                .build(ARouterHub.LOGIN_ACCOUNTLOGIN_FRAGMENT)
                .navigation();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_accountlogin;
    }

    @Override
    protected PFrg_AccountLogin createPresenter() {
        return new PFrg_AccountLogin(this);
    }

    @Override
    protected void initView(View mRootView) {
        setNavigationIcon(R.drawable.vector_back);
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
                ToastUtils.showShort("请输入账号");
                return;
            }
            if (passwordtStr.isEmpty()) {
                ToastUtils.showShort("请输入密码");
                return;
            }
            mPresenter.login(accountStr, passwordtStr);

        } else if (i == R.id.register) {
            start(RegisterFragment.newInstance());
        } else if (i == R.id.msglogin) {
            start(PhoneQuickLoginFragment.newInstance());
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
    public void loginSuccess(User user) {
        UserLoginUtils.upDateUser(user);
        getActivity().finish();
    }
}
