package com.example.yu.test;

import android.view.View;
import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;


public class CaseNewFarmer_delegate extends BaseCase {

	String tag = "CaseShoppingCar";

	public static CaseNewFarmer_delegate caseInstance(Solo solo1) {
		CaseNewFarmer_delegate instance = new CaseNewFarmer_delegate();
		instance.instance(solo1);
		return instance;
	}

	String text_nullClient="您没有邀请用户哦~";
	String text_delegate_sure="*代表人添加后不可修改,请仔细核对";
	String text_add="添加";
	String text_client_order="客户订单";
	String text_client_phone="13718603051";
	String text_bay_now="立即购买";
	String text_call="拨打";
	String text_clientRegister="客户登记";
	String text_clientParticulars="客户详情";
	String text_phone_register="13333333333";//已登记过的手机号
	String text_nullTown="选择所在街道或乡镇";
	
	String id_myDelegate="com.ksfc.newfarmer:id/radio_button2";//新农代表页面由我的客户切换到我的代表
	String id_edit_phone="com.ksfc.newfarmer:id/my_inviter_fragment_edittext";//新农代表页面输入代表手机号
	String id_client_order="com.ksfc.newfarmer:id/my_inviter_nickname";//我的客户页面查看客户订单
	String id_choose_sned="com.ksfc.newfarmer:id/deliveries_way_home";//提交订单页面选择配送到户
	String id_red="com.ksfc.newfarmer:id/my_inviter_nickname_remind_dot";//我的客户页面客户订单状态提醒红点
	String id_jump_text_clientParticulars="com.ksfc.newfarmer:id/item_already_customer_name";//客户登记页面跳转到客户详情
	String id_call="com.ksfc.newfarmer:id/my_inviter_phone_icon";//我的代表页面拨打电话
	String id_add_client="com.ksfc.newfarmer:id/add_potential_customer";//添加潜在客户
	String id_client_num="com.ksfc.newfarmer:id/count_left";//客户登记页面共登记客户
	String id_add_town="com.ksfc.newfarmer:id/choice_town_text";//添加客户页面乡镇
	String id_add_edit_name="com.ksfc.newfarmer:id/name_tv";//添加客户页面姓名
	String id_add_edit_phone="com.ksfc.newfarmer:id/phone_tv";//添加客户页面手机号
	String id_add_checkBox_man="com.ksfc.newfarmer:id/btn_check_item_item";//添加客户男性
	String id_add_checkBox_woman="com.ksfc.newfarmer:id/btn_check_item_item1";//添加客户女性
	String id_add_city="com.ksfc.newfarmer:id/choice_city_layout";//添加客户页面选择城市
	String id_add_choose_product="com.ksfc.newfarmer:id/choose_type_ll";//添加客户页面选择意向产品
	String id_add_edit_beizhu="com.ksfc.newfarmer:id/add_potential_remark";//添加客户页面备注
	
	String log_nullPhoneNum="请输入一个手机号码";
	String log_phoneErr="您输入的手机号码格式不正确";
	String log_choose_city_first="请先选择地区";
	String log_nullPerfect="请完善信息";
	String log_client_reg="该客户已注册，可让其直接添加您为新农代表，方便您跟踪订单与提供服务";
	String log_client_register="该客户资料已经登记过";
	String log_null_product="请至少选择一个意向商品";
	String log_add_success="添加成功";
	public void test_run() {
		case_delegate_null();
		 case_add_delegate();
		 case_delegate_jump();
		 case_add_client();
	}

	/**
	 * 没有代表，客户的账户
	 */
	public void case_delegate_null() {

		login_sure(Config.pNum_null);
		t(Config.text_newFarmer_delegate);
		// 没有客户的账户我的客户页面展示
		if (!solo.searchText(text_nullClient, 1, false, true)) {
			showErrLog(tag + ":case_delegate_null():没有客户的账户我的客户页面展示");
		}
		// 没有代表的账户我的代表页面展示
		v(id_myDelegate);
		if (!solo.searchText(text_delegate_sure, 1, false, true)) {
			showErrLog(tag + ":case_delegate_null():没有代表的账户我的代表页面展示");
		}}
		/**
		 * 添加新农代表（为了方便以后测试，不进行正确保存代表的操作）
		 */
	public void case_add_delegate(){
		login_sure(Config.pNum_null);
		t(Config.text_newFarmer_delegate);
		v(id_myDelegate);
		// 未填写手机号就添加
		t(text_add);
		toast_equals_string(tag +  ":case_delegate_null():未填写手机号就添加",
				log_nullPhoneNum);
		// 填写错误的手机号码
		enter(id_edit_phone,
				Config.pNum_err);
		t(text_add);
		toast_equals_string(tag + ":case_delegate_null():填写错误的手机号码",
				log_phoneErr);
		g();
		t(Config.text_homePage);
	}

	/**
	 * 有客户代表且已认证为新农经纪人的账户的展示及跳转
	 */
	public void case_delegate_jump() {
		login_sure(Config.pNum_reg);
		t(Config.text_newFarmer_delegate);
		// 我的客户页面去查看客户订单
		v(id_client_order);
		if (!solo.searchText(text_client_order)) {
			showErrLog(tag + ":case_delegate_jump():我的客户页面去查看客户订单");
		}
		/**
		 * 我的客户订单状态更新时有红点提示
		 */
		// 使用客户账号下单并返回新农代表的账户查看
		g();
		g();
		t(Config.text_homePage);
		login_sure(text_client_phone);
		t(Config.text_homePage);
		t(Config.text_fertilizer);
		solo.clickInList(2);
		t(text_bay_now);
		t(Config.text_sure);
		v(id_choose_sned);
		v(Config.id_shoppingcart_jiesuan);
		g();
		login_sure(Config.pNum_reg);
		t(Config.text_mine);
		t(Config.text_newFarmer_delegate);
		// 客户订单状态有更新
		View view = solo
				.getView(id_red);
		if (view.getVisibility() != View.VISIBLE) {
			showErrLog(tag + ":case_delegate_jump():客户订单状态有更新");
		}
		// 查看过客户订单后小红点消失
		v(id_client_order);
		g();
		view = solo
				.getView(id_red);
		if (view.getVisibility() != View.INVISIBLE) {
			showErrLog(tag + ":case_delegate_jump():查看过客户订单后小红点消失");
		}

		/**
		 * 我的代表
		 */
		// 在我的代表页面点击拨打电话按钮
		v(id_myDelegate);
		v(id_call);
		if (!solo.searchText(text_call)) {
			showErrLog(tag + ":case_delegate_jump():进入我的代表页面并尝试拨打电话");
		}
		solo.clickOnButton(Config.text_cancel);

		/**
		 * 客户登记
		 */
		// 客户登记页面查看客户订单
		t(text_clientRegister);
		v(id_jump_text_clientParticulars);
		if (!solo.searchText(text_clientParticulars)) {
			showErrLog(tag + ":case_delegate_jump():客户登记页面查看客户订单");
		}
		g();
		g();
		t(Config.text_homePage);
	}

	/**
	 * 添加潜在客户
	 */
	public void case_add_client() {
		login_sure(Config.pNum_reg);
		t(Config.text_newFarmer_delegate);
		t(text_clientRegister);
		int a = Integer
				.parseInt(getTextViewString(id_client_num));
		// 未选择地区时不能选择街道
		v(id_add_client);
		v(id_add_town);
		toast_equals_string(tag +":case_add_client():未选择地区时不能选择街道" ,
				log_choose_city_first);
		// 未填写姓名保存
		t(Config.text_save);
		toast_equals_string(tag +":case_add_client():未填写姓名保存" ,
				log_nullPerfect);
		// 姓名长度不能超过12个字符
		enter(id_add_edit_name, getRandomString(16));
		if (getTextViewString(id_add_edit_name).length() != 12) {
			showErrLog(tag + ":case_add_client():姓名长度不能超过12个字符");
		}
		// 未填写手机号保存
		t(Config.text_save);
		toast_equals_string(tag +":case_add_client():未填写手机号保存" ,
				log_nullPerfect);
		// 填写错误的手机号
		enter(id_add_edit_phone, Config.pNum_err);
		t(Config.text_save);
		toast_equals_string(tag + ":case_add_client():填写错误的手机号",
				log_nullPerfect);
		// 填写已注册过的手机号
		clear(id_add_edit_phone);
		enter(id_add_edit_phone, Config.pNum_reg);
		if (!solo.searchText(log_client_reg)) {
			showErrLog(tag + ":case_add_client():填写已注册过的手机号");
		}
		// 填写已登记过的手机号
		clear(id_add_edit_phone);
		enter(id_add_edit_phone,text_phone_register );
		if (!solo.searchText(log_client_register)) {
			showErrLog(tag + ":case_add_client():填写已登记过的手机号");
		}
		clear(id_add_edit_phone);
		enter(id_add_edit_phone, "133" + getRandomIntString(8));
		// 选择性别为男
		if (!solo.isCheckBoxChecked(0)) {
			v(id_add_checkBox_man);
			if (solo.isCheckBoxChecked(1)) {
				showErrLog(tag + ":case_add_client():选择性别为男");
			}
		} else {
			v(id_add_checkBox_woman);
			if (solo.isCheckBoxChecked(0)) {
				showErrLog(tag + ":case_add_client():选择性别为女");
			}
		}
		// 未填写地区
		t(Config.text_save);
		toast_equals_string(tag + ":case_add_client():未填写地区",
				log_nullPerfect);
		// 未填写街道
		v(id_add_city);
		solo.clickInList(1);
		int line = getRandomInt(1, 12);
		solo.clickInList(line);
		if (line != 9) {
			solo.clickInList(getRandomInt(1, 5));
		}
		t(Config.text_save);
		toast_equals_string(tag +":case_add_client():未填写街道",
				log_nullPerfect);
		// 未填写意向产品保存
		v(id_add_town);
		solo.clickInList(getRandomInt(1, 4));
		t(Config.text_save);
		toast_equals_string(tag +":case_add_client():未填写意向产品保存",
				log_nullPerfect);
		// 重新选择地区看街道是否重置
		v(id_add_city);
		solo.clickInList(1);
		solo.clickInList(getRandomInt(1, 12));
		solo.clickInList(getRandomInt(1, 6));
		if (!getTextHintString(id_add_town)
				.equalsIgnoreCase(text_nullTown)) {
			showErrLog(tag + ":case_add_client(): 重新选择地区看街道是否重置");
		}
		// 不选择意向产品就确定
		v(id_add_town);
		solo.clickInList(getRandomInt(1, 4));
		v(id_add_choose_product);
		t(Config.text_sure);
		toast_equals_string(tag +":case_add_client():不选择意向产品就确定",
				log_null_product);
		// 备注长度不能超过30字符
		solo.clickInList(2);
		t(Config.text_sure);
		enter(id_add_edit_beizhu, getRandomString(40));
		if (getEditTextString(id_add_edit_beizhu)
				.length() != 30) {
			showErrLog(tag + ":case_add_client():备注长度不能超过30字符");
		}
		t(Config.text_save);
		// 保存成功
		toast_equals_string(tag + ":case_add_client():保存成功",
				log_add_success);
		// 返回客户登记页面，此时今日可添加客户数减一
		if (Integer
				.parseInt(getTextViewString(id_client_num)) != (a - 1)) {
			showErrLog(tag + ":case_add_client():返回客户登记页面，此时今日可添加客户数减一");
		}
		g();
		t(Config.text_homePage);
	}
}