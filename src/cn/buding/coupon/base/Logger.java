package cn.buding.coupon.base;

import android.util.Log;

public class Logger {
	/**
	 * ����tag��ǩ
	 */
	public static String TAG = "==Coupon Robotium Test Tag==";

	/**
	 * ���������캯��������ʹ�þ�̬����
	 */
	private Logger() {

	}

	public static void d(String msg) {
		Log.d(TAG, msg);
	}

	public static void d(String msg, Throwable throwable) {
		Log.d(TAG, msg, throwable);
	}

	public static void e(String msg) {
		Log.e(TAG, msg);
	}

	public static void e(String msg, Throwable throwable) {
		Log.e(TAG, msg, throwable);
	}

	public static void i(String msg) {
		Log.i(TAG, msg);
	}

	public static void i(String msg, Throwable throwable) {
		Log.i(TAG, msg, throwable);
	}

	public static void v(String msg) {
		Log.v(TAG, msg);
	}

	public static void v(String msg, Throwable throwable) {
		Log.v(TAG, msg, throwable);
	}

	public static void w(String msg) {
		Log.v(TAG, msg);
	}

	public static void w(String msg, Throwable throwable) {
		Log.v(TAG, msg, throwable);
	}

}
