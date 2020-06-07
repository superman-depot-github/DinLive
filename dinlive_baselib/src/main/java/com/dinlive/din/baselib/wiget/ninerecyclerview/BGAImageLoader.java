package com.dinlive.din.baselib.wiget.ninerecyclerview;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.ImageView;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:16/6/25 下午4:30
 * 描述:
 */
public abstract class BGAImageLoader {

    protected String getPath(String path) {
        if (path == null) {
            path = "";
        }

        if (!path.startsWith("http") && !path.startsWith("file")) {
            path = "file://" + path;
        }
        return path;
    }

    protected Activity getActivity(View view) {
        Context context = view.getContext();
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public abstract void display(ImageView imageView, String path, @DrawableRes int loadingResId, @DrawableRes int failResId, int width, int height, DisplayDelegate delegate);

    public abstract void download(String path, DownloadDelegate delegate);

    public abstract void pause(Activity activity);

    public abstract void resume(Activity activity);

    public interface DisplayDelegate {
        void onSuccess(View view, String path);
    }

    public interface DownloadDelegate {
        void onSuccess(String path, Bitmap bitmap);

        void onFailed(String path);
    }
}
