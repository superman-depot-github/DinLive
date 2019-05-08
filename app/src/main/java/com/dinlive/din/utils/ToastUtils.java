package com.dinlive.din.utils;

import android.support.annotation.StringRes;
import android.widget.Toast;

import com.dinlive.din.app.MyAppliction;

/**
 * Created by superman on 2018/6/20.
 */
public class ToastUtils {

    private static Toast toast;

    public static void show(String text) {
        if (toast == null) {
            toast = Toast.makeText(MyAppliction.context, "", Toast.LENGTH_LONG);
//            toast.setGravity(Gravity.CENTER, 0, 0);
        }
        toast.setText(text);
        toast.show();
    }

    public static void show(@StringRes int resId) {
        show(MyAppliction.context.getResources().getString(resId));
    }

}
