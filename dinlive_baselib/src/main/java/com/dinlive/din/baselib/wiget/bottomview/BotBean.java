package com.dinlive.din.baselib.wiget.bottomview;

public class BotBean {
    String iconName;// 导航栏图标名字

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public int getUnCheckedIcon() {
        return unCheckedIcon;
    }

    public void setUnCheckedIcon(int unCheckedIcon) {
        this.unCheckedIcon = unCheckedIcon;
    }

    int unCheckedIcon;// 未选中的图标
    int checkedIcon;// 未选中的图标

    public int getCheckedIcon() {
        return checkedIcon;
    }

    public void setCheckedIcon(int checkedIcon) {
        this.checkedIcon = checkedIcon;
    }

    public BotBean(String iconName, int unCheckedIcon, int checkedIcon) {
        this.iconName = iconName;
        this.unCheckedIcon = unCheckedIcon;
        this.checkedIcon = checkedIcon;
    }


}
