package com.dinlive.din.person;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.holder.Holder;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.blankj.utilcode.util.ToastUtils;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.dinlive.din.baselib.base.BaseActivity;
import com.dinlive.din.baselib.base.BasePresenter;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.dinlive.din.baselib.utils.ImageLoaderUtils;
import com.dinlive.din.person.adapter.DemoAdapter;
import com.dinlive.din.person.model.DemoBean;
import com.dinlive.din.person.widget.banner.BannerLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 借鉴于
 * https://github.com/ren93/RecyclerBanner
 */
@Route(path = ARouterHub.PERSON_BANNERS_ACTIVITY, name = "Banner类工具")
public class BannersActivity extends BaseActivity {
    @BindView(R2.id.bannerLayout)
    BannerLayout bannerLayout;
    @BindView(R2.id.convenientBanner)
    ConvenientBanner convenientBanner;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_banner;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView() {
        setBarTitle("banner工具类");
        List<DemoBean> list = new ArrayList<>();
        list.add(new DemoBean("http://img0.imgtn.bdimg.com/it/u=1352823040,1166166164&fm=27&gp=0.jpg", true));
        list.add(new DemoBean("http://img3.imgtn.bdimg.com/it/u=2293177440,3125900197&fm=27&gp=0.jpg", false));
        list.add(new DemoBean("http://img4.imgtn.bdimg.com/it/u=1243617734,335916716&fm=27&gp=0.jpg", true));
        DemoAdapter signInOutAdapter = new DemoAdapter(this, list);
        signInOutAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(BannersActivity.this, ((DemoBean) adapter.getData().get(position)).getImg(), Toast.LENGTH_SHORT).show();
            }
        });
        bannerLayout.setAdapter(signInOutAdapter);


        //自定义你的Holder，实现更多复杂的界面，不一定是图片翻页，其他任何控件翻页亦可。
        convenientBanner.setPages(
                new CBViewHolderCreator() {

                    @Override
                    public Holder createHolder(View itemView) {
                        return new Holder<DemoBean>(itemView) {
                            ImageView img;
                            TextView tv;

                            @Override
                            protected void initView(View itemView) {
                                img = itemView.findViewById(R.id.image);
                                tv = itemView.findViewById(R.id.title);
                            }

                            @Override
                            public void updateUI(DemoBean data) {
                                ImageLoaderUtils.loadImage(BannersActivity.this, data.getImg(), img);
                                if (data.isShow()) {
                                    tv.setVisibility(View.VISIBLE);
                                } else {
                                    tv.setVisibility(View.GONE);
                                }

                                tv.setOnClickListener(view -> {
                                    ToastUtils.showShort("nidianlwo");
                                });
                            }
                        };
                    }

                    @Override
                    public int getLayoutId() {
                        return R.layout.item_layout;
                    }
                }, list)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
//                .setPageIndicator(new int[]{R.drawable.ic_page_indicator, R.drawable.ic_page_indicator_focused})
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        ToastUtils.showShort(position + "");
                    }
                }).setPointViewVisible(true);
        //设置指示器的方向
//                .setPageIndicatorAlign(ConvenientBanner.PageIndicatorAlign.ALIGN_PARENT_RIGHT)
//                .setOnPageChangeListener(this)//监听翻页事件
        ;

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }
}
