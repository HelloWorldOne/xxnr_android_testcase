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

	String text_bianji = "�༭";
	String text_add_address = "����ջ���ַ";
	String text_send = "���͵���";
	String text_noAddress = "����û���ջ���ַŶ�����һ����~";
	String text_nullTown = "��ѡ������";
	String text_delete_address = "ɾ���˵�ַ";
	String text_car_special = "����ר��";
	String text_allArea = "ȫ������";

	String id_join_addAddress = "com.ksfc.newfarmer:id/address_shouhuo_ll";// �ύ����ҳ������ջ���ַҳ��
	String id_send_button_delete = "com.ksfc.newfarmer:id/delete_address_img";// �ջ���ַҳ��ɾ����ť
	String id_send_addAddress = "com.ksfc.newfarmer:id/title_right_text";// �ջ���ַҳ����Ӱ�ť
	String id_send_addAddress_name = "com.ksfc.newfarmer:id/shouhuo_name";// ����ջ���ַҳ���ջ���
	String id_send_addAddress_pNum = "com.ksfc.newfarmer:id/shouhuo_tel";// ����ջ���ַҳ���ֻ���
	String id_send_addAddress_city = "com.ksfc.newfarmer:id/choice_city_layout";// ����ջ���ַҳ��ʡ������
	String id_send_addAddress_town = "com.ksfc.newfarmer:id/choice_town_layout";// ����ջ���ַҳ������
	String id_send_addAddress_particular = "com.ksfc.newfarmer:id/choice_detail_room_edit";// ����ջ���ַҳ����ϸ��ַ
	String id_bianji = "com.ksfc.newfarmer:id/edit_address_img";// �ջ���ַҳ��༭��ַ
	String id_join_chose_net = "com.ksfc.newfarmer:id/select_state_address_ll_state";// �ύ����ҳ�����ѡ�������ҳ��
	String id_choseNet_buttonSure = "com.ksfc.newfarmer:id/save_userInfo";// ѡ�������ҳ��ȷ��button��id
	String id_choseNet_city = "com.ksfc.newfarmer:id/state_city_rel";// ѡ�������ѡ�����
	String id_choseNet_county = "com.ksfc.newfarmer:id/state_county_rel";// ѡ�������ѡ����
	String id_choseNet_province = "com.ksfc.newfarmer:id/state_province_rel";// ѡ�������ѡ��ʡ��
	String id_join_chose_people = "com.ksfc.newfarmer:id/select_state_person_info";// �ύ����ҳ����ת��ѡ���ջ���ҳ��
	String id_chosePeople_buttonSure = "com.ksfc.newfarmer:id/name_submit_tv";// ѡ���ջ���ҳ��ȷ��Button
	String id_chosePeople_edit_name = "com.ksfc.newfarmer:id/shouhuo_name";// ѡ���ջ���ҳ������
	String id_chosePeople_edit_pNum = "com.ksfc.newfarmer:id/shouhuo_tel";// ѡ���ջ���ҳ���ֻ���

	String log_nullAddress = "�ջ���ַ����Ϊ��";// �ջ���ַΪ��ʱ��ʾ
	String log_nullName = "�������ջ�������";
	String log_nullPNum = "�������ֻ�����";
	String log_pNum_err = "��������ȷ���ֻ�����";
	String log_nullCity = "��ѡ�����";
	String log_nullParticular = "������������ϸ��ַ";
	String log_add_success = "�ɹ������˵�ַ";
	String log_delete_success = "ɾ���ɹ�";
	String log_different_net = "��ѡ�����Ʒ������ͬһ���������ᣬ�뷵�ع��ﳵ����ѡ��";
	String log_nullNet = "��ѡ����������";

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
	 * ���͵���:�ջ���ַΪ��ʱ�ύ����
	 */
	public void case_send_nullAddress() {
		add_shoppingcart();
		t(text_send);
		if (solo.searchText(text_add_address, 1, false, true)) {
			v(Config.id_shoppingcart_jiesuan);
			toast_equals_string(tag + ":case_send_nullAddress():���͵���:�ջ���ַΪ��ʱ�ύ����",
					log_nullAddress);

		} else {
			v(id_join_addAddress);
			while (!solo.searchText(text_noAddress, 1, false, true)) {
				v(id_send_button_delete);
				t(Config.text_sure);
			}
			g();
			v(Config.id_shoppingcart_jiesuan);
			toast_equals_string(tag + ":case_send_nullAddress():���͵���:�ջ���ַΪ��ʱ�ύ����",
					log_nullAddress);
		}
	}

	/**
	 * ���͵���������ջ���ַ
	 */
	public void case_send_addAddress() {
		add_shoppingcart();
		t(text_send);
		v(id_join_addAddress);
		v(id_send_addAddress);
		// δ��д�ջ��������ͱ���
		clear(id_send_addAddress_name);
		t(Config.text_save);
		toast_equals_string(tag + ":case_send_addAddress():δ��д�ջ��������ͱ���",
				log_nullName);
		// δ��д�ֻ���
		enter(id_send_addAddress_name, getRandomString(6));
		clear(id_send_addAddress_pNum);
		t(Config.text_save);
		toast_equals_string(tag +":case_send_addAddress():δ��д�ֻ���",
				log_nullPNum);
		
		// ��д������ֻ���
		enter(id_send_addAddress_pNum, Config.pNum_err);
		t(Config.text_save);
		toast_equals_string(tag +":case_send_addAddress():��д������ֻ���",
			log_pNum_err	);
		
		// ��д��ȷ���ֻ��ţ�����û����д��ַ
		clear(id_send_addAddress_pNum);
		enter(id_send_addAddress_pNum, Config.pNum_reg);
		t(Config.text_save);
		toast_equals_string(tag + ":case_send_addAddress():��д��ȷ���ֻ��ţ�����û����д��ַ"   ,
			log_nullCity	);
		// ѡ������к����������ѡ����У��������Ƿ���֮����
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
					+ ":case_send_addAddress():ѡ������к����������ѡ����У��������Ƿ���֮����");
		}
		// δ��д��ϸ��ַ
		t(Config.text_save);
		toast_equals_string(tag +  ":case_send_addAddress():δ��д��ϸ��ַ" ,
			log_nullParticular	);
		
		// �����ַ������ȳ���50����ϸ��ַ
		enter(id_send_addAddress_particular, getRandomString(55));
		if (getEditTextString(id_send_addAddress_particular).length() != 50) {
			showErrLog(tag + ":case_send_addAddress():�����ַ������ȳ���50����ϸ��ַ");
		}
		// �ɹ������ַ
		t(Config.text_save);
		toast_equals_string(tag +  ":case_send_addAddress():�ɹ������ַ" ,
			log_add_success	);
		
	}

	/**
	 * ���͵������༭�ջ���ַ
	 */
	public void case_send_compileAddress() {
		add_shoppingcart();
		t(text_send);
		v(id_join_addAddress);
		// �ڱ༭��ַҳ��ɾ����ַ
		addAddress();
		v(id_bianji);
		t(text_delete_address);
		v(Config.text_sure);
		toast_equals_string(tag +  ":case_send_compileAddress():�ڱ༭��ַҳ��ɾ����ַ"  ,
			log_delete_success	);
		
		addAddress();
		// ���ջ���ַҳ��ɾ����ַ
		v(id_send_button_delete);
		v(Config.text_sure);
		toast_equals_string(tag +":case_send_compileAddress():�ڱ༭��ַҳ��ɾ����ַ"   ,
			log_delete_success	);
		
		addAddress();
		g();
		// �ɹ��ύ����
		v(Config.id_shoppingcart_jiesuan);
		solo.assertCurrentActivity(tag + ":case_send_compileAddress():�ɹ��ύ����",
				"PaywayActivity");
		g();
	}

	/**
	 * ��������:��ͬ�������㲻��ͬʱ�ύ����
	 */
	public void case_ziti_different_net() {
		t(Config.text_shoppingcart);
		// ���ﳵ��������㲻ͬ����Ʒ�����Ƿ�����ѡ������ʾ
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
					+ ":case_ziti_different_net():���ﳵ��������㲻ͬ����Ʒ�����Ƿ�����ѡ������ʾ");
		}
		// ���ﳵ��������㲻ͬ����Ʒ�����Ƿ����ύ����
		v(Config.id_shoppingcart_jiesuan);
		toast_equals_string(tag + ":case_ziti_different_net():���ﳵ��������㲻ͬ����Ʒ�����Ƿ����ύ����"  ,
			log_different_net	);
		
	}

	/**
	 * �������᣺δѡ��������ύ����
	 */
	public void case_ziti_nullNet() {
		// �����ﳵ����ӳ���ѡ�������ȥ����
		add_shoppingcart();
		v(Config.id_shoppingcart_jiesuan);
		toast_equals_string(tag +   ":case_ziti_nullNet():û��ѡ�������������ύ����" ,
			log_nullNet	);
	}

	/**
	 * �������᣺ѡ�������
	 */
	public void case_ziti_chose_net() {
		add_shoppingcart();
		// �ж���δѡ��������������£�ȷ����ť�Ƿ��ܹ����
		v(id_join_chose_net);
		View view = solo.getView(id_choseNet_buttonSure);
		if (view.isEnabled()) {
			showErrLog(tag + ":case_ziti_chose_net():�ж���δѡ��������������£�ȷ����ť�Ƿ��ܹ����");
		}
		v(id_choseNet_city);
		solo.clickInList(getRandomInt(2, 5));
		View view2 = solo.getView(id_choseNet_buttonSure);
		if (view2.isEnabled()) {
			showErrLog(tag + ":case_ziti_chose_net():�ж���δѡ��������������£�ȷ����ť�Ƿ��ܹ����");
		}
		v(id_choseNet_county);
		solo.clickInList(2);
		View view3 = solo.getView(id_choseNet_buttonSure);
		if (view3.isEnabled()) {
			showErrLog(tag + ":case_ziti_chose_net():�ж���δѡ��������������£�ȷ����ť�Ƿ��ܹ����");
		}

		// ����һ����ַ��Ϊȫ��������������һ����ַ�Ƿ��Ϊȫ������
		v(id_choseNet_city);
		solo.clickInList(1);
		String s = getTextViewString(id_choseNet_county);
		if (!s.equals(text_allArea)) {
			showErrLog(tag
					+ ":case_ziti_chose_net():����һ����ַ��Ϊȫ��������������һ����ַ�Ƿ��Ϊȫ������");
		}
		// ����һ����ַ��Ϊȫ��������������һ����ַ�Ƿ�ɵ��
		View county = solo.getView(id_choseNet_county);
		if (!county.isEnabled()) {
			showErrLog(tag + ":case_ziti_chose_net():����һ����ַ��Ϊȫ��������������һ����ַ�Ƿ�ɵ��");
		}
		v(id_choseNet_city);
		solo.clickInList(2);
		v(id_choseNet_province);
		solo.clickInList(1);
		String s2 = getTextViewString(id_choseNet_city);
		if (!s2.equals(text_allArea)) {
			showErrLog(tag
					+ ":case_ziti_chose_net():����һ����ַ��Ϊȫ��������������һ����ַ�Ƿ��Ϊȫ������");
		}
		String s3 = getTextViewString(id_choseNet_county);
		if (!s3.equals(text_allArea)) {
			showErrLog(tag
					+ ":case_ziti_chose_net():����һ����ַ��Ϊȫ��������������һ����ַ�Ƿ��Ϊȫ������");
		}
		View city = solo.getView(id_choseNet_city);
		if (!city.isEnabled()) {
			showErrLog(tag + ":case_ziti_chose_net():����һ����ַ��Ϊȫ��������������һ����ַ�Ƿ�ɵ��");
		}
		// ѡ��ĳһ�������󷵻��ύ����ҳ��
		solo.clickInList(1);
		v(id_choseNet_buttonSure);
		if (!solo.searchText(text_send, 1, false, true)) {
			showErrLog(tag + ":case_ziti_chose_net():ѡ��ĳһ�������󷵻��ύ����ҳ��");
		}
	}

	/**
	 * �������᣺ѡ���ջ���ҳ��
	 */
	public void case_ziti_chose_people() {
		add_shoppingcart();
		// δ��д�ջ��˺��ֻ��ŵ�����£�����ȷ����ť�Ƿ��ܵ��
		v(id_join_chose_people);
		View button_sure = solo.getView(id_chosePeople_buttonSure);
		if (button_sure.isEnabled()) {
			showErrLog(tag
					+ ":case_ziti_chose_people():δ��д�ջ��˺��ֻ��ŵ�����£�����ȷ����ť�Ƿ��ܵ��");
		}
		// �ջ����������ܳ���12λ�ַ�
		enter(id_chosePeople_edit_name, getRandomString(15));
		if (getEditTextString(id_chosePeople_edit_name).length() != 12) {
			showErrLog(tag + "case_ziti_chose_people():�ջ����������ܳ���12λ�ַ�");
		}
		// ��д��ʽ������ֻ���
		enter(id_chosePeople_edit_pNum, Config.pNum_err);
		t(Config.text_sure);
		toast_equals_string(tag +  ":case_ziti_chose_people():��д��ʽ������ֻ���" ,
			log_pNum_err	);
		// ��д��ʽ��ȷ���ֻ��Ų�����
		clear(id_chosePeople_edit_pNum);
		enter(id_chosePeople_edit_pNum, Config.pNum_reg);
		t(Config.text_sure);
		// ���ص��ύ����ҳ�濴�ջ�����Ϣ�Ƿ���ȷ
		String getPeople = getTextViewString(id_join_chose_people);
		String pNum = getPeople.substring(getPeople.length() - 11,
				getPeople.length() - 1);
		if (!pNum.equals(Config.pNum_reg.toString())) {
			showErrLog(tag + ":case_ziti_chose_people():���ص��ύ����ҳ�濴�ջ�����Ϣ�Ƿ���ȷ");
		}
	}

	/**
	 * �������᣺ �ɹ��ύ����
	 */
	public void case_clearing_success() {
		add_shoppingcart();
		v(id_join_chose_net);
		solo.clickInList(1);
		v(id_choseNet_buttonSure);
		v(Config.id_shoppingcart_jiesuan);
		solo.assertCurrentActivity(tag + ":case_clearing_success():�ɹ��ύ����",
				"PaywayActivity");
		g();
		t(Config.text_homePage);
	}

	/**
	 * �����Ĳ��
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
		if (!solo.searchText("ѡ��֧������", 1, false, true)) {
			showErrLog(tag + ":case_order_separate():�����Ĳ��");
		}
		// ѡ������һ������ȥ֧��
		v("com.ksfc.newfarmer:id/go_to_pay");
		solo.assertCurrentActivity(tag + ":case_order_separate():ѡ������һ������ȥ֧��",
				"PaywayActivity");
	}

	/**
	 * �ڻ���ַҳ����ӵ�ַ
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
	 * ���������֧�����ͺ��������Ʒ���ύ������ҳ��
	 */
	void add_shoppingcart() {
		t(Config.text_shoppingcart);
		// ���ﳵ�����֧�����͵�������Ʒ�����뵽�ύ����ҳ��
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
