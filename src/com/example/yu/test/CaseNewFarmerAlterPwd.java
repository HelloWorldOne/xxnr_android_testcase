package com.example.yu.test;

import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;

public class CaseNewFarmerAlterPwd extends BaseCase {

	public String tag = " CaseNewFarmerAlterPwd";

	public static CaseNewFarmerAlterPwd caseInstance(Solo solo1) {
		CaseNewFarmerAlterPwd instance = new CaseNewFarmerAlterPwd();
		instance.instance(solo1);
		return instance;

	}

	String text_alter_pwd = "�޸�����";
	String text_finish = "���";

	String id_edit_oldPwd = "com.ksfc.newfarmer:id/backedit1";// �޸�����ҳ�����������
	String id_edit_newPwd = "com.ksfc.newfarmer:id/backnewpassword";// �޸�����ҳ������������
	String id_edit_surePwd = "com.ksfc.newfarmer:id/confimPasword";// �޸�����ҳ������ȷ������

	String log_nullOldPwd = "�����������";
	String log_nullNewPwd = "������������";
	String log_nullSurePwd = "������ȷ������";
	String log_oldPwd_err = "�������������";
	String log_pwd_same = "������������벻��һ��";
	String log_pwd_different = "�������벻һ�£�����������";
	String log_pwd_short = "�����費С��6λ";
	String log_alter_success = "�޸�����ɹ�";

	public void test_ren() {
		case_alter_pwd();

	}

	/**
	 * �޸�����
	 */
	public void case_alter_pwd() {
		login_sure(Config.pNum_reg);
		v(Config.id_jump_myself);
		t(text_alter_pwd);
		// δ�����κ�����
		t(text_finish);
		toast_equals_string(tag + ":case_alter_pwd():δ�����κ�����", log_nullOldPwd);

		// ֻ���������
		enter(id_edit_oldPwd, Config.pwd_err);
		t(text_finish);
		toast_equals_string(tag + ":case_alter_pwd():ֻ���������", log_nullNewPwd);

		// δ����ȷ������
		enter(id_edit_newPwd, Config.pwd_cur);
		t(text_finish);
		toast_equals_string(tag + log_nullSurePwd, log_nullSurePwd);

		// �������ľ�����
		enter(id_edit_surePwd, Config.pwd_cur);
		t(text_finish);
		toast_equals_string(tag + ":case_alter_pwd():�������ľ�����", log_oldPwd_err);

		// ������¾�����һ��
		clear(id_edit_oldPwd);
		enter(id_edit_oldPwd, Config.pwd_cur);
		t(text_finish);
		toast_equals_string(tag + ":case_alter_pwd():������¾�����һ��", log_pwd_same);

		// �������ȷ�����벻һ��
		clear(id_edit_newPwd);
		enter(id_edit_newPwd, Config.pwd_err);
		t(text_finish);
		toast_equals_string(tag + ":case_alter_pwd(): �������ȷ�����벻һ��",
				log_pwd_different);

		// ��������ȷ������С��6λ
		clear(id_edit_surePwd);
		enter(id_edit_surePwd, Config.pwd_err);
		t(text_finish);
		toast_equals_string(tag + ":case_alter_pwd(): ��������ȷ������С��6λ",
				log_pwd_short);

		// �޸�����ɹ�
		clear(id_edit_newPwd);
		enter(id_edit_newPwd, Config.pwd_new);
		clear(id_edit_surePwd);
		enter(id_edit_surePwd, Config.pwd_new);
		t(text_finish);
		toast_equals_string(tag + ":case_alter_pwd(): �޸�����ɹ�",
				log_alter_success);

	}
}
