package com.github.cf.baselibrary.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;

/**
 * 作者：Chengfu on 2017/3/23 16:58
 * 邮箱：
 */
public class GlideLoader implements ILoader {
    @Override
    public void loadImage(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(imageView);
    }

    @Override
    public void loadImageLoading(Context context, String url, ImageView imageView, int loadingImage, int errorImageView) {
        Glide.with(context)
                .load(url)
                .placeholder(loadingImage)
                .error(errorImageView)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(imageView);
    }

    @Override
    public void loadImageCenterCrop(Context context, String url, ImageView imageView, int loadingImage, int errorImageView) {
        Glide.with(context)
                .load(url)
                .centerCrop()
                .placeholder(loadingImage)
                .error(errorImageView)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .dontAnimate()
                .into(imageView);
    }

    /**
     * 项目中有很多需要先下载图片然后再做一些合成的功能，比如项目中出现的图文混排
     * @param mContext
     * @param path
     * @param simpleTarget
     */
    @Override
    public void loadImageAsBitmap(Context mContext, String path, SimpleTarget<Bitmap> simpleTarget) {
        Glide.with(mContext).load(path).asBitmap().into(simpleTarget);
    }
}
