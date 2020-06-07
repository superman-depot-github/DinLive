package com.dinlive.din.find.adapter;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dinlive.din.find.R;
import com.dinlive.din.find.model.CardBean;

import java.util.List;

/**
 * @author ChayChan
 * @description:
 * @date 2017/7/6  17:10
 */

public class CardsAdapter extends BaseQuickAdapter<CardBean, BaseViewHolder> {

    public CardsAdapter(int layoutResId, @Nullable List<CardBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, CardBean cardBean) {
        Glide.with(mContext).load(cardBean.getSrc()).into((ImageView) helper.getView(R.id.src));
        helper.setText(R.id.desc, cardBean.getDesc());
    }
}


