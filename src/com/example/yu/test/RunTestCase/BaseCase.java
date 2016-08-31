package com.example.yu.test.RunTestCase;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import android.util.Log;
import android.view.View;

import com.robotium.solo.Solo;

import android.os.SystemClock;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;
import android.widget.TextView;

@SuppressWarnings("rawtypes")
public class BaseCase extends ActivityInstrumentationTestCase2{

	public Solo solo;

	public void instance(Solo solo1) {
		solo = solo1;
	}

	/**
	 * 注意以下两个静态常量字符串 第一个是要测试的包名，和刚刚在AndroidMainfest里配置的包名一致 手机自动化之
	 * Robotium--从入门到精通 39 第二是被测程序的入口类 以下是众筹网的包名和入口类
	 */
	/**
	 * t(s);点击对应字符串的Text v(s);点击ID与字符串对应的View b(s);点击对应字符串的Button s();休眠1S
	 * jump();在订单页面没有订单式测试跳转到汽车化肥专场
	 * */
	public static final String TARGET_PACKAGE_ID = "com.ksfc.newfarmer";
	public static final String LAUNCHER_ACTIVITY_FULL_CLASSNAME = "com.ksfc.newfarmer.activitys.SplashActivity";
	// 声明一个Class类型的变量，用于ActivityInstrumentationTestCase2加载启动被测程序
	public static Class launcherActivityClass;
	// 静态加载auncherActivityClass也就是被测程序主类
	static {
		try {
			launcherActivityClass = Class
					.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	// 构造函数，传入TARGET_PACKAGE_ID,launcherActivityClass即可
	public BaseCase() {
		super(TARGET_PACKAGE_ID, launcherActivityClass);
	}

	@Before
	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation(), getActivity());
		instance(solo);
	}

	@After
	public void tearDown() throws Exception {
		solo.finishOpenedActivities();
	}

	// 让进程休眠指定时间
	public void s() {
		solo.sleep(Config.t);
	}

	// 点击Text
	public void t(String s) {
		solo.clickOnText(s);
		s();
	}
	
	// 点击Text
		public void t(String s,int i) {
			solo.clickOnText(s,i);
			s();
		}


	// 点击View
	public void v(String s) {
		solo.clickOnView(solo.getView(s));
		s();
	}

	// 模拟返回按键
	public void g() {
		solo.goBack();
	}

	// 清除输入框内的文字
	public void clear(String id) {
		solo.clearEditText((android.widget.EditText) solo.getView(id));
	}

	// 在输入文本框内输入文字
	public void enter(String id, String text) {
		solo.enterText((android.widget.EditText) solo.getView(id), text);
	}

	// 获取对应id的TextView内的String
	public String getTextViewString(String id) {
		TextView view = null;
		view = (TextView) solo.getView(id);
		String s = view.getText().toString();
		return s;
	}

	// 获取对应id的TextView内的提示文字并将其转换为String
	public String getTextHintString(String id) {
		TextView view = null;
		view = (TextView) solo.getView(id);
		String s = (String) view.getHint();
		return s;
	}

	// 获取对应id的EditText内的Text并转换为String
	public String getEditTextString(String id) {
		EditText ev = (EditText) solo.getView(id);
		String s=ev.getText().toString();
		return s;
	}

	// 打印deBugLog
	public void showLog(String msg) {
		Log.d("Robotium",msg);
	}

	// 打印错误LOG
	public void showErrLog(String msg) {
		Log.e("Robotium", msg);
	}

	// 进入登录界面
	public void login() {
		t("我的");
		if (!solo.searchText("请点击登陆", 1, false, true)) {
			v("com.ksfc.newfarmer:id/head_View_bg");
			t("退出登录");
			solo.clickOnButton("确定");
			v("com.ksfc.newfarmer:id/head_View_bg");

		} else {
			v("com.ksfc.newfarmer:id/head_View_bg");
		}
	}

	// 确认退出登录
	public void logout() {
		t("我的");
		if (!solo.searchText("请点击登陆", 1, false, true)) {
			v("com.ksfc.newfarmer:id/head_View_bg");
			t("退出登录");
			solo.clickOnButton("确定");
		}
		t("首页");
	}

	// 确认登录(根据需求来输入需要登录的账户)
	public void login_sure(String pNum) {
		t("我的");
		if (solo.searchText("请点击登陆", 1, false, true)) {
			v("com.ksfc.newfarmer:id/head_View_bg");
			clear("com.ksfc.newfarmer:id/login_layout_phone");
			enter(("com.ksfc.newfarmer:id/login_layout_phone"), pNum);
			enter(("com.ksfc.newfarmer:id/login_layoutpassword"),
					Config.pwd_cur);
			t("确认登录");
			if (solo.searchText("保存", 1, false, true)) {
				v("com.ksfc.newfarmer:id/choice_cancel");
			}
		} else {
			v("com.ksfc.newfarmer:id/head_View_bg");
			t("退出登录");
			solo.clickOnButton("确定");
			v("com.ksfc.newfarmer:id/head_View_bg");
			clear("com.ksfc.newfarmer:id/login_layout_phone");
			enter(("com.ksfc.newfarmer:id/login_layout_phone"), pNum);//
			enter(("com.ksfc.newfarmer:id/login_layoutpassword"),
					Config.pwd_cur);
			t("确认登录");
			if (solo.searchText("保存", 1, false, true)) {
				v("com.ksfc.newfarmer:id/choice_cancel");
			}
		}

	}

	// 滑动指定的View
	public void dragView(View view, float dragPercentFrom_X,
			float dragPercentFrom_Y, float dragPercentTo_X,
			float dragPercentTo_Y) {
		// 存储view的高度和宽度
		int[] xyLocation = new int[2];
		// 存储view的xy坐标，左下角坐标值
		view.getLocationOnScreen(xyLocation);
		// 获取view的宽度 final
		int viewWidth = view.getWidth();
		// 获取view的高度 final
		int viewHeight = view.getHeight();
		// 计算view的左上角的x坐标
		final float viewLeftTop_x = xyLocation[0];
		// 计算view的左上角的y坐标
		final float viewLeftTop_y = xyLocation[1];

		float FromX = viewLeftTop_x + viewWidth * dragPercentFrom_X;
		float FromY = viewLeftTop_y + viewHeight * dragPercentFrom_Y;
		float ToX = viewLeftTop_x + viewWidth * dragPercentTo_X;
		float ToY = viewLeftTop_y + viewHeight * dragPercentTo_Y;
		solo.drag(FromX, ToX, FromY, ToY, 3);
	}

	/**
	 * 随机返回一个限定范围内的整数
	 */
	public int getRandomInt(int begin, int end) {
		int a = begin + (int) (Math.random() * end);
		return a;
	}
	
	/**
	 * 随机返回一个指定长度的数字
	 */
	public String getRandomIntString(int length){
		String s="";
		for(int a=0;a<length;a++){
			s=s+""+(0+(int)(Math.random()*9));
		}
		return s;
	}
	/**
	 * 随机返回限定长度的字符串
	 */
	public String getRandomString(int length) { 
	    String base = "abcdefghijklmnopqrstuvwxyz0123456789";   
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();   
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }  
	    return sb.toString();
	}
	
	/**
	 * 获取Toast的String
	 * @return
	 */
	public String getToast(int timeout) {
		TextView toastTextView = null;
		String toastText = "";
		long endTime = SystemClock.uptimeMillis() + timeout;
		while (SystemClock.uptimeMillis() < endTime) {
			toastTextView = (TextView) solo.getView("message", 0);
			if (null != toastTextView) {
				toastText = toastTextView.getText().toString();
				break;
			} else {
				solo.sleep(500);
			}
		}
		return toastText;
	}
	/**
	 * 获取toast的text并与期望的String对比
	 * @param err_position 错误所在位置
	 * @param aim  期望获得的string
	 */
	
	public void toast_equals_string(String err_position,String aim){
		String toast=getToast(3);
		if(toast==null){
			showErrLog(err_position+"未获取到log提示");
		}else{
			if(!toast.equals(aim)){
				showErrLog(err_position+"aim:"+aim+";get:"+toast);
			}
		}
	}
	
	/**
	 * 获取到目标text后与期望的string作比较
	 * @param err_position 错误所在位置
	 * @param get 得到的text
	 * @param aim 期望的string
	 */
	public void getText_equals_aim(String err_position,String get,String aim){
		if(get==null){
			showErrLog(err_position+"获取到的text为空");
		}else{
			if(!get.equals(aim)){
				showErrLog(err_position+"aim:"+aim+"get:"+get);
			}
		}
	}
	
	/**
	 * 首页关闭活动
	 */
	public void close_huodong(){
		if(!solo.searchText(Config.text_car, 1, false, true)){
			v(Config.id_close_huodong);
		}
	}
	
	/**
	 * 判断是否出现了期望的text
	 * @param err_position 错误位置
	 * @param aim  期望出现的text
	 * @param minimumNumberOfMatches 出现的text最少次数
	 * @param scroll 是否能允许滚动查找
	 */
	public void search_text(String err_position,String aim,int minimumNumberOfMatches,boolean scroll){
		if(!solo.searchText(aim, minimumNumberOfMatches, scroll, true)){
			showErrLog(err_position+"aim:"+aim);
		}
	}
}

