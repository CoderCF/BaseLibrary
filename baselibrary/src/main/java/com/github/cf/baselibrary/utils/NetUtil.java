package com.github.cf.baselibrary.utils;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 网络相关工具类
 */
public class NetUtil {
	/**
	 *  检查当前网络是否可用
	 * @param context
	 * @return
	 */
	public static boolean isNetworkAvailable(Context context){
		ConnectivityManager mConnectivityManager=(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		if(mConnectivityManager!=null){
			NetworkInfo info = mConnectivityManager.getActiveNetworkInfo();
			if (info != null && info.isConnected()) {
				if (info.getState() == NetworkInfo.State.CONNECTED) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 判断WIFI和Mobile是否连接
	 * @param context
	 * @return
	 */
	public static boolean checkNetwork(Context context){
		boolean isWIFI = isWIFI(context);
		boolean isMobile = isMobile(context);
		//都没有连接
		if(isWIFI == false && isMobile == false){
			return false;
		}
		return true;
	}

	/**
	 * 判断MOBILE网络是否连接
	 * @param context
	 * @return
	 */
	private static boolean isMobile(Context context) {
		if(context != null){
			ConnectivityManager mcConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mcConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
			if(mNetworkInfo != null){
				return mNetworkInfo.isConnected();
			}
		}
		return false;
	}

	/**
	 * 判断WIFI是否连接
	 * @param context
	 * @return
	 */
	private static boolean isWIFI(Context context) {
		if(context != null){
			ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
			if(mNetworkInfo != null){
				return mNetworkInfo.isConnected();
			}
		}
		return false;
	}

	/**
	 * 判断网络类型
	 *
	 * @param context 上下文
	 * @return -1：没有网络  1：WIFI网络  2：wap网络  3：net网络
	 */
	public static int getNetworkType(Context context) {
		int netType = -1;
		ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo == null) {
			return netType;
		}
		int nType = networkInfo.getType();
		if (nType == ConnectivityManager.TYPE_MOBILE) {
			if (networkInfo.getExtraInfo().toLowerCase().equals("cmnet")) {
				netType = 3;
			} else {
				netType = 2;
			}
		} else if (nType == ConnectivityManager.TYPE_WIFI) {
			netType = 1;
		}
		return netType;
	}

	/**
	 * 打开网络设置界面
	 * <p>3.0以下打开设置界面</p>
	 */
	public static void openWirelessSettings(Context context) {
		if (android.os.Build.VERSION.SDK_INT > 10) {
			context.startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
		} else {
			context.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
		}
	}

}
