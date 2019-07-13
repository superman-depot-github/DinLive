package com.dinlive.din.baselib.model;

import java.util.List;
import java.util.Objects;

/**
 * Created by superman on 2019/6/28.
 */
public class NewsDetailedBean {
    private int start;
    private int more;
    //private String banner_list;
    //private String flash_list;
    private List<NewsBean> article_list;

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

    public List<NewsBean> getArticle_list() {
        return article_list;
    }

    public void setArticle_list(List<NewsBean> article_list) {
        this.article_list = article_list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewsDetailedBean that = (NewsDetailedBean) o;
        return start == that.start &&
                more == that.more &&
                Objects.equals(article_list, that.article_list);
    }


    @Override
    public int hashCode() {

        return Objects.hash(start, more, article_list);
    }

    public class BannerBean {
        private String theme;
        private String image_url;
        private String link;

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
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
            BannerBean that = (BannerBean) o;
            return Objects.equals(theme, that.theme) &&
                    Objects.equals(image_url, that.image_url) &&
                    Objects.equals(link, that.link);
        }

        @Override
        public int hashCode() {

            return Objects.hash(theme, image_url, link);
        }

        @Override
        public String toString() {
            return "BannerBean{" +
                    "theme='" + theme + '\'' +
                    ", image_url='" + image_url + '\'' +
                    ", link='" + link + '\'' +
                    '}';
        }
    }

    public class FlashBean {
        private String theme;
        private String image_url;
        private String link;

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
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
            FlashBean flashBean = (FlashBean) o;
            return Objects.equals(theme, flashBean.theme) &&
                    Objects.equals(image_url, flashBean.image_url) &&
                    Objects.equals(link, flashBean.link);
        }

        @Override
        public int hashCode() {

            return Objects.hash(theme, image_url, link);
        }

        @Override
        public String toString() {
            return "FlashBean{" +
                    "theme='" + theme + '\'' +
                    ", image_url='" + image_url + '\'' +
                    ", link='" + link + '\'' +
                    '}';
        }
    }

    public class NewsBean {
        private String theme;
        private String type;
        private String column_name;
        private String image_url;
        private String link;

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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
            NewsBean newsBean = (NewsBean) o;
            return Objects.equals(theme, newsBean.theme) &&
                    Objects.equals(type, newsBean.type) &&
                    Objects.equals(column_name, newsBean.column_name) &&
                    Objects.equals(image_url, newsBean.image_url) &&
                    Objects.equals(link, newsBean.link);
        }

        @Override
        public int hashCode() {

            return Objects.hash(theme, type, column_name, image_url, link);
        }

        @Override
        public String toString() {
            return "NewsBean{" +
                    "theme='" + theme + '\'' +
                    ", type='" + type + '\'' +
                    ", column_name='" + column_name + '\'' +
                    ", image_url='" + image_url + '\'' +
                    ", link='" + link + '\'' +
                    '}';
        }
    }
}
