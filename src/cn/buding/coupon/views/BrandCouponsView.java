package cn.buding.coupon.views;

import java.util.ArrayList;

import android.app.Instrumentation;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;

public class BrandCouponsView extends BaseView {

	private RobotiumTools robotiumTools = null;
	private static final String BRAND_REFRESH_BTN = "btn_left";
	private static final String BRAND_MYPOCKET_BTN = "btn_right";
	private static final String BRAND_SUB_SHOPS_RL = "subshops";
	private static final String BRAND_COUNT_TV = "tv_count";
	private static final String BRAND_COUPONS_LV = "list";
	private static final String BRAND_DOWNLOAD_LV = "download";
	private static final String BRAND_ERROR_TIPS_TV = "tv_tips";

	public static final int LEFT_SIDE = 21;
	public static final int RIGHT_SIDE = LEFT_SIDE + 1;
	public Instrumentation instrumentation = null;

	public BrandCouponsView(RobotiumTools robotiumTools) {
		super(robotiumTools);
		this.robotiumTools = robotiumTools;
	}

	@Override
	public void waitForActivity() {
		// TODO Auto-generated method stub
		robotiumTools.waitForActivity(
				StaticField.Activity.BRAND_COUPONS_ACTIVITY, TIME_DELAY);
	}

	public String getTitle() {
		String title = getViewTitle();
		return title;
	}

	public void clickDownloadBtn() {
		LinearLayout layout = (LinearLayout) robotiumTools
				.getViewById(BRAND_DOWNLOAD_LV);
		ArrayList<View> views = robotiumTools.getViewFromViewGroup(layout,
				StaticField.ViewType.TEXT_VIEW);
		View target = views.get(0);
		robotiumTools.clickOnView(target);
	}

	public void clickRefreshBtn() {
		Button refresh = (Button) robotiumTools.getViewById(BRAND_REFRESH_BTN);
		robotiumTools.clickOnView(refresh);
	}

	public void clickSubShops() {
		RelativeLayout relativeLayout = (RelativeLayout) robotiumTools
				.getViewById(BRAND_SUB_SHOPS_RL);
		robotiumTools.clickOnView(relativeLayout);
	}

	/**
	 * 点击口袋按钮
	 */
	public void clickPocketBtn() {
		Button myPocket = (Button) robotiumTools
				.getViewById(BRAND_MYPOCKET_BTN);
		robotiumTools.clickOnView(myPocket);
	}

	/**
	 * 点击list分页中首个item
	 * 
	 * @param line
	 */
	public void clickOnList(int line) {
		robotiumTools.clickOnList(line);
	}

	public void clickOnList(int line, boolean scroll) {
		View view = robotiumTools.getViewFromListView(
				line, LinearLayout.class);
		robotiumTools.clickOnView(view);
	}

	/**
	 * 
	 * 该商铺暂时没有优惠券 ================== 去看看其他的店铺吧 ==================
	 * 
	 * @return 1:successful 2:failed
	 */
	public int chickErrorTipsView() {
		int result = robotiumTools.clickCtrlById(BRAND_ERROR_TIPS_TV);
		return result;
	}

	/**
	 * 滚动至指定line
	 */
	public void scrollingList(int line) {
		robotiumTools.scrollingList(line, BRAND_COUPONS_LV);
		clickOnList(1);
	}

	public int getShopCount() {
		View view = robotiumTools.getViewById(BRAND_COUNT_TV);
		TextView textView = (TextView) view;
		String content = textView.getText().toString();
		content = robotiumTools.subString('共', '家', content);
		return Integer.parseInt(content);
	}

	public class DownloadDialog {
		public static final String CANCEL_BTN = "button2";
		public static final String OK_BTN = "button1";

		public void clickOKBtn() {
			robotiumTools.clickCtrlById(OK_BTN);
		}

		public void clickCancelBtn() {
			robotiumTools.clickCtrlById(CANCEL_BTN);
		}
	}

}
