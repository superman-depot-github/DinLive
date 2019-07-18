package com.dinlive.din.baselib.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.dinlive.din.baselib.R;


/**
 * Created by dengjie on 2018/11/6.
 * description dialog管理类
 */

public class DialogUtil {
    /**
     * 警告对话框
     *
     * @param context
     * @param content
     * @return
     */
    public static Dialog showWarningDialog(Context context, String content) {
        View view = LayoutInflater.from(context).inflate(R.layout.dialog_warning, null);
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
//        9
//        adjustSizeGravity(dialog, AppUtil.getScreenWidth() * 2 / 3, 0, Gravity.CENTER);
        dialog.show();
        return dialog;
    }


    /**
     * 调整dialog的size和位置
     *
     * @param dialog
     * @param x
     * @param y
     * @param gravity
     */
    private static void adjustSizeGravity(Dialog dialog, int x, int y, int gravity) {
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams params = dialogWindow.getAttributes();
        params.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        if (x != 0) {
            lp.width = x;
        }
        if (y != 0) {
            lp.height = y;
        }
        if (gravity != 0) {
            dialogWindow.setGravity(gravity);
        }
        dialogWindow.setAttributes(lp);
    }

    public interface OnDialogClick {
        void onTake();

        void onSelect();
    }
}