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

	String text_nullClient="��û�������û�Ŷ~";
	String text_delegate_sure="*��������Ӻ󲻿��޸�,����ϸ�˶�";
	String text_add="���";
	String text_client_order="�ͻ�����";
	String text_client_phone="13718603051";
	String text_bay_now="��������";
	String text_call="����";
	String text_clientRegister="�ͻ��Ǽ�";
	String text_clientParticulars="�ͻ�����";
	String text_phone_register="13333333333";//�ѵǼǹ����ֻ���
	String text_nullTown="ѡ�����ڽֵ�������";
	
	String id_myDelegate="com.ksfc.newfarmer:id/radio_button2";//��ũ����ҳ�����ҵĿͻ��л����ҵĴ���
	String id_edit_phone="com.ksfc.newfarmer:id/my_inviter_fragment_edittext";//��ũ����ҳ����������ֻ���
	String id_client_order="com.ksfc.newfarmer:id/my_inviter_nickname";//�ҵĿͻ�ҳ��鿴�ͻ�����
	String id_choose_sned="com.ksfc.newfarmer:id/deliveries_way_home";//�ύ����ҳ��ѡ�����͵���
	String id_red="com.ksfc.newfarmer:id/my_inviter_nickname_remind_dot";//�ҵĿͻ�ҳ��ͻ�����״̬���Ѻ��
	String id_jump_text_clientParticulars="com.ksfc.newfarmer:id/item_already_customer_name";//�ͻ��Ǽ�ҳ����ת���ͻ�����
	String id_call="com.ksfc.newfarmer:id/my_inviter_phone_icon";//�ҵĴ���ҳ�沦��绰
	String id_add_client="com.ksfc.newfarmer:id/add_potential_customer";//���Ǳ�ڿͻ�
	String id_client_num="com.ksfc.newfarmer:id/count_left";//�ͻ��Ǽ�ҳ�湲�Ǽǿͻ�
	String id_add_town="com.ksfc.newfarmer:id/choice_town_text";//��ӿͻ�ҳ������
	String id_add_edit_name="com.ksfc.newfarmer:id/name_tv";//��ӿͻ�ҳ������
	String id_add_edit_phone="com.ksfc.newfarmer:id/phone_tv";//��ӿͻ�ҳ���ֻ���
	String id_add_checkBox_man="com.ksfc.newfarmer:id/btn_check_item_item";//��ӿͻ�����
	String id_add_checkBox_woman="com.ksfc.newfarmer:id/btn_check_item_item1";//��ӿͻ�Ů��
	String id_add_city="com.ksfc.newfarmer:id/choice_city_layout";//��ӿͻ�ҳ��ѡ�����
	String id_add_choose_product="com.ksfc.newfarmer:id/choose_type_ll";//��ӿͻ�ҳ��ѡ�������Ʒ
	String id_add_edit_beizhu="com.ksfc.newfarmer:id/add_potential_remark";//��ӿͻ�ҳ�汸ע
	
	String log_nullPhoneNum="������һ���ֻ�����";
	String log_phoneErr="��������ֻ������ʽ����ȷ";
	String log_choose_city_first="����ѡ�����";
	String log_nullPerfect="��������Ϣ";
	String log_client_reg="�ÿͻ���ע�ᣬ������ֱ�������Ϊ��ũ�������������ٶ������ṩ����";
	String log_client_register="�ÿͻ������Ѿ��Ǽǹ�";
	String log_null_product="������ѡ��һ��������Ʒ";
	String log_add_success="��ӳɹ�";
	public void test_run() {
		case_delegate_null();
		 case_add_delegate();
		 case_delegate_jump();
		 case_add_client();
	}

	/**
	 * û�д����ͻ����˻�
	 */
	public void case_delegate_null() {

		login_sure(Config.pNum_null);
		t(Config.text_newFarmer_delegate);
		// û�пͻ����˻��ҵĿͻ�ҳ��չʾ
		if (!solo.searchText(text_nullClient, 1, false, true)) {
			showErrLog(tag + ":case_delegate_null():û�пͻ����˻��ҵĿͻ�ҳ��չʾ");
		}
		// û�д�����˻��ҵĴ���ҳ��չʾ
		v(id_myDelegate);
		if (!solo.searchText(text_delegate_sure, 1, false, true)) {
			showErrLog(tag + ":case_delegate_null():û�д�����˻��ҵĴ���ҳ��չʾ");
		}}
		/**
		 * �����ũ����Ϊ�˷����Ժ���ԣ���������ȷ�������Ĳ�����
		 */
	public void case_add_delegate(){
		login_sure(Config.pNum_null);
		t(Config.text_newFarmer_delegate);
		v(id_myDelegate);
		// δ��д�ֻ��ž����
		t(text_add);
		toast_equals_string(tag +  ":case_delegate_null():δ��д�ֻ��ž����",
				log_nullPhoneNum);
		// ��д������ֻ�����
		enter(id_edit_phone,
				Config.pNum_err);
		t(text_add);
		toast_equals_string(tag + ":case_delegate_null():��д������ֻ�����",
				log_phoneErr);
		g();
		t(Config.text_homePage);
	}

	/**
	 * �пͻ�����������֤Ϊ��ũ�����˵��˻���չʾ����ת
	 */
	public void case_delegate_jump() {
		login_sure(Config.pNum_reg);
		t(Config.text_newFarmer_delegate);
		// �ҵĿͻ�ҳ��ȥ�鿴�ͻ�����
		v(id_client_order);
		if (!solo.searchText(text_client_order)) {
			showErrLog(tag + ":case_delegate_jump():�ҵĿͻ�ҳ��ȥ�鿴�ͻ�����");
		}
		/**
		 * �ҵĿͻ�����״̬����ʱ�к����ʾ
		 */
		// ʹ�ÿͻ��˺��µ���������ũ������˻��鿴
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
		// �ͻ�����״̬�и���
		View view = solo
				.getView(id_red);
		if (view.getVisibility() != View.VISIBLE) {
			showErrLog(tag + ":case_delegate_jump():�ͻ�����״̬�и���");
		}
		// �鿴���ͻ�������С�����ʧ
		v(id_client_order);
		g();
		view = solo
				.getView(id_red);
		if (view.getVisibility() != View.INVISIBLE) {
			showErrLog(tag + ":case_delegate_jump():�鿴���ͻ�������С�����ʧ");
		}

		/**
		 * �ҵĴ���
		 */
		// ���ҵĴ���ҳ��������绰��ť
		v(id_myDelegate);
		v(id_call);
		if (!solo.searchText(text_call)) {
			showErrLog(tag + ":case_delegate_jump():�����ҵĴ���ҳ�沢���Բ���绰");
		}
		solo.clickOnButton(Config.text_cancel);

		/**
		 * �ͻ��Ǽ�
		 */
		// �ͻ��Ǽ�ҳ��鿴�ͻ�����
		t(text_clientRegister);
		v(id_jump_text_clientParticulars);
		if (!solo.searchText(text_clientParticulars)) {
			showErrLog(tag + ":case_delegate_jump():�ͻ��Ǽ�ҳ��鿴�ͻ�����");
		}
		g();
		g();
		t(Config.text_homePage);
	}

	/**
	 * ���Ǳ�ڿͻ�
	 */
	public void case_add_client() {
		login_sure(Config.pNum_reg);
		t(Config.text_newFarmer_delegate);
		t(text_clientRegister);
		int a = Integer
				.parseInt(getTextViewString(id_client_num));
		// δѡ�����ʱ����ѡ��ֵ�
		v(id_add_client);
		v(id_add_town);
		toast_equals_string(tag +":case_add_client():δѡ�����ʱ����ѡ��ֵ�" ,
				log_choose_city_first);
		// δ��д��������
		t(Config.text_save);
		toast_equals_string(tag +":case_add_client():δ��д��������" ,
				log_nullPerfect);
		// �������Ȳ��ܳ���12���ַ�
		enter(id_add_edit_name, getRandomString(16));
		if (getTextViewString(id_add_edit_name).length() != 12) {
			showErrLog(tag + ":case_add_client():�������Ȳ��ܳ���12���ַ�");
		}
		// δ��д�ֻ��ű���
		t(Config.text_save);
		toast_equals_string(tag +":case_add_client():δ��д�ֻ��ű���" ,
				log_nullPerfect);
		// ��д������ֻ���
		enter(id_add_edit_phone, Config.pNum_err);
		t(Config.text_save);
		toast_equals_string(tag + ":case_add_client():��д������ֻ���",
				log_nullPerfect);
		// ��д��ע������ֻ���
		clear(id_add_edit_phone);
		enter(id_add_edit_phone, Config.pNum_reg);
		if (!solo.searchText(log_client_reg)) {
			showErrLog(tag + ":case_add_client():��д��ע������ֻ���");
		}
		// ��д�ѵǼǹ����ֻ���
		clear(id_add_edit_phone);
		enter(id_add_edit_phone,text_phone_register );
		if (!solo.searchText(log_client_register)) {
			showErrLog(tag + ":case_add_client():��д�ѵǼǹ����ֻ���");
		}
		clear(id_add_edit_phone);
		enter(id_add_edit_phone, "133" + getRandomIntString(8));
		// ѡ���Ա�Ϊ��
		if (!solo.isCheckBoxChecked(0)) {
			v(id_add_checkBox_man);
			if (solo.isCheckBoxChecked(1)) {
				showErrLog(tag + ":case_add_client():ѡ���Ա�Ϊ��");
			}
		} else {
			v(id_add_checkBox_woman);
			if (solo.isCheckBoxChecked(0)) {
				showErrLog(tag + ":case_add_client():ѡ���Ա�ΪŮ");
			}
		}
		// δ��д����
		t(Config.text_save);
		toast_equals_string(tag + ":case_add_client():δ��д����",
				log_nullPerfect);
		// δ��д�ֵ�
		v(id_add_city);
		solo.clickInList(1);
		int line = getRandomInt(1, 12);
		solo.clickInList(line);
		if (line != 9) {
			solo.clickInList(getRandomInt(1, 5));
		}
		t(Config.text_save);
		toast_equals_string(tag +":case_add_client():δ��д�ֵ�",
				log_nullPerfect);
		// δ��д�����Ʒ����
		v(id_add_town);
		solo.clickInList(getRandomInt(1, 4));
		t(Config.text_save);
		toast_equals_string(tag +":case_add_client():δ��д�����Ʒ����",
				log_nullPerfect);
		// ����ѡ��������ֵ��Ƿ�����
		v(id_add_city);
		solo.clickInList(1);
		solo.clickInList(getRandomInt(1, 12));
		solo.clickInList(getRandomInt(1, 6));
		if (!getTextHintString(id_add_town)
				.equalsIgnoreCase(text_nullTown)) {
			showErrLog(tag + ":case_add_client(): ����ѡ��������ֵ��Ƿ�����");
		}
		// ��ѡ�������Ʒ��ȷ��
		v(id_add_town);
		solo.clickInList(getRandomInt(1, 4));
		v(id_add_choose_product);
		t(Config.text_sure);
		toast_equals_string(tag +":case_add_client():��ѡ�������Ʒ��ȷ��",
				log_null_product);
		// ��ע���Ȳ��ܳ���30�ַ�
		solo.clickInList(2);
		t(Config.text_sure);
		enter(id_add_edit_beizhu, getRandomString(40));
		if (getEditTextString(id_add_edit_beizhu)
				.length() != 30) {
			showErrLog(tag + ":case_add_client():��ע���Ȳ��ܳ���30�ַ�");
		}
		t(Config.text_save);
		// ����ɹ�
		toast_equals_string(tag + ":case_add_client():����ɹ�",
				log_add_success);
		// ���ؿͻ��Ǽ�ҳ�棬��ʱ���տ���ӿͻ�����һ
		if (Integer
				.parseInt(getTextViewString(id_client_num)) != (a - 1)) {
			showErrLog(tag + ":case_add_client():���ؿͻ��Ǽ�ҳ�棬��ʱ���տ���ӿͻ�����һ");
		}
		g();
		t(Config.text_homePage);
	}
}