package cn.buding.coupon.views;

import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;

public class RegisterActivityView extends BaseView{
	private RobotiumTools robotiumTools = null;
	private static String PHONE_ET = "et_phone";
	private static String PASS_ET = "et_password";
	private static String SHOWPASS_CB = "cb_show_password";
	private static String BACK_BTN = "btn_close";
	private static String REGISTER_BTN = "btn_register";
	private static String CLOSE_BTN = "ib_close";
	private static String USERAGREEMENT_CB = "cn_user_agreement";
	private static String USERAGREEMENT_TV = "tv_user_agreement";

	public RegisterActivityView(RobotiumTools robotiumTools) {
		super(robotiumTools);
		this.robotiumTools = robotiumTools;
	}

	public void waitForActivity() {
		robotiumTools.waitForActivity(StaticField.Activity.REGISTER_ACTIVITY,TIME_DELAY);
	}

	/**
	 * 输入注册手机号
	 * 
	 * @param phone
	 */
	public void inputPhone(String phone) {
		AutoCompleteTextView phoneEt = (AutoCompleteTextView) robotiumTools
				.getViewById(PHONE_ET);
		robotiumTools.enterText(phoneEt, phone);
	}

	/**
	 * 输入注册密码
	 * 
	 * @param pass
	 */
	public void inputPwd(String pass) {
		EditText passEt = (EditText) robotiumTools.getViewById(PASS_ET);
		robotiumTools.enterText(passEt, pass);
	}

	/**
	 * 点击关闭按钮
	 */
	public void clickCloseBtn() throws Exception {
		Button close = (Button) robotiumTools.getViewById(CLOSE_BTN);
		robotiumTools.clickOnView(close);
	}

	/**
	 * 点击注册按钮
	 */
	public void clickRegisterBtn() {
		Button close = (Button) robotiumTools.getViewById(REGISTER_BTN);
		robotiumTools.clickOnView(close);
	}

	/**
	 * 点击返回按钮
	 */
	public void clickloginBtn() {
		Button close = (Button) robotiumTools.getViewById(BACK_BTN);
		robotiumTools.clickOnView(close);
	}

	/**
	 * 点击“已阅读并同意用户注册协议”
	 * 
	 * @param agree
	 * @throws Exception
	 */
	public void isAgree(boolean agree) throws Exception {
		CheckBox agreementCb = (CheckBox) robotiumTools
				.getViewById(USERAGREEMENT_CB);
		boolean isChecked = agreementCb.isChecked();
		if ((isChecked == true || agree == true)
				|| (isChecked == false || agree == false)) {
			// do nothing now
		} else {
			/*
			 * CalledFromWrongThreadException: Only the original thread that
			 * created a view hierarchy can touch its views.
			 * agreementCb.setChecked(agree); can not work fine
			 */
			robotiumTools.clickOnView(agreementCb);
		}
	}

	/**
	 * 点击“用户注册协议”
	 * 
	 * @throws Exception
	 */
	public void clickAgreementTv() throws Exception {
		TextView agreementTv = (TextView) robotiumTools
				.getViewById(USERAGREEMENT_TV);
		robotiumTools.clickOnView(agreementTv);
	}

	/**
	 * 点击“显示密码”
	 * 
	 * @throws Exception
	 */
	public void showPass() throws Exception {
		CheckBox showPass = (CheckBox) robotiumTools.getViewById(SHOWPASS_CB);
		if (showPass.isChecked()) {
			// do nothing now
		} else {
			/*
			 * CalledFromWrongThreadException: Only the original thread that
			 * created a view hierarchy can touch its views.
			 * showPass.setChecked(true); can not work fine
			 */
			robotiumTools.clickOnView(showPass);
		}
	}

	/**
	 * 注册协议页面
	 * 
	 * @author xiaofei
	 * 
	 */
	class UserAgreementActivity {

		public void waitForActivity() {
			robotiumTools.waitForActivity(StaticField.Activity.USER_AGREEMENT_ACTIVITY,TIME_DELAY);
		}

		public void goBack() {
			robotiumTools.goBackToActivity(StaticField.Activity.REGISTER_ACTIVITY);
		}
	}

}
