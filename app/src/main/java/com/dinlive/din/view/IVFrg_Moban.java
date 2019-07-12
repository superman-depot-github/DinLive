package com.dinlive.din.view;


import com.dinlive.din.baselib.Base.IBaseView;
import com.dinlive.din.model.RoomInfoBean;

import java.util.List;

public interface IVFrg_Moban extends IBaseView {
    void showData(List<RoomInfoBean> roomInfoBeans);
}
