package cn.buding.coupon.views;

import android.view.View;
import android.widget.Button;
import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;

public class OrderActivity extends BaseView {
	private RobotiumTools robotiumTools = null;
	private static final String ORDER_MYPOCKET_BTN = "btn_right";
	private static final String ORDER_COUPON_TV = "tv_coupon";
	private static final String ORDER_ADD_BTN = "btn_add";
	private static final String ORDER_COUNT_TV = "tv_count";
	private static final String ORDER_SUB_BTN = "btn_sub";
	private static final String ORDER_UNIT_PRICE_TV = "tv_unit_price";
	private static final String ORDER_TOTAL_PRICE_TV = "tv_total_price";
	private static final String ORDER_VALID_TV = "tv_valid_date";
	private static final String ORDER_ALIPAY_RB = "rb_alipay";
	private static final String ORDER_UPPAY_RB = "rb_uppay";
	private static final String ORDER_CONFIRM_PRICE_TV = "tv_confirm_price";
	private static final String ORDER_PAY_BTN = "btn_pay";

	public OrderActivity(RobotiumTools robotiumTools) {
		super(robotiumTools);
		this.robotiumTools = robotiumTools;
	}

	@Override
	public void waitForActivity() {
		// TODO Auto-generated method stub
		robotiumTools
				.waitForActivity(StaticField.Activity.ORDER_ACTIVITY, 1000);
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		String title = getViewTitle();
		return title;
	}

	public String getCouponDetail() {
		String detail = robotiumTools.getTextById(ORDER_COUPON_TV);
		return detail;
	}

	public String getUnitPrice() {
		String detail = robotiumTools.getTextById(ORDER_UNIT_PRICE_TV);
		return detail;
	}

	public String getTotalPrice() {
		String detail = robotiumTools.getTextById(ORDER_TOTAL_PRICE_TV);
		return detail;
	}

	public String getValidDate() {
		String detail = robotiumTools.getTextById(ORDER_VALID_TV);
		return detail;
	}

	public String getCount() {
		String count = robotiumTools.getTextById(ORDER_COUNT_TV);
		return count;
	}

	public void clickAddBtn() {
		View add = robotiumTools.getViewById(ORDER_ADD_BTN);
		robotiumTools.clickOnView(add);
	}

	public void clickSubBtn() {
		View sub = robotiumTools.getViewById(ORDER_SUB_BTN);
		robotiumTools.clickOnView(sub);
	}

	public void choiceAlipay() {
		View alipay = robotiumTools.getViewById(ORDER_ALIPAY_RB);
		robotiumTools.clickOnView(alipay);
	}

	public void choiceUppay() {
		View uppay = robotiumTools.getViewById(ORDER_UPPAY_RB);
		robotiumTools.clickOnView(uppay);
	}

	public String getConfirmPrice() {
		String price = robotiumTools.getTextById(ORDER_CONFIRM_PRICE_TV);
		return price;
	}

	public void clickPayBtn() {
		View pay = robotiumTools.getViewById(ORDER_PAY_BTN);
		robotiumTools.clickOnView(pay);
	}

	/**
	 * µã»÷¿Ú´ü°´Å¥
	 */
	public void clickPocketBtn() {
		Button myPocket = (Button) robotiumTools
				.getViewById(ORDER_MYPOCKET_BTN);
		robotiumTools.clickOnView(myPocket);
	}

}
