package com.dinlive.din.baselib.wiget.channel.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dinlive.din.baselib.R;
import com.dinlive.din.baselib.utils.UserLoginUtils;
import com.dinlive.din.baselib.wiget.channel.ItmeManngerListener;
import com.dinlive.din.baselib.wiget.channel.MenuEntity;
import com.dinlive.din.baselib.wiget.channel.drag.DragAdapterInterface;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends BaseAdapter implements DragAdapterInterface {
    private boolean IsEdit = false;
    private List<MenuEntity> datas = new ArrayList();
    private Context context;
    private ItmeManngerListener itmeManngerListener;

    public MyAdapter(Context context, ItmeManngerListener itmeManngerListener, List<MenuEntity> datas) {
        this.context = context;
        this.itmeManngerListener = itmeManngerListener;
        this.datas = datas;
    }

    public void setDatas(List<MenuEntity> datas) {
        this.datas.clear();
        this.datas.addAll(datas);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        MenuEntity bean = datas.get(position);
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.view_item, null);
            holder.deleteImg = convertView.findViewById(R.id.delete_img);
            holder.iconImg = convertView.findViewById(R.id.icon_img);
            holder.nameTv = convertView.findViewById(R.id.name_tv);
            holder.container = convertView.findViewById(R.id.item_container);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        holder.deleteImg.setOnClickListener(v -> {
            itmeManngerListener.DelMeun(datas.get(position), position);
            datas.remove(position);
            UserLoginUtils.getInstance().setChannelTemp(datas);
        });
        if (IsEdit) {
            holder.deleteImg.setVisibility(View.VISIBLE);
        } else {
            holder.deleteImg.setVisibility(View.GONE);
        }
        //获取资源图片
        //int drawableId = context.getResources().getIdentifier(bean.getIco(),"mipmap", context.getPackageName());
        //holder.iconImg.setImageResource(drawableId);
        if (!bean.getIco().isEmpty()) {
            Glide.with(context).load(bean.getIco()).into(holder.iconImg);
        } else {
            Glide.with(context).load(R.drawable.empty_data)
                    .placeholder(R.drawable.empty_data).error(R.drawable.empty_data)
                    .into(holder.iconImg);
        }
        holder.nameTv.setText(bean.getTitle());
        holder.container.setBackgroundColor(Color.WHITE);
        return convertView;
    }

    class Holder {
        public ImageView deleteImg;
        public ImageView iconImg;
        public TextView nameTv;
        public View container;
    }

    @Override
    public void reOrder(int startPosition, int endPosition) {
        if (endPosition < datas.size()) {
            MenuEntity object = datas.remove(startPosition);
            datas.add(endPosition, object);
            UserLoginUtils.getInstance().setChannelTemp(datas);
            notifyDataSetChanged();
        }
    }

    public void setEdit() {
        IsEdit = true;
        notifyDataSetChanged();
    }

    public void getDatas() {
        for (MenuEntity data : datas) {
            // DebugLog.i("点击 Item " + data.getId());
        }
    }

    public void endEdit() {
        IsEdit = false;
        notifyDataSetChanged();
    }

    public boolean getEditStatue() {
        return IsEdit;
    }
}
