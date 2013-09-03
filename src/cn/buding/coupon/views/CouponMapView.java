package cn.buding.coupon.views;

import android.view.View;
import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;

public class CouponMapView extends BaseView {

	private RobotiumTools robotiumTools = null;
	private static String Map_PATH_BTN = "btn_right";

	public CouponMapView(RobotiumTools robotiumTools) {
		super(robotiumTools);
		this.robotiumTools = robotiumTools;
	}

	@Override
	public void waitForActivity() {
		// TODO Auto-generated method stub
		robotiumTools.waitForActivity(StaticField.Activity.COUPON_MAP_ACTIVITY,
				TIME_DELAY);
	}

	public void clickPathBtn() {
		View view = robotiumTools.getViewById(Map_PATH_BTN);
		robotiumTools.clickOnView(view);
	}

	@Override
	public String getViewTitle() {
		// TODO Auto-generated method stub
		String title = getViewTitle();
		return title;
	}

}
