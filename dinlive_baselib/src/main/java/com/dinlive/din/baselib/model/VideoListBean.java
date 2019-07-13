package com.dinlive.din.baselib.model;

import java.util.List;
import java.util.Objects;

/**
 * Created by superman on 2019/6/28.
 */
public class VideoListBean {
    private int start;
    private int more;
    private List<VideoBean> list;

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

    public List<VideoBean> getList() {
        return list;
    }

    public void setList(List<VideoBean> list) {
        this.list = list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VideoListBean that = (VideoListBean) o;
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
        return "VideoListBean{" +
                "start=" + start +
                ", more=" + more +
                ", list=" + list +
                '}';
    }

    public class VideoBean {
        private String theme;
        private String description;
        private String video_is_sans_href;
        private String video_ur;

        public String getTheme() {
            return theme;
        }

        public void setTheme(String theme) {
            this.theme = theme;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getVideo_is_sans_href() {
            return video_is_sans_href;
        }

        public void setVideo_is_sans_href(String video_is_sans_href) {
            this.video_is_sans_href = video_is_sans_href;
        }

        public String getVideo_ur() {
            return video_ur;
        }

        public void setVideo_ur(String video_ur) {
            this.video_ur = video_ur;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            VideoBean videoBean = (VideoBean) o;
            return Objects.equals(theme, videoBean.theme) &&
                    Objects.equals(description, videoBean.description) &&
                    Objects.equals(video_is_sans_href, videoBean.video_is_sans_href) &&
                    Objects.equals(video_ur, videoBean.video_ur);
        }

        @Override
        public int hashCode() {

            return Objects.hash(theme, description, video_is_sans_href, video_ur);
        }

        @Override
        public String toString() {
            return "VideoBean{" +
                    "theme='" + theme + '\'' +
                    ", description='" + description + '\'' +
                    ", video_is_sans_href='" + video_is_sans_href + '\'' +
                    ", video_ur='" + video_ur + '\'' +
                    '}';
        }
    }
}
