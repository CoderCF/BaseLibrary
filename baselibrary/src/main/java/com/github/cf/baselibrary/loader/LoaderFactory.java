package com.github.cf.baselibrary.loader;

/**
 *  加载工厂，可定制图片加载框架
 * 作者：Chengfu on 2017/3/23 16:59
 * 邮箱：
 */
public class LoaderFactory {
    private static ILoader iLoader;

    public static ILoader getLoader(){
        if(iLoader == null){
            synchronized (LoaderFactory.class){
                if(iLoader == null){
                    iLoader = new GlideLoader();
                }
            }
        }
        return iLoader;
    }
}
