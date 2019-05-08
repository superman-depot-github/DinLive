package com.dinlive.din.UI.activity;


import android.os.CountDownTimer;
import android.view.View;

import com.dinlive.din.R;
import com.dinlive.din.UI.Base.BaseActivity;
import com.dinlive.din.UI.activity.model.User;
import com.dinlive.din.UI.activity.presenter.PAct_Main;
import com.dinlive.din.UI.activity.view.IVAct_Main;
import com.dinlive.din.UI.wiget.FullScreenVideoView;
import com.dinlive.din.app.MyAppliction;
import com.dinlive.din.utils.SPUtil;
import com.flyco.roundview.RoundTextView;

import butterknife.BindView;
import butterknife.OnClick;


public class MainActivity extends BaseActivity<IVAct_Main, PAct_Main> implements IVAct_Main {

    @BindView(R.id.videoView)
    FullScreenVideoView videoView;
    @BindView(R.id.tvTime)
    RoundTextView tvTime;

    CountDownTimer timer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected PAct_Main createPresenter() {
        return new PAct_Main();
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {
//        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//            @Override
//            public void onPrepared(MediaPlayer mediaPlayer) {
//                mediaPlayer.setVolume(0f, 0f);
//                timer = new CountDownTimer(videoView.getDuration(), 1000) {
//                    @Override
//                    public void onTick(long l) {
//                        if (l / 1000 != 0) {
//                            tvTime.setText(Html.fromHtml("<font color='#2c2c2c'>跳过：</font>" + "<font color='#f82941'>" + l / 1000 + "</font>" + "<font color='#2c2c2c'>s</font>"));
//                        } else {
//                            tvTime.setText("");
//                        }
//
//                    }
//
//                    @Override
//                    public void onFinish() {
//
//                    }
//                }.start();
//            }
//        });
//
//        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            @Override
//            public void onCompletion(MediaPlayer mediaPlayer) {
//                if (!mediaPlayer.isPlaying()) {
//                    jumpActivity();
//                }
//            }
//        });

    }

    private void jumpActivity() {
        User user = (User) SPUtil.getInstance().getData("user", new User());
        if (user!= null) {
            gotoActAndFinish(HomeActivity.class);
        } else {
            gotoActAndFinish(LoginActivity.class);
        }
    }

    @Override
    protected void initData() {
//        videoView.setVideoURI(Uri.parse(getVideoPath()));
//        videoView.start();
        jumpActivity();
    }

    @OnClick({R.id.videoView, R.id.tvTime})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.videoView:
                break;
            case R.id.tvTime:
                jumpActivity();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
            timer.onFinish();
            timer = null;
        }
    }

    private String getVideoPath() {
        return path[(int) (Math.random() * path.length)];
    }

    private String[] path = {"android.resource://" + MyAppliction.context.getPackageName() + "/" + R.raw.beijing};
}
