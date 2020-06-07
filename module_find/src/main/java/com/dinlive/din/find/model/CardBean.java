package com.dinlive.din.find.model;

public class CardBean {
    private String src;
    private String desc;

    public CardBean(String src, String desc) {
        this.src = src;
        this.desc = desc;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
