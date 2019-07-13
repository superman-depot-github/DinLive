package com.dinlive.din.login;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dinlive.din.baselib.Base.BaseFragment;
import com.dinlive.din.baselib.model.User;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.dinlive.din.baselib.utils.ToastUtils;
import com.dinlive.din.baselib.utils.UserLoginUtils;
import com.dinlive.din.login.presenter.PFrg_PhoneQuickLogin;
import com.dinlive.din.login.view.IVFrg_PhoneQuickLogin;
import com.flyco.roundview.RoundTextView;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.OnClick;

@Route(path = ARouterHub.LOGIN_PHONEQUICKLOGIN_FRAGMENT, name = "短信快速登陆")
public class PhoneQuickLoginFragment extends BaseFragment<IVFrg_PhoneQuickLogin, PFrg_PhoneQuickLogin> implements IVFrg_PhoneQuickLogin {
    @BindView(R2.id.account)
    EditText account;
    @BindView(R2.id.smgcode)
    EditText smgcode;
    @BindView(R2.id.register)
    RoundTextView register;
    @BindView(R2.id.tologin)
    RoundTextView tologin;
    @BindView(R2.id.cleanaccount)
    ImageView cleanaccount;
    @BindView(R2.id.getcode)
    TextView getcode;

    private Timer timer;
    private TimerTask timerTask;
    private int DEFAULT_SECOND = 60; // 获取验证码倒计时开始时间
    private int second = DEFAULT_SECOND;
    Handler handler = new Handler() {

        public void handleMessage(Message msg) {
            if (msg.what == 0) {
                if (second > 0) {
                    second--;
                    getcode.setTextColor(getResources().getColor(R.color.gray));
                    getcode.setText(second + "秒");
                    getcode.setClickable(false);
                } else {
                    if (timer != null) {
                        timer.cancel();
                        timer = null;
                    }
                    if (timerTask != null) {
                        timerTask = null;
                    }
                    second = DEFAULT_SECOND;

                    getcode.setClickable(true);
                    getcode.setTextColor(getResources().getColor(R.color.red));
                    getcode.setText("获取验证码");
                }
            } else if (msg.what == 1) {
                if (timer != null) {
                    timer.cancel();
                    timer = null;
                }
                if (timerTask != null) {
                    timerTask = null;
                }
                second = DEFAULT_SECOND;
                getcode.setTextColor(getResources().getColor(R.color.red));
                getcode.setClickable(true);
                getcode.setText("获取验证码");
            }
        }
    };

    public static PhoneQuickLoginFragment newInstance() {
        return (PhoneQuickLoginFragment) ARouter.getInstance()
                .build(ARouterHub.LOGIN_PHONEQUICKLOGIN_FRAGMENT)
                .navigation();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_phonequick;
    }

    @Override
    protected PFrg_PhoneQuickLogin createPresenter() {
        return new PFrg_PhoneQuickLogin(this);
    }

    @Override
    protected void initView(View mRootView) {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }


    @OnClick({R2.id.account, R2.id.smgcode, R2.id.register, R2.id.toregister, R2.id.tologin, R2.id.cleanaccount, R2.id.getcode})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.account) {

        } else if (i == R.id.smgcode) {

        } else if (i == R.id.cleanaccount) {
            account.setText("");
        } else if (i == R.id.getcode) {
            if (!account.getText().toString().trim().isEmpty()) {
                if (account.getText().toString().trim().matches("^(?:13[0-9]|14[57]|15[0-35-9]|17[013678]|18[0-9])\\d{8}$")) {
                    mPresenter.getCode(account.getText().toString());
                } else {
                    ToastUtils.show("手机号码格式错误");
                }
            } else {
                ToastUtils.show("手机号码不能为空");
            }
        } else if (i == R.id.register) {
            String smgcodeStr = smgcode.getText().toString();
            if (!account.getText().toString().trim().isEmpty()) {
                if (account.getText().toString().matches("^(?:13[0-9]|14[57]|15[0-35-9]|17[013678]|18[0-9])\\d{8}$")) {
                    if (!smgcode.getText().toString().trim().isEmpty() || smgcode.getText().toString().trim().length() != 6) {
                        if (smgcode.getText().toString().trim().isEmpty()) {
                            ToastUtils.show("验证码错误");
                        }
                        mPresenter.checkSmslogin(account.getText().toString().trim(), smgcode.getText().toString().trim());
                    } else {
                        ToastUtils.show("验证码错误");
                    }
                } else {
                    ToastUtils.show("手机格式错误");
                }
            } else {
                ToastUtils.show("手机号码不能为空");
            }
        } else if (i == R.id.tologin) {
            pop();

        } else if (i == R.id.toregister) {
            start(RegisterFragment.newInstance());
        }
    }

    @Override
    public void onDestroy() {
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
        if (timerTask != null) {
            timerTask = null;
        }
        super.onDestroy();
    }

    @Override
    public void RefrenshCode() {
        smgcode.setClickable(false);
        timerTask = new TimerTask() {
            @Override
            public void run() {
                Message msg = new Message();
                msg.what = 0;
                handler.sendMessage(msg);
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 0, 1000);
    }

    public void setNavigationOnClickListener() {
        pop();
    }

    @Override
    public void checkSmsloginSuccess(String mobile, String sms_code, User user) {
        UserLoginUtils.upDateUser(user);
       pop();
    }

    @Override
    public void gotoLoginSeeting(String mobile, String sms_code) {
        start(BindSeetingFragment.newInstance(mobile,sms_code));
    }
}
