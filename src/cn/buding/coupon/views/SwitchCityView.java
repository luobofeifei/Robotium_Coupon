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
	 * �ȴ���ǰActivity
	 */
	public void waitForActivity() {
		robotiumTools.waitForActivity(StaticField.Activity.LAUNCHER_ACTIVITY,
				TIME_DELAY);
	}

	/**
	 * ��õ�ǰҳ��ı���
	 * 
	 * @return
	 */
	public String getViewTitle() {
		TextView titleTv = (TextView) robotiumTools.getViewById(view_Title_Id);
		String title = titleTv.getText().toString();
		return title;
	}

	/**
	 * �л�����
	 * 
	 * @throws Exception
	 */
	public void changeCity(int index) throws Exception {
		// ������С����ڡ���list�е�index=3
		robotiumTools.clickInList(index, 0);
	}

	/**
	 * �л�����
	 * 
	 * @throws Exception
	 */
	public void changeCity(String name) {
		this.selectCity(name);
		robotiumTools.clickInList(1);
	}

	/**
	 * ͨ��������ɸѡ����
	 * 
	 * @param name
	 */
	public void selectCity(String name) {
		EditText searchCity = (EditText) robotiumTools.getViewById(search_Et);
		robotiumTools.enterText(searchCity, name);
	}

	/**
	 * �л���ǰѡ�����
	 * 
	 * @throws Exception
	 */
	public void changeCurrentCity() {
		TextView currentCity = (TextView) robotiumTools
				.getViewById(current_City_Tv);
		robotiumTools.clickOnView(currentCity);
	}

	/**
	 * �л���ǰ��λ����
	 * 
	 * @throws Exception
	 */
	public void changeLocalCity() {
		TextView localCity = (TextView) robotiumTools
				.getViewById(local_City_Tv);
		robotiumTools.clickOnView(localCity);
	}
}
