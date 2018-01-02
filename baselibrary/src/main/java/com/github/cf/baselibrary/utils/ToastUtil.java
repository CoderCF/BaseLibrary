package com.github.cf.baselibrary.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
	private static Toast sToast;
	public static void showLongToast(Context context, String msg) {
		if(sToast == null){
			sToast = Toast.makeText(context, msg, Toast.LENGTH_LONG);
		}else{
			sToast.setText(msg);
		}
		sToast.show();
	}
}
