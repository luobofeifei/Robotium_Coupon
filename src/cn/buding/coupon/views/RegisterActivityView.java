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
	 * ����ע���ֻ���
	 * 
	 * @param phone
	 */
	public void inputPhone(String phone) {
		AutoCompleteTextView phoneEt = (AutoCompleteTextView) robotiumTools
				.getViewById(PHONE_ET);
		robotiumTools.enterText(phoneEt, phone);
	}

	/**
	 * ����ע������
	 * 
	 * @param pass
	 */
	public void inputPwd(String pass) {
		EditText passEt = (EditText) robotiumTools.getViewById(PASS_ET);
		robotiumTools.enterText(passEt, pass);
	}

	/**
	 * ����رհ�ť
	 */
	public void clickCloseBtn() throws Exception {
		Button close = (Button) robotiumTools.getViewById(CLOSE_BTN);
		robotiumTools.clickOnView(close);
	}

	/**
	 * ���ע�ᰴť
	 */
	public void clickRegisterBtn() {
		Button close = (Button) robotiumTools.getViewById(REGISTER_BTN);
		robotiumTools.clickOnView(close);
	}

	/**
	 * ������ذ�ť
	 */
	public void clickloginBtn() {
		Button close = (Button) robotiumTools.getViewById(BACK_BTN);
		robotiumTools.clickOnView(close);
	}

	/**
	 * ��������Ķ���ͬ���û�ע��Э�顱
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
	 * ������û�ע��Э�顱
	 * 
	 * @throws Exception
	 */
	public void clickAgreementTv() throws Exception {
		TextView agreementTv = (TextView) robotiumTools
				.getViewById(USERAGREEMENT_TV);
		robotiumTools.clickOnView(agreementTv);
	}

	/**
	 * �������ʾ���롱
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
	 * ע��Э��ҳ��
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
