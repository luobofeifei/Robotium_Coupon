package cn.buding.coupon.views;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import android.app.Instrumentation;
import android.os.SystemClock;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.Logger;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;

public class CouponView extends BaseView {
	private RobotiumTools robotiumTools = null;
	private static final String CITY_BTN = "btn_city";
	private static final String MYPOCKET_BTN = "btn_right";
	private static final String BANNER_GALLERY = "gallery";
	private static final String BANNER_CLOSE_BTN = "btn_close";

	public static final int LEFT_SIDE = 21;
	public static final int RIGHT_SIDE = LEFT_SIDE + 1;

	public CouponView(RobotiumTools robotiumTools) {
		super(robotiumTools);
		this.robotiumTools = robotiumTools;
	}

	@Override
	public void waitForActivity() {
		robotiumTools.waitForActivity(StaticField.Activity.LAUNCHER_ACTIVITY,
				TIME_DELAY);
	}

	@Override
	public String getViewTitle() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 点击城市按钮
	 */
	public void clcikCityBtn() {
		Button city = (Button) robotiumTools.getViewById(CITY_BTN);
		robotiumTools.clickOnView(city);
	}

	/**
	 * 点击口袋按钮
	 */
	public void clickPocketBtn() {
		Button myPocket = (Button) robotiumTools.getViewById(MYPOCKET_BTN);
		robotiumTools.clickOnView(myPocket);
	}

	/**
	 * 点击Banner
	 */
	public void clickBanner() {
		Gallery banner = (Gallery) robotiumTools.getViewById(BANNER_GALLERY);
		robotiumTools.clickOnView(banner);
	}

	/**
	 * 切换Banner
	 */
	public void switchBanner() {
		Gallery banner = (Gallery) robotiumTools.getViewById(BANNER_GALLERY);
		// CouponView.RIGHT or CouponView.LEFT
		robotiumTools.scrollViewToSide(banner, CouponView.RIGHT_SIDE);
	}

	/**
	 * 关闭Banner
	 */
	public void closeBanner() {
		Button close = (Button) robotiumTools.getViewById(BANNER_CLOSE_BTN);
		robotiumTools.clickOnView(close);
	}

	/**
	 * 点击优惠券列表页指定商家icon
	 * 
	 * @param brandName
	 */
	public void clickBrand(String brandName) {
		View targetView = null;
		if (robotiumTools.searchText(brandName, false)) {
			View brandName_Tv = robotiumTools.getViewByText(brandName,
					StaticField.ViewType.TEXT_VIEW);
			FrameLayout frameLayout = (FrameLayout) brandName_Tv.getParent();
			RelativeLayout asyncImageView = (RelativeLayout) frameLayout
					.getParent();
			int childCount = asyncImageView.getChildCount();
			for (int i = 0; i < childCount; i++) {
				View view = asyncImageView.getChildAt(i);
				targetView = robotiumTools.compareViewByType(view,
						StaticField.ViewType.CLICKABLE_IMAGEVIEW);
				if (targetView != null) {
					break;
				}
			}
			robotiumTools.clickOnView(targetView);
			try {
				Thread.sleep(1000);
				robotiumTools.takeScreenshot("clickBrand");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Logger.e(e.getMessage());
			}
		}

	}

	/**
	 * 根据优惠券分类名称，点击对应分类中"更多按钮"
	 * 
	 * @param title
	 *            优惠券分类名
	 */
	public void clickMore(String title) {
		TextView textView = robotiumTools.getTextView(title);
		ViewParent viewParent = textView.getParent();
		LinearLayout layout = (LinearLayout) viewParent;
		int count = layout.getChildCount();
		for (int i = 0; i < count; i++) {
			View view = layout.getChildAt(i);
			if (view.getClass().toString()
					.indexOf((StaticField.ViewType.ASYNC_IMAGEVIEW)) >= 0) {
				robotiumTools.clickOnView(view);
				try {
					Thread.sleep(1000);
					robotiumTools.takeScreenshot("clickMore");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					Logger.e(e.getMessage());
				}
			}
		}

	}

	/**
	 * 下拉刷新首页优惠券列�?
	 * 
	 * @param instrumentation
	 */
	@Deprecated
	public void pullToRefresh(Instrumentation instrumentation) {
		try {
			float x0 = 105;
			float y0 = 100;
			float x1 = 135;
			float y1 = 100;
			float x2 = 165;
			float y2 = 100;

			long downTime = SystemClock.uptimeMillis();
			long eventTime = SystemClock.uptimeMillis();
			android.app.Activity activity = robotiumTools.getCurrentActivity();
			MotionEvent down = MotionEvent.obtain(downTime, eventTime,
					MotionEvent.ACTION_DOWN, 90, 226, 0);
			activity.dispatchTouchEvent(down);

			down.recycle();
			MotionEvent move1 = MotionEvent.obtain(downTime, eventTime,
					MotionEvent.ACTION_SCROLL, x0, y0, 0);
			activity.dispatchTouchEvent(move1);
			activity.dispatchGenericMotionEvent(move1);
			move1.recycle();
			MotionEvent move2 = MotionEvent.obtain(downTime, eventTime,
					MotionEvent.ACTION_SCROLL, x1, y1, 0);
			activity.dispatchTouchEvent(move2);
			activity.dispatchGenericMotionEvent(move2);
			move2.recycle();
			MotionEvent move3 = MotionEvent.obtain(downTime, eventTime,
					MotionEvent.ACTION_SCROLL, x2, y2, 0);
			activity.dispatchTouchEvent(move3);
			activity.dispatchGenericMotionEvent(move3);
			move2.recycle();
			MotionEvent up = MotionEvent.obtain(downTime, eventTime,
					MotionEvent.ACTION_UP, 190, 226, 0);
			activity.dispatchTouchEvent(up);
			up.recycle();
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("=======>", e.getMessage());
		}

	}

	@Deprecated
	@SuppressWarnings(value = "unused")
	private void reflectTest() {
		Class<?> demo;
		try {
			demo = Class.forName(StaticField.Activity.LAUNCHER_ACTIVITY);
			Method method = demo.getClass().getDeclaredMethod("onTouchEvent",
					MotionEvent.class);
			Method[] methods = demo.getMethods();
			for (int i = 0; i < methods.length; ++i) {
				Class<?> returnType = methods[i].getReturnType();
				Class<?> para[] = methods[i].getParameterTypes();
				int temp = methods[i].getModifiers();
				System.out.print(Modifier.toString(temp) + " ");
				System.out.print(returnType.getName() + "  ");
				System.out.print(methods[i].getName() + " ");
				System.out.print("(");
				for (int j = 0; j < para.length; ++j) {
					System.out.print(para[j].getName() + " " + "arg" + j);
					if (j < para.length - 1) {
						System.out.print(",");
					}
				}
				Class<?> exce[] = methods[i].getExceptionTypes();
				if (exce.length > 0) {
					System.out.print(") throws ");
					for (int k = 0; k < exce.length; ++k) {
						System.out.print(exce[k].getName() + " ");
						if (k < exce.length - 1) {
							System.out.print(",");
						}
					}
				} else {
					System.out.print(")");
				}
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public class SortListActivity {
		public static final String CANCEL_BTN = "button2";
		public static final String OK_BTN = "button1";

		public void clickOKBtn() {
			robotiumTools.clickCtrlById(OK_BTN);
		}

		public void clickCancelBtn() {
			robotiumTools.clickCtrlById(CANCEL_BTN);
		}
	}

	/**
	 * 优惠券首页部分标签中文名�?
	 * 
	 * @author xiaofei
	 * 
	 */
	public class TextTag {
		public static final String sort_Popular = "热门精选";
		public static final String sort_Recommended = "优惠推荐";
		public static final String sort_Food = "美食餐饮";
		public static final String sort_Cinema = "电影院";
		public static final String sort_Relax = "休闲娱乐";
		public static final String sort_Reserve = "在线预订";
		public static final String sort_Print = "打印优惠";
	}

}
