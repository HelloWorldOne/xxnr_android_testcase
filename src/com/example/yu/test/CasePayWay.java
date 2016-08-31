package com.example.yu.test;

import android.view.View;
import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;

public class CasePayWay extends BaseCase {
	public static String tag = "CasePayWay";

	public static CasePayWay caseInstance(Solo solo1) {
		CasePayWay instance = new CasePayWay();
		instance.instance(solo1);
		return instance;
	}

	String text_bay_now = "立即购买";
	String text_send = "配送到户";
	String text_pay_times = "分次支付";
	String text_pay_all = "全额支付";
	String text_to_pay = "去支付";
	String text_EPOS = "全民付EPOS";
	String text_EPOS_net = "EPOS刷卡网点";
	String text_pay_now = "立即支付";
	String text_pay_fail = "支付失败";
	String text_pay = "去付款";
	String text_pay_underLine = "线下支付";
	String text_check_order = "查看订单";
	String text_order_particulars = "订单详情";
	String text_order_zhaungtai = "订单状态";
	String text_pay_way = "支付方式";
	String text_check_pay_message = "查看付款信息";
	String text_alter_pay_way = "修改支付方式";

	String id_sum = "com.ksfc.newfarmer:id/payway_sumPrice";// 支付方式页面待付金额
	String id_wait_sum = "com.ksfc.newfarmer:id/payWay_pay_total_price";// 支付方式页面将要支付的金额
	String id_add = "com.ksfc.newfarmer:id/payWay_discount_jia";// 分次支付+
	String id_jian = "com.ksfc.newfarmer:id/payWay_discount_jian";// 分次支付—
	String id_choose_zhifubao = "com.ksfc.newfarmer:id/alipay_ll";// 选择支付宝支付
	String id_chooose_EPOS = "com.ksfc.newfarmer:id/pos_ll";// 选择EPOS支付
	String id_EPOS_jump_EPONet = "com.ksfc.newfarmer:id/view_other_state_ll";// EPOS支付页面跳转到选择EPOS刷卡点页面
	String id_choose_nuderLine = "com.ksfc.newfarmer:id/bank_dianhui_ll";// 选择线下支付
	String id_order_jump_zhuangtai = "com.ksfc.newfarmer:id/my_order_detail_id";// 订单详情页面跳转到订单状态页面
	String id_pay_separate_wait_price = "com.ksfc.newfarmer:id/payWay_discount_price";// 分次支付时待支付的金额
	String id_pay_separate_add = "com.ksfc.newfarmer:id/payWay_discount_jia";// 分次支付页面+
	String id_pay_separate_jian = "com.ksfc.newfarmer:id/payWay_discount_jian";// 分次支付页面—

	public void test_run() {
		case_sum_less();
		case_payAll_zhifubao();
		case_payAll_EPOS();
		case_pay_underLine();
		case_pay_separate();

	}

	/**
	 * 金额不足以分次支付
	 */
	public void case_sum_less() {
		login_sure(Config.pNum_reg);
		t(Config.text_homePage);
		/**
		 * 金额不足3000的无法选择分次支付
		 */
		t(Config.text_fertilizer);
		solo.clickInList(2);
		t(text_bay_now);
		t(Config.text_sure);
		t(text_send);
		v(Config.id_shoppingcart_jiesuan);
		// 判断待付金额与全额支付金额是否一致
		String all_one = getTextViewString(id_sum);
		String all = all_one.substring(0, all_one.length() - 2);
		String wait_one = getTextViewString(id_wait_sum);
		String wait = wait_one.substring(1, wait_one.length() - 1);
		if (!all.equals(wait)) {
			showErrLog(tag + ":case_sum_lese():判断待付金额与全额支付金额是否一致");
		}
		// 金额不足3000无法分次支付
		t(text_pay_times);
		View view_one = solo.getView(id_add);
		View view_two = solo.getView(id_jian);
		if (view_one.isEnabled() | view_two.isEnabled()) {
			showErrLog(tag + ":case_sum_lese(): 金额不足3000无法分次支付");
		}
	}

	/**
	 * 支付宝全额支付
	 */
	public void case_payAll_zhifubao() {
		login_sure(Config.pNum_reg);
		t(Config.text_myOrder);
		t(text_pay);
		// 支付宝支付
		v(id_choose_zhifubao);
		t(text_to_pay);
	}

	/**
	 * EPSO支付
	 */
	public void case_payAll_EPOS() {
		login_sure(Config.pNum_reg);
		t(Config.text_myOrder);
		t(text_pay);
		// EPOS刷卡全额支付
		v(id_chooose_EPOS);
		t(text_to_pay);
		if (!solo.searchText(text_EPOS, 1, false, true)) {
			showErrLog(tag + ":case_payAll_EPOS():EPOS刷卡全额支付");
		}
		// EPSO支付页面查看其他网点
		v(id_EPOS_jump_EPONet);
		if (!solo.searchText(text_EPOS_net, 1, false, true)) {
			showErrLog(tag + ":case_payAll_EPOS():EPSO支付页面查看其他网点");
		}
		g();
		// EPOS已在服务点立即支付
		t(text_pay_now);
		g();
		toast_equals_string(tag + ":case_payAll_EPOS():EPOS已在服务点立即支付",
				text_pay_fail);
		g();
	}

	/**
	 * 线下支付
	 */
	public void case_pay_underLine() {
		login_sure(Config.pNum_reg);
		t(Config.text_myOrder);
		t(text_pay);
		// 进入线下支付页面
		v(id_choose_nuderLine);
		t(text_to_pay);
		if (!solo.searchText(text_pay_underLine, 1, false, true)) {
			showErrLog(tag + ":case_pay_underLine():进入线下支付页面");
		}
		// 线下付款页面去查看订单
		t(text_check_order);
		if (!solo.searchText(text_order_particulars, 1, false, true)) {
			showErrLog(tag + ":case_pay_underLine():线下付款页面去查看订单");
		}
		// 订单详情页面查看订单状态
		v(id_order_jump_zhuangtai);
		if (!solo.searchText(text_order_zhaungtai, 1, false, true)) {
			showErrLog(tag + ":case_pay_underLine():订单详情页面查看付款审核状态");
		}
		g();
		// 订单详情页面查看付款信息
		t(text_check_pay_message);
		if (!solo.searchText(text_pay_underLine, 1, false, true)) {
			showErrLog(tag + ":case_pay_underLine():订单详情页面查看付款信息");
		}
		g();
		// 订单详情页面去修改支付方式
		t(text_alter_pay_way);
		if (!solo.searchText(text_pay_way, 1, false, true)) {
			showErrLog(tag + ":case_pay_underLine():订单详情页面去修改支付方式");
		}
		g();
		g();
		g();
	}

	/**
	 * 分次支付
	 */
	public void case_pay_separate() {
		login_sure(Config.pNum_reg);
		t(Config.text_homePage);
		t(Config.text_fertilizer);
		solo.clickInList(5);
		t(text_bay_now);
		t(Config.text_sure);
		t(text_send);
		v(Config.id_shoppingcart_jiesuan);
		// 判断待付金额与全额支付金额是否一致
		String all_one = getTextViewString(id_sum);
		String all = all_one.substring(0, all_one.length() - 1);
		String wait_one = getTextViewString(id_wait_sum);
		String wait = wait_one.substring(1, wait_one.length());
		double pay_wait = Double.parseDouble(all);
		if (!all.equals(wait)) {
			showErrLog(tag + ":case_pay_separate():判断待付金额与全额支付金额是否一致");
		}
		t(text_pay_times);
		// 线下支付不能分次
		if (solo.searchText(text_pay_underLine, 1, false, true)) {
			showErrLog(tag + ":case_pay_separate():线下支付不能分次");
		}
		// 获取分次支付的金额看初始值是否为3000
		String s = getTextViewString(id_pay_separate_wait_price);
		double pay_reality = Double.parseDouble(s);
		if (pay_reality != 3000.00) {
			showErrLog(tag + ":case_pay_separate():获取分次支付的金额看初始值是否为3000");
		}

		// 分次支付不停增加支付金额直到等于待付金额
		while (pay_reality != pay_wait) {
			v(id_pay_separate_add);
			s = getTextViewString(id_pay_separate_wait_price);
			double pay_reality_jia = Double.parseDouble(s);
			pay_reality = pay_reality_jia;
		}
		if (pay_reality != pay_wait) {
			showErrLog(tag + ":case_pay_separate():分次支付不停增加支付金额直到等于待付金额");
		}

		// 分次支付不停减少支付金额直到等于默认金额
		while (pay_reality != 3000) {
			v(id_pay_separate_jian);
			s = getTextViewString(id_pay_separate_wait_price);
			double pay_reality_jian = Double.parseDouble(s);
			pay_reality = pay_reality_jian;
		}
		if (pay_reality != 3000.00) {
			showErrLog(tag + ":case_pay_separate():分次支付不停减少支付金额直到等于默认金额");
		}
		g();
		g();
	}
}