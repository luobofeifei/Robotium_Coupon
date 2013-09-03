package cn.buding.coupon.views;

import java.util.ArrayList;

import com.jayway.android.robotium.solo.Solo;
import com.jayway.android.robotium.solo.WebElement;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.widget.Button;
import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.Logger;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.base.ScreenHelper;
import cn.buding.coupon.base.ScreenHelper.Coords;
import cn.buding.coupon.field.StaticField;

public class CouponDetailsSliderView extends BaseView {
	private RobotiumTools robotiumTools = null;
	private Solo solo = null;

	private static final String DETAILS_TITLE_TV = "tv_title";
	private static final String DETAILS_MYPOCKET_BTN = "btn_right";
	private static final String DETAILS_PAGE_LEFT_BTN = "btn_page_left";
	private static final String DETAILS_PAGE_RIGHT_BTN = "btn_page_right";
	// pay coupon
	private static final String PURCHASE_BTN = "button1";
	private static final String DURATION_TV = "content";
	private WebElements webElements = null;

	public CouponDetailsSliderView(RobotiumTools robotiumTools, Solo solo) {
		super(robotiumTools);
		this.robotiumTools = robotiumTools;
		this.solo = solo;
	}

	@Override
	public void waitForActivity() {
		// TODO Auto-generated method stub
		robotiumTools.waitForActivity(
				StaticField.Activity.COUPON_DETAILS_SLIDER_ACTIVITY,
				TIME_DELAY + 2000);
	}

	@Override
	public String getViewTitle() {
		// TODO Auto-generated method stub
		String title = robotiumTools.getTextById(DETAILS_TITLE_TV);
		return title;
	}

	public void clickPurchaseBtn() {
		Button purchase = (Button) robotiumTools.getViewById(PURCHASE_BTN);
		robotiumTools.clickOnView(purchase);
	}

	public String getDuration() {
		String duration = robotiumTools.getTextById(DURATION_TV);
		return duration;
	}

	public void clickLeftPageBtn() {
		Button left = (Button) robotiumTools.getViewById(DETAILS_PAGE_LEFT_BTN);
		robotiumTools.clickOnView(left);
	}

	public void clickRightPageBtn() {
		Button right = (Button) robotiumTools
				.getViewById(DETAILS_PAGE_RIGHT_BTN);
		robotiumTools.clickOnView(right);
	}

	private void clickWebView(int[] location) {
		long downTime = SystemClock.uptimeMillis();
		long eventTime = SystemClock.uptimeMillis();
		android.app.Activity activity = solo.getCurrentActivity();
		float xStart = location[0];
		float yStart = location[1];
		MotionEvent down = MotionEvent.obtain(downTime, eventTime,
				MotionEvent.ACTION_DOWN, xStart, yStart, 0);
		activity.dispatchTouchEvent(down);
		down.recycle();
		MotionEvent up = MotionEvent.obtain(downTime, eventTime,
				MotionEvent.ACTION_UP, xStart, yStart, 0);
		activity.dispatchTouchEvent(up);
		up.recycle();
	}

	@Deprecated
	public void clickWebView(float x, float y, float screenWidth,
			float screenHeight) {
		long downTime = SystemClock.uptimeMillis();
		long eventTime = SystemClock.uptimeMillis();
		android.app.Activity activity = solo.getCurrentActivity();
		float xStart = matchingX(x, screenWidth);
		float yStart = matchingY(y, screenHeight);
		MotionEvent down = MotionEvent.obtain(downTime, eventTime,
				MotionEvent.ACTION_DOWN, xStart, yStart, 0);
		activity.dispatchTouchEvent(down);
		down.recycle();
		MotionEvent up = MotionEvent.obtain(downTime, eventTime,
				MotionEvent.ACTION_UP, xStart, yStart, 0);
		activity.dispatchTouchEvent(up);
		up.recycle();
	}

	public void clickSubShopsBtn() {
		if (webElements == null) {
			WebElements webElements = new WebElements();
			this.webElements = webElements;
		}
		clickWebView(this.webElements.subShops);
	}

	public void clickFavorBtn() {
		if (webElements == null) {
			WebElements webElements = new WebElements();
			this.webElements = webElements;
		}
		clickWebView(this.webElements.favor);
	}

	public void clickCouponImg() {
		if (webElements == null) {
			WebElements webElements = new WebElements();
			this.webElements = webElements;
		}
		clickWebView(this.webElements.image);
	}

	public void clickPhoneBtn() {
		solo.scrollDown();
		robotiumTools.sleep();
		WebElements elements = new WebElements();
		Logger.d("==============elements.phone[1]============="
				+ elements.phone[0]);
		Logger.d("==============elements.phone[1]============="
				+ elements.phone[1]);
		clickWebView(elements.phone);
	}

	public void clickDownloadBtn() {
		solo.scrollDown();
		robotiumTools.sleep();
		WebElements elements = new WebElements();
		Logger.d("==============elements.download[1]============="
				+ elements.download[0]);
		Logger.d("==============elements.download[1]============="
				+ elements.download[1]);
		clickWebView(elements.download);
	}

	private static boolean compareContents(String src, String target) {
		if (src.indexOf(target) < 0) {
			return false;
		} else {
			return true;
		}
	}
	
	@Deprecated
	private static float matchingX(float rawX,float screenWidth) {
		float p = screenWidth / Coords.SCREEN_WIDTH;
		return p * rawX;
	}
	
	@Deprecated
	private static float matchingY(float rawY, float screenHeight) {
		float p = screenHeight / Coords.SCREEN_HEIGHT;
		return p * rawY;
	}

	/**
	 * 点击口袋按钮
	 */
	public void clickPocketBtn() {
		Button myPocket = (Button) robotiumTools
				.getViewById(DETAILS_MYPOCKET_BTN);
		robotiumTools.clickOnView(myPocket);
	}
	

	public class ImageOperate extends BaseView {

		public ImageOperate() {
			super(robotiumTools);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void waitForActivity() {
			// TODO Auto-generated method stub
			robotiumTools.waitForActivity(
					StaticField.Activity.IMAGE_OPERATE_ACTIVITY, 1000);
		}

		@Override
		public String getViewTitle() {
			// TODO Auto-generated method stub
			return null;
		}

		@Deprecated
		public void zoomIn() {
			long downTime = SystemClock.uptimeMillis();
			long eventTime = SystemClock.uptimeMillis();
			android.app.Activity activity = solo.getCurrentActivity();
			ScreenHelper screenHelper = new ScreenHelper(solo);
			
			int rawX = screenHelper.getScreenWidth()/2;
			int rawY = screenHelper.getScreenHeight()/2;
			
			float xStart1 = matchingX(rawX-20, screenHelper.getScreenWidth());
			float yStart1 = matchingY(rawY-20, screenHelper.getScreenHeight());
			
			float xStart2 = matchingX(rawX+20, screenHelper.getScreenWidth());
			float yStart2 = matchingY(rawY+20, screenHelper.getScreenHeight());
			MotionEvent down1 = MotionEvent.obtain(downTime, eventTime,
					MotionEvent.ACTION_DOWN, xStart1, yStart1, 0);
			MotionEvent down2 = MotionEvent.obtain(downTime, eventTime,
					MotionEvent.ACTION_DOWN, xStart2, yStart2, 0);
			activity.dispatchTouchEvent(down1);
			activity.dispatchTouchEvent(down2);
			down1.recycle();
			down2.recycle();
			
			
			MotionEvent move1 = MotionEvent.obtain(downTime, eventTime,
					MotionEvent.ACTION_DOWN, xStart1-10, yStart1-10, 0);
			MotionEvent move2 = MotionEvent.obtain(downTime, eventTime,
					MotionEvent.ACTION_DOWN, xStart2+10, yStart2+10, 0);
			activity.dispatchTouchEvent(move1);
			activity.dispatchTouchEvent(move2);
			move1.recycle();
			move2.recycle();
			
			
			MotionEvent up1 = MotionEvent.obtain(downTime, eventTime,
					MotionEvent.ACTION_UP, xStart1-10, yStart1-10, 0);
			MotionEvent up2 = MotionEvent.obtain(downTime, eventTime,
					MotionEvent.ACTION_UP, xStart2+10, yStart2+10, 0);
			activity.dispatchTouchEvent(up1);
			activity.dispatchTouchEvent(up2);
			up1.recycle();
			up2.recycle();
		}
		
		@Deprecated
		public void zoomOut() {
			long downTime = SystemClock.uptimeMillis();
			long eventTime = SystemClock.uptimeMillis();
			android.app.Activity activity = solo.getCurrentActivity();
			ScreenHelper screenHelper = new ScreenHelper(solo);
			
			int rawX = screenHelper.getScreenWidth()/2;
			int rawY = screenHelper.getScreenHeight()/2;
			
			float xStart1 = matchingX(rawX-20, screenHelper.getScreenWidth());
			float yStart1 = matchingY(rawY-20, screenHelper.getScreenHeight());
			
			float xStart2 = matchingX(rawX+20, screenHelper.getScreenWidth());
			float yStart2 = matchingY(rawY+20, screenHelper.getScreenHeight());
			MotionEvent down1 = MotionEvent.obtain(downTime, eventTime,
					MotionEvent.ACTION_DOWN, xStart1, yStart1, 0);
			MotionEvent down2 = MotionEvent.obtain(downTime, eventTime,
					MotionEvent.ACTION_DOWN, xStart2, yStart2, 0);
			activity.dispatchTouchEvent(down1);
			activity.dispatchTouchEvent(down2);
			down1.recycle();
			down2.recycle();
			
			
			MotionEvent move1 = MotionEvent.obtain(downTime, eventTime,
					MotionEvent.ACTION_DOWN, xStart1-10, yStart1-10, 0);
			MotionEvent move2 = MotionEvent.obtain(downTime, eventTime,
					MotionEvent.ACTION_DOWN, xStart2+10, yStart2+10, 0);
			activity.dispatchTouchEvent(move1);
			activity.dispatchTouchEvent(move2);
			move1.recycle();
			move2.recycle();
			
			
			MotionEvent up1 = MotionEvent.obtain(downTime, eventTime,
					MotionEvent.ACTION_UP, xStart1-10, yStart1-10, 0);
			MotionEvent up2 = MotionEvent.obtain(downTime, eventTime,
					MotionEvent.ACTION_UP, xStart2+10, yStart2+10, 0);
			activity.dispatchTouchEvent(up1);
			activity.dispatchTouchEvent(up2);
			up1.recycle();
			up2.recycle();
		}

		public void back() {
			robotiumTools.goBack();
		}

	}

	class WebElements {
		public int[] subShops = new int[] { -1, -1 };
		public int[] favor = new int[] { -1, -1 };
		public int[] image = new int[] { -1, -1 };
		public int[] download = new int[] { -1, -1 };
		public int[] phone = new int[] { -1, -1 };

		private ArrayList<WebElement> elements = null;

		public WebElements() {
			this.elements = solo.getCurrentWebElements();
			getLocations();
		}

		private void getLocations() {
			int count = elements.size();
			Logger.d("==============count=============" + count);
			if (count > 0) {
				for (WebElement webElement : elements) {
					String tagName = webElement.getTagName();
					String text = webElement.getText();
					String getName = webElement.getName();
					Logger.d("==============tagName=============" + tagName);
					Logger.d("==============text=============" + text);
					Logger.d("==============getName=============" + getName);
					Logger.d("==============x============="
							+ webElement.getLocationX());
					Logger.d("==============y============="
							+ webElement.getLocationY());
					Logger.d("==============getClass============="
							+ webElement.getClassName());
					if (tagName.equals("BUTTON")
							&& compareContents(text, "可用分店")) {
						webElement.getLocationOnScreen(subShops);
					} else if (tagName.equals("BUTTON")
							&& compareContents(text, "可兑换影院")) {
						webElement.getLocationOnScreen(subShops);
					} else if (tagName.equals("BUTTON")
							&& compareContents(text, "收藏")) {
						webElement.getLocationOnScreen(favor);
					} else if (tagName.equals("IMG")) {
						webElement.getLocationOnScreen(image);
					} else if (webElement.getClassName().equals("link")) {
						webElement.getLocationOnScreen(download);
					} else if (tagName.equals("A")
							&& compareContents(text, "400 610 5966")) {
						webElement.getLocationOnScreen(phone);
					}
				}
			}
		}

	}

}
