package com.example.yu.test;

import android.view.View;
import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;

public class CaseCommodity extends BaseCase {
	public static String tag = "CaseCommodity";

	public static CaseCommodity caseInstance(Solo solo1) {
		CaseCommodity instance = new CaseCommodity();
		instance.instance(solo1);
		return instance;

	}

	String text_bay_now = "��������";
	String text_canshu = "��ϸ����";
	String text_shuoming = "����˵��";

	String id_imageView = "imageView";// ��ƷͼƬ
	String id_jia = "pop_discount_jia";// ��Ʒ����ҳ��Ӻ�
	String id_jian = "pop_discount_jian";// ��Ʒ����ҳ�����
	String id_edit_num = "pop_discount_geshu";// ��Ʒ����ҳ�����������

	String log_max_jia = "��Ʒ�������ܴ���9999";
	String log_min_jian = "��Ʒ���������ټ�����";
	String log_nullAttribute = "��ѡ����Ʒ��Ϣ";
	String log_joinShoppingCart_success = "��ӹ��ﳵ�ɹ�";

	public void test_run() {
		close_huodong();
		case_commodityParticulars_show();
		case_alter_num();
		case_logout_nullAttribute_join();
		case_logout_choseAttribute_join();
		case_login_nullAttribute_join();
		case_login_choseAttribute_join();
		case_logout_bay();
		case_login_nullAttribute_bay();
		case_login_choseAttribute_bay();

	}

	/**
	 * ��Ʒ����ҳ���չʾ
	 */
	public void case_commodityParticulars_show() {
		join_commodityParticulars();
		// ���ҹ�����ƷͼƬ��Ϣ
		View view = solo.getView(id_imageView);
		dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);
		dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);
		dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);

		// ����Ŵ�ͼƬ
		solo.clickOnScreen(360, 500);
		g();

		// ���»������Ʒ����
		solo.drag(460, 460, 900, 400, 3);
		solo.drag(460, 460, 900, 400, 3);
		search_text(tag + ":case_commodityParticulars_show():���»������Ʒ����",
				text_canshu, 1, false);

		// �л���Ʒ��������
		solo.drag(460, 460, 900, 400, 3);
		t(text_canshu);
		t(text_shuoming);
		g();
		g();
	}

	/**
	 * ��Ʒ����ҳ���޸���Ʒ����
	 */
	public void case_alter_num() {
		join_commodityParticulars();
		// ͨ����+-�����޸���Ʒ����
		t(Config.text_add_shoppingcart);
		int i = 0;
		int j = 0;
		while (i < 3) {
			int num = Integer.parseInt(getEditTextString(id_edit_num));
			v(id_jia);
			int num_add = Integer.parseInt(getEditTextString(id_edit_num));
			if (num + 1 != num_add) {
				showErrLog(tag + "case_alter_num():ͨ����+-�����޸���Ʒ����");
			}
			i++;
		}
		while (j < 3) {
			int num = Integer.parseInt(getEditTextString(id_edit_num));
			v(id_jian);
			int num_add = Integer.parseInt(getEditTextString(id_edit_num));
			if (num - 1 != num_add) {
				showErrLog(tag + "case_alter_num():ͨ����+-�����޸���Ʒ����");
			}
			j++;
		}

		// ��Ʒ����Ϊ9999ʱ��������
		clear(id_edit_num);
		enter(id_edit_num, "9999");
		v(id_jia);
		toast_equals_string(tag + ":case_alter_num():��Ʒ����Ϊ9999ʱ��������",
				log_max_jia);

		// ��Ʒ����Ϊ1ʱ�����������
		clear(id_edit_num);
		enter(id_edit_num, "1");
		v(id_jian);
		toast_equals_string(tag + ":case_alter_num(): ��Ʒ����Ϊ1ʱ�����������",
				log_min_jian);

		// ����Ʒ������Ϊ0
		clear(id_edit_num);
		enter(id_edit_num, "0");
		String num = getEditTextString(id_edit_num);
		showLog(num);
		if (num != "1") {
			showErrLog(tag + ":case_alter_num():�����ּ��̽���Ʒ������Ϊ0");
		}

		// �����������ȷ����Ʒ����
		int x = 1 + (int) (Math.random() * 9999);
		String number = x + "";
		clear(id_edit_num);
		enter(id_edit_num, number);
		String num2 = getEditTextString(id_edit_num);
		int a = Integer.parseInt(num2);
		if (a != x) {
			showErrLog(tag + ":case_alter_num():�����ּ���������ȷ����Ʒ����");
		}
		g();
		g();
		g();
	}

	/**
	 * δ��¼�������Ʒ����δѡ����ȫ�ͼ��빺�ﳵ
	 */
	public void case_logout_nullAttribute_join() {
		logout();
		join_commodityParticulars();
		t(Config.text_add_shoppingcart);
		t(Config.text_sure);
		toast_equals_string(tag
				+ "case_logout_nullAttribute_join():δ��¼�������Ʒ����δѡ����ȫ�ͼ��빺�ﳵ",
				log_nullAttribute);
		g();
		g();
		g();
	}

	/**
	 * δ��¼ѡ����Ʒ���Ժ���빺�ﳵ
	 */
	public void case_logout_choseAttribute_join() {
		logout();
		join_commodityParticulars();
		t(Config.text_add_shoppingcart);
		t("2.0T �Զ���6DCT��");
		t("������");
		t("���ƺ�");
		t(Config.text_sure);
		toast_equals_string(tag
				+ "case_logout_choseAttribute_join():δ��¼�����ѡ������Ʒ���Ժ���빺�ﳵ",
				log_joinShoppingCart_success);
		g();
		g();
	}

	/**
	 * ��½����Ʒ����δѡ����ͼ��빺�ﳵ
	 */
	public void case_login_nullAttribute_join() {
		login_sure(Config.pNum_reg);
		t(Config.text_homePage);
		join_commodityParticulars();
		t(Config.text_add_shoppingcart);
		t(Config.text_sure);
		toast_equals_string(tag
				+ "case_login_nullAttribute_join():��½����Ʒ����δѡ����ͼ��빺�ﳵ",
				log_nullAttribute);
		g();
		g();
		g();
	}

	/**
	 * ��½����Ʒ����ѡ���겢���빺�ﳵ
	 */
	public void case_login_choseAttribute_join() {
		login_sure(Config.pNum_reg);
		t(Config.text_homePage);
		join_commodityParticulars();
		t(Config.text_add_shoppingcart);
		t("2.0T �Զ���6DCT��");
		t("������");
		t("���ƺ�");
		t(Config.text_sure);
		toast_equals_string(tag
				+ "case_login_choseAttribute_join():δ��¼�����ѡ������Ʒ���Ժ���빺�ﳵ",
				log_joinShoppingCart_success);
		g();
		g();
	}

	/**
	 * δ��¼��������
	 */
	public void case_logout_bay() {
		logout();
		join_commodityParticulars();
		t(text_bay_now);
		t(Config.text_sure);
		solo.assertCurrentActivity(tag + ":case_logout_bay():δ��¼��������",
				"LoginActivity");
		g();
		g();
		g();
		g();
	}

	/**
	 * ��¼����Ʒ����δѡ����ȫ����������
	 */
	public void case_login_nullAttribute_bay() {
		login_sure(Config.pNum_reg);
		t(Config.text_homePage);
		join_commodityParticulars();
		t(text_bay_now);
		t(Config.text_sure);
		toast_equals_string(tag
				+ "case_login_nullAttribute_bay():��¼����Ʒ����δѡ����ȫ����������",
				log_nullAttribute);
		g();
		g();
		g();
	}

	/**
	 * ��½��ѡ������Ʒ���Ժ�ȷ����������
	 */
	public void case_login_choseAttribute_bay() {
		login_sure(Config.pNum_reg);
		t(Config.text_homePage);
		join_commodityParticulars();
		t(text_bay_now);
		t("2.0T �Զ���6DCT��");
		t("������");
		t("���ƺ�");
		t(Config.text_sure);
		solo.assertCurrentActivity(tag
				+ ":case_login_choseAttribute_bay():��½��ѡ������Ʒ���Ժ�ȷ����������",
				"AddOrderActivity");

	}

	/**
	 * ������Ʒ����ҳ��
	 */
	void join_commodityParticulars() {
		t(Config.text_car);
		solo.clickInList(2);
	}
}