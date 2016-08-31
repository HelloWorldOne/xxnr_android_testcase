package com.example.yu.test;

import android.view.View;
import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;

public class CaseHomePage extends BaseCase {
	public static String tag = "CaseHomePage";

	public static CaseHomePage caseInstance(Solo solo1) {
		CaseHomePage instance = new CaseHomePage();
		instance.instance(solo1);
		return instance;
	}

	String id_viewPager = "com.ksfc.newfarmer:id/iv";

	String text_qiandaoSuccess = "签到成功";

	String log_qiaodao = "您今日已签到成功，明天再来呦！";

	// 运行
	public void test_run() {
		close_huodong();
		case_homePage_qiandao();
		case_homePager_jump();
		case_homePage_information();
	}

	/**
	 * 首页:签到
	 */
	public void case_homePage_qiandao() {

		// 未登录情况下签到
		logout();
		v(Config.id_title_right_img);
		solo.assertCurrentActivity(tag + ":case_homePage_qiandao():未登录情况下签到",
				Config.AcName_login);
		g();
		// 登录情况下签到
		login_sure(Config.pNum_reg);
		t(Config.text_homePage);
		v(Config.id_title_right_img);
		if (!solo.waitForText(log_qiaodao)) {
			search_text(tag + ": case_homePage_qiandao()登录情况下签到",
					text_qiandaoSuccess, 1, false);
		}
		v(Config.id_title_right_img);
		toast_equals_string(tag + ": case_homePage_qiandao():登录情况下签到",
				log_qiaodao);
	}

	/**
	 * 首页的跳转
	 */
	public void case_homePager_jump() {
		// 首页轮播画面的转换
		View view = solo.getView(id_viewPager);
		for (int a = 0; a < 4; a++) {
			dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);
		}

		// 进入汽车专场并返回
		t(Config.text_car);
		solo.assertCurrentActivity(tag + ":case_homePager_jump():进入汽车专场并返回",
				Config.AcName_special);
		g();

		// 化肥专场并返回
		t(Config.text_fertilizer);
		solo.assertCurrentActivity(tag + ":homePage():化肥专场并返回",
				Config.AcName_special);
		g();
		t(Config.text_information);
		solo.assertCurrentActivity(tag + ":homePage():资讯",
				Config.AcName_information);
		t(Config.text_homePage);
		t(Config.text_shoppingcart);
		solo.assertCurrentActivity(tag + ":homePage():购物车",
				Config.AcName_shoppingcart);
		t(Config.text_homePage);
		t(Config.text_mine);
		solo.assertCurrentActivity(tag + ":homePage():我的", Config.AcName_mine);
		t(Config.text_homePage);
		v("com.ksfc.newfarmer:id/huafei_img");
		solo.assertCurrentActivity(tag + ":homePage():商品详情",
				"GoodsDetailActivity");
		g();// 任意某个商品的商品详情页面
	}

	/**
	 * 资讯
	 */
	public void case_homePage_information() {
		t(Config.text_information);
		for (int a = 0; a < 3; a++) {
			int x = (int) (Math.random() * 5);
			solo.clickInList(x);
			solo.assertCurrentActivity(tag + ":case_homePage_information()",
					"ArticleActivity");
			g();
		}
		int x = (int) (Math.random() * 5);
		solo.clickInList(x);
		v(Config.id_title_right_img);
		g();
		g();
		t(Config.text_homePage);
	}
}
