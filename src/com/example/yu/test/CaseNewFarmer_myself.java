package com.example.yu.test;

import android.view.View;
import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;

public class CaseNewFarmer_myself extends BaseCase {

	public String tag = " CaseNewFarmer_myself";

	public static CaseNewFarmer_myself caseInstance(Solo solo1) {
		CaseNewFarmer_myself instance = new CaseNewFarmer_myself();
		instance.instance(solo1);
		return instance;
	}

	String text_shangchuan = "本地上传";
	String text_nickname = "我的昵称";
	String text_name = "姓名";
	String text_sex = "性别";
	String text_man = "男";
	String text_woman = "女";
	String text_address = "所在地区";
	String text_chosse_town = "请选择街道";
	String text_genre = "类型";
	String text_genre_common = "普通用户";
	String text_genre_agent = "新农经纪人";
	String text_genre_town_business = "县级经销商";
	String text_check_information = "查看认证信息";
	String text_nullUser_show = "想成为新新农人的县级网点？去申请认证吧";

	String id_headPortrait = "com.ksfc.newfarmer:id/header_image_ll";// 个人信息头像
	String id_myself_save = "com.ksfc.newfarmer:id/name_submit_tv";// 个人信息的下级页面保存按钮
	String id_alterName_edit_name = "com.ksfc.newfarmer:id/et_modify";// 修改昵称(姓名)页面输入昵称
	String id_sex = "com.ksfc.newfarmer:id/sex_tv";// 个人信息页面现实的性别
	String id_chooseSex_man = "com.ksfc.newfarmer:id/btn_sure";// 性别选择页面选择男
	String id_chooseSex_woman = "com.ksfc.newfarmer:id/btn_normal";// 性别选择页面选择女
	String id_address_city = "com.ksfc.newfarmer:id/choice_city_layout";// 修改地区页面修改地区
	String id_address_town = "com.ksfc.newfarmer:id/choice_town_text";// 修改地区页面修改街道
	String id_user_genre = "com.ksfc.newfarmer:id/type_tv";// 个人信息页面展示的用户类型
	String id_jump_check_information = "com.ksfc.newfarmer:id/choose_type_Certified_ll";// 个人信息页面跳转到查看认证信息页面

	String log_nuperfect = "请您先完善信息";
	String log_save_success = "保存成功";
	String log_nullAddress = "地址不能为空";

	public void test_run() {
		case_myself();
		 case_myself_name();
		 case_myself_sex();
		 case_myself_address();
		 case_user_genre();
	}

	/**
	 * 个人信息
	 */
	public void case_myself() {
		login_sure(Config.pNum_reg);
		v(Config.id_jump_myself);
		// 修改头像
		v(id_headPortrait);
		if (!solo.searchText(text_shangchuan, 1, false, true)) {
			showErrLog(tag + ":case_myself():修改头像");
		}
		t(Config.text_cancel);

		/**
		 * 修改昵称
		 */
		t(text_nickname);
		// 未修改昵称，保存按钮不可点击
		View view = solo.getView(id_myself_save);
		if (view.isEnabled()) {
			showErrLog(tag + ":case_myself():未修改昵称，保存按钮不可点击");
		}
		// 在有昵称的前提下清空昵称保存
		clear(id_alterName_edit_name);
		t(Config.text_save);
		toast_equals_string(tag + ":case_myself():在有昵称的前提下清空昵称", log_nuperfect);
		// 修改昵称超过12位字符
		enter(id_alterName_edit_name, getRandomString(16));
		String nicheng = getEditTextString(id_alterName_edit_name);
		if (nicheng.length() != 12) {
			showErrLog(tag + ":case_newFarmer_information():修改昵称超过12位字符");
		}
		// 保存昵称
		t(Config.text_save);
		toast_equals_string(tag + ":case_newFarmer_information():保存昵称",
				log_save_success);
	}

	/**
	 * 个人信息页面修改姓名
	 */
	public void case_myself_name() {
		login_sure(Config.pNum_reg);
		v(Config.id_jump_myself);
		// 未修改姓名，保存按钮不可点击
		t(text_name);
		View view = solo.getView(id_myself_save);
		if (view.isEnabled()) {
			showErrLog(tag + ":case_myself_name():未修改姓名，保存按钮不可点击");
		}
		// 姓名为空时保存
		clear(id_alterName_edit_name);
		t(Config.text_save);
		toast_equals_string(tag + ":case_myself_name(): 姓名为空时保存", log_nuperfect);
		// 修改姓名超过12位字符
		enter(id_alterName_edit_name, getRandomString(17));
		String name = getEditTextString(id_alterName_edit_name);
		if (name.length() != 12) {
			showErrLog(tag + ":case_myself_name():修改姓名超过12位字符");
		}
		// 保存姓名
		t(Config.text_save);
		toast_equals_string(tag + ":case_myself_name():保存姓名", log_save_success);
	}

	/**
	 * 修改性别
	 */
	public void case_myself_sex() {
		login_sure(Config.pNum_reg);
		v(Config.id_jump_myself);
		String sex = getTextViewString(id_sex);
		t(text_sex);
		// 取消选择性别
		t(Config.text_cancel);
		String sex_change = getTextViewString(id_sex);
		if (!sex.equals(sex_change)) {
			showErrLog(tag + ":case_myself_sex():取消选择性别");
		}
		// 将性别修改为男
		t(text_sex);
		v(id_chooseSex_man);
		toast_equals_string(tag + ":case_myself_sex():将性别修改为男",
				log_save_success);
		sex_change = getTextViewString(id_sex);
		if (!sex_change.equals(text_man)) {
			showErrLog(tag + ":case_myself_sex():将性别修改为男");
		}
		// 将性别修改为女
		t(text_sex);
		v(id_chooseSex_woman);
		toast_equals_string(tag + ":case_myself_sex():将性别修改为女",
				log_save_success);
		sex_change = getTextViewString(id_sex);
		if (!sex_change.equals(text_woman)) {
			showErrLog(tag + ":case_myself_sex():将性别修改为女");
		}
	}

	/**
	 * 用户所在地区
	 */
	public void case_myself_address() {
		login_sure(Config.pNum_reg);
		v(Config.id_jump_myself);
		// 未修地区，保存按钮不可点击
		t(text_address);
		View view = solo.getView(id_myself_save);
		if (view.isEnabled()) {
			showErrLog(tag + ":case_myself_address():未修地区，保存按钮不可点击");
		}

		// 在已正确填写地址情况下修改地区，查看街道是否随之变化
		v(id_address_city);
		solo.clickInList(1);
		solo.clickInList(getRandomInt(1, 12));
		solo.clickInList(getRandomInt(1, 4));
		if (!getTextHintString(id_address_town).equals(text_chosse_town)) {
			showErrLog(tag
					+ ":case_myself_address():在已正确填写地址情况下修改地区，查看街道是否随之变化");
		}
		// 未填写街道情况下保存
		t(Config.text_save);
		toast_equals_string(tag + ":case_myself_address():未填写街道情况下保存",
				log_nullAddress);
		// 正确保存地区
		v(id_address_town);
		solo.clickInList(getRandomInt(1, 5));
		t(Config.text_save);
		toast_equals_string(tag + ":case_myself_address():正确保存地区",
				log_save_success);
	}

	/**
	 * 更改用户类型
	 */
	public void case_user_genre() {
		login_sure(Config.pNum_reg);
		v(Config.id_jump_myself);
		// 普通用户
		t(text_genre);
		t(text_genre_common);
		toast_equals_string(tag + ":case_user_genre():普通用户", log_save_success);
		if (!getTextViewString(id_user_genre).equals(text_genre_common)) {
			showErrLog(tag + ":case_user_genre():普通用户");
		}
		// 新农经纪人
		t(text_genre);
		t(text_genre_agent);
		toast_equals_string(tag + ":case_user_genre():新农经纪人", log_save_success);
		if (!getTextViewString(id_user_genre).equals(text_genre_agent)) {
			showErrLog(tag + ":case_user_genre():新农经纪人");
		}
		// 县级经销商
		t(text_genre);
		t(text_genre_town_business);
		toast_equals_string(tag + ":case_user_genre():县级经销商", log_save_success);
		if (!getTextViewString(id_user_genre).equals(text_genre_town_business)) {
			showErrLog(tag + ":case_user_genre():县级经销商");
		}
		// 已申请认证的县级经销商可以查看认证信息
		if (!solo.searchText(text_check_information)) {
			showErrLog(tag + ":case_user_genre():已申请认证的县级经销商可以查看认证信息");
		}
		// 查看认证信息
		v(id_jump_check_information);
		if (!solo.searchText(text_name)) {
			showErrLog(tag + ":case_user_genre():查看认证信息");
		}
		g();
		// 未申请县级网点认证的账户
		g();
		t(Config.text_homePage);
		login_sure(Config.pNum_null);
		v(Config.id_jump_myself);
		if (!solo.searchText(text_nullUser_show)) {
			showErrLog(tag + ":case_user_genre():未申请县级网点认证的账户");
		}
		g();
		g();
	}

}