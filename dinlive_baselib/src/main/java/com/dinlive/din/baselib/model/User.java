package com.dinlive.din.baselib.model;

import java.util.Objects;

/**
 * Created by superman on 2019/6/28.
 */
public class User {
    private Token token;
    private UserInfo user_info;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public UserInfo getUser_info() {
        return user_info;
    }

    public void setUser_info(UserInfo user_info) {
        this.user_info = user_info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(token, user.token) &&
                Objects.equals(user_info, user.user_info);
    }

    @Override
    public String toString() {
        return "User{" +
                "token=" + token +
                ", user_info=" + user_info +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, user_info);
    }

    public class Token {
        private String value;
        private Long expire_time;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Long getExpire_time() {
            return expire_time;
        }

        public void setExpire_time(Long expire_time) {
            this.expire_time = expire_time;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Token token = (Token) o;
            return Objects.equals(value, token.value) &&
                    Objects.equals(expire_time, token.expire_time);
        }

        @Override
        public int hashCode() {

            return Objects.hash(value, expire_time);
        }

        @Override
        public String toString() {
            return "Token{" +
                    "value='" + value + '\'' +
                    ", expire_time=" + expire_time +
                    '}';
        }
    }

    public class UserInfo {
        private String head_url;
        private String nickname;
        private String mobile;
        private String email;

        public String getHead_url() {
            return head_url;
        }

        public void setHead_url(String head_url) {
            this.head_url = head_url;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            UserInfo userInfo = (UserInfo) o;
            return Objects.equals(head_url, userInfo.head_url) &&
                    Objects.equals(nickname, userInfo.nickname) &&
                    Objects.equals(mobile, userInfo.mobile) &&
                    Objects.equals(email, userInfo.email);
        }

        @Override
        public int hashCode() {

            return Objects.hash(head_url, nickname, mobile, email);
        }

        @Override
        public String toString() {
            return "UserInfo{" +
                    "head_url='" + head_url + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", mobile='" + mobile + '\'' +
                    ", email='" + email + '\'' +
                    '}';
        }
    }


}

