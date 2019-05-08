package com.dinlive.din.UI.fragment.view;


import com.dinlive.din.UI.Base.IBaseView;
import com.dinlive.din.UI.fragment.model.RoomInfoBean;

import java.util.List;

public interface IVFrg_Moban extends IBaseView {
    void showData(List<RoomInfoBean> roomInfoBeans);
}
