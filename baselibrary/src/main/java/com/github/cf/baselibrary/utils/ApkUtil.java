package com.github.cf.baselibrary.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import java.io.File;
import java.util.List;

/**
 * app相关工具
 */
public class ApkUtil {
    /**
     * 获取PackageManager对象
     * @param context 上下文对象
     * @return
     */
    private static PackageManager getPackageManager(Context context) {
        if (context != null) {
            return context.getPackageManager();
        }
        return null;
    }

    /**
     * 获取PackageInfo对象
     * @param context 上下文对象
     * @return
     */
    private static PackageInfo getPackageInfo(Context context) {
        PackageManager packageManager = getPackageManager(context);
        if(packageManager != null){
            try {
                return packageManager.getPackageInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                return null;
            }
        }
        return null;
    }

    /**
     * 获取App包名
     * @param context 上下文对象
     * @return
     */
    public static String getPackageName(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        if(packageInfo != null){
            return packageInfo.packageName;
        }
        return null;
    }

    /**
     * 获取版本名字
     * @param context 上下文对象
     * @return
     */
    public static String getVersionName(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        if(packageInfo != null){
            return packageInfo.versionName;
        }
        return null;
    }

    /**
     * 获取程序版本号
     * @param context 上下文对象
     * @return
     */
    public static int getVersionCode(Context context) {
        PackageInfo packageInfo = getPackageInfo(context);
        if(packageInfo != null){
            return packageInfo.versionCode;
        }
        return -1;
    }

    /**
     * 安装apk
     * @param context 上下文对象
     * @param uriFile apk路径
     */
    public static void install(Context context, File uriFile) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(uriFile), "application/vnd.android.package-archive");
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * 卸载apk
     * @param context 上下文对象
     * @param packageName apk包名
     */
    public static void uninstall(Context context, String packageName) {
        //通过程序的包名创建URI
        Uri packageURI = Uri.parse("package:" + packageName);
        //创建Intent意图
        Intent intent = new Intent(Intent.ACTION_DELETE, packageURI);
        //执行卸载程序
        context.startActivity(intent);
    }

    /**
     * 检查手机上是否安装了指定的软件
     * @param context 上下文对象
     * @param packageName apk包名
     * @return
     */
    public static boolean isInstalled(Context context, String packageName) {
        // 获取packageManager
        PackageManager packageManager = getPackageManager(context);
        if(packageManager != null){
            // 获取所有已安装程序的包信息
            List<PackageInfo> packageInfos = packageManager.getInstalledPackages(0);
            // 用于存储所有已安装程序的包名
            if (packageInfos != null) {
                for (PackageInfo packageInfo : packageInfos) {
                    if(packageName != null && packageName.equals(packageInfo.packageName)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
