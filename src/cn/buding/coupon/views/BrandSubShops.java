package cn.buding.coupon.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.Logger;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;

public class BrandSubShops extends BaseView {
	private RobotiumTools robotiumTools = null;
	private static final String BRAND_MAP_BTN = "btn_right";
	private static final String BRAND_COUPONS_LV = "list";
	private static final String BRAND_LLFOOTER_LL_TXT = "查看更多";

	public BrandSubShops(RobotiumTools robotiumTools) {
		super(robotiumTools);
		this.robotiumTools = robotiumTools;
	}

	@Override
	public void waitForActivity() {
		// TODO Auto-generated method stub
		robotiumTools.waitForActivity(
				StaticField.Activity.BRAND_SUBSHOPS_ACTIVITY, TIME_DELAY);
	}

	public String getTitle() {
		// TODO Auto-generated method stub
		String title = getViewTitle();
		return title;
	}

	public int getShopCount() {
		String content = getViewTitle();
		int count = Integer
				.parseInt(robotiumTools.subString('(', ')', content));
		return count;
	}

	public void clickMapBtn() {
		robotiumTools.clickCtrlById(BRAND_MAP_BTN);
	}

	public void clickMoreInList() {
		scrollBottom();
		robotiumTools.searchText(BRAND_LLFOOTER_LL_TXT, false);
	}

	public Map<String, String> getBrandName(int line) {
		ArrayList<ListView> listViews = robotiumTools.getCurrentListViews();
		Map<String, String> brandMap = new HashMap<String, String>();
		int size = listViews.size();
		if (size > 0) {
			for (ListView listView : listViews) {
				try {
					RelativeLayout relativeLayout = (RelativeLayout) listView
							.getChildAt(line + 1);
					ArrayList<View> lists = robotiumTools.getViewFromViewGroup(
							relativeLayout, StaticField.ViewType.TEXT_VIEW);
					TextView name_tv = (TextView) lists.get(1);
					String name = name_tv.getText().toString();
					brandMap.put("name", name);
					String address = getAddress(relativeLayout);
					brandMap.put("address", address);
					return brandMap;
				} catch (Exception e) {
					// TODO: handle exception
					Logger.e(e.getMessage());
				}

			}
		}
		return null;
	}

	private String getAddress(RelativeLayout relativeLayout) {
		ArrayList<View> lists = robotiumTools.getViewFromViewGroup(
				relativeLayout, StaticField.ViewType.LINEAR_LAYOUT);
		LinearLayout layout = (LinearLayout) lists.get(0);
		TextView address_tv = (TextView) layout.getChildAt(1);
		String address = address_tv.getText().toString();
		return address;
	}

	/**
	 * 点击附近分店页面指定分店
	 * 
	 * @param line
	 *            指定点击行数
	 * @param mode
	 *            指定点击后模式 {@value=Mode.COPY ,@value=Mode.MAP }
	 */
	public void clickOnList(int line, int mode) {
		robotiumTools.clickOnList(line);
		ArrayList<ListView> listViews = robotiumTools.getCurrentListViews();
		int size = listViews.size();
		if (size > 0) {
			View view = null;
			for (ListView listView : listViews) {
				switch (mode) {
				case Mode.COPY:
					view = listView.getChildAt(1);
					robotiumTools.clickOnView(view);
					getCopyContents();
					break;
				case Mode.MAP:
					view = listView.getChildAt(0);
					robotiumTools.clickOnView(view);
					break;
				default:
					break;
				}
			}
		}

	}

	public String getCopyContents() {
		Context context = robotiumTools.getCurrentActivity()
				.getApplicationContext();
		ClipboardManager clip = (ClipboardManager) context
				.getSystemService(Context.CLIPBOARD_SERVICE);
		StringBuffer sb = new StringBuffer();
		ClipData data = clip.getPrimaryClip();
		if (data != null) {
			int count = data.getItemCount();
			for (int i = 0; i < count; i++) {
				String text = data.getItemAt(i).getText().toString();
				Logger.e(text);
				sb.append(text + " ");
			}
		}
		return sb.toString();
	}

	/**
	 * 滚动至指定line
	 */
	public void scrollingList(int line) {
		robotiumTools.scrollingList(line, BRAND_COUPONS_LV);
		clickOnList(1, 0);
	}

	public void scrollBottom() {
		ArrayList<ListView> lists = robotiumTools.getCurrentListViews();
		AbsListView list = (AbsListView) lists.get(0);
		robotiumTools.scrollListToBottom(list);
	}

	public class Mode {
		public static final int COPY = 1;
		public static final int MAP = 2;
	}

}
