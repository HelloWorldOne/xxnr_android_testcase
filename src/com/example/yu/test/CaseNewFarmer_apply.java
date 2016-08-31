package com.example.yu.test;

import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;

public class CaseNewFarmer_apply extends BaseCase {

	public String tag = " CaseNewFarmer_apply";

	public static CaseNewFarmer_apply caseInstance(Solo solo1) {
		CaseNewFarmer_apply instance = new CaseNewFarmer_apply();
		instance.instance(solo1);
		return instance;
	}

	String text_businessman_county = "�ؼ�������";
	String text_genre = "����";
	String text_submit = "�ύ";
	String text_choose_town = "ѡ�����ڽֵ�������";

	String id_jump_apply = "com.ksfc.newfarmer:id/choose_type_Certified_ll";// ������Ϣҳ��
																			// ���뵽����վ��֤ҳ��
	String id_choose_city = "com.ksfc.newfarmer:id/choice_city_layout";// ����վ��֤ҳ��ѡ������
	String id_choose_town = "com.ksfc.newfarmer:id/choice_town_layout";// ����վ��֤ҳ��ѡ��ֵ�
	String id_edit_name = "com.ksfc.newfarmer:id/name_tv";// ��֤ҳ����������
	String id_edit_identity = "com.ksfc.newfarmer:id/id_card_number_tv";// ��֤ҳ��ʡ��֤
	String id_edit_store_name = "com.ksfc.newfarmer:id/store_name_tv";// ��֤ҳ���ŵ�����
	String id_edit_phoneNum = "com.ksfc.newfarmer:id/phone_tv";// ��֤ҳ���ֻ���
	String id_edit_address = "com.ksfc.newfarmer:id/store_address_tv";// ��֤ҳ����ϸ��ַ

	String log_nullCity = "����ѡ�����";
	String log_nullPerfect = "��������Ϣ";
	String log_phoneNum_err = "�����ֻ��Ż������֤�����Ƿ���ȷ";

	public void test_run() {
		case_newFarmer_business();
	}

	/**
	 * ��֤�ؼ�������
	 */
	public void case_newFarmer_business() {
		login_sure(Config.pNum_null);
		t(Config.text_mine);
		v(Config.id_jump_myself);
		if (!(solo.searchText(text_businessman_county, 1, false, true))) {
			t(text_genre);
			t(text_businessman_county);
		}
		v(id_jump_apply);

		// ��û��ѡ�����������¾�ȥѡ��ֵ�
		v(id_choose_town);
		toast_equals_string(tag
				+ ":case_newFarmer_business():��û��ѡ�����������¾�ȥѡ��ֵ�", log_nullCity);
		// û����д�����ύ
		t(text_submit);
		toast_equals_string(tag + ":case_newFarmer_business():û����д�����ύ",
				log_nullPerfect);
		// �������ܳ���12λ�ַ�
		enter(id_edit_name, getRandomString(16));
		if (getEditTextString(id_edit_name).length() != 12) {
			showErrLog(tag + ":case_newFarmer_business():�������ܳ���12λ�ַ�");
		}
		// δ��д���֤��
		t(text_submit);
		toast_equals_string(tag + ":case_newFarmer_business(): δ��д���֤��",
				log_nullPerfect);
		// δ��д�ŵ�
		enter(id_edit_identity, getRandomIntString(18));
		t(text_submit);
		toast_equals_string(tag + ":case_newFarmer_business():δ��д�ŵ�",
				log_nullPerfect);
		// �ŵ겻�ܳ���40���ַ�
		enter(id_edit_store_name, getRandomString(50));
		if (getEditTextString(id_edit_store_name).length() != 40) {
			showErrLog(tag + ":case_newFarmer_business():�ŵ겻�ܳ���40���ַ�");
		}
		// δ��д��ϵ�绰
		t(text_submit);
		toast_equals_string(tag + ":case_newFarmer_business(): δ��д��ϵ�绰",
				log_nullPerfect);
		// δ��д����
		enter(id_edit_phoneNum, Config.pNum_err);
		t(text_submit);
		toast_equals_string(tag + ":case_newFarmer_business(): δ��д����",
				log_nullPerfect);
		// δ��д�ֵ�
		v(id_choose_city);
		solo.clickInList(1);
		s();
		solo.clickInList(getRandomInt(1, 12));
		s();
		solo.clickInList(getRandomInt(1, 5));
		s();
		t(text_submit);
		toast_equals_string(tag + ":case_newFarmer_business(): δ��д�ֵ�",
				log_nullPerfect);
		// δ��д��ϸ��ַ
		v(id_choose_town);
		solo.clickInList(getRandomInt(1, 7));
		t(text_submit);
		toast_equals_string(tag + ":case_newFarmer_business():δ��д��ϸ��ַ",
				log_nullPerfect);
		// ��ѡ�������ֵ��Ƿ�����
		v(id_choose_city);
		solo.clickInList(1);
		s();
		solo.clickInList(getRandomInt(1, 12));
		s();
		solo.clickInList(getRandomInt(1, 5));
		s();
		if (!getTextHintString(id_choose_town).equals(text_choose_town)) {
			showErrLog(tag + ":case_newFarmer_business():��ѡ�������ֵ��Ƿ�����");
		}
		// ��ϸ��ַ���ܳ���60λ�ַ�
		v(text_choose_town);
		solo.clickInList(getRandomInt(1, 7));
		enter(id_edit_address, getRandomString(70));
		if (getEditTextString(id_edit_address).length() != 60) {
			showErrLog(tag + ":case_newFarmer_business():��ϸ��ַ���ܳ���60λ�ַ�");
		}
		// ��д��ʽ������ֻ���
		t(text_submit);
		toast_equals_string(tag + ":case_newFarmer_business():��д��ʽ������ֻ���",
				log_phoneNum_err);
		// �ύ��ʽ��������֤��
		clear(id_edit_phoneNum);
		enter(id_edit_phoneNum, Config.pNum_reg);
		clear(id_edit_identity);
		enter(id_edit_identity, getRandomIntString(6));
		t(text_submit);
		toast_equals_string(tag + ":case_newFarmer_business():�ύ��ʽ��������֤��",
				log_phoneNum_err);

		/**
		 * ���ڹ��̲����棬Ϊ�˷����β��ԣ��ʲ�������ȷ��ʽ�ı���
		 */
		g();
		g();
		t(Config.text_homePage);
	}
}