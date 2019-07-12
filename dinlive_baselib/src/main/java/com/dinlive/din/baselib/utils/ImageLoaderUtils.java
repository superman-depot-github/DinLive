package com.dinlive.din.baselib.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RawRes;
import android.widget.ImageView;

import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.util.Preconditions;

import java.io.File;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2018/05/16
 *     desc  :
 * </pre>
 */
public final class ImageLoaderUtils {

    /**
     * 加载圆形图片
     *
     * @param context
     * @param path
     * @param view
     */
    public static void loadCircleImage(Context context, String path, ImageView view) {
        loadCircleImage(context, path, 0, 0, view);
    }

    /**
     * 加载圆形图片
     *
     * @param context
     * @param id
     * @param view
     */
    public static void loadCircleImage(Context context, @RawRes @DrawableRes @Nullable Integer id, ImageView view) {
        RequestOptions requestOptions = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .circleCrop()
                .dontAnimate();
        Glide.with(context).load(id).apply(requestOptions).into(view);
    }

    /**
     * 加载圆形图片
     *
     * @param context
     * @param path
     * @param view
     */
    public static void loadCircleImage(Context context, String path, @DrawableRes int placeholderResourceId, ImageView view) {
        loadCircleImage(context, path, placeholderResourceId, 0, view);
    }

    /**
     * 加载圆形图片
     *
     * @param context
     * @param path
     * @param view
     */
    @SuppressLint("CheckResult")
    public static void loadCircleImage(Context context, String path, @DrawableRes int placeholderResourceId, @DrawableRes int errorResourceId, ImageView view) {
        RequestOptions requestOptions = new RequestOptions();
        if (placeholderResourceId != 0) {
            requestOptions.placeholder(placeholderResourceId);
        }
        if (errorResourceId != 0) {
            requestOptions.error(errorResourceId);
        }
        requestOptions.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .circleCrop()
                .dontAnimate();
        Glide.with(context).load(path).apply(requestOptions).into(view);
    }

    /**
     * 加载圆角图片
     */
    public static void loadRoundImage(Context context, String path, ImageView view) {
        loadRoundImage(context, path, 0, 0, view, 5);
    }

    /**
     * 加载圆角图片
     */
    public static void loadRoundImage(Context context, String path, ImageView view, int roundingRadius) {
        loadRoundImage(context, path, 0, 0, view, roundingRadius);
    }

    /**
     * 加载圆角图片
     */
    public static void loadRoundImage(Context context, String path, @DrawableRes int placeholderResourceId, ImageView view, int roundingRadius) {
        loadRoundImage(context, path, placeholderResourceId, 0, view, roundingRadius);
    }

    /**
     * 加载圆角图片
     */
    @SuppressLint("CheckResult")
    public static void loadRoundImage(Context context, String path, @DrawableRes int placeholderResourceId, @DrawableRes int errorResourceId, ImageView view, int roundingRadius) {
        CenterCropRoundedCorners roundedCorners = new CenterCropRoundedCorners(SizeUtils.dp2px(roundingRadius));
        RequestOptions requestOptions = new RequestOptions()
                .transform(roundedCorners)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .dontAnimate();
        if (placeholderResourceId != 0) {
            requestOptions.placeholder(placeholderResourceId);
        }
        if (errorResourceId != 0) {
            requestOptions.error(errorResourceId);
        }
        Glide.with(context).load(path).apply(requestOptions).into(view);
    }

    /**
     * 加载图片
     *
     * @param context
     * @param path    图片地址
     * @param view
     */
    public static void loadImage(Context context, String path, ImageView view) {
        loadImage(context, path, 0, 0, view);
    }

    /**
     * 加载图片
     *
     * @param context
     * @param path    图片地址
     * @param view
     */
    public static void loadImage(Context context, String path, @DrawableRes int placeholderResourceId, ImageView view) {
        loadImage(context, path, placeholderResourceId, 0, view);
    }

    /**
     * 加载图片
     *
     * @param context
     * @param path    图片地址
     * @param view
     */
    @SuppressLint("CheckResult")
    public static void loadImage(Context context, String path, @DrawableRes int placeholderResourceId, @DrawableRes int errorResourceId, ImageView view) {
        RequestOptions requestOptions = new RequestOptions();
        if (placeholderResourceId != 0) {
            requestOptions.placeholder(placeholderResourceId);
        }
        if (errorResourceId != 0) {
            requestOptions.error(errorResourceId);
        }
        requestOptions.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).dontAnimate();
        Glide.with(context).load(path).apply(requestOptions).into(view);
    }

    /**
     * 加载图片
     *
     * @param context
     * @param file    图片文件
     * @param view
     */
    public static void loadImage(Context context, @Nullable File file, ImageView view) {
        RequestOptions requestOptions = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .dontAnimate();
        Glide.with(context).load(file).apply(requestOptions).into(view);
    }

    /**
     * 加载图片
     *
     * @param context
     * @param uri     uri
     * @param view
     */
    public static void loadImage(Context context, @Nullable Uri uri, ImageView view) {
        RequestOptions requestOptions = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .dontAnimate();
        Glide.with(context).load(uri).apply(requestOptions).into(view);
    }

    /**
     * 加载图片
     *
     * @param context
     * @param id      图片资源id
     * @param view
     */
    public static void loadImage(Context context, @RawRes @DrawableRes @Nullable Integer id, ImageView view) {
        RequestOptions requestOptions = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .dontAnimate();
        Glide.with(context).load(id).apply(requestOptions).into(view);
    }

    /**
     * 加载图片
     *
     * @param context
     * @param url     图片链接
     * @param view
     */
    @SuppressLint("CheckResult")
    public static void loadImageBlur(Context context, @Nullable String url, ImageView view, int radius) {
        loadImageBlur(context, url, 0, 0, view, radius);
    }

    /**
     * 加载图片
     *
     * @param context
     * @param url     图片链接
     * @param view
     */
    @SuppressLint("CheckResult")
    public static void loadImageBlur(Context context, @Nullable String url, @DrawableRes int placeholderResourceId, ImageView view, int radius) {
        loadImageBlur(context, url, placeholderResourceId, 0, view, radius);
    }

    /**
     * 加载图片
     *
     * @param context
     * @param url     图片链接
     * @param view
     */
    @SuppressLint("CheckResult")
    public static void loadImageBlur(Context context, @Nullable String url, @DrawableRes int placeholderResourceId, @DrawableRes int errorResourceId, ImageView view, int radius) {
        RequestOptions requestOptions = new RequestOptions();
        if (placeholderResourceId != 0) {
            requestOptions.placeholder(placeholderResourceId);
        }
        if (errorResourceId != 0) {
            requestOptions.error(errorResourceId);
        }
        requestOptions.diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .transform(new BlurTransformation(radius))
                .dontAnimate();
        Glide.with(context).load(url).apply(requestOptions).into(view);
    }

    /**
     * 加载指定等边尺寸
     *
     * @param context
     * @param path    图片地址
     * @param size
     * @param view
     */
    public static void loadImageSize(Context context, String path, int size, ImageView view) {
        loadImageSize(context, path, size, size, view);
    }

    /**
     * 加载指定尺寸
     *
     * @param context
     * @param path
     * @param width
     * @param height
     * @param view
     */
    public static void loadImageSize(Context context, String path, int width, int height, ImageView view) {
        RequestOptions requestOptions = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .override(width, height)
                .dontAnimate();
        Glide.with(context).load(path).apply(requestOptions).into(view);
    }

    /**
     * 加载gif
     *
     * @param context
     * @param path
     * @param view
     */
    public static void loadImageGif(Context context, String path, ImageView view) {
        RequestOptions requestOptions = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .dontAnimate();
        Glide.with(context).asGif().load(path).apply(requestOptions).into(view);
    }

    private static void loadSvgImage(Context context, String path, ImageView view) {
        Glide.with(context)
                .as(PictureDrawable.class)
                .load(path)
                .into(view);
    }


    public static final class CenterCropRoundedCorners extends CenterCrop {

        private final int roundingRadius;

        /**
         * @param roundingRadius the corner radius (in device-specific pixels).
         */
        public CenterCropRoundedCorners(int roundingRadius) {
            Preconditions.checkArgument(roundingRadius > 0, "roundingRadius must be greater than 0.");
            this.roundingRadius = roundingRadius;
        }

        @Override
        protected Bitmap transform(@NonNull BitmapPool pool, @NonNull Bitmap toTransform, int outWidth, int outHeight) {
            Bitmap bitmap = super.transform(pool, toTransform, outWidth, outHeight);
            return roundCrop(pool, bitmap);
        }

        private Bitmap roundCrop(BitmapPool pool, Bitmap source) {
            if (source == null) {
                return null;
            }
            Bitmap result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
            canvas.drawRoundRect(rectF, roundingRadius, roundingRadius, paint);
            return result;
        }
    }
}
