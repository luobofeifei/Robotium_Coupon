package cn.buding.coupon.views;


import cn.buding.coupon.base.BaseView;
import cn.buding.coupon.base.RobotiumTools;
import cn.buding.coupon.field.StaticField;
import android.widget.EditText;
import android.widget.TextView;

public class SwitchCityView extends BaseView {

	private RobotiumTools robotiumTools = null;
	private String search_Et = "et_search";
	private String current_City_Tv = "tv_selected_city";
	private String local_City_Tv = "tv_located_city";
	private String view_Title_Id = "tv_title";

	public SwitchCityView(RobotiumTools robotiumTools) {
		super(robotiumTools);
		this.robotiumTools = robotiumTools;
	}

	/**
	 * 等待当前Activity
	 */
	public void waitForActivity() {
		robotiumTools.waitForActivity(StaticField.Activity.LAUNCHER_ACTIVITY,
				TIME_DELAY);
	}

	/**
	 * 获得当前页面的标题
	 * 
	 * @return
	 */
	public String getViewTitle() {
		TextView titleTv = (TextView) robotiumTools.getViewById(view_Title_Id);
		String title = titleTv.getText().toString();
		return title;
	}

	/**
	 * 切换城市
	 * 
	 * @throws Exception
	 */
	public void changeCity(int index) throws Exception {
		// 例如城市“深圳”在list中的index=3
		robotiumTools.clickInList(index, 0);
	}

	/**
	 * 切换城市
	 * 
	 * @throws Exception
	 */
	public void changeCity(String name) {
		this.selectCity(name);
		robotiumTools.clickInList(1);
	}

	/**
	 * 通过搜索框筛选城市
	 * 
	 * @param name
	 */
	public void selectCity(String name) {
		EditText searchCity = (EditText) robotiumTools.getViewById(search_Et);
		robotiumTools.enterText(searchCity, name);
	}

	/**
	 * 切换当前选择城市
	 * 
	 * @throws Exception
	 */
	public void changeCurrentCity() {
		TextView currentCity = (TextView) robotiumTools
				.getViewById(current_City_Tv);
		robotiumTools.clickOnView(currentCity);
	}

	/**
	 * 切换当前定位城市
	 * 
	 * @throws Exception
	 */
	public void changeLocalCity() {
		TextView localCity = (TextView) robotiumTools
				.getViewById(local_City_Tv);
		robotiumTools.clickOnView(localCity);
	}
}
