package com.dinlive.din.baselib.wiget.bottomview;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.util.SizeUtils;
import com.bupt.edison.magicreddot.MagicRedDotView;


// 图标 + 文字的 底部按钮
public class TabView1 extends RelativeLayout {
    BotBean botBean;
    private TextView iconName;
    private ImageView iconImage;
    private MagicRedDotView magicRedDotView;

    public TabView1(Context context, BotBean botBean) {
        super(context);
        this.botBean = botBean;
        initView();
    }

    private void initView() {

        //图标
        iconImage = new ImageView(getContext());
        Drawable drawable = getContext().getResources().getDrawable(botBean.getUnCheckedIcon());
        Drawable wrapDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrapDrawable, ColorStateList.valueOf(Color.GRAY));
        iconImage.setImageDrawable(wrapDrawable);
        RelativeLayout.LayoutParams iconImageParams = new RelativeLayout.LayoutParams(SizeUtils.dp2px(25), SizeUtils.dp2px(25));
        iconImageParams.addRule(RelativeLayout.CENTER_HORIZONTAL);//与父容器的左侧对齐
        int iconImageId = 1;
        iconImage.setId(iconImageId);//设置这个View 的id
        iconImage.setLayoutParams(iconImageParams);//设置布局参数
        addView(iconImage);//RelativeLayout添加子View

        //底部文字
        iconName = new TextView(getContext());
        RelativeLayout.LayoutParams iconNameParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        iconNameParams.addRule(RelativeLayout.CENTER_HORIZONTAL);//与父容器的左侧对齐
        int iconNameId = 2;
        iconName.setId(iconNameId);//设置这个View 的id
        iconName.setLayoutParams(iconNameParams);//设置布局参数
        iconName.setText(botBean.getIconName());
        addView(iconName);//RelativeLayout添加子View

        //消息小图标
        magicRedDotView = new MagicRedDotView(getContext());
        RelativeLayout.LayoutParams magicRedDotViewParams = new RelativeLayout.LayoutParams(SizeUtils.dp2px(5), SizeUtils.dp2px(5));
        magicRedDotViewParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);//与父容器的左侧对齐
        magicRedDotViewParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);//与父容器的左侧对齐

        int magicRedDotViewParamsId = 3;
        magicRedDotView.setId(magicRedDotViewParamsId);//设置这个View 的id
        magicRedDotView.setLayoutParams(iconImageParams);//设置布局参数
        addView(magicRedDotView);//RelativeLayout添加子View
    }

    // 判断选择状态改变图标，供外部调用
    public void setSelected(boolean isSelected) {
        if (botBean == null) {
            return;
        }

        if (isSelected) {
            if (iconImage != null) {
                // 使用颜色过滤器，改变选中时的颜色为红色
                Drawable drawable = getContext().getResources().getDrawable(botBean.getCheckedIcon());
                Drawable wrapDrawable = DrawableCompat.wrap(drawable);
                DrawableCompat.setTintList(wrapDrawable, ColorStateList.valueOf(Color.BLACK));
                iconImage.setImageDrawable(wrapDrawable);

                iconName.setTextColor(Color.BLACK);
            }
        } else {// 没选中的图标为黑色，标题为灰色
            if (iconName != null) {
                Drawable drawable = getContext().getResources().getDrawable(botBean.getUnCheckedIcon());
                Drawable wrapDrawable = DrawableCompat.wrap(drawable);
                DrawableCompat.setTintList(wrapDrawable, ColorStateList.valueOf(Color.GRAY));
                iconImage.setImageDrawable(wrapDrawable);

                iconName.setTextColor(Color.GRAY);
            }
        }
    }
}
