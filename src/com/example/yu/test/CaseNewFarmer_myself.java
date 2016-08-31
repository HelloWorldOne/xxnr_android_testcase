package com.example.yu.test;

import android.view.View;
import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;

public class CaseNewFarmer_myself extends BaseCase {

	public String tag = " CaseNewFarmer_myself";

	public static CaseNewFarmer_myself caseInstance(Solo solo1) {
		CaseNewFarmer_myself instance = new CaseNewFarmer_myself();
		instance.instance(solo1);
		return instance;
	}

	String text_shangchuan = "�����ϴ�";
	String text_nickname = "�ҵ��ǳ�";
	String text_name = "����";
	String text_sex = "�Ա�";
	String text_man = "��";
	String text_woman = "Ů";
	String text_address = "���ڵ���";
	String text_chosse_town = "��ѡ��ֵ�";
	String text_genre = "����";
	String text_genre_common = "��ͨ�û�";
	String text_genre_agent = "��ũ������";
	String text_genre_town_business = "�ؼ�������";
	String text_check_information = "�鿴��֤��Ϣ";
	String text_nullUser_show = "���Ϊ����ũ�˵��ؼ����㣿ȥ������֤��";

	String id_headPortrait = "com.ksfc.newfarmer:id/header_image_ll";// ������Ϣͷ��
	String id_myself_save = "com.ksfc.newfarmer:id/name_submit_tv";// ������Ϣ���¼�ҳ�汣�水ť
	String id_alterName_edit_name = "com.ksfc.newfarmer:id/et_modify";// �޸��ǳ�(����)ҳ�������ǳ�
	String id_sex = "com.ksfc.newfarmer:id/sex_tv";// ������Ϣҳ����ʵ���Ա�
	String id_chooseSex_man = "com.ksfc.newfarmer:id/btn_sure";// �Ա�ѡ��ҳ��ѡ����
	String id_chooseSex_woman = "com.ksfc.newfarmer:id/btn_normal";// �Ա�ѡ��ҳ��ѡ��Ů
	String id_address_city = "com.ksfc.newfarmer:id/choice_city_layout";// �޸ĵ���ҳ���޸ĵ���
	String id_address_town = "com.ksfc.newfarmer:id/choice_town_text";// �޸ĵ���ҳ���޸Ľֵ�
	String id_user_genre = "com.ksfc.newfarmer:id/type_tv";// ������Ϣҳ��չʾ���û�����
	String id_jump_check_information = "com.ksfc.newfarmer:id/choose_type_Certified_ll";// ������Ϣҳ����ת���鿴��֤��Ϣҳ��

	String log_nuperfect = "������������Ϣ";
	String log_save_success = "����ɹ�";
	String log_nullAddress = "��ַ����Ϊ��";

	public void test_run() {
		case_myself();
		 case_myself_name();
		 case_myself_sex();
		 case_myself_address();
		 case_user_genre();
	}

	/**
	 * ������Ϣ
	 */
	public void case_myself() {
		login_sure(Config.pNum_reg);
		v(Config.id_jump_myself);
		// �޸�ͷ��
		v(id_headPortrait);
		if (!solo.searchText(text_shangchuan, 1, false, true)) {
			showErrLog(tag + ":case_myself():�޸�ͷ��");
		}
		t(Config.text_cancel);

		/**
		 * �޸��ǳ�
		 */
		t(text_nickname);
		// δ�޸��ǳƣ����水ť���ɵ��
		View view = solo.getView(id_myself_save);
		if (view.isEnabled()) {
			showErrLog(tag + ":case_myself():δ�޸��ǳƣ����水ť���ɵ��");
		}
		// �����ǳƵ�ǰ��������ǳƱ���
		clear(id_alterName_edit_name);
		t(Config.text_save);
		toast_equals_string(tag + ":case_myself():�����ǳƵ�ǰ��������ǳ�", log_nuperfect);
		// �޸��ǳƳ���12λ�ַ�
		enter(id_alterName_edit_name, getRandomString(16));
		String nicheng = getEditTextString(id_alterName_edit_name);
		if (nicheng.length() != 12) {
			showErrLog(tag + ":case_newFarmer_information():�޸��ǳƳ���12λ�ַ�");
		}
		// �����ǳ�
		t(Config.text_save);
		toast_equals_string(tag + ":case_newFarmer_information():�����ǳ�",
				log_save_success);
	}

	/**
	 * ������Ϣҳ���޸�����
	 */
	public void case_myself_name() {
		login_sure(Config.pNum_reg);
		v(Config.id_jump_myself);
		// δ�޸����������水ť���ɵ��
		t(text_name);
		View view = solo.getView(id_myself_save);
		if (view.isEnabled()) {
			showErrLog(tag + ":case_myself_name():δ�޸����������水ť���ɵ��");
		}
		// ����Ϊ��ʱ����
		clear(id_alterName_edit_name);
		t(Config.text_save);
		toast_equals_string(tag + ":case_myself_name(): ����Ϊ��ʱ����", log_nuperfect);
		// �޸���������12λ�ַ�
		enter(id_alterName_edit_name, getRandomString(17));
		String name = getEditTextString(id_alterName_edit_name);
		if (name.length() != 12) {
			showErrLog(tag + ":case_myself_name():�޸���������12λ�ַ�");
		}
		// ��������
		t(Config.text_save);
		toast_equals_string(tag + ":case_myself_name():��������", log_save_success);
	}

	/**
	 * �޸��Ա�
	 */
	public void case_myself_sex() {
		login_sure(Config.pNum_reg);
		v(Config.id_jump_myself);
		String sex = getTextViewString(id_sex);
		t(text_sex);
		// ȡ��ѡ���Ա�
		t(Config.text_cancel);
		String sex_change = getTextViewString(id_sex);
		if (!sex.equals(sex_change)) {
			showErrLog(tag + ":case_myself_sex():ȡ��ѡ���Ա�");
		}
		// ���Ա��޸�Ϊ��
		t(text_sex);
		v(id_chooseSex_man);
		toast_equals_string(tag + ":case_myself_sex():���Ա��޸�Ϊ��",
				log_save_success);
		sex_change = getTextViewString(id_sex);
		if (!sex_change.equals(text_man)) {
			showErrLog(tag + ":case_myself_sex():���Ա��޸�Ϊ��");
		}
		// ���Ա��޸�ΪŮ
		t(text_sex);
		v(id_chooseSex_woman);
		toast_equals_string(tag + ":case_myself_sex():���Ա��޸�ΪŮ",
				log_save_success);
		sex_change = getTextViewString(id_sex);
		if (!sex_change.equals(text_woman)) {
			showErrLog(tag + ":case_myself_sex():���Ա��޸�ΪŮ");
		}
	}

	/**
	 * �û����ڵ���
	 */
	public void case_myself_address() {
		login_sure(Config.pNum_reg);
		v(Config.id_jump_myself);
		// δ�޵��������水ť���ɵ��
		t(text_address);
		View view = solo.getView(id_myself_save);
		if (view.isEnabled()) {
			showErrLog(tag + ":case_myself_address():δ�޵��������水ť���ɵ��");
		}

		// ������ȷ��д��ַ������޸ĵ������鿴�ֵ��Ƿ���֮�仯
		v(id_address_city);
		solo.clickInList(1);
		solo.clickInList(getRandomInt(1, 12));
		solo.clickInList(getRandomInt(1, 4));
		if (!getTextHintString(id_address_town).equals(text_chosse_town)) {
			showErrLog(tag
					+ ":case_myself_address():������ȷ��д��ַ������޸ĵ������鿴�ֵ��Ƿ���֮�仯");
		}
		// δ��д�ֵ�����±���
		t(Config.text_save);
		toast_equals_string(tag + ":case_myself_address():δ��д�ֵ�����±���",
				log_nullAddress);
		// ��ȷ�������
		v(id_address_town);
		solo.clickInList(getRandomInt(1, 5));
		t(Config.text_save);
		toast_equals_string(tag + ":case_myself_address():��ȷ�������",
				log_save_success);
	}

	/**
	 * �����û�����
	 */
	public void case_user_genre() {
		login_sure(Config.pNum_reg);
		v(Config.id_jump_myself);
		// ��ͨ�û�
		t(text_genre);
		t(text_genre_common);
		toast_equals_string(tag + ":case_user_genre():��ͨ�û�", log_save_success);
		if (!getTextViewString(id_user_genre).equals(text_genre_common)) {
			showErrLog(tag + ":case_user_genre():��ͨ�û�");
		}
		// ��ũ������
		t(text_genre);
		t(text_genre_agent);
		toast_equals_string(tag + ":case_user_genre():��ũ������", log_save_success);
		if (!getTextViewString(id_user_genre).equals(text_genre_agent)) {
			showErrLog(tag + ":case_user_genre():��ũ������");
		}
		// �ؼ�������
		t(text_genre);
		t(text_genre_town_business);
		toast_equals_string(tag + ":case_user_genre():�ؼ�������", log_save_success);
		if (!getTextViewString(id_user_genre).equals(text_genre_town_business)) {
			showErrLog(tag + ":case_user_genre():�ؼ�������");
		}
		// ��������֤���ؼ������̿��Բ鿴��֤��Ϣ
		if (!solo.searchText(text_check_information)) {
			showErrLog(tag + ":case_user_genre():��������֤���ؼ������̿��Բ鿴��֤��Ϣ");
		}
		// �鿴��֤��Ϣ
		v(id_jump_check_information);
		if (!solo.searchText(text_name)) {
			showErrLog(tag + ":case_user_genre():�鿴��֤��Ϣ");
		}
		g();
		// δ�����ؼ�������֤���˻�
		g();
		t(Config.text_homePage);
		login_sure(Config.pNum_null);
		v(Config.id_jump_myself);
		if (!solo.searchText(text_nullUser_show)) {
			showErrLog(tag + ":case_user_genre():δ�����ؼ�������֤���˻�");
		}
		g();
		g();
	}

}