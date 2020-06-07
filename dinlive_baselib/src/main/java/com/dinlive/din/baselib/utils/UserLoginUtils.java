package com.dinlive.din.baselib.utils;

import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.SPUtils;
import com.dinlive.din.baselib.model.User;
import com.dinlive.din.baselib.wiget.channel.MenuEntity;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by superman on 2019/6/28.
 */
public class UserLoginUtils extends SpConstants {
    private volatile static UserLoginUtils instance;

    public static UserLoginUtils getInstance() {
        if (instance == null) {
            synchronized (UserLoginUtils.class) {
                if (instance == null) {
                    instance = new UserLoginUtils();
                }
            }
        }
        return instance;
    }

    /**
     * 获取用户信息
     *
     * @return
     */
    public User getUser() {
        return GsonUtils.fromJson(SPUtils.getInstance(USER_SP_NAME).getString(USER_DATA_GSON), User.class);
    }

    /**
     * 保存用户信息
     */
    public static void setUser(User user) {
        if (user != null) {
            SPUtils.getInstance(USER_SP_NAME).put(USER_DATA_GSON, GsonUtils.toJson(user));
        }
    }

    /**
     * 删除登录的用户信息
     */
    public void deleteUser() {
        SPUtils.getInstance(USER_SP_NAME).remove(USER_DATA_GSON);
    }


    /**
     * 获取用户频道数据
     */
    public List<MenuEntity> getChannel() {
        return GsonUtils.fromJson(SPUtils.getInstance(USER_SP_NAME).getString(USER_CHANNEL_GSON), new TypeToken<List<MenuEntity>>() {
        }.getType());
    }

    /**
     * 保存用户频道数据
     */
    public void setChannel(List<MenuEntity> channels) {
        if (channels != null) {
            SPUtils.getInstance(USER_SP_NAME).put(USER_CHANNEL_GSON, GsonUtils.toJson(channels));
        }
    }

    /**
     * 获取用户频道数据 临时保存
     */
    public List<MenuEntity> getChannelTemp() {
        return GsonUtils.fromJson(SPUtils.getInstance(USER_SP_NAME).getString(USER_SAVECHANNELTEMP_GSON), new TypeToken<List<MenuEntity>>() {
        }.getType());
    }

    /**
     * 保存用户频道数据 临时保存
     */
    public void setChannelTemp(List<MenuEntity> channels) {
        if (channels != null) {
            SPUtils.getInstance(USER_SP_NAME).put(USER_SAVECHANNELTEMP_GSON, GsonUtils.toJson(channels));
        }
    }

    /**
     * 获取用户频道数据 临时保存
     */
    public List<MenuEntity> getChannelAll() {
        return GsonUtils.fromJson(SPUtils.getInstance(USER_SP_NAME).getString(USER_CHANNELALLGSON), new TypeToken<List<MenuEntity>>() {
        }.getType());
    }

    /**
     * 保存用户频道数据 临时保存
     */
    public void setChannelAll(List<MenuEntity> channels) {
        if (channels != null) {
            SPUtils.getInstance(USER_SP_NAME).put(USER_CHANNELALLGSON, GsonUtils.toJson(channels));
        }
    }
}
