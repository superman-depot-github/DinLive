package com.dinlive.din.baselib.wiget.ninerecyclerview;

import android.app.Activity;
import android.support.annotation.DrawableRes;
import android.util.Log;
import android.widget.ImageView;

/**
 * 作者:王浩 邮件:bingoogolapple@gmail.com
 * 创建时间:16/6/25 下午5:03
 * 描述:
 */
public class BGAImage {
    private static final String TAG = BGAImage.class.getSimpleName();
    private static BGAImageLoader sImageLoader;

    private BGAImage() {
    }

    private static final BGAImageLoader getImageLoader() {
        if (sImageLoader == null) {
            synchronized (BGAImage.class) {
                if (sImageLoader == null) {
                    if (isClassExists("com.bumptech.glide.Glide")) {
                        sImageLoader = new BGAGlideImageLoader();
                    } else if (isClassExists("com.squareup.picasso.Picasso")) {
                        //sImageLoader = new BGAPicassoImageLoader();
                    } else if (isClassExists("com.nostra13.universalimageloader.core.ImageLoader")) {
                        //sImageLoader = new BGAUILImageLoader();
                    } else if (isClassExists("org.xutils.x")) {
                        //sImageLoader = new BGAXUtilsImageLoader();
                    } else {
                        throw new RuntimeException("必须在你的build.gradle文件中配置「Glide、Picasso、universal-image-loader、XUtils3」中的某一个图片加载库的依赖");
                    }
                }
            }
        }
        return sImageLoader;
    }

    /**
     * 设置开发者自定义 ImageLoader
     *
     * @param imageLoader
     */
    public static void setImageLoader(BGAImageLoader imageLoader) {
        sImageLoader = imageLoader;
    }

    private static final boolean isClassExists(String classFullName) {
        try {
            Class.forName(classFullName);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static void display(ImageView imageView, @DrawableRes int loadingResId, @DrawableRes int failResId, String path, int width, int height, final BGAImageLoader.DisplayDelegate delegate) {
        try {
            getImageLoader().display(imageView, path, loadingResId, failResId, width, height, delegate);
        } catch (Exception e) {
            Log.d(TAG, "显示图片失败：" + e.getMessage());
        }
    }

    public static void display(ImageView imageView, @DrawableRes int placeholderResId, String path, int width, int height, final BGAImageLoader.DisplayDelegate delegate) {
        display(imageView, placeholderResId, placeholderResId, path, width, height, delegate);
    }

    public static void display(ImageView imageView, @DrawableRes int placeholderResId, String path, int width, int height) {
        display(imageView, placeholderResId, path, width, height, null);
    }

    public static void display(ImageView imageView, @DrawableRes int placeholderResId, String path, int size) {
        display(imageView, placeholderResId, path, size, size);
    }

    public static void download(String path, final BGAImageLoader.DownloadDelegate delegate) {
        try {
            getImageLoader().download(path, delegate);
        } catch (Exception e) {
            Log.d(TAG, "下载图片失败：" + e.getMessage());
        }
    }

    /**
     * 暂停加载
     *
     * @param activity
     */
    public static void pause(Activity activity) {
        getImageLoader().pause(activity);
    }

    /**
     * @param activity
     */
    public static void resume(Activity activity) {
        getImageLoader().resume(activity);
    }
}
