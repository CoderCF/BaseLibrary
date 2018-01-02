package com.github.cf.baselibrary.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.request.target.SimpleTarget;

/**
 * 作者：Chengfu on 2017/3/23 16:42
 * 邮箱：
 */
public interface ILoader {

    void loadImage(Context context, String url, ImageView imageView);
    void loadImageLoading(Context context, String url, ImageView imageView, int loadingImage, int errorImageView);
    void loadImageCenterCrop(Context context, String url, ImageView imageView, int loadingImage, int errorImageView);
    void loadImageAsBitmap(Context mContext, String path, SimpleTarget<Bitmap> simpleTarget);
}
