package com.dinlive.din.baselib.wiget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.dinlive.din.baselib.Base.IBaseView;
import com.dinlive.din.baselib.R;
import com.dinlive.din.baselib.R2;

import butterknife.BindView;
import butterknife.OnClick;

public class PerfectToolBar extends Toolbar {
    @BindView(R2.id.bar_title)
    TextView barTitle;
    @BindView(R2.id.bar_right)
    TextView barRight;
    @BindView(R2.id.toolbar)
    Toolbar toolbar;

    public PerfectToolBar(Context context) {
        super(context);
        initView();
    }

    public PerfectToolBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }


    public PerfectToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.toolbar, this, true);
    }

    public void setNavigationIcon(@DrawableRes int resId) {
        toolbar.setNavigationIcon(resId);
    }

    public void setNavigationIcon(@Nullable Drawable icon) {
        toolbar.setNavigationIcon(icon);
    }

    @OnClick({R2.id.bar_title, R2.id.bar_right, R2.id.toolbar})
    public void onViewClicked(View view) {
        int i = view.getId();
        if (i == R.id.bar_title) {

        } else if (i == R.id.bar_right) {
            if (rightNavigationOnClickListener != null) {
                rightNavigationOnClickListener.onClick(barRight);
            }
        } else if (i == R.id.toolbar) {
            if (leftNavigationOnClickListener != null) {
                leftNavigationOnClickListener.onClick(toolbar);
            }
        }
    }

    private LeftNavigationOnClickListener leftNavigationOnClickListener;

    public void setLeftNavigationOnClickListener(LeftNavigationOnClickListener leftNavigationOnClickListener) {
        this.leftNavigationOnClickListener = leftNavigationOnClickListener;
    }

    public interface LeftNavigationOnClickListener extends IBaseView {
        void onClick(View view);
    }

    private RightNavigationOnClickListener rightNavigationOnClickListener;

    public void setRightNavigationOnClickListener(RightNavigationOnClickListener rightNavigationOnClickListener) {
        this.rightNavigationOnClickListener = rightNavigationOnClickListener;
    }

    public interface RightNavigationOnClickListener extends IBaseView {
        void onClick(View view);
    }
}
