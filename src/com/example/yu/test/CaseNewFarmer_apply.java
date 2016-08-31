package com.example.yu.test;

import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;

public class CaseNewFarmer_apply extends BaseCase {

	public String tag = " CaseNewFarmer_apply";

	public static CaseNewFarmer_apply caseInstance(Solo solo1) {
		CaseNewFarmer_apply instance = new CaseNewFarmer_apply();
		instance.instance(solo1);
		return instance;
	}

	String text_businessman_county = "县级经销商";
	String text_genre = "类型";
	String text_submit = "提交";
	String text_choose_town = "选择所在街道或乡镇";

	String id_jump_apply = "com.ksfc.newfarmer:id/choose_type_Certified_ll";// 个人信息页面
																			// 进入到服务站认证页面
	String id_choose_city = "com.ksfc.newfarmer:id/choice_city_layout";// 服务站认证页面选择市县
	String id_choose_town = "com.ksfc.newfarmer:id/choice_town_layout";// 服务站认证页面选择街道
	String id_edit_name = "com.ksfc.newfarmer:id/name_tv";// 认证页面输入姓名
	String id_edit_identity = "com.ksfc.newfarmer:id/id_card_number_tv";// 认证页面省份证
	String id_edit_store_name = "com.ksfc.newfarmer:id/store_name_tv";// 认证页面门店名称
	String id_edit_phoneNum = "com.ksfc.newfarmer:id/phone_tv";// 认证页面手机号
	String id_edit_address = "com.ksfc.newfarmer:id/store_address_tv";// 认证页面详细地址

	String log_nullCity = "请先选择地区";
	String log_nullPerfect = "请完善信息";
	String log_phoneNum_err = "请检查手机号或者身份证号码是否正确";

	public void test_run() {
		case_newFarmer_business();
	}

	/**
	 * 认证县级经销商
	 */
	public void case_newFarmer_business() {
		login_sure(Config.pNum_null);
		t(Config.text_mine);
		v(Config.id_jump_myself);
		if (!(solo.searchText(text_businessman_county, 1, false, true))) {
			t(text_genre);
			t(text_businessman_county);
		}
		v(id_jump_apply);

		// 在没有选择地区的情况下就去选择街道
		v(id_choose_town);
		toast_equals_string(tag
				+ ":case_newFarmer_business():在没有选择地区的情况下就去选择街道", log_nullCity);
		// 没有填写姓名提交
		t(text_submit);
		toast_equals_string(tag + ":case_newFarmer_business():没有填写姓名提交",
				log_nullPerfect);
		// 姓名不能超过12位字符
		enter(id_edit_name, getRandomString(16));
		if (getEditTextString(id_edit_name).length() != 12) {
			showErrLog(tag + ":case_newFarmer_business():姓名不能超过12位字符");
		}
		// 未填写身份证号
		t(text_submit);
		toast_equals_string(tag + ":case_newFarmer_business(): 未填写身份证号",
				log_nullPerfect);
		// 未填写门店
		enter(id_edit_identity, getRandomIntString(18));
		t(text_submit);
		toast_equals_string(tag + ":case_newFarmer_business():未填写门店",
				log_nullPerfect);
		// 门店不能超过40个字符
		enter(id_edit_store_name, getRandomString(50));
		if (getEditTextString(id_edit_store_name).length() != 40) {
			showErrLog(tag + ":case_newFarmer_business():门店不能超过40个字符");
		}
		// 未填写联系电话
		t(text_submit);
		toast_equals_string(tag + ":case_newFarmer_business(): 未填写联系电话",
				log_nullPerfect);
		// 未填写地区
		enter(id_edit_phoneNum, Config.pNum_err);
		t(text_submit);
		toast_equals_string(tag + ":case_newFarmer_business(): 未填写地区",
				log_nullPerfect);
		// 未填写街道
		v(id_choose_city);
		solo.clickInList(1);
		s();
		solo.clickInList(getRandomInt(1, 12));
		s();
		solo.clickInList(getRandomInt(1, 5));
		s();
		t(text_submit);
		toast_equals_string(tag + ":case_newFarmer_business(): 未填写街道",
				log_nullPerfect);
		// 未填写详细地址
		v(id_choose_town);
		solo.clickInList(getRandomInt(1, 7));
		t(text_submit);
		toast_equals_string(tag + ":case_newFarmer_business():未填写详细地址",
				log_nullPerfect);
		// 重选地区看街道是否重置
		v(id_choose_city);
		solo.clickInList(1);
		s();
		solo.clickInList(getRandomInt(1, 12));
		s();
		solo.clickInList(getRandomInt(1, 5));
		s();
		if (!getTextHintString(id_choose_town).equals(text_choose_town)) {
			showErrLog(tag + ":case_newFarmer_business():重选地区看街道是否重置");
		}
		// 详细地址不能超过60位字符
		v(text_choose_town);
		solo.clickInList(getRandomInt(1, 7));
		enter(id_edit_address, getRandomString(70));
		if (getEditTextString(id_edit_address).length() != 60) {
			showErrLog(tag + ":case_newFarmer_business():详细地址不能超过60位字符");
		}
		// 填写格式错误的手机号
		t(text_submit);
		toast_equals_string(tag + ":case_newFarmer_business():填写格式错误的手机号",
				log_phoneNum_err);
		// 提交格式错误的身份证号
		clear(id_edit_phoneNum);
		enter(id_edit_phoneNum, Config.pNum_reg);
		clear(id_edit_identity);
		enter(id_edit_identity, getRandomIntString(6));
		t(text_submit);
		toast_equals_string(tag + ":case_newFarmer_business():提交格式错误的身份证号",
				log_phoneNum_err);

		/**
		 * 由于过程不可逆，为了方便多次测试，故不进行正确方式的保存
		 */
		g();
		g();
		t(Config.text_homePage);
	}
}