package com.dinlive.din.home.presenter;


import com.dinlive.din.baselib.Base.BasePresenter;
import com.dinlive.din.baselib.model.NewsDetailedBean;
import com.dinlive.din.baselib.net.result.HttpRespResult;
import com.dinlive.din.baselib.net.rxjava.converter.ResultException;
import com.dinlive.din.baselib.net.rxjava.observable.TransformerHelper;
import com.dinlive.din.baselib.net.rxjava.observer.CommonObserver;
import com.dinlive.din.baselib.net.service.ParmsUtils;
import com.dinlive.din.baselib.net.service.ServiceManager;
import com.dinlive.din.home.Fragment_home;
import com.dinlive.din.home.view.IVFrg_Home;

import java.util.Map;

public class PFrg_Home extends BasePresenter<IVFrg_Home> {
    private Fragment_home context;

    public PFrg_Home(Fragment_home fragment) {
        context = fragment;
    }

    public void recommendList(int loadType, int start) {
        Map<String, String> map = ParmsUtils.getParmsMap();
        map.put("id", "recommend");
        map.put("start", String.valueOf(start));
        ServiceManager
                .getApiService()
                .recommendList(map)
                .compose(context.<HttpRespResult<NewsDetailedBean>>bindToLifecycle())
                .compose(TransformerHelper.<NewsDetailedBean>transformer())
                //.compose(new DialogTransformer(context.getActivity()).<HttpRespResult<NewsDetailedBean>>showDialog())
                // .compose(new NewStateTransformer(context.getActivity()).<HttpRespResult<NewsDetailedBean>>CheckNet())
                .subscribe(new CommonObserver<NewsDetailedBean>() {
                    @Override
                    protected void onSuccess(NewsDetailedBean newsDetailedBean) {
                        getView().recommendListSuccess(loadType, newsDetailedBean);
                    }

                    @Override
                    protected void onError(ResultException exception) {
                        getView().recommendListFaild(loadType,exception);
                    }
                });
    }
}
