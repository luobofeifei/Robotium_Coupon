package cn.buding.coupon.views;

import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;

public class SettingsView extends BaseView {
	public static final String SETTING_TITLE_TXT = "����";
	private static final String SETTING_BTN_TXT = "����";

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
	 * �л�������ҳ��
	 */
	private void switchToThis() {
		robotiumTools.clickOnText(SETTING_BTN_TXT, 1, true);
	}

	/**
	 * ����б�
	 * 
	 * @param lineTitle
	 *            list��item��title �μ�SettingsView.TwoLineViewTitle���ж���
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
	 * ����ҳ��List�и������
	 * 
	 * @author xiaofei
	 * 
	 */
	public class TwoLineViewTitle {
		public static final String MESSAGE_TITLE = "��Ϣ֪ͨ";
		public static final String SWITHC_CITY_TITLE = "�л�����";
		public static final String SET_EMAIL_TITLE = "��������";
		public static final String SHOW_TITLE = "2G/3G��������ʾͼƬ";
		public static final String PUSH_TITLE = "��������";
		public static final String CLEAR_TITLE = "���ͼƬ����";
		public static final String UPDATE_TITLE = "������";
		public static final String FEEDBACK_TITLE = "�������";
		public static final String CONTACT_TITLE = "�̼���ϵ��ʽ";
		public static final String ABOUT_TITLE = "���ڲ����Ż�ȯ";

	}

}
