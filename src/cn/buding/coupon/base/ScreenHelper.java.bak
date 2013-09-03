package cn.buding.coupon.base;

import com.jayway.android.robotium.solo.Solo;

import android.util.DisplayMetrics;
import android.view.Display;

public class ScreenHelper {
	private int width = 0;
	private int height = 0;
	private DisplayMetrics displayMetrics;
	
	public ScreenHelper(Solo solo){
		Display display = solo.getCurrentActivity().getWindowManager()
				.getDefaultDisplay();
		this.displayMetrics = new DisplayMetrics();
		display.getMetrics(displayMetrics);
	}
	
	public int[] getScreenSize() {
		int[] size = new int[2];
		width = size[0] = displayMetrics.widthPixels;
		height = size[1] = displayMetrics.heightPixels;
		return size;
	}
	
	public int getScreenWidth(){
		return width;
	}
	
	public int getScreenHeight(){
		return height;
	}
	
	public class Coords {
		public static final float SCREEN_WIDTH = 540.0f;
		public static final float SCREEN_HEIGHT = 960.0f;
	}
}
