package com.dinlive.din.person;

import android.content.Intent;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.SPUtils;
import com.dinlive.din.baselib.base.BaseActivity;
import com.dinlive.din.baselib.base.BasePresenter;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.dinlive.din.baselib.utils.SpConstants;
import com.dinlive.din.baselib.utils.UserLoginUtils;
import com.dinlive.din.baselib.wiget.channel.LineGridView;
import com.dinlive.din.baselib.wiget.channel.MenuEntity;
import com.dinlive.din.baselib.wiget.channel.adapter.IndexDataAdapter;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Route(path = ARouterHub.PERSON_UTILS_ACTIVITY, name = "时间类工具")
public class UtilsActivity extends BaseActivity {
    private String channelStr = "[\n" +
            "  {\n" +
            "    \"ico\": \"https://www.baidu.com/img/bd_logo1.png?qua=high\",\n" +
            "    \"id\": \"8b2abd6b-18c2-4f8b-9990-b2d45f1aa91b\",\n" +
            "    \"sort\": \"1\",\n" +
            "    \"num\": \"0\",\n" +
            "    \"title\": \"我的任务\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"ico\": \"https://www.baidu.com/img/bd_logo1.png?qua=high\",\n" +
            "    \"id\": \"afce4ddf-194a-492a-b4ce-db79fd14801f\",\n" +
            "    \"sort\": \"2\",\n" +
            "    \"num\": \"12\",\n" +
            "    \"title\": \"计划审批\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"ico\": \"https://www.baidu.com/img/bd_logo1.png?qua=high\",\n" +
            "    \"id\": \"ac888f31-8392-4820-9254-49b11f71e2d3\",\n" +
            "    \"sort\": \"3\",\n" +
            "    \"num\": \"2\",\n" +
            "    \"title\": \"任务审批\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"ico\": \"https://www.baidu.com/img/bd_logo1.png?qua=high\",\n" +
            "    \"id\": \"f5462bb1-7151-4d1c-8d8e-d3653dc53e9a\",\n" +
            "    \"sort\": \"4\",\n" +
            "    \"num\": \"0\",\n" +
            "    \"title\": \"总结审批\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"ico\": \"https://www.baidu.com/img/bd_logo1.png?qua=high\",\n" +
            "    \"id\": \"13673a54-fa67-4f02-aeea-e4725ffbc853\",\n" +
            "    \"sort\": \"5\",\n" +
            "    \"num\": \"1\",\n" +
            "    \"title\": \"绩效等级评定\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"ico\": \"https://www.baidu.com/img/bd_logo1.png?qua=high\",\n" +
            "    \"id\": \"92e44b6a-027c-4cd5-b35e-f90d29fe093f\",\n" +
            "    \"sort\": \"6\",\n" +
            "    \"num\": \"4\",\n" +
            "    \"title\": \"待办流程\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"ico\": \"https://www.baidu.com/img/bd_logo1.png?qua=high\",\n" +
            "    \"id\": \"aa7f6c21-5227-4f4b-832e-e04b34a1389e\",\n" +
            "    \"sort\": \"7\",\n" +
            "    \"num\": \"0\",\n" +
            "    \"title\": \"已办流程\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"ico\": \"https://www.baidu.com/img/bd_logo1.png?qua=high\",\n" +
            "    \"id\": \"e924e4a9-0698-4624-8947-66cf883e8809\",\n" +
            "    \"sort\": \"8\",\n" +
            "    \"num\": \"1\",\n" +
            "    \"title\": \"我的计划\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"ico\": \"https://www.baidu.com/img/bd_logo1.png?qua=high\",\n" +
            "    \"id\": \"14c0f70a-5f6a-47c9-9ea4-4356773aa225\",\n" +
            "    \"sort\": \"9\",\n" +
            "    \"num\": \"0\",\n" +
            "    \"title\": \"我的总结\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"ico\": \"https://www.baidu.com/img/bd_logo1.png?qua=high\",\n" +
            "    \"id\": \"a708b6d3-b5f5-439e-9544-5dc0508fc34b\",\n" +
            "    \"sort\": \"10\",\n" +
            "    \"num\": \"12\",\n" +
            "    \"title\": \"流程阅看\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"ico\": \"https://www.baidu.com/img/bd_logo1.png?qua=high\",\n" +
            "    \"id\": \"0c4ad7d6-cb7b-4a27-9adb-fbb82dbfe67f\",\n" +
            "    \"sort\": \"11\",\n" +
            "    \"num\": \"3\",\n" +
            "    \"title\": \"流程草稿箱\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"ico\": \"https://www.baidu.com/img/bd_logo1.png?qua=high\",\n" +
            "    \"id\": \"3d8b4e65-09b9-4731-ba97-6b3b1e317290\",\n" +
            "    \"sort\": \"12\",\n" +
            "    \"num\": \"2\",\n" +
            "    \"title\": \"我的流程\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"ico\": \"https://www.baidu.com/img/bd_logo1.png?qua=high\",\n" +
            "    \"id\": \"1437cd9c-4595-46cb-8fde-e866e43f0825\",\n" +
            "    \"sort\": \"13\",\n" +
            "    \"num\": \"0\",\n" +
            "    \"title\": \"邮箱\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"ico\": \"https://www.baidu.com/img/bd_logo1.png?qua=high\",\n" +
            "    \"id\": \"1cd85fc6-0b69-4f04-aa79-883c6ba8649e\",\n" +
            "    \"sort\": \"14\",\n" +
            "    \"num\": \"2\",\n" +
            "    \"title\": \"公司发文\"\n" +
            "  },\n" +
            "  {\n" +
            "    \"ico\": \"https://www.baidu.com/img/bd_logo1.png?qua=high\",\n" +
            "    \"id\": \"a4f08830-adaa-4412-9adf-55b9e773118e\",\n" +
            "    \"sort\": \"15\",\n" +
            "    \"num\": \"5\",\n" +
            "    \"title\": \"公告/通知\"\n" +
            "  }\n" +
            "]";
    @BindView(R2.id.gv_lanuch_start)
    LineGridView gridView;
    private List<MenuEntity> indexDataAll = new ArrayList();
    private List<MenuEntity> indexDataList = new ArrayList();
    private IndexDataAdapter adapter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_utils;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        setBarTitle("频道管理案例");

        indexDataAll.addAll(GsonUtils.fromJson(channelStr, new TypeToken<List<MenuEntity>>() {}.getType()));
        UserLoginUtils.getInstance().setChannelAll(indexDataAll);

        List<MenuEntity> indexDataUser = UserLoginUtils.getInstance().getChannel();
        if (indexDataUser == null || indexDataUser.size() == 0) {
            //UserLoginUtils.getInstance().setChannel(indexDataAll);
            SPUtils.getInstance(SpConstants.USER_SP_NAME).put(SpConstants.USER_CHANNEL_GSON, channelStr);
        }
        indexDataList = UserLoginUtils.getInstance().getChannel();
        MenuEntity allMenuEntity = new MenuEntity();
        allMenuEntity.setIco("http://img2.bdstatic.com/static/common/widget/shitu/images/camera_new_on_4e3e250.png");
        allMenuEntity.setId("all");
        allMenuEntity.setTitle("全部");
        indexDataList.add(allMenuEntity);
        adapter = new IndexDataAdapter(UtilsActivity.this, indexDataList);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            String title = indexDataList.get(position).getTitle();
            String strId = indexDataList.get(position).getId();
            if (strId.equals("all")) {// 更多
                intent.setClass(UtilsActivity.this, MenuManageActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        indexDataList.clear();
        indexDataList = UserLoginUtils.getInstance().getChannel();
        MenuEntity allMenuEntity = new MenuEntity();
        allMenuEntity.setIco("http://img2.bdstatic.com/static/common/widget/shitu/images/camera_new_on_4e3e250.png");
        allMenuEntity.setId("all");
        allMenuEntity.setTitle("全部");
        indexDataList.add(allMenuEntity);
        adapter = new IndexDataAdapter(UtilsActivity.this, indexDataList);
        gridView.setAdapter(adapter);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
