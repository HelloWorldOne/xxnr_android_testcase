package com.example.yu.test;

import java.util.ArrayList;

import android.widget.ImageView;

import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;

public class CasePointStore extends BaseCase {

	public String tag = " CasePointStore";

	public static CasePointStore caseInstance(Solo solo1) {
		CasePointStore instance = new CasePointStore();
		instance.instance(solo1);
		return instance;
	}

	String AcName_point_rule = "RewardRulesActivity";// 积分规则活动名

	String text_logout_show = "您还未登录，立即登录兑换礼品、签到拿积分";
	String text_lift_particular = "礼品详情";
	String text_daiziti = "待自提";
	String text_finish = "已完成";
	String text_exchangeNow = "立即兑换";
	String text_exchageSure = "确定兑换";
	String text_chooseNet = "选择自提网点";
	String text_exchange_success = "兑换成功";
	String text_exchange_record = "兑换记录";
	String text_point_nuEnough = "积分不足";
	String text_null = "已抢光";
	String text_version_updating = "版本更新";
	String text_update_now = "立即更新";
	String text_update_later = "暂不更新";

	String id_logout_show = "com.ksfc.newfarmer:id/head_unLogin_tall_layout_float";// 未登录时的提示
	String id_pointStore_pointShow = "com.ksfc.newfarmer:id/integral_count_tv";// 积分商城首页积分展示
	String id_point = "com.ksfc.newfarmer:id/integral_count_ll";// 积分商城积分
	String id_exchange_record = "com.ksfc.newfarmer:id/changing_record_ll";// 积分商城兑换
	String id_point_rule = "com.ksfc.newfarmer:id/integral_rules_ll";// 积分商城积分规则
	String id_lift_particular = "com.ksfc.newfarmer:id/gift_content_rel";// 礼品详情
	String id_exchange_now = "com.ksfc.newfarmer:id/gift_detail_sure_tv";// 礼品详情立即兑换
	String id_myPoint_qiaodao = "com.ksfc.newfarmer:id/sign_button_tv";// 我的积分签到按钮
	String id_myPoint_pointShow = "com.ksfc.newfarmer:id/my_integral_count_tv";// 我的积分页面积分显示
	String id_myPoint_pointAdd = "com.ksfc.newfarmer:id/point_log_point_tv";// 我的积分页面签到增加的积分
	String id_linearLayout = "com.ksfc.newfarmer:id/view_container";// 积分商城商品展示的布局
	String id_gift_exchangeNow = "com.ksfc.newfarmer:id/gift_detail_sure_tv";// 礼品详情页面立即兑换按钮
	String id_jump_choose_net = "com.ksfc.newfarmer:id/select_state_address_ll_state";// 提交兑换页面进入选择自提点
	String id_gift_price = "com.ksfc.newfarmer:id/gift_price_tv";// 提交兑换页面礼品价格
	String id_exchangeSuccess_check = "com.ksfc.newfarmer:id/check_order_tv";// 兑换成功页面查看兑换记录

	String log_nullNet = "请选择自提网点";
	String log_noNte = "该地区没有网点";
	String log_version_new = "最新版本";

	public void test_run() {
		case_pointStore_logout();
		case_pointStore_loginNull();
		case_pointStore_login();
		case_pointStore_exchange();
		case_gift_noNet();
		case_gift_expensive();
		case_gift_null();
		case_gift_oldEdition();
	}

	/**
	 * 未登录时的积分商城
	 */
	public void case_pointStore_logout() {
		logout();
		// 未登录时有未登录提示
		t(Config.text_mine);
		t(Config.text_pointStore);
		if (!solo.searchText(text_logout_show, 1, false, true)) {
			showErrLog(tag + ":case_pointStore_logout():未登录时有未登录提示");
		}
		// 点击未登录提示，跳转到登录页面
		v(id_logout_show);
		solo.assertCurrentActivity(tag
				+ "case_pointStore_logout():点击未登录提示，跳转到登录页面",
				Config.AcName_login);
		g();
		// 未登录时积分显示为0
		if (!getTextViewString(id_pointStore_pointShow).equals("0")) {
			showErrLog(tag + ":case_pointStore_logout():未登录时积分显示为0");
		}
		// 未登录点击积分，应跳转到登录页面
		v(id_point);
		solo.assertCurrentActivity(tag
				+ "case_pointStore_logout():未登录点击积分，应跳转到登录页面",
				Config.AcName_login);
		g();
		// 未登路点击兑换记录，应跳转到登录页面
		v(id_exchange_record);
		solo.assertCurrentActivity(tag
				+ "case_pointStore_logout():未登路点击兑换记录，应跳转到登录页面",
				Config.AcName_login);
		g();
		// 积分规则页面
		v(id_point_rule);
		solo.assertCurrentActivity(tag
				+ "case_pointStore_logout():未登路点击兑换记录，应跳转到登录页面",
				AcName_point_rule);
		g();
		// 未登录进入商品详情页面
		v(id_lift_particular);
		if (!solo.searchText(text_lift_particular, 1, false, true)) {
			showErrLog(tag + ":case_pointStore_logout():未登录进入商品详情页面");
		}
		// 未登录在礼品详情页面兑换
		v(id_exchange_now);
		solo.assertCurrentActivity(tag
				+ "case_pointStore_logout():未登录在礼品详情页面兑换", Config.AcName_login);
		g();
		g();
		g();
		t(Config.text_homePage);
	}

	/**
	 * 兑换记录为空的账户登陆情况下的积分商城
	 */
	public void case_pointStore_loginNull() {
		// 没有兑换记录的账户
		login_sure(Config.pNum_null);
		t(Config.text_pointStore);
		// 没有兑换记录的账户进入未完成页面
		v(id_exchange_record);
		if (solo.searchText(text_daiziti, 1, false, true)) {
			showErrLog(tag + ":pointStore_login():没有兑换记录的账户进入未完成页面");
		}
		t(text_finish);
		// 没有兑换记录的账户进入已完成页面
		if (solo.searchText(text_finish, 2, false, true)) {
			showErrLog(tag + ":pointStore_login():没有兑换记录的账户进入已完成页面");
		}
		g();
		g();
		t(Config.text_homePage);
	}

	/**
	 * 登录有积分和兑换记录的账户
	 */
	public void case_pointStore_login() {
		login_sure(Config.pNum_reg);
		t(Config.text_mine);
		t(Config.text_pointStore);
		// 签到
		v(id_point);
		if (solo.getView(id_myPoint_qiaodao).isEnabled()) {
			// 在可签到的情况下签到，看是否增加相应积分
			int a = Integer.parseInt(getTextViewString(id_myPoint_pointShow));
			v(id_myPoint_qiaodao);
			String add = getTextViewString(id_myPoint_pointAdd);
			int b = Integer.parseInt(add.substring(1, add.length()));
			if (Integer.parseInt(getTextViewString(id_myPoint_pointShow)) != a
					+ b) {
				showErrLog(tag
						+ ":case_pointStore_login():在可签到的情况下签到，看是否增加相应积分");

				// 返回积分商城首页看展示的积分对不对
				g();
				int point = Integer
						.parseInt(getTextViewString(id_pointStore_pointShow));
				if (point != a + b) {
					showErrLog(tag
							+ ":case_pointStore_login():返回积分商城首页看展示的积分对不对");
				}
			}
		}
		g();
		// 有兑换记录的账户查看兑换记录
		v("com.ksfc.newfarmer:id/changing_record_ll");
		// 点击向下展开兑换订单详情
		v("com.ksfc.newfarmer:id/item_gift_order_Indicator");
		if (!solo.searchText("自提码", 1, false, true)) {
			showErrLog(tag + ":pointStore_login():点击向下展开兑换订单详情");
		}
		// 切换到已完成table
		t("已完成");
		if (!solo.searchText("已完成", 1, false, true)) {
			showErrLog(tag + ":pointStore_login():切换到已完成table");
		}
		g();
		g();
		t("首页");
	}

	/**
	 * 兑换礼品
	 */
	public void case_pointStore_exchange() {
		login_sure(Config.pNum_reg);
		t(Config.text_pointStore);
		/**
		 * 能成功兑换的商品
		 */
		int point = Integer
				.parseInt(getTextViewString(id_pointStore_pointShow));
		ArrayList<ImageView> list = solo.getCurrentViews(ImageView.class,
				solo.getView(id_linearLayout));
		solo.clickOnView(list.get(8));
		if (!solo.searchText(text_exchangeNow, 1, false, true)) {
			showErrLog(tag + ":case_pointStore_exchange():进入能兑换的礼品详情页面");
		}
		// 进入兑换页面
		v(id_gift_exchangeNow);
		if (!solo.searchText(text_exchageSure, 1, false, true)) {
			showErrLog(tag + ":case_pointStore_exchange():进入兑换页面");
		}
		// 未选择自提点的情况下兑换
		t(text_exchageSure);
		toast_equals_string(tag + ":case_pointStore_exchange():未选择自提点的情况下兑换",
				log_nullNet);
		// 选择自提网点后兑换
		v(id_jump_choose_net);
		if (!solo.searchText(text_chooseNet, 1, false, true)) {
			showErrLog(tag + ":case_pointStore_exchange():选择自提网点后兑换");
		}
		solo.clickInList(1);
		t(Config.text_sure);
		// 成功兑换
		int price = Integer.parseInt(getTextViewString(id_gift_price));
		t(text_exchageSure);
		if (!solo.searchText(text_exchange_success, 1, false, true)) {
			showErrLog(tag + ":case_pointStore_exchange():成功兑换");
		}
		// 兑换成功后跳转到兑换记录页面
		v(id_exchangeSuccess_check);
		if (!solo.searchText(text_exchange_record, 1, false, true)) {
			showErrLog(tag + ":case_pointStore_exchange():兑换成功后跳转到兑换记录页面");
		}
		g();
		g();
		// 查看兑换后积分变化
		int point_surplus = Integer
				.parseInt(getTextViewString(id_pointStore_pointShow));
		if (point_surplus != point - price) {
			showErrLog(tag + ":case_pointStore_exchange():查看兑换后积分变化");
		}
		g();
		t(Config.text_homePage);
	}

	/**
	 * 没有自提点的礼品的兑换
	 */
	public void case_gift_noNet() {
		login_sure(Config.pNum_reg);
		t(Config.text_pointStore);
		ArrayList<ImageView> list = solo.getCurrentViews(ImageView.class,
				solo.getView(id_linearLayout));
		solo.scrollDown();
		solo.clickOnView(list.get(10));
		t(text_exchangeNow);
		v(id_jump_choose_net);
		toast_equals_string(tag + ":case_gift_noStore():没有自提点的礼品的兑换", log_noNte);
		g();
		g();
		g();
		g();
		t(Config.text_homePage);
	}

	/**
	 * 积分不够的商品
	 */
	public void case_gift_expensive() {
		login_sure(Config.pNum_reg);
		t(Config.text_pointStore);
		ArrayList<ImageView> list = solo.getCurrentViews(ImageView.class,
				solo.getView(id_linearLayout));
		solo.scrollDown();
		solo.clickOnView(list.get(14));
		if (!solo.searchText(text_point_nuEnough, 1, false, true)) {
			showErrLog(tag + ":case_gift_expensive():积分不够的商品");
		}
		// 积分不足无法点击兑换
		if (solo.getView(id_gift_exchangeNow).isEnabled()) {
			showErrLog(tag + ":case_gift_expensive():积分不足无法点击兑换");
		}
		g();
		g();
		t(Config.text_homePage);
	}

	/**
	 * 已抢光的礼品
	 */
	public void case_gift_null() {
		login_sure(Config.pNum_reg);
		t(Config.text_pointStore);
		ArrayList<ImageView> list = solo.getCurrentViews(ImageView.class,
				solo.getView(id_linearLayout));
		solo.scrollDown();
		solo.clickOnView(list.get(12));
		if (!solo.searchText(text_null, 1, false, true)) {
			showErrLog(tag + ": case_gift_null()");
		}
		// 已抢光，兑换按钮无法点击
		if (solo.getView(id_gift_exchangeNow).isEnabled()) {
			showErrLog(tag + ": case_gift_null():已抢光，兑换按钮无法点击");
		}
		g();
		g();
		t(Config.text_homePage);
	}

	/**
	 * 不支持兑换的老版本
	 */
	public void case_gift_oldEdition() {
		login_sure(Config.pNum_reg);
		t(Config.text_pointStore);
		ArrayList<ImageView> list = solo.getCurrentViews(ImageView.class,
				solo.getView(id_linearLayout));
		solo.clickOnView(list.get(0));
		// 老板本进入提交兑换页面
		v(id_gift_exchangeNow);
		if (!solo.searchText(text_version_updating, 1, false, true)) {
			showErrLog(tag + ":case_gift_oldEdition():老板本进入提交兑换页面");
		}
		// 选择版本更新
		t(text_version_updating);
		if (solo.waitForText(log_version_new)) {
			g();
			g();
			g();
			t(Config.text_homePage);
		} else {
			if (!solo.searchText(text_update_now, 1, false, true)) {
				showErrLog(tag + ":case_gift_oldEdition():选择版本更新");
			}
			t(text_update_later);
			v("com.ksfc.newfarmer:id/up_grade");
			t(text_update_now);
		}
	}
}
