package cn.buding.coupon.views;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;

public class MyPocketView extends BaseView {
	private RobotiumTools robotiumTools = null;
	private static final String MYPOCKET_LOGIN_BTN = "btn_right";
	private static final String MYPOCKET_LOGOFF_BTN = "btn_right";
	private static final String MYPOCKET_BACK_BTN = "btn_left";
	private static final String MYPOCKET_HEADER_TV = "tv_header";
	private static final String MYPOCKET_HEADER_TXT = "��ӭʹ�ò����Ż�ȯ";
	private static final String MYPOCKET_FAVOR_TV = "content";
	private boolean loginState = false;

	public MyPocketView(RobotiumTools robotiumTools) {
		super(robotiumTools);
		this.robotiumTools = robotiumTools;
	}

	@Override
	public void waitForActivity() {
		robotiumTools.waitForActivity(StaticField.Activity.MYPOCKET_ACTIVITY,
				TIME_DELAY);
		String header = robotiumTools.getTextById(MYPOCKET_HEADER_TV);
		if (header.equals(MYPOCKET_HEADER_TXT)) {
			loginState = false;
		} else {
			loginState = true;
		}
	}

	/**
	 * w �����½��ť
	 */
	public void clickLoginBtn() {
		Button myPocket = (Button) robotiumTools
				.getViewById(MYPOCKET_LOGIN_BTN);
		try {
			Thread.sleep(100);
		} catch (Exception e) {
			// TODO: handle exception
		}
		robotiumTools.clickOnView(myPocket);
	}

	/**
	 * ���ע����ť
	 */
	public void clickLogoutBtn() {
		Button myPocket = (Button) robotiumTools
				.getViewById(MYPOCKET_LOGOFF_BTN);
		if (loginState)
			robotiumTools.clickOnView(myPocket);
	}

	/**
	 * ������ذ�ť
	 */
	public void clickBackBtn() {
		Button myPocket = (Button) robotiumTools.getViewById(MYPOCKET_BACK_BTN);
		robotiumTools.clickOnView(myPocket);
	}

	/**
	 * ����б�
	 * 
	 * @param lineTitle
	 *            list��item��title �μ�MyPocketView.TwoLineViewTitle���ж���
	 */
	public void clickInList(String lineTitle) {
		robotiumTools.clickOnText(lineTitle, 0, true);
	}

	/**
	 * ����Ƿ�Ϊ��½״̬
	 * 
	 * @return
	 */
	public boolean checkLoginState() {
		return loginState;
	}

	/**
	 * ����ղ��Ż�ȯ������
	 * 
	 * @return
	 */
	public int getFavorCount() {
		View view = robotiumTools.getViewById(MYPOCKET_FAVOR_TV);
		TextView textView = (TextView) view;
		String content = textView.getText().toString();
		content = robotiumTools.subString('��', '��', content);
		return Integer.parseInt(content);
	}

	/**
	 * ����ҳ��List�и������
	 * 
	 * @author xiaofei
	 * 
	 */
	public class TwoLineViewTitle {

		/**
		 * δ��½״̬��List��item��title
		 * 
		 * @author xiaofei
		 * 
		 */
		public class LogoutState {
			public static final String FAVOR_TITLE = "�ҵ��ղ�";
			public static final String PURCHASE_TITLE = "�ҵĹ���ȯ";
			public static final String CREDIT_TITLE = "�ҵĻ���";
			public static final String PHONE_TITLE = "�ͷ��绰:400 610 5966";
		}

		/**
		 * ��½״̬��List��item��title
		 * 
		 * @author xiaofei
		 * 
		 */
		public class LoginState {
			public static final String FAVOR_TITLE = "�ҵ��ղ�";
			public static final String PURCHASE_TITLE = "�ҵĹ���ȯ";
			public static final String CREDIT_TITLE = "�ҵĻ���";
			public static final String PASSWORD_TITLE = "�޸�����";
			public static final String PHONE_TITLE = "�ͷ��绰:400 610 5966";
		}
	}

}
