package cn.buding.coupon.views;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;

public class PrintActivityView extends BaseView {
	private RobotiumTools robotiumTools = null;
	private static final String PRINT_NUM_TV = "tv_print_num";
	private static final String PRINT_MYPOCKET_BTN = "btn_right";
	private static final String PRINT_HINT_LL = "ll_print_hint";

	public PrintActivityView(RobotiumTools tools) {
		super(tools);
		// TODO Auto-generated constructor stub
		this.robotiumTools = tools;
	}

	@Override
	public void waitForActivity() {
		// TODO Auto-generated method stub
		robotiumTools.waitForActivity(StaticField.Activity.PRINT_ACTIVITY,
				TIME_DELAY);
	}

	public String getTitle() {
		String title = getViewTitle();
		return title;
	}

	public void addCouponToPrint(int line) {
		LinearLayout view = (LinearLayout) robotiumTools.getViewFromListView(
				line, LinearLayout.class);
		LinearLayout view1 = (LinearLayout) view.getChildAt(2);
		View view2 = view1.getChildAt(1);
		robotiumTools.clickOnView(view2);
	}

	public void clickInList(int line) {
		robotiumTools.clickInList(line);
	}

	public void clickMyPocketBtn() {
		View view = robotiumTools.getViewById(PRINT_MYPOCKET_BTN);
		robotiumTools.clickOnView(view);
	}

	public void clickPrintBar() {
		View view = robotiumTools.getViewById(PRINT_HINT_LL);
		robotiumTools.clickOnView(view);
	}

	public String getCount() {
		String count = robotiumTools.getTextById(PRINT_NUM_TV);
		return count;
	}

	public class PrintDetailActivityView {

		private static final String PRINT_SUBSHOPS_BTN = "btn_sub_shops";
		private static final String PRINT_COUPON_ADD_ll = "ll_coupon_add";
		private static final String DETAILS_PAGE_LEFT_BTN = "btn_page_left_btn";
		private static final String DETAILS_PAGE_RIGHT_BTN = "btn_page_right_btn";

		public PrintDetailActivityView() {
		}

		public void waitForActivity() {
			robotiumTools.waitForActivity(
					StaticField.Activity.PRINT_DETAIL_ACTIVITY, TIME_DELAY);
		}

		public void clickLeftPageBtn() {
			Button left = (Button) robotiumTools
					.getViewById(DETAILS_PAGE_LEFT_BTN);
			robotiumTools.clickOnView(left);
		}

		public void clickRightPageBtn() {
			Button right = (Button) robotiumTools
					.getViewById(DETAILS_PAGE_RIGHT_BTN);
			robotiumTools.clickOnView(right);
		}

		public String getTitle() {
			String title = getViewTitle();
			return title;
		}

		public void addCouponToPrint(int line) {
			View view = robotiumTools.getViewById(PRINT_COUPON_ADD_ll);
			robotiumTools.clickOnView(view);
		}

		public void clickMyPocketBtn() {
			View view = robotiumTools.getViewById(PRINT_MYPOCKET_BTN);
			robotiumTools.clickOnView(view);
		}

		public void clickSubshopsBtn() {
			View view = robotiumTools.getViewById(PRINT_SUBSHOPS_BTN);
			robotiumTools.clickOnView(view);
		}

		public void clickInList(int line) {
			robotiumTools.clickInList(line);
		}

		public void clickPrintBar() {
			View view = robotiumTools.getViewById(PRINT_HINT_LL);
			robotiumTools.clickOnView(view);
		}

		public String getCount() {
			String count = robotiumTools.getTextById(PRINT_NUM_TV);
			return count;
		}

		/**
		 * to be continued
		 */
		public void scrollView() {
		}

	}

	public class PrintComfirmActivityView {
		private static final String OK_BTN = "button1";
		private static final String CANCEL_BTN = "button2";
		private static final String PRINT_EMAIL_TV = "tv_email";
		private static final String PRINT_SUM_TV = "tv_sum";
		private static final String PRINT_CONFIRM_BTN = "btn_confirm";

		private LinearLayout linearLayout;
		private RelativeLayout relativeLayout;
		private RelativeLayout relativeLayout1;

		private ListView listView;

		public PrintComfirmActivityView() {
		}

		public void waitForActivity() {
			robotiumTools.waitForActivity(
					StaticField.Activity.PRINT_CONFIRM_ACTIVITY, TIME_DELAY);
		}

		public String getTitle() {
			String title = getViewTitle();
			return title;
		}

		public void clickMyPocketBtn() {
			View view = robotiumTools.getViewById(PRINT_MYPOCKET_BTN);
			robotiumTools.clickOnView(view);
		}

		public void clickSetEmail(String email, boolean set) {
			View view = robotiumTools.getViewById(PRINT_HINT_LL);
			robotiumTools.clickOnView(view);
			FrameLayout frameLayout = (FrameLayout) robotiumTools
					.getViewById("custom");
			EditText editText = (EditText) frameLayout.getChildAt(0);
			robotiumTools.enterText(editText, email);
			if (set) {
				robotiumTools.clickOnView(robotiumTools.getViewById(OK_BTN));
			} else {
				robotiumTools
						.clickOnView(robotiumTools.getViewById(CANCEL_BTN));
			}
		}

		public String getEmail() {
			String email = robotiumTools.getTextById(PRINT_EMAIL_TV);
			return email;
		}

		public void addCount(int line) {
			if (listView == null) {
				ListView listView = robotiumTools.getCurrentListViews(0);
				this.listView = listView;
			}
			init(line);
			Button plus = (Button) relativeLayout1.getChildAt(2);
			robotiumTools.clickOnView(plus);
		}

		public void minusCount(int line) {
			if (listView == null) {
				ListView listView = robotiumTools.getCurrentListViews(0);
				this.listView = listView;
			}
			init(line);
			Button minus = (Button) relativeLayout1.getChildAt(0);
			robotiumTools.clickOnView(minus);

		}

		public int getCount(int line) {
			if (listView == null) {
				ListView listView = robotiumTools.getCurrentListViews(0);
				this.listView = listView;
			}
			init(line);
			TextView count = (TextView) relativeLayout1.getChildAt(1);
			return Integer.parseInt(count.getText().toString());
		}

		private void init(int line) {
			if (linearLayout == null || relativeLayout == null
					|| relativeLayout1 == null) {
				LinearLayout linearLayout = (LinearLayout) listView
						.getChildAt(line - 1);
				this.linearLayout = linearLayout;
				RelativeLayout relativeLayout = (RelativeLayout) linearLayout
						.getChildAt(1);
				this.relativeLayout = relativeLayout;
				RelativeLayout relativeLayout1 = (RelativeLayout) relativeLayout
						.getChildAt(2);
				this.relativeLayout1 = relativeLayout1;
			}

		}

		public int getSumCount() {
			String count = robotiumTools.getTextById(PRINT_SUM_TV);
			return Integer.parseInt(count);
		}

		public void clickComfirmBtn() {
			View view = robotiumTools.getViewById(PRINT_CONFIRM_BTN);
			robotiumTools.clickOnView(view);
		}

		/**
		 * to be continued
		 */
		public void scrollView() {
		}

	}

}
