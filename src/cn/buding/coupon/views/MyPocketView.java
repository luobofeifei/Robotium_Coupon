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
	private static final String MYPOCKET_HEADER_TXT = "欢迎使用布丁优惠券";
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
	 * w 点击登陆按钮
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
	 * 点击注销按钮
	 */
	public void clickLogoutBtn() {
		Button myPocket = (Button) robotiumTools
				.getViewById(MYPOCKET_LOGOFF_BTN);
		if (loginState)
			robotiumTools.clickOnView(myPocket);
	}

	/**
	 * 点击返回按钮
	 */
	public void clickBackBtn() {
		Button myPocket = (Button) robotiumTools.getViewById(MYPOCKET_BACK_BTN);
		robotiumTools.clickOnView(myPocket);
	}

	/**
	 * 点击列表
	 * 
	 * @param lineTitle
	 *            list中item的title 参见MyPocketView.TwoLineViewTitle类中定义
	 */
	public void clickInList(String lineTitle) {
		robotiumTools.clickOnText(lineTitle, 0, true);
	}

	/**
	 * 检查是否为登陆状态
	 * 
	 * @return
	 */
	public boolean checkLoginState() {
		return loginState;
	}

	/**
	 * 获得收藏优惠券的数量
	 * 
	 * @return
	 */
	public int getFavorCount() {
		View view = robotiumTools.getViewById(MYPOCKET_FAVOR_TV);
		TextView textView = (TextView) view;
		String content = textView.getText().toString();
		content = robotiumTools.subString('：', '张', content);
		return Integer.parseInt(content);
	}

	/**
	 * 设置页面List中各项标题
	 * 
	 * @author xiaofei
	 * 
	 */
	public class TwoLineViewTitle {

		/**
		 * 未登陆状态下List中item的title
		 * 
		 * @author xiaofei
		 * 
		 */
		public class LogoutState {
			public static final String FAVOR_TITLE = "我的收藏";
			public static final String PURCHASE_TITLE = "我的购买券";
			public static final String CREDIT_TITLE = "我的积分";
			public static final String PHONE_TITLE = "客服电话:400 610 5966";
		}

		/**
		 * 登陆状态下List中item的title
		 * 
		 * @author xiaofei
		 * 
		 */
		public class LoginState {
			public static final String FAVOR_TITLE = "我的收藏";
			public static final String PURCHASE_TITLE = "我的购买券";
			public static final String CREDIT_TITLE = "我的积分";
			public static final String PASSWORD_TITLE = "修改密码";
			public static final String PHONE_TITLE = "客服电话:400 610 5966";
		}
	}

}
