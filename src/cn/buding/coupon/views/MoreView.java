package cn.buding.coupon.views;

import android.view.View;
import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;

public class MoreView extends BaseView {
	public static final String MORE_TITLE_TXT = "����";

	private RobotiumTools robotiumTools = null;
	private static final String MORE_BTN_TXT = "����";

	public static final int LEFT_SIDE = 21;
	public static final int RIGHT_SIDE = LEFT_SIDE + 1;

	public MoreView(RobotiumTools robotiumTools) {
		super(robotiumTools);
		this.robotiumTools = robotiumTools;
	}

	@Override
	public void waitForActivity() {
		robotiumTools.waitForActivity(StaticField.Activity.LAUNCHER_ACTIVITY,
				TIME_DELAY);
		switchToThis();
	}

	public String getTitle() {
		String title = getViewTitle();
		return title;
	}

	/**
	 * �л�������ҳ��
	 */
	public void switchToThis() {
		robotiumTools.clickOnText(MORE_BTN_TXT, 1, true);
	}

	/**
	 * ���list��ҳ���׸�item
	 * 
	 * @param line
	 */
	public void clickOnList(int line) {
		View view = robotiumTools.getViewFromListView(line, View.class);
		robotiumTools.clickOnView(view);
	}

}
