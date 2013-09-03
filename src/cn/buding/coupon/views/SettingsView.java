package cn.buding.coupon.views;

import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;

public class SettingsView extends BaseView {
	public static final String SETTING_TITLE_TXT = "设置";
	private static final String SETTING_BTN_TXT = "设置";

	private RobotiumTools robotiumTools = null;

	public SettingsView(RobotiumTools robotiumTools) {
		super(robotiumTools);
		this.robotiumTools = robotiumTools;
	}

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
	 * 切换至设置页面
	 */
	private void switchToThis() {
		robotiumTools.clickOnText(SETTING_BTN_TXT, 1, true);
	}

	/**
	 * 点击列表
	 * 
	 * @param lineTitle
	 *            list中item的title 参见SettingsView.TwoLineViewTitle类中定义
	 */
	public void clickInList(String lineTitle) {
		robotiumTools.clickOnText(lineTitle, 0, true);
	}

	public void clickNoticeBox() {
		robotiumTools.clickOnText(TwoLineViewTitle.MESSAGE_TITLE, 0, true);
	}

	public void clickSwicthCity() {
		robotiumTools.clickOnText(TwoLineViewTitle.SWITHC_CITY_TITLE, 0, true);
	}

	public void clickSetEmail() {
		robotiumTools.clickOnText(TwoLineViewTitle.SET_EMAIL_TITLE, 0, true);
	}

	public void clickShow() {
		robotiumTools.clickOnText(TwoLineViewTitle.SHOW_TITLE, 0, true);
	}

	public void clickPush() {
		robotiumTools.clickOnText(TwoLineViewTitle.PUSH_TITLE, 0, true);
	}

	public void clickClear() {
		robotiumTools.clickOnText(TwoLineViewTitle.CLEAR_TITLE, 0, true);
	}

	public void clickUpdate() {
		robotiumTools.clickOnText(TwoLineViewTitle.UPDATE_TITLE, 0, true);
	}

	public void clickFeedback() {
		robotiumTools.clickOnText(TwoLineViewTitle.FEEDBACK_TITLE, 0, true);
	}

	public void clickContact() {
		robotiumTools.clickOnText(TwoLineViewTitle.CONTACT_TITLE, 0, true);
	}

	public void clickAbout() {
		robotiumTools.clickOnText(TwoLineViewTitle.ABOUT_TITLE, 0, true);
	}

	/**
	 * 设置页面List中各项标题
	 * 
	 * @author xiaofei
	 * 
	 */
	public class TwoLineViewTitle {
		public static final String MESSAGE_TITLE = "消息通知";
		public static final String SWITHC_CITY_TITLE = "切换城市";
		public static final String SET_EMAIL_TITLE = "设置邮箱";
		public static final String SHOW_TITLE = "2G/3G网络下显示图片";
		public static final String PUSH_TITLE = "设置推送";
		public static final String CLEAR_TITLE = "清空图片缓存";
		public static final String UPDATE_TITLE = "检查更新";
		public static final String FEEDBACK_TITLE = "意见反馈";
		public static final String CONTACT_TITLE = "商家联系方式";
		public static final String ABOUT_TITLE = "关于布丁优惠券";

	}

}
