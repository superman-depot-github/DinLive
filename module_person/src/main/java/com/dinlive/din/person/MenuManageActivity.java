package com.dinlive.din.person;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.blankj.utilcode.util.ToastUtils;
import com.dinlive.din.baselib.base.BaseActivity;
import com.dinlive.din.baselib.base.BasePresenter;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.dinlive.din.baselib.utils.UserLoginUtils;
import com.dinlive.din.baselib.wiget.channel.ItmeManngerListener;
import com.dinlive.din.baselib.wiget.channel.MenuEntity;
import com.dinlive.din.baselib.wiget.channel.adapter.MenuParentAdapter;
import com.dinlive.din.baselib.wiget.channel.adapter.MyAdapter;
import com.dinlive.din.baselib.wiget.channel.drag.DragCallback;
import com.dinlive.din.baselib.wiget.channel.drag.DragForScrollView;
import com.dinlive.din.baselib.wiget.channel.drag.DragGridView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

@Route(path = ARouterHub.PERSON_MENUMANAGE_ACTIVITY, name = "Channel编辑界面")
public class MenuManageActivity extends BaseActivity implements ItmeManngerListener {

    @BindView(R2.id.gridview)
    DragGridView dragGridView;
    @BindView(R2.id.expandableListView)
    ExpandableListView expandableListView;
    @BindView(R2.id.sv_index)
    DragForScrollView sv_index;
    @BindView(R2.id.tv_drag_tip)
    TextView tv_drag_tip;

    private static MyAdapter adapterSelect;
    private static ArrayList<MenuEntity> menuList = new ArrayList<>();
    ;
    private static MenuParentAdapter menuParentAdapter;
    private static List<MenuEntity> indexSelect = new ArrayList<>();

    @Override
    protected int getLayoutId() {
        return R.layout.activity_menumanage;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        setBarTitle("编辑界面");
        setBarRightText("管理");
        //获取设置保存到本地的菜单
        List<MenuEntity> indexDataList = UserLoginUtils.getInstance().getChannel();
        if (indexDataList != null) {
            indexSelect.clear();
            indexSelect.addAll(indexDataList);
        }

        adapterSelect = new MyAdapter(this, this, indexSelect);
        dragGridView.setAdapter(adapterSelect);

        dragGridView.setDragCallback(new DragCallback() {
            @Override
            public void startDrag(int position) {
                sv_index.startDrag(position);
            }
            @Override
            public void endDrag(int position) {
                sv_index.endDrag(position);
            }
        });
        dragGridView.setOnItemClickListener((parent, view, position, id) -> {
            if(!adapterSelect.getEditStatue()){
                //dragGridView.clicked(position);
                MenuEntity cateModel = indexSelect.get(position);
                initUrl(cateModel);
            }
        });
        dragGridView.setOnItemLongClickListener((parent, view, position, id) -> {
            if (getBarRightText().equals("管理")) {
                setBarRightText("完成");
                adapterSelect.setEdit();
                if(menuParentAdapter!=null){
                    menuParentAdapter.setEdit();
                }
                tv_drag_tip.setVisibility(View.VISIBLE);
            }
            dragGridView.startDrag(position);
            return false;
        });



        setOnClickRightTextListener(view -> {
            if (getBarRightText().equals("管理")) {
                setBarRightText("完成");
                adapterSelect.setEdit();
                if(menuParentAdapter!=null){
                    menuParentAdapter.setEdit();
                }
                tv_drag_tip.setVisibility(View.VISIBLE);
            } else {
                setBarRightText("管理");
                tv_drag_tip.setVisibility(View.GONE);
                adapterSelect.endEdit();
                if(menuParentAdapter!=null){
                    menuParentAdapter.endEdit();
                }
                postMenu();
            }
        });
    }

    protected void postMenu() {
        List<MenuEntity> indexDataList = UserLoginUtils.getInstance().getChannelTemp();
        UserLoginUtils.getInstance().setChannel(indexDataList);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        List<MenuEntity> indexDataList = UserLoginUtils.getInstance().getChannelAll();
        init(indexDataList);
    }

    private void init(List<MenuEntity> indexAll) {
        expandableListView.setGroupIndicator(null);
        menuList.clear();
        try {
            MenuEntity index = new MenuEntity();
            index.setTitle("流程审批");
            index.setId("1");
            List<MenuEntity> indexLC= new ArrayList();
            for (int i = 0; i < indexAll.size(); i++) {
                if(indexAll.get(i).getId().equals("92e44b6a-027c-4cd5-b35e-f90d29fe093f")){
                    indexLC.add(indexAll.get(i));
                }
                if(indexAll.get(i).getId().equals("aa7f6c21-5227-4f4b-832e-e04b34a1389e")){
                    indexLC.add(indexAll.get(i));
                }
                if(indexAll.get(i).getId().equals("a708b6d3-b5f5-439e-9544-5dc0508fc34b")){
                    indexLC.add(indexAll.get(i));
                }
                if(indexAll.get(i).getId().equals("0c4ad7d6-cb7b-4a27-9adb-fbb82dbfe67f")){
                    indexLC.add(indexAll.get(i));
                }
                if(indexAll.get(i).getId().equals("3d8b4e65-09b9-4731-ba97-6b3b1e317290")){
                    indexLC.add(indexAll.get(i));
                }
            }
            for (int i = 0; i < indexLC.size(); i++) {
                for (int j = 0; j < indexSelect.size(); j++) {
                    if (indexLC.get(i).getTitle().equals(indexSelect.get(j).getTitle())) {
                        indexLC.get(i).setSelect(true);
                    }
                }
            }
            index.setChilds(indexLC);
            menuList.add(index);

            MenuEntity index1 = new MenuEntity();
            index1.setTitle("绩效考核");
            index1.setId("1");

            List<MenuEntity> indexJX= new ArrayList();
            for (int i = 0; i < indexAll.size(); i++) {
                if(indexAll.get(i).getId().equals("ac888f31-8392-4820-9254-49b11f71e2d3")){
                    indexJX.add(indexAll.get(i));
                }
                if(indexAll.get(i).getId().equals("afce4ddf-194a-492a-b4ce-db79fd14801f")){
                    indexJX.add(indexAll.get(i));
                }
                if(indexAll.get(i).getId().equals("8b2abd6b-18c2-4f8b-9990-b2d45f1aa91b")){
                    indexJX.add(indexAll.get(i));
                }
                if(indexAll.get(i).getId().equals("f5462bb1-7151-4d1c-8d8e-d3653dc53e9a")){
                    indexJX.add(indexAll.get(i));
                }
                if(indexAll.get(i).getId().equals("13673a54-fa67-4f02-aeea-e4725ffbc853")){
                    indexJX.add(indexAll.get(i));
                }
                if (indexAll.get(i).getId().equals("14c0f70a-5f6a-47c9-9ea4-4356773aa225")) {
                    indexJX.add(indexAll.get(i));
                }
                if (indexAll.get(i).getId().equals("e924e4a9-0698-4624-8947-66cf883e8809")) {
                    indexJX.add(indexAll.get(i));
                }
            }
            for (int i = 0; i < indexJX.size(); i++) {
                for (int j = 0; j < indexSelect.size(); j++) {
                    if (indexJX.get(i).getTitle().equals(indexSelect.get(j).getTitle())) {
                        indexJX.get(i).setSelect(true);
                    }
                }
            }
            index1.setChilds(indexJX);
            menuList.add(index1);

            MenuEntity index2 = new MenuEntity();
            index2.setTitle("其他");
            index2.setId("2");

            List<MenuEntity> indexQT=new ArrayList<MenuEntity>();
            for (int i = 0; i < indexAll.size(); i++) {
                if(indexAll.get(i).getId().equals("1437cd9c-4595-46cb-8fde-e866e43f0825")){
                    indexQT.add(indexAll.get(i));
                }
                if(indexAll.get(i).getId().equals("1cd85fc6-0b69-4f04-aa79-883c6ba8649e")){
                    indexQT.add(indexAll.get(i));
                }
                if(indexAll.get(i).getId().equals("a4f08830-adaa-4412-9adf-55b9e773118e")){
                    indexQT.add(indexAll.get(i));
                }
            }
            for (int i = 0; i < indexQT.size(); i++) {
                for (int j = 0; j < indexSelect.size(); j++) {
                    if (indexQT.get(i).getTitle().equals(indexSelect.get(j).getTitle())) {
                        indexQT.get(i).setSelect(true);
                    }
                }
            }
            index2.setChilds(indexQT);
            menuList.add(index2);

            menuParentAdapter = new MenuParentAdapter(this,this, menuList);
            expandableListView.setAdapter(menuParentAdapter);

            // expandableListView.expandGroup(6); // 在分组列表视图中 展开一组
            // expandableListView.isGroupExpanded(0); //判断此组是否展开
            for (int i = 0; i < menuParentAdapter.getGroupCount(); i++) {
                expandableListView.expandGroup(i);
            }
            expandableListView.setOnGroupClickListener((expandableListView, view, groupPosition, l) -> {
                MenuEntity cateModel = menuList.get(groupPosition);
                return true;
            });
            expandableListView.setOnItemClickListener((arg0, arg1, arg2, arg3) -> {
                if (getBarRightText().equals("管理")) {
                    MenuEntity cateModel = menuList.get(arg2);
                    initUrl(cateModel);
                }
            });

            expandableListView.setOnItemLongClickListener((arg0, arg1, arg2, arg3) -> {
                if (getBarRightText().equals("管理")) {
                    setBarRightText("完成");
                    adapterSelect.setEdit();
                    menuParentAdapter.setEdit();
                }
                return false;
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void DelMeun(MenuEntity indexData, int position) {
        for (int i = 0; i < menuList.size(); i++) {
            for (int k = 0; k < menuList.get(i).getChilds().size(); k++) {
                if (menuList.get(i).getChilds().get(k).getTitle().equals(indexData.getTitle())) {
                    menuList.get(i).getChilds().get(k).setSelect(false);
                }
            }
        }
        if(menuParentAdapter!=null){
            menuParentAdapter.notifyDataSetChanged();
        }
        adapterSelect.notifyDataSetChanged();
    }

    @Override
    public void initUrl(MenuEntity cateModel) {
        if (getBarRightText().equals("管理")) {
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            String title = cateModel.getTitle();
            String strId = cateModel.getId();
            ToastUtils.showShort(title);
        }
    }

    @Override
    public void AddMenu(MenuEntity menuEntity) {
        indexSelect.add(menuEntity);
        UserLoginUtils.getInstance().setChannelTemp(indexSelect);
        for (int i = 0; i < menuList.size(); i++) {
            for (int k = 0; k < menuList.get(i).getChilds().size(); k++) {
                if (menuList.get(i).getChilds().get(k).getTitle().equals(menuEntity.getTitle())) {
                    menuList.get(i).getChilds().get(k).setSelect(true);
                }
            }
        }
        menuParentAdapter.notifyDataSetChanged();
        adapterSelect.notifyDataSetChanged();
    }
}
