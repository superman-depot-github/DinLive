package com.dinlive.din.UI.fragment.model;

import java.util.Objects;

public class RoomInfoBean {
    private long id;
    private String name;
    private String describe;
    private String poster;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }


    @Override
    public String toString() {
        return "RoomInfoBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", describe='" + describe + '\'' +
                ", poster='" + poster + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomInfoBean that = (RoomInfoBean) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(describe, that.describe) &&
                Objects.equals(poster, that.poster);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, describe, poster);
    }
}
