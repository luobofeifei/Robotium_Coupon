package cn.buding.coupon.views;

import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;

public class LoginActivityView extends BaseView {
	private RobotiumTools robotiumTools = null;

	private static String LOGIN_PHONE_ET = "et_phone";
	private static String LOGIN_PASS_ET = "et_password";

	private static String LOGIN_BTN = "btn_login";
	private static String REGISTER_BTN = "btn_register";
	private static String CLOSE_BTN = "ib_close";
	private static String FORGET_PASSWORD_TV = "tv_forget_password";

	public LoginActivityView(RobotiumTools robotiumTools) {
		super(robotiumTools);
		this.robotiumTools = robotiumTools;
	}

	@Override
	public void waitForActivity() {
		robotiumTools.waitForActivity(StaticField.Activity.LOGIN_ACTIVITY,
				TIME_DELAY);
	}

	/**
	 * ÊäÈë×¢²áÊÖ»úºÅ
	 * 
	 * @param phone
	 */
	public void inputPhone(String phone) {
		AutoCompleteTextView phoneEt = (AutoCompleteTextView) robotiumTools
				.getViewById(LOGIN_PHONE_ET);
		robotiumTools.enterText(phoneEt, phone);
	}

	/**
	 * ÊäÈë×¢²áÃÜÂë
	 * 
	 * @param pass
	 */
	public void inputPwd(String pass) {
		EditText passEt = (EditText) robotiumTools.getViewById(LOGIN_PASS_ET);
		robotiumTools.enterText(passEt, pass);
	}

	/**
	 * µã»÷×¢²á°´Å¥
	 */
	public void clickRegisterBtn() {
		Button close = (Button) robotiumTools.getViewById(REGISTER_BTN);
		robotiumTools.clickOnView(close);
	}

	/**
	 * µã»÷µÇÂ½°´Å¥
	 */
	public void clickloginBtn() {
		Button close = (Button) robotiumTools.getViewById(LOGIN_BTN);
		robotiumTools.clickOnView(close);
	}

	/**
	 * µã»÷Íü¼ÇÃÜÂë
	 */
	public void clickForgetTV() {
		View forgetTv = robotiumTools.getViewById(FORGET_PASSWORD_TV);
		robotiumTools.clickOnView(forgetTv);
	}

	/**
	 * µã»÷¹Ø±Õ°´Å¥
	 */
	public void clickCloseBtn() throws Exception {
		Button close = (Button) robotiumTools.getViewById(CLOSE_BTN);
		robotiumTools.clickOnView(close);
	}
}
