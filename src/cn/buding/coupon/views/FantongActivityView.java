package cn.buding.coupon.views;

import java.util.ArrayList;

import android.app.Instrumentation;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;

public class FantongActivityView extends BaseView {
	private RobotiumTools robotiumTools = null;
	private static final String BRAND_REFRESH_BTN = "btn_left";
	private static final String BRAND_MYPOCKET_BTN = "btn_right";
	private static final String BRAND_SUB_SHOPS_RL = "subshops";
	private static final String BRAND_COUNT_TV = "tv_count";
	private static final String BRAND_COUPONS_LV = "list";
	private static final String BRAND_DOWNLOAD_LV = "download";
	private static final String BRAND_ERROR_TIPS_TV = "tv_tips";

	public static final int LEFT_SIDE = 21;
	public static final int RIGHT_SIDE = LEFT_SIDE + 1;
	public Instrumentation instrumentation = null;

	public FantongActivityView(RobotiumTools tools) {
		super(tools);
		// TODO Auto-generated constructor stub
		this.robotiumTools = tools;
	}

	@Override
	public void waitForActivity() {
		// TODO Auto-generated method stub
		tools.waitForActivity(StaticField.Activity.FANTONG_ACTIVITY, TIME_DELAY);
	}
	
	public void clickInList(){
		ArrayList<ListView> lists = robotiumTools.getCurrentListViews();
		int count = lists.size();
		if(count > 0){
			ListView listView = lists.get(0);
			int shopCount = listView.getChildCount();
			if(shopCount > 0){
				robotiumTools.clickOnList(1);
			}
			
		}
		
	}
	
	public class FantongInfo{
		private static final String ORDER_BTN= "btn_enter";
		
		public String getTitle(){
			return getViewTitle();
		}
		
		public void clickEnterBtn(){
			View view = robotiumTools.getViewById(ORDER_BTN);
			robotiumTools.clickOnView(view);
		}
		
		
	}
	
	public class FantongOrder {
		private static final String SHOP_TV= "tv_shop";
		private static final String DATE_BTN= "btn_date";
		
		public String getTitle(){
			return getViewTitle();
		}
		
		public String getShopName(){
			String name = robotiumTools.getTextById(SHOP_TV);
			return name;
		}
		
		public void setDate(){
			View view = robotiumTools.getViewById(DATE_BTN);
			robotiumTools.clickOnView(view);
			View view2 = robotiumTools.getViewById("year");
			NumberPicker numberPicker = (NumberPicker)view2;
			View view3 = numberPicker.getChildAt(0);
			EditText editText = (EditText)view3;
			robotiumTools.enterText(editText, "2014");
		}
		
		
	}
	
	

}
