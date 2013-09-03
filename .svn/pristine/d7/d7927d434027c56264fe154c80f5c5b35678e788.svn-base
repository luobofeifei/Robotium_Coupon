package cn.buding.coupon.views;

import java.util.ArrayList;

import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;

public class PurchasedCouponsView extends BaseView {

	private RobotiumTools robotiumTools = null;
	private static final String PURCHASED_TIPS_TV = "tv_tips";
	private static final String PURCHASED_REFRESH_BTN = "btn_right";
	private static final String PURCHASED_LIST = "list";
	private static final String PURCHASED_TABPAGE_INDICATOR = "indicator";
	private static final int FIRST_POSITION_IN_LINE = 1;

	public PurchasedCouponsView(RobotiumTools robotiumTools) {
		super(robotiumTools);
		this.robotiumTools = robotiumTools;
	}

	@Override
	public void waitForActivity() {
		robotiumTools.waitForActivity(
				StaticField.Activity.PURCHASED_COUPONS_ACTIVITY, TIME_DELAY);
	}
	
	public String getTitle() {
		// TODO Auto-generated method stub
		String title = getViewTitle();
		return title;
	}

	/**
	 * 
	 * 无购买时时，显示的页面 ================== 您尚未购买任何优惠券 去看看.... ==================
	 * 
	 * @return 1:successful 2:failed
	 */
	public void chickNoPurchasedTips() {
		robotiumTools.clickCtrlById(PURCHASED_TIPS_TV);
	}

	/**
	 * 点击list分页中首个item
	 * 
	 * @param line
	 */
	public void clickOnList() {
		robotiumTools.clickOnList(FIRST_POSITION_IN_LINE);
	}

	/**
	 * 点击刷新按钮
	 */
	public void clickRefreshBtn() {
		robotiumTools.clickCtrlById(PURCHASED_REFRESH_BTN);
	}

	/**
	 * 滚动至指定line
	 */
	public void scrollingList(int line) {
		robotiumTools.scrollingList(line, PURCHASED_LIST);
		clickOnList();
	}

	/**
	 * 切换我的购买券页面顶部tab
	 */
	public void switchTab() {
		View view = robotiumTools.getViewById(PURCHASED_TABPAGE_INDICATOR);
		HorizontalScrollView scrollView = (HorizontalScrollView) view;
		int count = scrollView.getChildCount();
		if (count > 0) {
			ArrayList<View> list = new ArrayList<View>();
			LinearLayout layout = (LinearLayout) scrollView.getChildAt(0);
			count = layout.getChildCount();
			for (int i = 0; i < count; i++) {
				View tabView = layout.getChildAt(i);
				list.add(tabView);
			}
			robotiumTools.clickQueue(list, 1000);
		}
	}

}
