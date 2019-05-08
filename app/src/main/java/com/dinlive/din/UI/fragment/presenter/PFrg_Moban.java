package com.dinlive.din.UI.fragment.presenter;


import com.dinlive.din.UI.Base.BasePresenter;
import com.dinlive.din.UI.fragment.MobanFragment;
import com.dinlive.din.UI.fragment.model.RoomInfoBean;
import com.dinlive.din.UI.fragment.view.IVFrg_Moban;
import com.dinlive.din.net.result.ExceptionHandle;
import com.dinlive.din.net.result.HttpRespResult;
import com.dinlive.din.net.rxjava.observable.DialogTransformer;
import com.dinlive.din.net.rxjava.observable.TransformerHelper;
import com.dinlive.din.net.rxjava.observer.CommonObserver;
import com.dinlive.din.net.service.ServiceManager;

import java.util.List;

public class PFrg_Moban extends BasePresenter<IVFrg_Moban> {
    private MobanFragment context;

    public PFrg_Moban(MobanFragment mobanFragment) {
        super();
        this.context = mobanFragment;
    }

    public void findAll() {
        ServiceManager
                .getApiService()
                .findAll()
                .compose(context.<HttpRespResult<List<RoomInfoBean>>>bindToLifecycle())
                .compose(TransformerHelper.<List<RoomInfoBean>>transformer())
                .compose(new DialogTransformer(context.getActivity()).<HttpRespResult<List<RoomInfoBean>>>showDialog())
                .subscribe(new CommonObserver<List<RoomInfoBean>>() {
                    @Override
                    protected void onSuccess(List<RoomInfoBean> roomInfoBeans) {
                        getView().showData(roomInfoBeans);
                    }

                    @Override
                    protected void onError(ExceptionHandle.ResponseException exception) {

                    }
                });

    }
}
