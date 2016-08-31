package com.example.yu.test;

import java.util.ArrayList;

import android.view.View;
import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;
import android.widget.TextView;

public class CaseShoppingCar extends BaseCase {

	String tag = "CaseShoppingCar";

	public static CaseShoppingCar caseInstance(Solo solo1) {
		CaseShoppingCar instance = new CaseShoppingCar();
		instance.instance(solo1);
		return instance;
	}

	String text_bianji = "�༭";
	String text_delete = "ɾ��";
	String text_finish = "���";

	String id_add = "com.ksfc.newfarmer:id/ordering_item_jia1";// ���ﳵҳ��+��ť
	String id_jian = "com.ksfc.newfarmer:id/ordering_item_jian1";// ���ﳵҳ�桪��ť
	String id_jump_alter_num = "com.ksfc.newfarmer:id/ordering_item_geshu";// ���ﳵҳ�浯���޸���������
	String id_edit_alter_num = "com.ksfc.newfarmer:id/dialog_item_geshu";// �޸�����
	String id_shoppingcart_goods_view = "com.ksfc.newfarmer:id/ordering_item_img";// ���ﳵҳ����ƷView
	String id_num = "ordering_item_geshu";// ���ﳵҳ����ʾ��Ʒ������textView

	String log_numErr = "��������ȷ����Ʒ������";
	String log_numMin = "��Ʒ�����ټ�����Ŷ";
	String log_numMax = "��Ʒ�������ܴ���9999";
	String log_choose_goods = "��������ѡ��һ����Ʒ";

	public void test_run() {
		close_huodong();
		case_shoppingCar_jump();
		case_shoppingCar_number();
		case_shoppingCar_delete();
		case_toClearing();
	}
	
	// �����ﳵ�������Ʒ�����ع��ﳵ
	public void add() {
		t(Config.text_homePage);
		t(Config.text_car);
		solo.clickInList(3);
		t(Config.text_add_shoppingcart);
		t(Config.text_sure);
		g();
		g();
		t(Config.text_fertilizer);
		solo.clickInList(2);
		t(Config.text_add_shoppingcart);
		t(Config.text_sure);
		g();
		g();
		t(Config.text_shoppingcart);
	}

	/**
	 * ���ﳵҳ�����ת
	 */
	public void case_shoppingCar_jump() {

		// ��֤���ﳵΪ��
		t(Config.text_shoppingcart);
		if (!solo.searchText(Config.text_bay_fertilizer, 1, false, true)) {
			t(text_bianji);
			v(Config.id_checkButton_all);
			v(Config.id_shoppingcart_jiesuan);
			solo.clickOnButton(Config.text_yes);
		}
		t(Config.text_homePage);
		solo.assertCurrentActivity(tag + ":case_shoppingCar_jump():��ҳ",
				Config.AcName_homePage);
		t(Config.text_shoppingcart);
		t(Config.text_information);
		solo.assertCurrentActivity(tag + ":case_shoppingCar_jump():��Ѷ",
				Config.AcName_information);
		t(Config.text_shoppingcart);
		t(Config.text_mine);
		solo.assertCurrentActivity(tag + ":case_shoppingCar_jump():�ҵ�",
				Config.AcName_mine);
		t(Config.text_shoppingcart);
		t(Config.text_bay_fertilizer);
		solo.assertCurrentActivity(tag + ":case_shoppingCar_jump():����ר��",
				Config.AcName_special);
		g();
		t(Config.text_bay_car);
		solo.assertCurrentActivity(tag + ":case_shoppingCar_jump():����ר��",
				Config.AcName_special);
		g();
	}

	/**
	 * �޸���Ʒ����
	 */
	public void case_shoppingCar_number() {
		// ���ﳵ�����д������Ʒ
		add();
		// ͨ����+-�����޸���Ʒ����
		int i = 0;
		int j = 0;
		while (i < 3) {
			int num = Integer.parseInt(getTextViewString(id_num));
			v(id_add);
			int num_add = Integer.parseInt(getTextViewString(id_num));
			if (num + 1 != num_add) {
				showErrLog(tag
						+ "case_acase_shoppingCar_numberlter_num():ͨ����+-�����޸���Ʒ����");
			}
			i++;
		}
		while (j < 3) {
			int num = Integer.parseInt(getTextViewString(id_num));
			v(id_jian);
			int num_add = Integer.parseInt(getTextViewString(id_num));
			if (num - 1 != num_add) {
				showErrLog(tag + "case_shoppingCar_number():ͨ����+-�����޸���Ʒ����");
			}
			j++;
		}

		// ����Ʒ����ɾ��
		v(id_jump_alter_num);
		clear(id_edit_alter_num);
		t(Config.text_sure);
		toast_equals_string(tag + ":case_shoppingCar_number():����Ʒ����ɾ��",
				log_numErr);
		// ����Ʒ������Ϊ0
		clear(id_edit_alter_num);
		enter(id_edit_alter_num, "0");
		t(Config.text_sure);
		if (!solo.searchText(log_numErr)) {
			showErrLog(tag + ":case_shoppingCar_number():����Ʒ������Ϊ0");
		}

		// �����������ȷ����Ʒ����
		int x = 1 + (int) (Math.random() * 9999);
		String number = x + "";
		clear(id_edit_alter_num);
		enter(id_edit_alter_num, number);
		t(Config.text_sure);
		TextView tv = (TextView) solo.getView(id_edit_alter_num);
		String s = (String) tv.getText();
		int a = Integer.parseInt(s);
		if (a != x) {
			showErrLog(tag + ":case_shoppingCar_number():�����ּ���������ȷ����Ʒ����");
		}

		// ��Ʒ����Ϊ1ʱ�����������
		v(id_jump_alter_num);
		clear(id_edit_alter_num);
		enter(id_edit_alter_num, "1");
		t(Config.text_sure);
		v(id_jian);
		toast_equals_string(tag + ":case_shoppingCar_number(): ��Ʒ����Ϊ1ʱ�����������",
				log_numMin);

		// ��Ʒ����Ϊ9999ʱ��������
		v(id_jump_alter_num);
		clear(id_edit_alter_num);
		enter(id_edit_alter_num, "9999");
		t(Config.text_sure);
		v(id_add);
		toast_equals_string(tag + ":case_shoppingCar_number():��Ʒ����Ϊ9999ʱ��������",
				log_numMax);
	}

	/**
	 * ɾ����Ʒ
	 */
	public void case_shoppingCar_delete() {
		add();
		// ���󻬶�ɾ��ĳ����Ʒ
		if (solo.searchText(text_finish, 1, false, true)) {
			t(text_finish);
		}
		View view = solo.getView(id_shoppingcart_goods_view);
		dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);
		search_text(tag + ":case_shoppingCar_delete():���󻬶�ɾ��ĳ����Ʒ", text_delete,
				1, false);
		t(text_delete);
		t(Config.text_yes);

		// ͨ���༭����ɾ����Ʒ
		// ͨ��ȡ��ȫѡ����û��ѡ���κ���Ʒ�������ɾ��
		t(text_bianji);
		ArrayList<android.widget.CheckBox> checkBox = solo
				.getCurrentViews(android.widget.CheckBox.class);
		int a = (checkBox.size() - 1);
		if (solo.isCheckBoxChecked(0)) {
			solo.clickOnCheckBox(0);
		}
		solo.clickOnCheckBox(a);
		solo.clickOnCheckBox(a);
		v(Config.id_shoppingcart_jiesuan);
		toast_equals_string(tag
				+ ":case_shoppingCar_delete():ͨ��ȡ��ȫѡ����û��ѡ���κ���Ʒ�������ɾ��",
				log_choose_goods);

		// ���ѡ��ɾ��������Ʒ
		int x = (int) (Math.random() * a);
		solo.clickOnView(checkBox.get(x));
		v(Config.id_shoppingcart_jiesuan);
		t(Config.text_yes);
		t(Config.text_homePage);
	}

	/**
	 * ���ﳵҳ���ȥ�������
	 */

	public void case_toClearing() {
		logout();
		t(Config.text_shoppingcart);
		// �жϹ��ﳵ�ڻ���û����Ʒû�������
		if (solo.searchText(Config.text_bay_fertilizer, 1, false, true)) {
			add();
		}

		// δ��¼��δѡ���κ���Ʒ�������ѡ��ȥ����
		v(Config.id_shoppingcart_jiesuan);
		solo.assertCurrentActivity(tag + ":case_toClearing():δ��¼�����ѡ����Ʒȥ����",
				Config.AcName_login);
		g();

		// δ��¼�����ѡ����Ʒȥ����
		solo.clickOnCheckBox(0);
		v(Config.id_shoppingcart_jiesuan);
		solo.assertCurrentActivity(tag + ":case_toClearing():δ��¼�����ѡ����Ʒȥ����",
				Config.AcName_login);
		// ��¼�����δѡ���κ���Ʒȥ����
		login_sure(Config.pNum_reg);
		add();
		v(Config.id_shoppingcart_jiesuan);
		toast_equals_string(tag + ":case_toClearing():��¼�����δѡ���κ���Ʒȥ����",
				log_choose_goods);
		// ��½��ѡ��һ����Ʒȥ����
		ArrayList<android.widget.CheckBox> checkBox2 = solo
				.getCurrentViews(android.widget.CheckBox.class);
		int a = (checkBox2.size() - 1);
		solo.clickOnView(checkBox2.get(1));
		v(Config.id_shoppingcart_jiesuan);
		solo.assertCurrentActivity(tag + ":case_toClearing():��½��ѡ��һ����Ʒȥ����",
				Config.AcName_clearing);
		g();

		// ��½��ѡ��ȫ����Ʒȥ����
		solo.clickOnView(checkBox2.get(a));
		v(Config.id_shoppingcart_jiesuan);
		solo.assertCurrentActivity(tag + ":case_toClearing():��½��ѡ��ȫ����Ʒȥ����",
				Config.AcName_clearing);

	}

}
