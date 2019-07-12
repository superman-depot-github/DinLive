package com.dinlive.din.baselib.utils;

import android.util.Log;

/**
 * 日志打印
 * Created by superman on 2018/4/9.
 */

public class LogUtil {

    public static final String TAG = "DinLive";

    /**
     * @param msg
     */
    public static void i(String msg) {
        Log.i(TAG, msg != null ? msg : "");
    }

    /**
     * @param tag
     * @param msg
     */
    public static void i(String tag, String msg) {
        Log.i(tag, msg != null ? msg : "");
    }

    /**
     * @param msg
     */
    public static void d(String msg) {
        Log.d(TAG, msg != null ? msg : "");
    }

    /**
     * @param tag
     * @param msg
     */
    public static void d(String tag, String msg) {
        Log.d(tag, msg != null ? msg : "");
    }

    /**
     * @param msg
     */
    public static void e(String msg) {
        Log.e(TAG, msg != null ? msg : "");
    }

    /**
     * @param tag
     * @param msg
     */
    public static void e(String tag, String msg) {
        Log.e(tag, msg != null ? msg : "");
    }

    /**
     * @param msg
     */
    public static void w(String msg) {
        Log.w(TAG, msg != null ? msg : "");
    }

    /**
     * @param tag
     * @param msg
     */
    public static void w(String tag, String msg) {
        Log.w(tag, msg != null ? msg : "");
    }

    /**
     * @param msg
     */
    public static void v(String msg) {
        Log.v(TAG, msg != null ? msg : "");
    }

    /**
     * @param tag
     * @param msg
     */
    public static void v(String tag, String msg) {
        Log.v(tag, msg != null ? msg : "");
    }
}
