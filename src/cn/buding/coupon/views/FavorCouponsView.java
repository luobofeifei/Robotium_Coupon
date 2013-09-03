package cn.buding.coupon.views;

import java.util.ArrayList;

import android.app.Instrumentation;
import android.widget.Button;
import android.widget.ListView;
import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;

public class FavorCouponsView extends BaseView {
	private RobotiumTools robotiumTools = null;
	private static final String FAVOR_TIPS_TV = "tv_tips";
	private static final String FAVOR_CLEAR_BTN = "btn_right";
	private static final String FAVOR_LIST = "list";
	private static final int FIRST_POSITION_IN_LINE = 1;
	public static final int LEFT_SIDE = 21;
	public static final int RIGHT_SIDE = LEFT_SIDE + 1;
	public Instrumentation instrumentation = null;

	public FavorCouponsView(RobotiumTools robotiumTools) {
		super(robotiumTools);
		this.robotiumTools = robotiumTools;
	}

	@Override
	public void waitForActivity() {
		robotiumTools.waitForActivity(
				StaticField.Activity.FAVOR_COUPONS_ACTIVITY, 0);
	}

	@Override
	public String getViewTitle() {
		// TODO Auto-generated method stub
		String title = getViewTitle();
		return title;
	}

	/**
	 * 
	 * ���ղ�ʱ����ʾ��ҳ�� ================== ����δ�ղ��Ż�ȯ �鿴�����Ż�ȯ ==================
	 * 
	 * @return 1:successful 2:failed
	 */
	public void chickNoFavorTips() {
		robotiumTools.clickCtrlById(FAVOR_TIPS_TV);
	}

	/**
	 * ������ȫ����ť
	 * 
	 * @param clear�Ƿ����
	 */
	public void chickClearBTN(boolean clear) {
		int result = robotiumTools.clickCtrlById(FAVOR_CLEAR_BTN);
		if (result == 1 && clear) {
			new ParentPanel().clickOKBtn();
		} else if ((result == 1 && !clear)) {
			new ParentPanel().clickCancelBtn();
		}
	}

	/**
	 * ���list��ҳ���׸�item
	 * 
	 * @param line
	 */
	public void clickOnList() {
		robotiumTools.clickOnList(FIRST_POSITION_IN_LINE);
	}

	/**
	 * ����ղ��Ż�ȯ����
	 * 
	 * @return
	 */
	public int getFavorCount() {
		try {
			ArrayList<ListView> lists = robotiumTools.getCurrentListViews();
			ListView listView = lists.get(0);
			int count = listView.getChildCount();
			return count;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	/**
	 * ������ָ��line
	 */
	public void scrollingList(int line) {
		robotiumTools.scrollingList(line, FAVOR_LIST);
		clickOnList();
	}

	private class ParentPanel {
		private static final String OK_Btn = "button1";
		private static final String Cancel_Btn = "button2";

		public void clickOKBtn() {
			Button button = (Button) robotiumTools.getViewById(OK_Btn);
			robotiumTools.clickOnView(button);
		}

		public void clickCancelBtn() {
			Button button = (Button) robotiumTools.getViewById(Cancel_Btn);
			robotiumTools.clickOnView(button);
		}
	}

}
