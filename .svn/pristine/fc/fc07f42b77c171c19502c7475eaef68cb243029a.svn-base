package cn.buding.coupon.views;

import android.widget.AutoCompleteTextView;
import android.widget.Button;
import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;

public class ResetPwdActivityView extends BaseView {
	private RobotiumTools robotiumTools = null;

	private static String Reset_PHONE_ET = "et_phone";
	private static String Reset_CANCEL_BTN = "btn_cancel";
	private static String Reset_CLOSE_BTN = "ib_close";
	private static String Reset_RESET_BTN = "btn_reset";

	private static String NEW_PWD_ET = "et_new_password";
	private static String CONFIRM_ET = "et_confirm";
	private static String Reset_CONFIRM_BTN = "et_phone";

	public ResetPwdActivityView(RobotiumTools robotiumTools) {
		super(robotiumTools);
		this.robotiumTools = robotiumTools;
	}

	public void waitForActivity() {
		robotiumTools.waitForActivity(StaticField.Activity.REGISTER_ACTIVITY,
				TIME_DELAY);
	}

	/**
	 * 找回密码第一步
	 * 
	 * @author xiaofei
	 * 
	 */
	public class ResetPwdStepFirst {

		public ResetPwdStepFirst() {
		}

		/**
		 * 输入注册手机号
		 * 
		 * @param phone
		 */
		public void inputPhone(String phone) {
			// AutoCompleteTextView phoneEt = (AutoCompleteTextView)
			// robotiumTools
			// .getViewById(Reset_PHONE_ET);
			// robotiumTools.enterText(phoneEt, phone);
			robotiumTools.enterText(0, phone);
		}

		/**
		 * 点击关闭按钮
		 */
		public void clickCloseBtn() throws Exception {
			Button close = (Button) robotiumTools.getViewById(Reset_CLOSE_BTN);
			robotiumTools.clickOnView(close);
		}

		/**
		 * 点击获取验证码按钮
		 */
		public void clickRegisterBtn() {
			Button close = (Button) robotiumTools.getViewById(Reset_RESET_BTN);
			robotiumTools.clickOnView(close);
		}

		/**
		 * 点击返回按钮
		 */
		public void clickloginBtn() {
			Button close = (Button) robotiumTools.getViewById(Reset_CANCEL_BTN);
			robotiumTools.clickOnView(close);
		}
	}

	/**
	 * 找回密码第二步
	 * 
	 * @author xiaofei
	 * 
	 */
	public class ResetPwdStepSecond {

		public ResetPwdStepSecond() {
		}

		/**
		 * 输入验证码
		 * 
		 * @param phone
		 */
		public void inputConfirmCode(String confirmCode) {
			AutoCompleteTextView phoneEt = (AutoCompleteTextView) robotiumTools
					.getViewById(Reset_PHONE_ET);
			robotiumTools.enterText(phoneEt, confirmCode);
		}

		/**
		 * 点击关闭按钮
		 */
		public void clickCloseBtn() throws Exception {
			Button close = (Button) robotiumTools.getViewById(Reset_CLOSE_BTN);
			robotiumTools.clickOnView(close);
		}

		/**
		 * 点击提交按钮
		 */
		public void clickReciveCodeBtn() {
			Button close = (Button) robotiumTools.getViewById(Reset_RESET_BTN);
			robotiumTools.clickOnView(close);
		}

		/**
		 * 点击返回按钮
		 */
		public void clickloginBtn() {
			Button close = (Button) robotiumTools.getViewById(Reset_CANCEL_BTN);
			robotiumTools.clickOnView(close);
		}
	}

	/**
	 * 找回密码第三步
	 * 
	 * @author xiaofei
	 * 
	 */
	public class ResetPwdStepThrid {

		public ResetPwdStepThrid() {
		}

		/**
		 * 输入新密码
		 * 
		 * @param phone
		 */
		public void inputNewPwd(String pwd) {
			AutoCompleteTextView pwdEt = (AutoCompleteTextView) robotiumTools
					.getViewById(NEW_PWD_ET);
			robotiumTools.enterText(pwdEt, pwd);
		}

		/**
		 * 确认密码
		 * 
		 * @param phone
		 */
		public void inputConfirmPwd(String pwd) {
			AutoCompleteTextView pwdEt = (AutoCompleteTextView) robotiumTools
					.getViewById(CONFIRM_ET);
			robotiumTools.enterText(pwdEt, pwd);
		}

		/**
		 * 点击关闭按钮
		 */
		public void clickCloseBtn() throws Exception {
			Button close = (Button) robotiumTools.getViewById(Reset_CLOSE_BTN);
			robotiumTools.clickOnView(close);
		}

		/**
		 * 点击确定按钮
		 */
		public void clickRegisterBtn() {
			Button close = (Button) robotiumTools
					.getViewById(Reset_CONFIRM_BTN);
			robotiumTools.clickOnView(close);
		}

		/**
		 * 点击取消按钮
		 */
		public void clickloginBtn() {
			Button close = (Button) robotiumTools.getViewById(Reset_CANCEL_BTN);
			robotiumTools.clickOnView(close);
		}
	}
}
