package com.dinlive.din.person.model;

import java.util.Objects;

/**
 * @author daifalin
 * @date 2019-10-14 17:16
 * @ClassName DemoBean
 * @Description
 */
public class DemoBean {

    private String img;
    private boolean isShow;
    public DemoBean(String img, boolean isShow) {
        this.img = img;
        this.isShow = isShow;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    @Override
    public String toString() {
        return "DemoBean{" +
                "img='" + img + '\'' +
                ", isShow=" + isShow +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DemoBean demoBean = (DemoBean) o;
        return isShow == demoBean.isShow &&
                Objects.equals(img, demoBean.img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(img, isShow);
    }
}
