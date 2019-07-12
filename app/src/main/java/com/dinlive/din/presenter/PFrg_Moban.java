package com.dinlive.din.presenter;


import com.dinlive.din.baselib.Base.BasePresenter;
import com.dinlive.din.MobanFragment;
import com.dinlive.din.view.IVFrg_Moban;

public class PFrg_Moban extends BasePresenter<IVFrg_Moban> {
    private MobanFragment context;

    public PFrg_Moban(MobanFragment mobanFragment) {
        super();
        this.context = mobanFragment;
    }

    public void findAll() {
//        ServiceManager
//                .getApiService()
//                .findAll()
//                .compose(context.<HttpRespResult<List<RoomInfoBean>>>bindToLifecycle())
//                .compose(TransformerHelper.<List<RoomInfoBean>>transformer())
//                .compose(new DialogTransformer(context.getActivity()).<HttpRespResult<List<RoomInfoBean>>>showDialog())
//                .subscribe(new CommonObserver<List<RoomInfoBean>>() {
//                    @Override
//                    protected void onSuccess(List<RoomInfoBean> roomInfoBeans) {
//                        getView().showData(roomInfoBeans);
//                    }
//
//                    @Override
//                    protected void onError(ExceptionHandle.ResponseException exception) {
//
//                    }
//                });

    }
}
