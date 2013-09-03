package cn.buding.coupon.views;

import android.view.View;
import android.widget.Button;
import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;

public class NearByView extends BaseView {
	
	public static final String NEARBY_TITLE_TXT = "附近优惠";
	
	private static final String NEARBY_MYPOCKET_BTN = "btn_right";
	private static final String NEARBY_REFRESH_BTN = "btn_left";
	private static final String NEARBY_ERROR_TIPS_TV = "tv_tips";
	private static final String NEARBY_BTN_TXT = "附近";
	private static final String NEARBY_LV = "tv_shop_name";

	private RobotiumTools robotiumTools = null;

	public NearByView(RobotiumTools robotiumTools) {
		super(robotiumTools);
		this.robotiumTools = robotiumTools;
	}

	@Override
	public void waitForActivity() {
		robotiumTools.waitForActivity(StaticField.Activity.LAUNCHER_ACTIVITY,
				TIME_DELAY);
		switchToThis();
	}
	
	@Override
	public String getViewTitle() {
		// TODO Auto-generated method stub
		String title = getViewTitle();
		return title;
	}

	/**
	 * 点击刷新按钮
	 */
	public void refreshPage() {
		Button refresh = (Button) robotiumTools.getViewById(NEARBY_REFRESH_BTN);
		robotiumTools.clickOnView(refresh);
	}

	/**
	 * 点击口袋按钮
	 */
	public void clickPocketBtn() {
		Button myPocket = (Button) robotiumTools
				.getViewById(NEARBY_MYPOCKET_BTN);
		robotiumTools.clickOnView(myPocket);
	}

	/**
	 * 
	 * 获取不到定位信息时，显示的错误页面 ================== 暂时获取不到您的位置 请稍后刷新重试
	 * ==================
	 * 
	 * @return 1:successful 2:failed
	 */
	public int chickErrorTipsView() {
		int result = robotiumTools.clickCtrlById(NEARBY_ERROR_TIPS_TV);
		return result;
	}

	/**
	 * 点击list分页中首个item
	 * 
	 * @param line
	 */
	public void clickOnList(int line) {
		View view = robotiumTools.getViewFromListView(line, View.class);
		robotiumTools.clickOnView(view);
	}

	/**
	 * 滚动至指定line
	 */
	public void scrollingList(int line) {
		robotiumTools.scrollingList(line, NEARBY_LV);
	}

	/**
	 * 切换至附近页面
	 */
	private void switchToThis() { 
		robotiumTools.clickOnText(NEARBY_BTN_TXT, 1, true);
	}

}
