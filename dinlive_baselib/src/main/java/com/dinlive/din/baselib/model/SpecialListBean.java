package com.dinlive.din.baselib.model;

import java.util.List;
import java.util.Objects;

/**
 * Created by superman on 2019/6/28.
 */
public class SpecialListBean {
    private int start;
    private int more;
    private List<SpecialBean> list;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getMore() {
        return more;
    }

    public void setMore(int more) {
        this.more = more;
    }

    public List<SpecialBean> getList() {
        return list;
    }

    public void setList(List<SpecialBean> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SpecialListBean that = (SpecialListBean) o;
        return start == that.start &&
                more == that.more &&
                Objects.equals(list, that.list);
    }

    @Override
    public int hashCode() {

        return Objects.hash(start, more, list);
    }

    @Override
    public String toString() {
        return "SpecialListBean{" +
                "start=" + start +
                ", more=" + more +
                ", list=" + list +
                '}';
    }

    public class SpecialBean {
        private String theme;
        private String column_name;
        private String image_url;
        private String link;

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }

        public String getColumn_name() {
            return column_name;
        }

        public void setColumn_name(String column_name) {
            this.column_name = column_name;
        }

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SpecialBean that = (SpecialBean) o;
            return Objects.equals(theme, that.theme) &&
                    Objects.equals(column_name, that.column_name) &&
                    Objects.equals(image_url, that.image_url) &&
                    Objects.equals(link, that.link);
        }

        @Override
        public int hashCode() {

            return Objects.hash(theme, column_name, image_url, link);
        }

        @Override
        public String toString() {
            return "SpecialBean{" +
                    "theme='" + theme + '\'' +
                    ", column_name='" + column_name + '\'' +
                    ", image_url='" + image_url + '\'' +
                    ", link='" + link + '\'' +
                    '}';
        }
    }
}
