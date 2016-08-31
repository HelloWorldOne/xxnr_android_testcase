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

	String AcName_point_rule = "RewardRulesActivity";// ���ֹ�����

	String text_logout_show = "����δ��¼��������¼�һ���Ʒ��ǩ���û���";
	String text_lift_particular = "��Ʒ����";
	String text_daiziti = "������";
	String text_finish = "�����";
	String text_exchangeNow = "�����һ�";
	String text_exchageSure = "ȷ���һ�";
	String text_chooseNet = "ѡ����������";
	String text_exchange_success = "�һ��ɹ�";
	String text_exchange_record = "�һ���¼";
	String text_point_nuEnough = "���ֲ���";
	String text_null = "������";
	String text_version_updating = "�汾����";
	String text_update_now = "��������";
	String text_update_later = "�ݲ�����";

	String id_logout_show = "com.ksfc.newfarmer:id/head_unLogin_tall_layout_float";// δ��¼ʱ����ʾ
	String id_pointStore_pointShow = "com.ksfc.newfarmer:id/integral_count_tv";// �����̳���ҳ����չʾ
	String id_point = "com.ksfc.newfarmer:id/integral_count_ll";// �����̳ǻ���
	String id_exchange_record = "com.ksfc.newfarmer:id/changing_record_ll";// �����̳Ƕһ�
	String id_point_rule = "com.ksfc.newfarmer:id/integral_rules_ll";// �����̳ǻ��ֹ���
	String id_lift_particular = "com.ksfc.newfarmer:id/gift_content_rel";// ��Ʒ����
	String id_exchange_now = "com.ksfc.newfarmer:id/gift_detail_sure_tv";// ��Ʒ���������һ�
	String id_myPoint_qiaodao = "com.ksfc.newfarmer:id/sign_button_tv";// �ҵĻ���ǩ����ť
	String id_myPoint_pointShow = "com.ksfc.newfarmer:id/my_integral_count_tv";// �ҵĻ���ҳ�������ʾ
	String id_myPoint_pointAdd = "com.ksfc.newfarmer:id/point_log_point_tv";// �ҵĻ���ҳ��ǩ�����ӵĻ���
	String id_linearLayout = "com.ksfc.newfarmer:id/view_container";// �����̳���Ʒչʾ�Ĳ���
	String id_gift_exchangeNow = "com.ksfc.newfarmer:id/gift_detail_sure_tv";// ��Ʒ����ҳ�������һ���ť
	String id_jump_choose_net = "com.ksfc.newfarmer:id/select_state_address_ll_state";// �ύ�һ�ҳ�����ѡ�������
	String id_gift_price = "com.ksfc.newfarmer:id/gift_price_tv";// �ύ�һ�ҳ����Ʒ�۸�
	String id_exchangeSuccess_check = "com.ksfc.newfarmer:id/check_order_tv";// �һ��ɹ�ҳ��鿴�һ���¼

	String log_nullNet = "��ѡ����������";
	String log_noNte = "�õ���û������";
	String log_version_new = "���°汾";

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
	 * δ��¼ʱ�Ļ����̳�
	 */
	public void case_pointStore_logout() {
		logout();
		// δ��¼ʱ��δ��¼��ʾ
		t(Config.text_mine);
		t(Config.text_pointStore);
		if (!solo.searchText(text_logout_show, 1, false, true)) {
			showErrLog(tag + ":case_pointStore_logout():δ��¼ʱ��δ��¼��ʾ");
		}
		// ���δ��¼��ʾ����ת����¼ҳ��
		v(id_logout_show);
		solo.assertCurrentActivity(tag
				+ "case_pointStore_logout():���δ��¼��ʾ����ת����¼ҳ��",
				Config.AcName_login);
		g();
		// δ��¼ʱ������ʾΪ0
		if (!getTextViewString(id_pointStore_pointShow).equals("0")) {
			showErrLog(tag + ":case_pointStore_logout():δ��¼ʱ������ʾΪ0");
		}
		// δ��¼������֣�Ӧ��ת����¼ҳ��
		v(id_point);
		solo.assertCurrentActivity(tag
				+ "case_pointStore_logout():δ��¼������֣�Ӧ��ת����¼ҳ��",
				Config.AcName_login);
		g();
		// δ��·����һ���¼��Ӧ��ת����¼ҳ��
		v(id_exchange_record);
		solo.assertCurrentActivity(tag
				+ "case_pointStore_logout():δ��·����һ���¼��Ӧ��ת����¼ҳ��",
				Config.AcName_login);
		g();
		// ���ֹ���ҳ��
		v(id_point_rule);
		solo.assertCurrentActivity(tag
				+ "case_pointStore_logout():δ��·����һ���¼��Ӧ��ת����¼ҳ��",
				AcName_point_rule);
		g();
		// δ��¼������Ʒ����ҳ��
		v(id_lift_particular);
		if (!solo.searchText(text_lift_particular, 1, false, true)) {
			showErrLog(tag + ":case_pointStore_logout():δ��¼������Ʒ����ҳ��");
		}
		// δ��¼����Ʒ����ҳ��һ�
		v(id_exchange_now);
		solo.assertCurrentActivity(tag
				+ "case_pointStore_logout():δ��¼����Ʒ����ҳ��һ�", Config.AcName_login);
		g();
		g();
		g();
		t(Config.text_homePage);
	}

	/**
	 * �һ���¼Ϊ�յ��˻���½����µĻ����̳�
	 */
	public void case_pointStore_loginNull() {
		// û�жһ���¼���˻�
		login_sure(Config.pNum_null);
		t(Config.text_pointStore);
		// û�жһ���¼���˻�����δ���ҳ��
		v(id_exchange_record);
		if (solo.searchText(text_daiziti, 1, false, true)) {
			showErrLog(tag + ":pointStore_login():û�жһ���¼���˻�����δ���ҳ��");
		}
		t(text_finish);
		// û�жһ���¼���˻����������ҳ��
		if (solo.searchText(text_finish, 2, false, true)) {
			showErrLog(tag + ":pointStore_login():û�жһ���¼���˻����������ҳ��");
		}
		g();
		g();
		t(Config.text_homePage);
	}

	/**
	 * ��¼�л��ֺͶһ���¼���˻�
	 */
	public void case_pointStore_login() {
		login_sure(Config.pNum_reg);
		t(Config.text_mine);
		t(Config.text_pointStore);
		// ǩ��
		v(id_point);
		if (solo.getView(id_myPoint_qiaodao).isEnabled()) {
			// �ڿ�ǩ���������ǩ�������Ƿ�������Ӧ����
			int a = Integer.parseInt(getTextViewString(id_myPoint_pointShow));
			v(id_myPoint_qiaodao);
			String add = getTextViewString(id_myPoint_pointAdd);
			int b = Integer.parseInt(add.substring(1, add.length()));
			if (Integer.parseInt(getTextViewString(id_myPoint_pointShow)) != a
					+ b) {
				showErrLog(tag
						+ ":case_pointStore_login():�ڿ�ǩ���������ǩ�������Ƿ�������Ӧ����");

				// ���ػ����̳���ҳ��չʾ�Ļ��ֶԲ���
				g();
				int point = Integer
						.parseInt(getTextViewString(id_pointStore_pointShow));
				if (point != a + b) {
					showErrLog(tag
							+ ":case_pointStore_login():���ػ����̳���ҳ��չʾ�Ļ��ֶԲ���");
				}
			}
		}
		g();
		// �жһ���¼���˻��鿴�һ���¼
		v("com.ksfc.newfarmer:id/changing_record_ll");
		// �������չ���һ���������
		v("com.ksfc.newfarmer:id/item_gift_order_Indicator");
		if (!solo.searchText("������", 1, false, true)) {
			showErrLog(tag + ":pointStore_login():�������չ���һ���������");
		}
		// �л��������table
		t("�����");
		if (!solo.searchText("�����", 1, false, true)) {
			showErrLog(tag + ":pointStore_login():�л��������table");
		}
		g();
		g();
		t("��ҳ");
	}

	/**
	 * �һ���Ʒ
	 */
	public void case_pointStore_exchange() {
		login_sure(Config.pNum_reg);
		t(Config.text_pointStore);
		/**
		 * �ܳɹ��һ�����Ʒ
		 */
		int point = Integer
				.parseInt(getTextViewString(id_pointStore_pointShow));
		ArrayList<ImageView> list = solo.getCurrentViews(ImageView.class,
				solo.getView(id_linearLayout));
		solo.clickOnView(list.get(8));
		if (!solo.searchText(text_exchangeNow, 1, false, true)) {
			showErrLog(tag + ":case_pointStore_exchange():�����ܶһ�����Ʒ����ҳ��");
		}
		// ����һ�ҳ��
		v(id_gift_exchangeNow);
		if (!solo.searchText(text_exchageSure, 1, false, true)) {
			showErrLog(tag + ":case_pointStore_exchange():����һ�ҳ��");
		}
		// δѡ������������¶һ�
		t(text_exchageSure);
		toast_equals_string(tag + ":case_pointStore_exchange():δѡ������������¶һ�",
				log_nullNet);
		// ѡ�����������һ�
		v(id_jump_choose_net);
		if (!solo.searchText(text_chooseNet, 1, false, true)) {
			showErrLog(tag + ":case_pointStore_exchange():ѡ�����������һ�");
		}
		solo.clickInList(1);
		t(Config.text_sure);
		// �ɹ��һ�
		int price = Integer.parseInt(getTextViewString(id_gift_price));
		t(text_exchageSure);
		if (!solo.searchText(text_exchange_success, 1, false, true)) {
			showErrLog(tag + ":case_pointStore_exchange():�ɹ��һ�");
		}
		// �һ��ɹ�����ת���һ���¼ҳ��
		v(id_exchangeSuccess_check);
		if (!solo.searchText(text_exchange_record, 1, false, true)) {
			showErrLog(tag + ":case_pointStore_exchange():�һ��ɹ�����ת���һ���¼ҳ��");
		}
		g();
		g();
		// �鿴�һ�����ֱ仯
		int point_surplus = Integer
				.parseInt(getTextViewString(id_pointStore_pointShow));
		if (point_surplus != point - price) {
			showErrLog(tag + ":case_pointStore_exchange():�鿴�һ�����ֱ仯");
		}
		g();
		t(Config.text_homePage);
	}

	/**
	 * û����������Ʒ�Ķһ�
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
		toast_equals_string(tag + ":case_gift_noStore():û����������Ʒ�Ķһ�", log_noNte);
		g();
		g();
		g();
		g();
		t(Config.text_homePage);
	}

	/**
	 * ���ֲ�������Ʒ
	 */
	public void case_gift_expensive() {
		login_sure(Config.pNum_reg);
		t(Config.text_pointStore);
		ArrayList<ImageView> list = solo.getCurrentViews(ImageView.class,
				solo.getView(id_linearLayout));
		solo.scrollDown();
		solo.clickOnView(list.get(14));
		if (!solo.searchText(text_point_nuEnough, 1, false, true)) {
			showErrLog(tag + ":case_gift_expensive():���ֲ�������Ʒ");
		}
		// ���ֲ����޷�����һ�
		if (solo.getView(id_gift_exchangeNow).isEnabled()) {
			showErrLog(tag + ":case_gift_expensive():���ֲ����޷�����һ�");
		}
		g();
		g();
		t(Config.text_homePage);
	}

	/**
	 * ���������Ʒ
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
		// �����⣬�һ���ť�޷����
		if (solo.getView(id_gift_exchangeNow).isEnabled()) {
			showErrLog(tag + ": case_gift_null():�����⣬�һ���ť�޷����");
		}
		g();
		g();
		t(Config.text_homePage);
	}

	/**
	 * ��֧�ֶһ����ϰ汾
	 */
	public void case_gift_oldEdition() {
		login_sure(Config.pNum_reg);
		t(Config.text_pointStore);
		ArrayList<ImageView> list = solo.getCurrentViews(ImageView.class,
				solo.getView(id_linearLayout));
		solo.clickOnView(list.get(0));
		// �ϰ屾�����ύ�һ�ҳ��
		v(id_gift_exchangeNow);
		if (!solo.searchText(text_version_updating, 1, false, true)) {
			showErrLog(tag + ":case_gift_oldEdition():�ϰ屾�����ύ�һ�ҳ��");
		}
		// ѡ��汾����
		t(text_version_updating);
		if (solo.waitForText(log_version_new)) {
			g();
			g();
			g();
			t(Config.text_homePage);
		} else {
			if (!solo.searchText(text_update_now, 1, false, true)) {
				showErrLog(tag + ":case_gift_oldEdition():ѡ��汾����");
			}
			t(text_update_later);
			v("com.ksfc.newfarmer:id/up_grade");
			t(text_update_now);
		}
	}
}
