package com.example.yu.test;


import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;
public class CaseNewFarmer_indent extends BaseCase {

	public String tag = " CaseNewFarmer_indent";

	public static CaseNewFarmer_indent caseInstance(Solo solo1) {
		CaseNewFarmer_indent instance = new CaseNewFarmer_indent();
		instance.instance(solo1);
		return instance;
	}

	public void test_run() {
	//	indent_null();
		indent_waitForPay_show();
	}

	/**
	 * null账户测试跳转及没有订单的状态
	 */
	
	
	public void indent_null(){
		login_sure(Config.pNum_null);
		//我的订单
		v("com.ksfc.newfarmer:id/my_order_ll");
		jump("我的订单页面");
		g();
		//待付款页面
		t("待付款");
		jump("待付款页面");
		g();
		//待发货页面
		t("待发货");
		jump("待发货页面");
		g();
		//待收货页面
		t("待收货");
		jump("待收货页面");
		g();
		//已完成页面
		t("已完成");
		jump("已完成页面");
		g();
	}
	
	/**
	 * 我的订单：待付款展示
	 */
	
	public void indent_waitForPay_show(){
	//	login_sure(Config.pNum_reg);
		t("我的");
		t("我的订单");
		t("待付款");
		v("com.ksfc.newfarmer:id/ordering_item_img");
		g();
	}
	/**
	 * 各个没有订单的页面的判断以及跳转到化肥、汽车专场
	 * @param text
	 */
	public void jump(String text){
		if(!solo.searchText("您还没有订单")){
			showErrLog(tag+":indent_null():跳转到"+text);
		}
		t("去买化肥");
		if(!solo.searchText("化肥")){
			showErrLog(tag+":indent_null():"+text+"跳转到化肥专场");
		}
		g();
		t("去买汽车");
		if(!solo.searchText("汽车")){
			showErrLog(tag+":indent_null():"+text+"跳转到汽车专场");
		}
		g();
	}

}