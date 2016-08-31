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

	String text_bay_now = "��������";
	String text_send = "���͵���";
	String text_pay_times = "�ִ�֧��";
	String text_pay_all = "ȫ��֧��";
	String text_to_pay = "ȥ֧��";
	String text_EPOS = "ȫ��EPOS";
	String text_EPOS_net = "EPOSˢ������";
	String text_pay_now = "����֧��";
	String text_pay_fail = "֧��ʧ��";
	String text_pay = "ȥ����";
	String text_pay_underLine = "����֧��";
	String text_check_order = "�鿴����";
	String text_order_particulars = "��������";
	String text_order_zhaungtai = "����״̬";
	String text_pay_way = "֧����ʽ";
	String text_check_pay_message = "�鿴������Ϣ";
	String text_alter_pay_way = "�޸�֧����ʽ";

	String id_sum = "com.ksfc.newfarmer:id/payway_sumPrice";// ֧����ʽҳ��������
	String id_wait_sum = "com.ksfc.newfarmer:id/payWay_pay_total_price";// ֧����ʽҳ�潫Ҫ֧���Ľ��
	String id_add = "com.ksfc.newfarmer:id/payWay_discount_jia";// �ִ�֧��+
	String id_jian = "com.ksfc.newfarmer:id/payWay_discount_jian";// �ִ�֧����
	String id_choose_zhifubao = "com.ksfc.newfarmer:id/alipay_ll";// ѡ��֧����֧��
	String id_chooose_EPOS = "com.ksfc.newfarmer:id/pos_ll";// ѡ��EPOS֧��
	String id_EPOS_jump_EPONet = "com.ksfc.newfarmer:id/view_other_state_ll";// EPOS֧��ҳ����ת��ѡ��EPOSˢ����ҳ��
	String id_choose_nuderLine = "com.ksfc.newfarmer:id/bank_dianhui_ll";// ѡ������֧��
	String id_order_jump_zhuangtai = "com.ksfc.newfarmer:id/my_order_detail_id";// ��������ҳ����ת������״̬ҳ��
	String id_pay_separate_wait_price = "com.ksfc.newfarmer:id/payWay_discount_price";// �ִ�֧��ʱ��֧���Ľ��
	String id_pay_separate_add = "com.ksfc.newfarmer:id/payWay_discount_jia";// �ִ�֧��ҳ��+
	String id_pay_separate_jian = "com.ksfc.newfarmer:id/payWay_discount_jian";// �ִ�֧��ҳ�桪

	public void test_run() {
		case_sum_less();
		case_payAll_zhifubao();
		case_payAll_EPOS();
		case_pay_underLine();
		case_pay_separate();

	}

	/**
	 * �����Էִ�֧��
	 */
	public void case_sum_less() {
		login_sure(Config.pNum_reg);
		t(Config.text_homePage);
		/**
		 * ����3000���޷�ѡ��ִ�֧��
		 */
		t(Config.text_fertilizer);
		solo.clickInList(2);
		t(text_bay_now);
		t(Config.text_sure);
		t(text_send);
		v(Config.id_shoppingcart_jiesuan);
		// �жϴ��������ȫ��֧������Ƿ�һ��
		String all_one = getTextViewString(id_sum);
		String all = all_one.substring(0, all_one.length() - 2);
		String wait_one = getTextViewString(id_wait_sum);
		String wait = wait_one.substring(1, wait_one.length() - 1);
		if (!all.equals(wait)) {
			showErrLog(tag + ":case_sum_lese():�жϴ��������ȫ��֧������Ƿ�һ��");
		}
		// ����3000�޷��ִ�֧��
		t(text_pay_times);
		View view_one = solo.getView(id_add);
		View view_two = solo.getView(id_jian);
		if (view_one.isEnabled() | view_two.isEnabled()) {
			showErrLog(tag + ":case_sum_lese(): ����3000�޷��ִ�֧��");
		}
	}

	/**
	 * ֧����ȫ��֧��
	 */
	public void case_payAll_zhifubao() {
		login_sure(Config.pNum_reg);
		t(Config.text_myOrder);
		t(text_pay);
		// ֧����֧��
		v(id_choose_zhifubao);
		t(text_to_pay);
	}

	/**
	 * EPSO֧��
	 */
	public void case_payAll_EPOS() {
		login_sure(Config.pNum_reg);
		t(Config.text_myOrder);
		t(text_pay);
		// EPOSˢ��ȫ��֧��
		v(id_chooose_EPOS);
		t(text_to_pay);
		if (!solo.searchText(text_EPOS, 1, false, true)) {
			showErrLog(tag + ":case_payAll_EPOS():EPOSˢ��ȫ��֧��");
		}
		// EPSO֧��ҳ��鿴��������
		v(id_EPOS_jump_EPONet);
		if (!solo.searchText(text_EPOS_net, 1, false, true)) {
			showErrLog(tag + ":case_payAll_EPOS():EPSO֧��ҳ��鿴��������");
		}
		g();
		// EPOS���ڷ��������֧��
		t(text_pay_now);
		g();
		toast_equals_string(tag + ":case_payAll_EPOS():EPOS���ڷ��������֧��",
				text_pay_fail);
		g();
	}

	/**
	 * ����֧��
	 */
	public void case_pay_underLine() {
		login_sure(Config.pNum_reg);
		t(Config.text_myOrder);
		t(text_pay);
		// ��������֧��ҳ��
		v(id_choose_nuderLine);
		t(text_to_pay);
		if (!solo.searchText(text_pay_underLine, 1, false, true)) {
			showErrLog(tag + ":case_pay_underLine():��������֧��ҳ��");
		}
		// ���¸���ҳ��ȥ�鿴����
		t(text_check_order);
		if (!solo.searchText(text_order_particulars, 1, false, true)) {
			showErrLog(tag + ":case_pay_underLine():���¸���ҳ��ȥ�鿴����");
		}
		// ��������ҳ��鿴����״̬
		v(id_order_jump_zhuangtai);
		if (!solo.searchText(text_order_zhaungtai, 1, false, true)) {
			showErrLog(tag + ":case_pay_underLine():��������ҳ��鿴�������״̬");
		}
		g();
		// ��������ҳ��鿴������Ϣ
		t(text_check_pay_message);
		if (!solo.searchText(text_pay_underLine, 1, false, true)) {
			showErrLog(tag + ":case_pay_underLine():��������ҳ��鿴������Ϣ");
		}
		g();
		// ��������ҳ��ȥ�޸�֧����ʽ
		t(text_alter_pay_way);
		if (!solo.searchText(text_pay_way, 1, false, true)) {
			showErrLog(tag + ":case_pay_underLine():��������ҳ��ȥ�޸�֧����ʽ");
		}
		g();
		g();
		g();
	}

	/**
	 * �ִ�֧��
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
		// �жϴ��������ȫ��֧������Ƿ�һ��
		String all_one = getTextViewString(id_sum);
		String all = all_one.substring(0, all_one.length() - 1);
		String wait_one = getTextViewString(id_wait_sum);
		String wait = wait_one.substring(1, wait_one.length());
		double pay_wait = Double.parseDouble(all);
		if (!all.equals(wait)) {
			showErrLog(tag + ":case_pay_separate():�жϴ��������ȫ��֧������Ƿ�һ��");
		}
		t(text_pay_times);
		// ����֧�����ִܷ�
		if (solo.searchText(text_pay_underLine, 1, false, true)) {
			showErrLog(tag + ":case_pay_separate():����֧�����ִܷ�");
		}
		// ��ȡ�ִ�֧���Ľ���ʼֵ�Ƿ�Ϊ3000
		String s = getTextViewString(id_pay_separate_wait_price);
		double pay_reality = Double.parseDouble(s);
		if (pay_reality != 3000.00) {
			showErrLog(tag + ":case_pay_separate():��ȡ�ִ�֧���Ľ���ʼֵ�Ƿ�Ϊ3000");
		}

		// �ִ�֧����ͣ����֧�����ֱ�����ڴ������
		while (pay_reality != pay_wait) {
			v(id_pay_separate_add);
			s = getTextViewString(id_pay_separate_wait_price);
			double pay_reality_jia = Double.parseDouble(s);
			pay_reality = pay_reality_jia;
		}
		if (pay_reality != pay_wait) {
			showErrLog(tag + ":case_pay_separate():�ִ�֧����ͣ����֧�����ֱ�����ڴ������");
		}

		// �ִ�֧����ͣ����֧�����ֱ������Ĭ�Ͻ��
		while (pay_reality != 3000) {
			v(id_pay_separate_jian);
			s = getTextViewString(id_pay_separate_wait_price);
			double pay_reality_jian = Double.parseDouble(s);
			pay_reality = pay_reality_jian;
		}
		if (pay_reality != 3000.00) {
			showErrLog(tag + ":case_pay_separate():�ִ�֧����ͣ����֧�����ֱ������Ĭ�Ͻ��");
		}
		g();
		g();
	}
}