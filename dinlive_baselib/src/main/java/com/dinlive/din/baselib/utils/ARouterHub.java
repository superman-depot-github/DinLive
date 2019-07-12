package com.dinlive.din.baselib.utils;

/**
 * The interface A router hub.
 *
 * @author acb
 * @date 2018 /6/28 10:04
 * @ClassName ARouterHub
 * @Description <ARouter跳转路由地址>
 */
public interface ARouterHub {
    /**
     * home模块
     */
    String HOME = "/module_home/";
    String HOME_FRAGMENT = HOME + "FavoriteFragment";

    /**
     * person模块
     */
    String PERSON = "/module_person/";
    String PERSON_FRAGMENT = PERSON + "FavoriteFragment";

    /**
     * Login模块
     */
    String LOGIN = "/module_login/";
    String LOGIN_ACTIVITY = LOGIN + "LoginActivity";

}
