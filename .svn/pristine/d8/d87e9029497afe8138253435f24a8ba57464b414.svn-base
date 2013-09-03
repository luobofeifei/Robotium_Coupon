package cn.buding.coupon.base;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import com.jayway.android.robotium.solo.Solo;

import android.app.Activity;
import android.app.Instrumentation;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import cn.buding.coupon.field.StaticField;
import cn.buding.coupon.main.MainTest;

public class RobotiumTools {
	Solo solo = null;

	private RobotiumTools() {
		this.solo = MainTest.solo;
	}

	public static RobotiumTools getInstance() {
		return new RobotiumTools();
	}

	/**
	 * 封装的根据控件名称点击事件
	 * 
	 * @param id
	 * @param packageName
	 * @param timeDelay
	 * @return int
	 */
	public int clickCtrlById(String id, String packageName, int timeDelay) {
		int ctrl = 0;
		try {
			View v = null;

			if (id == "") {
				return -1;
			}
			ctrl = solo.getCurrentActivity().getResources()
					.getIdentifier(id, "id", packageName);
			v = solo.getView(ctrl);
			solo.clickOnView(v);
			solo.sleep(timeDelay);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Logger.e(e.getMessage());
		}
		return 0;
	}

	/**
	 * 根据控件名称点击指定控件
	 * 
	 * @param id
	 * @return 1:successful 2:failed
	 */
	public int clickCtrlById(String id) {
		int ctrl = 0;
		try {
			View v = null;

			if (id == "") {
				return -1;
			}
			ctrl = solo.getCurrentActivity().getResources()
					.getIdentifier(id, "id", StaticField.COUPON_PACKAGE);
			v = solo.getView(ctrl);
			solo.clickOnView(v);
			solo.sleep(0);
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.e(e.getMessage());
		}
		return 0;
	}

	/**
	 * 根据ID获得控件view
	 * 
	 * @param id
	 * @return View
	 */
	public View getViewById(String id) {
		int ctrl = 0;
		try {
			if (id == "") {
				return null;
			}
			ctrl = solo.getCurrentActivity().getResources()
					.getIdentifier(id, "id", StaticField.COUPON_PACKAGE);
		} catch (Exception e) {
			// TODO: handle exception
			Logger.e(e.getMessage());
		}
		return solo.getView(ctrl);
	}

	/**
	 * 根据text内容获得控件view
	 * 
	 * @param id
	 * @return View
	 */
	public View getViewByText(String contents, String targetType) {
		try {
			ArrayList<View> views = solo.getCurrentViews();
			ArrayList<TextView> temp = new ArrayList<TextView>();
			Iterator<View> iterator = views.iterator();
			while (iterator.hasNext()) {
				View target = iterator.next();
				String viewType = target.getClass().getName();
				if (viewType.indexOf(targetType) > 0) {
					temp.add((TextView) target);
				}
			}
			for (int i = 0; i < temp.size(); i++) {
				TextView textView = temp.get(i);
				String text = textView.getText().toString();
				if (text.indexOf(contents) >= 0) {
					return textView;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.e(e.getMessage());
		}
		return null;
	}

	/**
	 * 查找符合View类型、部分匹配text的textView
	 * 
	 * @param key
	 * @return TextView
	 */
	public TextView getTextView(String key) {
		ArrayList<View> views = solo.getCurrentViews();
		Iterator<View> iterator = views.iterator();
		while (iterator.hasNext()) {
			View view = iterator.next();
			String name = view.getClass().getName().toString();
			Logger.d(name);
			if (name.indexOf(StaticField.ViewType.TEXT_VIEW) > 0) {
				TextView textView = (TextView) view;
				String content = textView.getText().toString();
				if (content.indexOf(key) >= 0) {
					return textView;

				}
			}
		}
		return null;
	}

	/**
	 * 根据Id获得控件view
	 * 
	 * @param id
	 * @return View
	 */
	public View getViewById(String contents, String targetType) {
		int ctrl = 0;
		try {
			ArrayList<View> views = solo.getCurrentViews();
			ArrayList<TextView> temp = new ArrayList<TextView>();
			Iterator<View> iterator = views.iterator();
			while (iterator.hasNext()) {
				View target = iterator.next();
				String viewType = target.getClass().getName();
				if (viewType.indexOf(targetType) > 0) {
					temp.add((TextView) target);
				}
			}
			for (int i = 0; i < temp.size(); i++) {
				TextView textView = temp.get(i);
				String text = textView.getText().toString();
				if (text.equals(contents)) {
					ctrl = textView.getId();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.e(e.getMessage());
		}
		return solo.getView(ctrl);
	}

	/**
	 * 判断View是否与Type匹配
	 * 
	 * @param id
	 * @return View
	 */
	public View compareViewByType(View view, String targetType) {
		try {
			String viewType = view.getClass().getName();
			if (viewType.indexOf(targetType) > 0) {
				return view;
			}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.d(e.getMessage());
		}
		return null;
	}

	public ArrayList<View> getViewFromViewGroup(ViewGroup viewGroup,
			String targetType) {
		try {
			int count = viewGroup.getChildCount();
			ArrayList<View> views = new ArrayList<View>();
			for (int i = 0; i < count; i++) {
				View childView = viewGroup.getChildAt(i);
				String type = childView.getClass().toString();
				if (type.indexOf(targetType) >= 0)
					views.add(viewGroup.getChildAt(i));
			}
			return views;
		} catch (Exception e) {
			// TODO: handle exception
			Logger.d(e.getMessage());
		}
		return null;
	}

	/**
	 * 根据Index在listview中获取控件view
	 * 
	 * @param listElement
	 * @param indexInList
	 * @param instrumentation
	 * @return View
	 */
	public View getViewAtIndex(final ListView listElement,
			final int indexInList, Instrumentation instrumentation) {
		ListView parent = listElement;
		if (parent != null) {
			if (indexInList <= parent.getAdapter().getCount()) {
				scrollListTo(parent, indexInList, instrumentation);
				int indexToUse = indexInList - parent.getFirstVisiblePosition();
				return parent.getChildAt(indexToUse);
			}
		}
		return null;
	}

	/**
	 * 滚动至list指定行
	 * 
	 * @param listView
	 * @param index
	 * @param instrumentation
	 */
	public <T extends AbsListView> void scrollListTo(final T listView,
			final int index, Instrumentation instrumentation) {
		instrumentation.runOnMainSync(new Runnable() {
			@Override
			public void run() {
				listView.setSelection(index);
			}
		});
		instrumentation.waitForIdleSync();
	}

	public void scrollListToBottom(AbsListView list) {
		solo.scrollListToBottom(list);
	}

	/**
	 * 获得指定TextView的txt内容
	 * 
	 * @param viewId
	 * @return TextView.getText()
	 */
	public String getTextById(String viewId) {
		TextView textView = (TextView) getViewById(viewId);
		String content = textView.getText().toString();
		return content;
	}

	/**
	 * 截取String
	 * @param beginChar
	 * @param endChar
	 * @param content
	 * @return 截取后的内容
	 */
	public String subString(char beginChar, char endChar, String content) {
		int start = content.indexOf(beginChar) + 1;
		int end = content.indexOf(endChar);
		content = content.substring(start, end);
		return content;
	}

	/**
	 * 获取当前时间
	 * 
	 * @return 当前日期
	 */
	public String GetNowDate() {
		String temp_str = "";
		Date dt = new Date();
		// 最后的aa表示“上午”或“下午” HH表示24小时制 如果换成hh表示12小时制
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss aa");
		temp_str = " " + sdf.format(dt);
		return temp_str;
	}

	/**
	 * 滚动List至指定行数
	 * 
	 * @param line
	 *            指定行数
	 * @param viewId
	 *            指定ListView的ID
	 */
	public void scrollingList(int line, String viewId) {
		View tv = getViewById(viewId);
		ViewParent viewParent = (tv.getParent()).getParent();
		AbsListView absListView = (AbsListView) viewParent;
		solo.scrollListToLine(absListView, line);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Logger.e(e.getMessage());
		}
	}
	
	/**
	 * 滚动List至指定行数
	 * 
	 * @param line
	 *            指定行数
	 * @param viewId
	 *            指定ListView的ID
	 */
	public void scrollingList(int line, View list) {
		AbsListView absListView = (AbsListView) list;
		solo.scrollListToLine(absListView, line);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Logger.e(e.getMessage());
		}
	}

	/**
	 * 点击list分页中首个item
	 * 
	 * @param line
	 *            指定行数
	 */
	public void clickOnList(int line) {
		int onClickLine = line;
		solo.clickInList(onClickLine);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			Logger.e(e.getMessage());
		}
	}

	
	public void scrollViewToSide(View view, int side) {
		solo.scrollViewToSide(view, side);
	}

	public boolean searchText(String text, boolean isVisible) {
		return solo.searchText(text, isVisible);
	}

	public void takeScreenshot(String name) {
		if (name != null) {
			solo.takeScreenshot(name);
		} else {
			solo.takeScreenshot();
		}
	}

	/**
	 * 依次点击list中View对象
	 * 
	 * @param list
	 *            目标list
	 * @param delay
	 *            执行间隔
	 */
	public void clickQueue(ArrayList<View> targets, long delay) {
		int count = targets.size();
		for (int i = 0; i < count; i++) {
			View view = targets.get(i);
			solo.clickOnView(view);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
				Logger.e(e.getMessage());
			}
		}
	}

	public void clickOnView(View view) {
		solo.clickOnView(view);
	}

	public void waitForActivity(String activityName, int timeout) {
		solo.waitForActivity(activityName, timeout);
	}

	public ArrayList<ListView> getCurrentListViews() {
//		return solo.getCurrentListViews();
		return solo.getCurrentViews(ListView.class);
	}

	public ListView getCurrentListViews(int index) {
//		ArrayList<ListView> lists = solo.getCurrentListViews();
		ArrayList<ListView> lists = solo.getCurrentViews(ListView.class);
		if (lists.size() > 0) {
			return lists.get(index);
		}
		return null;
	}

	public Activity getCurrentActivity() {
		return solo.getCurrentActivity();
	}

	public void enterText(EditText editText, String content) {
		solo.enterText(editText, content);
	}

	public void clickOnText(String text, int match, boolean scroll) {
		solo.clickOnText(text, match, scroll);
	}

	public void goBackToActivity(String name) {
		solo.goBackToActivity(name);
	}
	
	public void goBack() {
		solo.goBack();
	}

	public void enterText(int index, String text) {
		solo.enterText(index, text);
	}

	public void clickInList(int line) {
		solo.clickInList(line);
	}

	public void clickInList(int line, int index) {
		solo.clickInList(line, index);
	}

//	public ScrollView getCurrentScrollViews(int index) {
//		return solo.getCurrentScrollViews().get(index);
//	}
//
//	public ArrayList<ScrollView> getCurrentScrollViews() {
//		return solo.getCurrentScrollViews();
//	}
	
	public View getViewFromListView(int line,Class<?> clazz){
		if(clazz == null){
			return null;
		}
		line -=1;
		ListView listView = getCurrentListViews(0);
		int count = listView.getCount();
		int currentHeight = listView.getHeight();
		int childHeight = listView.getChildAt(0).getHeight();
		int cPerView = currentHeight/childHeight;
		int index = line%count;
		
		if (line  > count) {
			return null;
		}
		LinearLayout view = null;
		if((count-index) >= cPerView){
			view = (LinearLayout) listView.getChildAt(line);
			if(view == null){
				scrollingList(line, listView);
				listView.getChildAt(0);
			}
		}else{
			scrollListToBottom(listView);
			line = cPerView/(count - index);
			return  listView.getChildAt(line);
		}
		return view;
	}
	
	public void sleep(){
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
