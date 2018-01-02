package com.github.cf.baselibrary.utils;

import android.app.ProgressDialog;
import android.content.Context;

/**
 * 描    述：
 * 创建日期：2017/8/1 15:54
 * 作    者：Chengfu
 * 邮    箱：
 * 备    注：
 */
public class DialogUtil {
    private static ProgressDialog progressDialog;
    public static void showProgressDialog(Context context, String msg){
        if(progressDialog==null){
            progressDialog = new ProgressDialog(context);
        }
        progressDialog.setMessage(msg);
        progressDialog.show();
    }

    public static void closeProgressDialog(){
        if( progressDialog!=null && progressDialog.isShowing() ){
            progressDialog.cancel();
            progressDialog=null;
            System.gc();
        }
    }

    public static void showProgressDialogNoExit(Context context, String msg){
        if(progressDialog==null){
            progressDialog = new ProgressDialog(context);
        }
        progressDialog.setMessage(msg);
        progressDialog.show();
        progressDialog.setCanceledOnTouchOutside(false);
    }
}
