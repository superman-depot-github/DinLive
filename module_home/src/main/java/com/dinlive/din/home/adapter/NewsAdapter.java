package com.dinlive.din.home.adapter;


import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.util.MultiTypeDelegate;
import com.dinlive.din.baselib.model.NewsDetailedBean;
import com.dinlive.din.home.R;

import java.util.List;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * @author ChayChan
 * @description: TODO
 * @date 2017/7/6  17:10
 */

public class NewsAdapter extends BaseQuickAdapter<NewsDetailedBean.NewsBean, BaseViewHolder> {


    private static final int NEWS = 1; //新闻
    private static final int NEWSFLASH = 3;//快讯
    private static final int VEDIO = 4;//视频
    private static final int SPECIA = 6;//专题
    private Context mContext;


    /**
     * @param context 上下文
     * @param data    新闻集合
     */
    public NewsAdapter(Context context, List<NewsDetailedBean.NewsBean> data) {
        super(data);
        mContext = context;
        //Step.1
        setMultiTypeDelegate(new MultiTypeDelegate<NewsDetailedBean.NewsBean>() {
            @Override
            protected int getItemType(NewsDetailedBean.NewsBean newsBean) {
                if (Integer.parseInt(newsBean.getType()) == NEWS) {
                    return NEWS;
                } else if (Integer.parseInt(newsBean.getType()) == NEWSFLASH) {
                    return NEWSFLASH;
                } else if (Integer.parseInt(newsBean.getType()) == VEDIO) {
                    return VEDIO;
                } else if (Integer.parseInt(newsBean.getType()) == SPECIA) {
                    return SPECIA;
                } else {
                    return NEWS;
                }

            }
        });
        //Step .2
        getMultiTypeDelegate()
                .registerItemType(NEWS, R.layout.recyclerview_itme_newsfg_news)
                .registerItemType(NEWSFLASH, R.layout.recyclerview_itme_newsfg_newflash)
                .registerItemType(VEDIO, R.layout.recyclerview_itme_newsfg_video)
                .registerItemType(SPECIA, R.layout.recyclerview_itme_newsfg_special);
    }

    @Override
    protected void convert(BaseViewHolder helper, NewsDetailedBean.NewsBean item) {
        //根据类型为不同布局的条目设置数据
        switch (helper.getItemViewType()) {
            case NEWS:
                ImageView news_pictrue = helper.getView(R.id.pictrue);
                TextView news_them = helper.getView(R.id.them);
                TextView news_descrip = helper.getView(R.id.descrip);
                news_descrip.setText(String.valueOf(item.getColumn_name()));
                news_them.setText(String.valueOf(item.getTheme()));
                Glide.with(mContext).load(item.getImage_url()).into(news_pictrue);
                break;
            case NEWSFLASH:
                TextView newsfalse_them = helper.getView(R.id.them);
                TextView newsfalse_time = helper.getView(R.id.time);
                ImageView newsfalse_share = helper.getView(R.id.share);
                newsfalse_them.setText(String.valueOf(item.getTheme()));
                break;
            case VEDIO:
                JZVideoPlayerStandard video_layer = helper.getView(R.id.videoplayer);
                TextView video_them = helper.getView(R.id.them);
                TextView video_descrip = helper.getView(R.id.descrip);
                video_descrip.setText(item.getColumn_name());
                break;
            case SPECIA:
                TextView specia_descrip = helper.getView(R.id.descrip);
                specia_descrip.setText(item.getColumn_name());
                break;
        }
    }
}

