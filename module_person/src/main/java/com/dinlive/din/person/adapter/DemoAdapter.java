package com.dinlive.din.person.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.dinlive.din.person.R;
import com.dinlive.din.person.model.DemoBean;

import java.util.List;

/**
 * @author daifalin
 */
public class DemoAdapter extends BaseQuickAdapter<DemoBean, BaseViewHolder> {
    private Context context;

    public DemoAdapter(Context context, @Nullable List<DemoBean> data) {
        super(R.layout.item_layout, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, DemoBean demoBean) {
        ImageView iv = helper.getView(R.id.image);
        TextView title = helper.getView(R.id.title);
        Glide.with(context).load(demoBean.getImg()).into(iv);
        if (demoBean.isShow()) {
            helper.setGone(R.id.title, true);
        } else {
            helper.setGone(R.id.title, false);
        }
        helper.addOnClickListener(R.id.image);
        helper.addOnClickListener(R.id.title);
    }
}



