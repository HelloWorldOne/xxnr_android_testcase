package com.example.yu.test;

import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;

public class CaseMyNewFarmer extends BaseCase {

	public String tag = " CaseMyNewFarmer";

	public static CaseMyNewFarmer caseInstance(Solo solo1) {
		CaseMyNewFarmer instance = new CaseMyNewFarmer();
		instance.instance(solo1);
		return instance;
	}

	String text_tell = "客服电话";
	String text_call = "拨打";
	String text_set = "设置";
	String text_headPortrait = "我的头像";
	String text_clearing = "清除缓存";
	String text_version_updating = "版本更新";
	String text_update_later = "暂不升级";
	String text_update_now = "立即升级";
	String text_recommend = "推荐新新农人给好友";
	String text_recommed_to = "分享到";
	String text_about = "关于";
	String text_about_us = "关于我们";

	String log_clearing = "缓存已经清理干净了！";
	String log_new_version = "最新版本";

	public void test_run() {
		case_newFarmer_louout_jump();
		case_newFarmer_login_jump();
		case_newFarmer_setting();
	}

	/**
	 * 未登录状态下我的页面与其他页面之间的跳转
	 */
	public void case_newFarmer_louout_jump() {
		/**
		 * 未登录状态下的跳转
		 */
		logout();
		t(Config.text_mine);
		// 未登录状态下不展示我的网点
		if (solo.searchText(Config.text_myNet, 1, false, true)) {
			showErrLog(tag + ":case_newFarmer_louout_jump():未登录状态下不展示我的网点");
		}
		// 未登录状态各页面的跳转
		v(Config.id_jump_myself);
		solo.assertCurrentActivity(tag + "case_newFarmer_louout_jump():登录页面",
				Config.AcName_login);
		g();
		t(Config.text_myOrder);
		solo.assertCurrentActivity(tag + "case_newFarmer_louout_jump():我的订单",
				Config.AcName_login);
		g();
		t(Config.text_pointStore);
		solo.assertCurrentActivity(tag + "case_newFarmer_louout_jump():积分商城",
				Config.AcName_pointStore);
		g();
		t(Config.text_newFarmer_delegate);
		solo.assertCurrentActivity(tag + "case_newFarmer_louout_jump():新农代表",
				Config.AcName_login);
		g();
		t(text_tell);
		if (!solo.searchText(text_call, 1, false, true)) {
			showErrLog(tag + ":case_newFarmer_louout_jump():客服电话");
		}
		t(Config.text_cancel);
		t(text_set);
		solo.assertCurrentActivity(tag + "case_newFarmer_louout_jump():设置",
				Config.AcName_set);
		g();
		t(Config.text_homePage);
		solo.assertCurrentActivity(tag + "case_newFarmer_louout_jump():首页",
				Config.AcName_homePage);
		t(Config.text_mine);
		t(Config.text_shoppingcart);
		solo.assertCurrentActivity(tag + "case_newFarmer_louout_jump():购物车",
				Config.AcName_shoppingcart);
		t(Config.text_mine);
		t(Config.text_information);
		solo.assertCurrentActivity(tag + "case_newFarmer_louout_jump():资讯",
				Config.AcName_information);
		t(Config.text_homePage);
	}

	/**
	 * 我的页面登录状态下的跳转
	 */
	public void case_newFarmer_login_jump() {
		login_sure(Config.pNum_reg);
		v(Config.id_jump_myself);
		if (!solo.searchText(text_headPortrait, 1, false, true)) {
			showErrLog(tag + ":case_newFarmer_login_jump():个人信息");
		}
		g();
		t(Config.text_myOrder);
		if (!solo.searchText(Config.text_myOrder, 1, false, true)) {
			showErrLog(tag + ":case_newFarmer_login_jump():我的订单");
		}
		g();
		t(Config.text_pointStore);
		solo.assertCurrentActivity(tag + "case_newFarmer_login_jump():积分商城",
				Config.AcName_pointStore);
		g();
		t(Config.text_newFarmer_delegate);
		if (!solo.searchText(Config.text_newFarmer_delegate, 1, false, true)) {
			showErrLog(tag + ":case_newFarmer_login_jump():登陆后的新农代表");
		}
		g();
		t(text_call);
		if (!solo.searchText(text_call, 1, false, true)) {
			showErrLog(tag + ":case_newFarmer_login_jump():客服电话");
		}
		t(Config.text_cancel);
		t(text_set);
		solo.assertCurrentActivity(tag + "case_newFarmer_login_jump():登陆后的设置",
				"SettingActivity");
		g();
		t(Config.text_homePage);
		solo.assertCurrentActivity(tag + "case_newFarmer_login_jump():登陆后的首页",
				Config.AcName_homePage);
		t(Config.text_mine);
		t(Config.text_add_shoppingcart);
		solo.assertCurrentActivity(tag + "case_newFarmer_login_jump():登陆后的购物车",
				Config.AcName_shoppingcart);
		t(Config.text_mine);
		t(Config.text_information);
		solo.assertCurrentActivity(tag + "case_newFarmer_login_jump():登陆后的资讯",
				Config.AcName_information);
		t(Config.text_mine);
	}

	/**
	 * 设置页面
	 */
	public void case_newFarmer_setting() {
		t(text_set);
		// 关闭消息通知
		if (solo.isCheckBoxChecked(0)) {
			solo.clickOnCheckBox(0);
			if (!solo.searchText(Config.text_sure, 1, false, true)) {
				showErrLog(tag + ":case_newFarmer_setting():关闭消息通知");
			}
			solo.clickOnButton(Config.text_sure);
			s();
		}
		solo.clickOnCheckBox(0);
		s();
		// 清除缓存
		t(text_clearing);
		if (!solo.searchText(Config.text_sure, 1, false, true)) {
			showErrLog(tag + ":case_newFarmer_setting():清除缓存");
		}
		solo.clickOnButton(Config.text_sure);
		solo.sleep(1000);
		toast_equals_string(tag + ":case_newFarmer_setting():确定清除缓存",
				log_clearing);
		// 版本更新
		t(text_version_updating);
		if (solo.searchText(text_update_later, 1, false, true)) {
			t(text_update_later);
			t(text_version_updating);
			t(text_update_now);
		} else {
			t(text_version_updating);
			toast_equals_string(tag + ":case_newFarmer_setting():版本是最新版本",
					log_new_version);
		}
		// 推荐新新农人给好友
		t(text_recommend);
		if (!solo.searchText(text_recommed_to, 1, false, true)) {
			showErrLog(tag + ":case_newFarmer_setting():推荐新新农人给好友");
		}
		g();
		// 关于
		t(text_about);
		if (!solo.searchText(text_about_us, 1, false, true)) {
			showErrLog(tag + ":case_newFarmer_setting():关于");
		}
		g();
	}
}
