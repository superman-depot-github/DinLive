package com.dinlive.din.baselib.wiget.channel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.dinlive.din.baselib.R;
import com.dinlive.din.baselib.wiget.channel.ItmeManngerListener;
import com.dinlive.din.baselib.wiget.channel.MenuEntity;

import java.util.List;

public class MenuChildAdapter extends BaseAdapter {
	private List<MenuEntity> menuList;
	private Context context;
	private ItmeManngerListener itmeManngerListener;
	private boolean IsEdit = false;

	public MenuChildAdapter(Context context,ItmeManngerListener itmeManngerListener, List<MenuEntity> list, boolean isEdit2) {
		this.context = context;
		this.itmeManngerListener = itmeManngerListener;
		this.menuList = list;
		this.IsEdit = isEdit2;
	}

	@Override
	public int getCount() {
		return menuList.size();
	}

	@Override
	public Object getItem(int position) {
		return menuList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHodler viewHodler;
		if (convertView == null) {
			convertView = LayoutInflater.from(context).inflate(R.layout.items_cate_child, null);
			viewHodler = new ViewHodler();
			viewHodler.tv_item_cate_child_name = convertView.findViewById(R.id.tv_item_cate_child_name);

			viewHodler.deleteImg = convertView.findViewById(R.id.delete_img);
			viewHodler.iconImg = convertView.findViewById(R.id.icon_img);

			convertView.setTag(viewHodler);
		} else {
			viewHodler = (ViewHodler) convertView.getTag();
		}
		final MenuEntity menuEntity = menuList.get(position);

		if (IsEdit) {
			viewHodler.deleteImg.setVisibility(View.VISIBLE);
			if (menuEntity.isSelect()) {
				viewHodler.deleteImg.setBackgroundResource(R.mipmap.menu_select);
			} else {
				viewHodler.deleteImg.setBackgroundResource(R.mipmap.menu_add);
			}
		} else {
			viewHodler.deleteImg.setVisibility(View.GONE);
		}

		viewHodler.deleteImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// datas.remove(position);
				// String key = AppConfig.KEY_USER;
				// appContext.saveObject((Serializable) datas, key);
				if (!menuEntity.isSelect()) {
					itmeManngerListener.AddMenu(menuEntity);
				}
			}
		});

		//获取资源图片
		//int drawableId = context.getResources().getIdentifier(menuEntity.getIco(),"mipmap", context.getPackageName());
		//viewHodler.iconImg.setImageResource(drawableId);
		if (!menuEntity.getIco().isEmpty()) {
			Glide.with(context).load(menuEntity.getIco()).into(viewHodler.iconImg);
		} else {
			Glide.with(context).load(R.drawable.empty_data)
					.placeholder(R.drawable.empty_data).error(R.drawable.empty_data)
					.into(viewHodler.iconImg);
		}
		viewHodler.tv_item_cate_child_name.setText(menuEntity.getTitle());
		return convertView;
	}

	private class ViewHodler {
		private TextView tv_item_cate_child_name;
		private ImageView deleteImg, iconImg;
	}
}
