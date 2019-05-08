package com.dinlive.din.UI.activity.presenter;

import com.dinlive.din.UI.Base.BasePresenter;
import com.dinlive.din.UI.activity.view.IVAct_Main;

public class PAct_Main extends BasePresenter<IVAct_Main> {
//    public void getData() {
//        ServiceManager
//                .getApiService()
//                .getBigPrizeWinRanking()
//                .compose(((MainActivity) context).<HttpRespResult<List<BigPrizeWinRankingBean>>>bindToLifecycle())
//                .compose(TransformerHelper.<List<BigPrizeWinRankingBean>>transformer())
//                .compose(new DialogTransformer(context).<HttpRespResult<List<BigPrizeWinRankingBean>>>showDialog())//是否显示加载进度条  注掉不显示
//                .subscribe(new CommonObserver<List<BigPrizeWinRankingBean>>() {
//                    @Override
//                    public void onSuccess(List<BigPrizeWinRankingBean> bigPrizeWinRankingBeans) {
//                        getView().showData(bigPrizeWinRankingBeans);
//                    }
//
//                    @Override
//                    public void onError(ExceptionHandle.ResponseException exception) {
//                        UniversalToast.makeText(context, exception.getMessage(), UniversalToast.LENGTH_SHORT)
//                                .setGravity(Gravity.BOTTOM, 0, 100).showWarning();
//                    }
//                });
//
//        Map<String, Integer> map = new HashMap();
//        map.put("page", 1);
//        ServiceManager
//                .getApiService()
//                .getDkOrders(map)
//                .compose(((MainActivity) context).<HttpRespResult<DkOrdersInfo>>bindToLifecycle())
//                .compose(TransformerHelper.<DkOrdersInfo>transformer())
//                .compose(new DialogTransformer(context).<HttpRespResult<DkOrdersInfo>>showDialog())//是否显示加载进度条  注掉不显示
//                .subscribe(new CommonObserver<DkOrdersInfo>() {
//                    @Override
//                    public void onSuccess(DkOrdersInfo bigPrizeWinRankingBeans) {
//                        //getView().showData(bigPrizeWinRankingBeans);
//                    }
//
//                    @Override
//                    public void onError(ExceptionHandle.ResponseException exception) {
//                        UniversalToast.makeText(context, exception.message, UniversalToast.LENGTH_SHORT)
//                                .setGravity(Gravity.BOTTOM, 0, 100).showWarning();
//                    }
//                });
//    }
}
