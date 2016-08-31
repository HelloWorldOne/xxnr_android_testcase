package com.example.yu.test;

import com.example.yu.test.RunTestCase.*;
import com.robotium.solo.Solo;
import android.view.View;

public class CaseClearing extends BaseCase {
	public static String tag = "CaseClearing";

	public static CaseClearing caseInstance(Solo solo1) {
		CaseClearing instance = new CaseClearing();
		instance.instance(solo1);
		return instance;
	}

	String text_bianji = "编辑";
	String text_add_address = "添加收货地址";
	String text_send = "配送到户";
	String text_noAddress = "您还没有收货地址哦，添加一个吧~";
	String text_nullTown = "请选择乡镇";
	String text_delete_address = "删除此地址";
	String text_car_special = "汽车专场";
	String text_allArea = "全部地区";

	String id_join_addAddress = "com.ksfc.newfarmer:id/address_shouhuo_ll";// 提交订单页面进入收货地址页面
	String id_send_button_delete = "com.ksfc.newfarmer:id/delete_address_img";// 收货地址页面删除按钮
	String id_send_addAddress = "com.ksfc.newfarmer:id/title_right_text";// 收货地址页面添加按钮
	String id_send_addAddress_name = "com.ksfc.newfarmer:id/shouhuo_name";// 添加收货地址页面收货人
	String id_send_addAddress_pNum = "com.ksfc.newfarmer:id/shouhuo_tel";// 添加收货地址页面手机号
	String id_send_addAddress_city = "com.ksfc.newfarmer:id/choice_city_layout";// 添加收货地址页面省市区县
	String id_send_addAddress_town = "com.ksfc.newfarmer:id/choice_town_layout";// 天价收货地址页面乡镇
	String id_send_addAddress_particular = "com.ksfc.newfarmer:id/choice_detail_room_edit";// 添加收货地址页面详细地址
	String id_bianji = "com.ksfc.newfarmer:id/edit_address_img";// 收货地址页面编辑地址
	String id_join_chose_net = "com.ksfc.newfarmer:id/select_state_address_ll_state";// 提交订单页面进入选择自提点页面
	String id_choseNet_buttonSure = "com.ksfc.newfarmer:id/save_userInfo";// 选择自提点页面确认button的id
	String id_choseNet_city = "com.ksfc.newfarmer:id/state_city_rel";// 选择自提点选择城市
	String id_choseNet_county = "com.ksfc.newfarmer:id/state_county_rel";// 选择自提点选择县
	String id_choseNet_province = "com.ksfc.newfarmer:id/state_province_rel";// 选择自提点选择省份
	String id_join_chose_people = "com.ksfc.newfarmer:id/select_state_person_info";// 提交订单页面跳转到选择收货人页面
	String id_chosePeople_buttonSure = "com.ksfc.newfarmer:id/name_submit_tv";// 选择收货人页面确认Button
	String id_chosePeople_edit_name = "com.ksfc.newfarmer:id/shouhuo_name";// 选择收货人页面姓名
	String id_chosePeople_edit_pNum = "com.ksfc.newfarmer:id/shouhuo_tel";// 选择收货人页面手机号

	String log_nullAddress = "收货地址不能为空";// 收货地址为空时提示
	String log_nullName = "请输入收货人姓名";
	String log_nullPNum = "请输入手机号码";
	String log_pNum_err = "请输入正确的手机号码";
	String log_nullCity = "请选择城市";
	String log_nullParticular = "请输入您的详细地址";
	String log_add_success = "成功新增了地址";
	String log_delete_success = "删除成功";
	String log_different_net = "您选择的商品不能在同一个网点自提，请返回购物车重新选择";
	String log_nullNet = "请选择自提网点";

	public void test_run() {
		login_sure(Config.pNum_reg);
		t(Config.text_homePage);
		case_send_nullAddress();
		case_send_addAddress();
		case_send_compileAddress();
		case_ziti_different_net();
		 case_ziti_nullNet();
		 case_ziti_chose_net();
		 case_ziti_chose_people();
		 case_clearing_success();
		 case_order_separate();
	}

	/**
	 * 配送到户:收货地址为空时提交订单
	 */
	public void case_send_nullAddress() {
		add_shoppingcart();
		t(text_send);
		if (solo.searchText(text_add_address, 1, false, true)) {
			v(Config.id_shoppingcart_jiesuan);
			toast_equals_string(tag + ":case_send_nullAddress():配送到户:收货地址为空时提交订单",
					log_nullAddress);

		} else {
			v(id_join_addAddress);
			while (!solo.searchText(text_noAddress, 1, false, true)) {
				v(id_send_button_delete);
				t(Config.text_sure);
			}
			g();
			v(Config.id_shoppingcart_jiesuan);
			toast_equals_string(tag + ":case_send_nullAddress():配送到户:收货地址为空时提交订单",
					log_nullAddress);
		}
	}

	/**
	 * 配送到户：添加收货地址
	 */
	public void case_send_addAddress() {
		add_shoppingcart();
		t(text_send);
		v(id_join_addAddress);
		v(id_send_addAddress);
		// 未填写收货人姓名就保存
		clear(id_send_addAddress_name);
		t(Config.text_save);
		toast_equals_string(tag + ":case_send_addAddress():未填写收货人姓名就保存",
				log_nullName);
		// 未填写手机号
		enter(id_send_addAddress_name, getRandomString(6));
		clear(id_send_addAddress_pNum);
		t(Config.text_save);
		toast_equals_string(tag +":case_send_addAddress():未填写手机号",
				log_nullPNum);
		
		// 填写错误的手机号
		enter(id_send_addAddress_pNum, Config.pNum_err);
		t(Config.text_save);
		toast_equals_string(tag +":case_send_addAddress():填写错误的手机号",
			log_pNum_err	);
		
		// 填写正确的手机号，但是没有填写地址
		clear(id_send_addAddress_pNum);
		enter(id_send_addAddress_pNum, Config.pNum_reg);
		t(Config.text_save);
		toast_equals_string(tag + ":case_send_addAddress():填写正确的手机号，但是没有填写地址"   ,
			log_nullCity	);
		// 选择完城市和乡镇后重新选择城市，看乡镇是否随之重置
		v(id_send_addAddress_city);
		solo.clickInList(1);
		solo.clickInList(getRandomInt(1, 12));
		solo.clickInList(getRandomInt(1, 7));
		v(id_send_addAddress_town);
		solo.clickInList(getRandomInt(1, 5));
		v(id_send_addAddress_city);
		solo.clickInList(1);
		solo.clickInList(getRandomInt(1, 12));
		solo.clickInList(getRandomInt(1, 7));
		if (!getTextHintString(id_send_addAddress_town).contains(text_nullTown)) {
			showErrLog(tag
					+ ":case_send_addAddress():选择完城市和乡镇后重新选择城市，看乡镇是否随之重置");
		}
		// 未填写详细地址
		t(Config.text_save);
		toast_equals_string(tag +  ":case_send_addAddress():未填写详细地址" ,
			log_nullParticular	);
		
		// 输入字符串长度超过50的详细地址
		enter(id_send_addAddress_particular, getRandomString(55));
		if (getEditTextString(id_send_addAddress_particular).length() != 50) {
			showErrLog(tag + ":case_send_addAddress():输入字符串长度超过50的详细地址");
		}
		// 成功保存地址
		t(Config.text_save);
		toast_equals_string(tag +  ":case_send_addAddress():成功保存地址" ,
			log_add_success	);
		
	}

	/**
	 * 配送到户：编辑收货地址
	 */
	public void case_send_compileAddress() {
		add_shoppingcart();
		t(text_send);
		v(id_join_addAddress);
		// 在编辑地址页面删除地址
		addAddress();
		v(id_bianji);
		t(text_delete_address);
		v(Config.text_sure);
		toast_equals_string(tag +  ":case_send_compileAddress():在编辑地址页面删除地址"  ,
			log_delete_success	);
		
		addAddress();
		// 在收货地址页面删除地址
		v(id_send_button_delete);
		v(Config.text_sure);
		toast_equals_string(tag +":case_send_compileAddress():在编辑地址页面删除地址"   ,
			log_delete_success	);
		
		addAddress();
		g();
		// 成功提交订单
		v(Config.id_shoppingcart_jiesuan);
		solo.assertCurrentActivity(tag + ":case_send_compileAddress():成功提交订单",
				"PaywayActivity");
		g();
	}

	/**
	 * 网点自提:不同自提网点不能同时提交订单
	 */
	public void case_ziti_different_net() {
		t(Config.text_shoppingcart);
		// 向购物车中添加网点不同的商品，看是否有重选文字提示
		if (!solo.searchText(Config.text_bay_car, 1, false, true)) {
			v(Config.id_checkButton_all);
			t(text_bianji);
			v(Config.id_shoppingcart_jiesuan);
			solo.clickOnButton(Config.text_yes);
		}
		t(Config.text_bay_fertilizer);
		solo.clickInList(1);
		t(Config.text_add_shoppingcart);
		t("2-2-2");
		t("40", 2);
		t(Config.text_sure);
		g();
		g();
		t(Config.text_homePage);
		t(text_car_special);
		solo.clickInList(3);
		t(Config.text_add_shoppingcart);
		t(Config.text_sure);
		g();
		g();
		t(Config.text_shoppingcart);
		v(Config.id_checkButton_all);
		v(Config.id_shoppingcart_jiesuan);
		if (!solo.searchText(log_different_net, 1, false, true)) {
			showErrLog(tag
					+ ":case_ziti_different_net():向购物车中添加网点不同的商品，看是否有重选文字提示");
		}
		// 向购物车中添加网点不同的商品，看是否能提交订单
		v(Config.id_shoppingcart_jiesuan);
		toast_equals_string(tag + ":case_ziti_different_net():向购物车中添加网点不同的商品，看是否能提交订单"  ,
			log_different_net	);
		
	}

	/**
	 * 网点自提：未选择网店就提交订单
	 */
	public void case_ziti_nullNet() {
		// 往购物车中添加车并选择该汽车去结算
		add_shoppingcart();
		v(Config.id_shoppingcart_jiesuan);
		toast_equals_string(tag +   ":case_ziti_nullNet():没有选择网店的情况下提交订单" ,
			log_nullNet	);
	}

	/**
	 * 网点自提：选择自提点
	 */
	public void case_ziti_chose_net() {
		add_shoppingcart();
		// 判断在未选择具体网点的情况下，确定按钮是否能够点击
		v(id_join_chose_net);
		View view = solo.getView(id_choseNet_buttonSure);
		if (view.isEnabled()) {
			showErrLog(tag + ":case_ziti_chose_net():判断在未选择具体网点的情况下，确定按钮是否能够点击");
		}
		v(id_choseNet_city);
		solo.clickInList(getRandomInt(2, 5));
		View view2 = solo.getView(id_choseNet_buttonSure);
		if (view2.isEnabled()) {
			showErrLog(tag + ":case_ziti_chose_net():判断在未选择具体网点的情况下，确定按钮是否能够点击");
		}
		v(id_choseNet_county);
		solo.clickInList(2);
		View view3 = solo.getView(id_choseNet_buttonSure);
		if (view3.isEnabled()) {
			showErrLog(tag + ":case_ziti_chose_net():判断在未选择具体网点的情况下，确定按钮是否能够点击");
		}

		// 让上一级地址变为全部地区，测试下一级地址是否变为全部地区
		v(id_choseNet_city);
		solo.clickInList(1);
		String s = getTextViewString(id_choseNet_county);
		if (!s.equals(text_allArea)) {
			showErrLog(tag
					+ ":case_ziti_chose_net():让上一级地址变为全部地区，测试下一级地址是否变为全部地区");
		}
		// 让上一级地址变为全部地区，测试下一级地址是否可点击
		View county = solo.getView(id_choseNet_county);
		if (!county.isEnabled()) {
			showErrLog(tag + ":case_ziti_chose_net():让上一级地址变为全部地区，测试下一级地址是否可点击");
		}
		v(id_choseNet_city);
		solo.clickInList(2);
		v(id_choseNet_province);
		solo.clickInList(1);
		String s2 = getTextViewString(id_choseNet_city);
		if (!s2.equals(text_allArea)) {
			showErrLog(tag
					+ ":case_ziti_chose_net():让上一级地址变为全部地区，测试下一级地址是否变为全部地区");
		}
		String s3 = getTextViewString(id_choseNet_county);
		if (!s3.equals(text_allArea)) {
			showErrLog(tag
					+ ":case_ziti_chose_net():让上一级地址变为全部地区，测试下一级地址是否变为全部地区");
		}
		View city = solo.getView(id_choseNet_city);
		if (!city.isEnabled()) {
			showErrLog(tag + ":case_ziti_chose_net():让上一级地址变为全部地区，测试下一级地址是否可点击");
		}
		// 选择某一个自提点后返回提交订单页面
		solo.clickInList(1);
		v(id_choseNet_buttonSure);
		if (!solo.searchText(text_send, 1, false, true)) {
			showErrLog(tag + ":case_ziti_chose_net():选择某一个自提点后返回提交订单页面");
		}
	}

	/**
	 * 网点自提：选择收货人页面
	 */
	public void case_ziti_chose_people() {
		add_shoppingcart();
		// 未填写收货人和手机号的情况下，测试确定按钮是否能点击
		v(id_join_chose_people);
		View button_sure = solo.getView(id_chosePeople_buttonSure);
		if (button_sure.isEnabled()) {
			showErrLog(tag
					+ ":case_ziti_chose_people():未填写收货人和手机号的情况下，测试确定按钮是否能点击");
		}
		// 收货人姓名不能超过12位字符
		enter(id_chosePeople_edit_name, getRandomString(15));
		if (getEditTextString(id_chosePeople_edit_name).length() != 12) {
			showErrLog(tag + "case_ziti_chose_people():收货人姓名不能超过12位字符");
		}
		// 填写格式错误的手机号
		enter(id_chosePeople_edit_pNum, Config.pNum_err);
		t(Config.text_sure);
		toast_equals_string(tag +  ":case_ziti_chose_people():填写格式错误的手机号" ,
			log_pNum_err	);
		// 填写格式正确的手机号并保存
		clear(id_chosePeople_edit_pNum);
		enter(id_chosePeople_edit_pNum, Config.pNum_reg);
		t(Config.text_sure);
		// 返回到提交订单页面看收货人信息是否正确
		String getPeople = getTextViewString(id_join_chose_people);
		String pNum = getPeople.substring(getPeople.length() - 11,
				getPeople.length() - 1);
		if (!pNum.equals(Config.pNum_reg.toString())) {
			showErrLog(tag + ":case_ziti_chose_people():返回到提交订单页面看收货人信息是否正确");
		}
	}

	/**
	 * 网点自提： 成功提交订单
	 */
	public void case_clearing_success() {
		add_shoppingcart();
		v(id_join_chose_net);
		solo.clickInList(1);
		v(id_choseNet_buttonSure);
		v(Config.id_shoppingcart_jiesuan);
		solo.assertCurrentActivity(tag + ":case_clearing_success():成功提交订单",
				"PaywayActivity");
		g();
		t(Config.text_homePage);
	}

	/**
	 * 订单的拆分
	 */
	public void case_order_separate() {
		t(Config.text_shoppingcart);
		if (!solo.searchText(Config.text_bay_fertilizer, 1, false, true)) {
			v(Config.id_checkButton_all);
			t(text_bianji);
			v(Config.id_shoppingcart_jiesuan);
			solo.clickOnButton(Config.text_yes);
		}
		t(Config.text_bay_fertilizer);
		solo.clickInList(2);
		t(Config.text_add_shoppingcart);
		t(Config.text_sure);
		g();
		solo.clickInList(5);
		t(Config.text_add_shoppingcart);
		t(Config.text_sure);
		g();
		g();
		t(Config.text_shoppingcart);
		v(Config.id_checkButton_all);
		v(Config.id_shoppingcart_jiesuan);
		v(id_join_chose_net);
		solo.clickInList(1);
		v(id_choseNet_buttonSure);
		v(Config.id_shoppingcart_jiesuan);
		if (!solo.searchText("选择支付订单", 1, false, true)) {
			showErrLog(tag + ":case_order_separate():订单的拆分");
		}
		// 选择其中一个订单去支付
		v("com.ksfc.newfarmer:id/go_to_pay");
		solo.assertCurrentActivity(tag + ":case_order_separate():选择其中一个订单去支付",
				"PaywayActivity");
	}

	/**
	 * 在货地址页面添加地址
	 */
	public void addAddress() {
		v(id_send_addAddress);
		clear(id_send_addAddress_name);
		enter(id_send_addAddress_name, getRandomString(6));
		clear(id_send_addAddress_pNum);
		enter(id_send_addAddress_pNum, Config.pNum_reg);
		v(id_send_addAddress_city);
		solo.clickInList(1);
		int x = 1 + (int) (Math.random() * 12);
		solo.clickInList(x);
		int y = 1 + (int) (Math.random() * 5);
		solo.clickInList(y);
		enter(id_send_addAddress_particular, getRandomString(10));
		t(Config.text_save);
	}

	/**
	 * 向购物中添加支持配送和自提的商品并提交到结算页面
	 */
	void add_shoppingcart() {
		t(Config.text_shoppingcart);
		// 向购物车内添加支持配送到户的商品并进入到提交订单页面
		if (!solo.searchText(Config.text_bay_car, 1, false, true)) {
			v(Config.id_checkButton_all);
			t(text_bianji);
			v(Config.id_shoppingcart_jiesuan);
			solo.clickOnButton(Config.text_yes);
		}
		t(Config.text_bay_fertilizer);
		solo.clickInList(2);
		t(Config.text_add_shoppingcart);
		t(Config.text_sure);
		g();
		g();
		t(Config.text_shoppingcart);
		v(Config.id_checkButton_all);
		v(Config.id_shoppingcart_jiesuan);
	}
}
