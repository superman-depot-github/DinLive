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
     * dinlive_baselib模块
     */
    String BASE = "/dinlive_baselib/";
    String BASE_ACTIVITY_AGENTWEB = BASE + "AgentWebActivity";
    String BASE_FRAGMENT_AGENTWEB = BASE + "AgentWebFragment";

    /**
     * home模块
     */
    String HOME = "/module_home/";
    String HOME_FRAGMENT_HOME = HOME + "Fragment_home";
    /**
     * find模块
     */
    String FIND = "/module_find/";
    String FIND_FRAGMENT = FIND + "Fragment_Find";

    /**
     * person模块
     */
    String PERSON = "/module_person/";
    String PERSON_TIMEUTILS_ACTIVITY = PERSON + "TimeUtilsActivity";
    String PERSON_BANNERS_ACTIVITY = PERSON + "BannersActivity";
    String PERSON_UTILS_ACTIVITY = PERSON + "UtilsActivity";
    String PERSON_MENUMANAGE_ACTIVITY = PERSON + "MenuManageActivity";
    String PERSON_DROPDOWNMENU_ACTIVITY = PERSON + "DropDownMenuActivity";
    String PERSON_FRAGMENT = PERSON + "FavoriteFragment";

    /**
     * Login模块
     */
    String LOGIN = "/module_login/";
    String LOGIN_ACTIVITY = LOGIN + "LoginActivity";
    String LOGIN_ACCOUNTLOGIN_FRAGMENT = LOGIN + "AccountLoginFragment";
    String LOGIN_PHONEQUICKLOGIN_FRAGMENT = LOGIN + "PhoneQuickLoginFragment";
    String LOGIN_REGISTER_FRAGMENT = LOGIN + "RegisterFragment";
    String LOGIN_BINDSEETING_FRAGMENT = LOGIN + "BindSeetingFragment";

}
