package com.dinlive.din.baselib.utils;

import com.dinlive.din.baselib.model.User;
import com.google.gson.Gson;

/**
 * Created by superman on 2019/6/28.
 */
public class UserLoginUtils {
    public static User getUser() {
        String userInfoStr = PreUtils.getString("UserInfo", "");
        if (userInfoStr.isEmpty()){
            return null;
        }
        User user = new Gson().fromJson(userInfoStr, User.class);
        return user;
    }

    public static void upDateUser(User user) {
        PreUtils.putString("UserInfo", new Gson().toJson(user));
    }

    public static void cleanUser() {
        PreUtils.clear();
    }
}