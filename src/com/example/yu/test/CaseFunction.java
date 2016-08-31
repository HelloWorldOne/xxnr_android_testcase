package com.example.yu.test;

import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;

public class CaseFunction extends BaseCase {

	public String tag = " CaseFunction";

	public static CaseFunction caseInstance(Solo solo1) {
		CaseFunction instance = new CaseFunction();
		instance.instance(solo1);
		return instance;
	}

	/**
	 * ע��ҳ��
	 */
	String text_register = "����ע��";// ����ע�ᰴť
	String text_getVerification = "��ѻ�ȡ��֤��";// ע��ҳ����ѻ�ȡ��֤�밴ť
	String text_sure = "ȷ��";// ȷ����ť
	String text_anquanyanzheng = "��ȫ��֤";
	String text_forgetPWd = "��������?";
	String text_login = "��¼";
	String text_jump = "����";

	String log_nullPhongNum = "�������ֻ���";// ע��ҳ��δ�����ֻ��ŵ���ʾlog
	String log_phoneReg = "���ֻ�����ע�ᣬ����������";// ע��ҳ��������ע���ֻ��ŵ���ʾLog
	String log_phoneErr = "��������ȷ���ֻ���";// ע��ҳ����д�����ֻ��ŵ���ʾlog
	String log_nullVerification = "��������֤��";// ע��ҳ��δ������֤�����ʾLog
	String log_nullPassWord = "����������";// ע��ҳ��δ����������ʾlog
	String log_nullSurePassWord = "������ȷ������";// ע��ҳ��δ����ȷ��������ʾlog
	String log_shortPassWord = "���볤�Ȳ�С��6λ";// ע��ҳ�������ȷ�����벻����λ��ʾlog
	String log_differentPassWord = "�������벻һ�£�����������";// ע��ҳ���������벻һ����ʾlog
	String log_verification_overdue = "��֤���ѹ��ڣ������»�ȡ";// ��֤�������ʾlog
	String log_verification_nofind="û�в��ҵ���֤��";
	String log_verification_err = "��֤���������";// ��֤�������ʾlog
	String log_nullPictureVerification = "������ͼ����֤��";// δ����ͼ����֤����ʾlog
	String log_pictureVerification_err = "ͼ����֤�����";// ͼ����֤�������ʾlog

	String id_edit_phoneNum = "com.ksfc.newfarmer:id/backedit1";// ע��ҳ�������ֻ���
	String id_edit_enterPictureVerification = "com.ksfc.newfarmer:id/sms_auth_code_et";// ע��ҳ�����ͼ����֤��
	String id_edit_enterVerification = "com.ksfc.newfarmer:id/backyanzhengma";// ע��ҳ��������֤��
	String id_edit_enterPassWord = "com.ksfc.newfarmer:id/backnewpassword";// ע��ҳ����������
	String id_edit_enterSurePassWord = "com.ksfc.newfarmer:id/confimPasword";// ע��ҳ������ȷ������
	String id_checkBok = "com.ksfc.newfarmer:id/check_box";// ע��ҳ�渴ѡ��

	/**
	 * ��¼ҳ��
	 */
	String id_edit_login_pNum = "com.ksfc.newfarmer:id/login_layout_phone";// �����ֻ���
	String id_edit_login_pwd = "com.ksfc.newfarmer:id/login_layoutpassword";// ��������

	String text_login_sure = "ȷ�ϵ�¼";// ȷ�ϵ�¼��ť

	String log_pNumUnreg = "���ֻ���δע�ᣬ����������";// ����δע����ֻ���
	String log_pwdErr = "�����������������";// ������������

	/**
	 * ��������ҳ��
	 */
	String text_finish = "���";

	String log_froget_differentPwd = "�������벻һ�£�����������";

	// ����
	public void test_run() {
		close_huodong();
		case_register();
		case_loginTest();
		case_forgetPassword();
	}

	/**
	 * ע��ҳ��
	 */
	public void case_register() {
		// ����ע�����
		login();
		t(text_register);
		// δ��д�ֻ���
		t(text_register);
		toast_equals_string(tag + ":case_register() :δ��д�ֻ���", log_nullPhongNum);

		// ��ע����ֻ���
		enter(id_edit_phoneNum, Config.pNum_reg);
		t(text_getVerification);
		toast_equals_string(tag + ":case_register()��ע����ֻ���:", log_phoneReg);

		// ��ʽ������ֻ���
		clear(id_edit_phoneNum);
		enter(id_edit_phoneNum, Config.pNum_err);
		t(text_register);
		toast_equals_string(tag + ":case_register():��ʽ������ֻ���", log_phoneErr);

		// ��Ҫ��дͼ����֤�룬����ͼ����֤�봰��
		clear(id_edit_phoneNum);
		enter(id_edit_phoneNum, Config.pNum_unReg);
		t(text_getVerification);
		if (!solo.searchText(text_anquanyanzheng, true)) {
			g();
			t(text_register);
			enter(id_edit_phoneNum, Config.pNum_reg);
			t(text_getVerification);
		}
		if (!solo.searchText(text_anquanyanzheng, true)) {
			showErrLog(tag + ": case_register():��Ҫ��дͼ����֤�룬����ͼ����֤�봰��");
		}
		// û����дͼ����֤��
		solo.clickOnButton(text_sure);
		if (!solo.searchText(log_nullPictureVerification, true)) {
			showErrLog(tag + ":case_register() :û����дͼ����֤��");
		}
		// ͼ����֤�����
		enter(id_edit_enterPictureVerification, getRandomString(3));
		solo.clickOnButton(text_sure);
		if (!solo.searchText(log_pictureVerification_err, true)) {
			showErrLog(tag + ":case_register() :ͼ����֤�����");
		}
		solo.clickOnButton(Config.text_cancel);
		// δ��д��֤��
		t(text_register);
		toast_equals_string(tag + ":case_register():δ��д��֤��",
				log_nullVerification);
		// δ��д����
		enter(id_edit_enterVerification, getRandomIntString(4));
		t(text_register);
		toast_equals_string(tag + ":case_register():δ��д����", log_nullPassWord);

		// δ��дȷ������
		enter(id_edit_enterPassWord, Config.pwd_err);
		t(text_register);
		toast_equals_string(tag + ":case_register():δ��дȷ������",
				log_nullSurePassWord);
		// �����ȷ�����������λ
		enter(id_edit_enterSurePassWord, Config.pwd_err);
		t("����ע��");
		toast_equals_string(tag + ":case_register():�����ȷ�����������λ",
				log_shortPassWord);
		// ������ȷ�����벻һ��
		clear(id_edit_enterPassWord);
		enter(id_edit_enterPassWord, Config.pwd_cur);
		t(text_register);
		toast_equals_string(tag + ":case_register():������ȷ�����벻һ��",
				log_differentPassWord);
		// δ��ѡ�û�Э��
		clear(id_edit_enterSurePassWord);
		enter(id_edit_enterSurePassWord, Config.pwd_cur);
		if (solo.isCheckBoxChecked(0)) {
			v(id_checkBok);
		}
		t(text_register);
		toast_equals_string(tag + ":case_register():δ��ѡ�û�Э��", "��ͬ����վʹ��Э��");
		// �鿴�û�Э��
		v("com.ksfc.newfarmer:id/register_layoutxieyi");
		g();
		// ��֤������û�в��ҵ���֤��
		v(id_checkBok);
		t(text_register);
		String get=getToast(2);
		if (!(get.equals(log_verification_overdue) | get
				.equals(log_verification_nofind))) {
			showErrLog(tag + ":case_()forgetPassword:��֤�����" + "aim:"
					+ log_verification_err + "or" + log_verification_overdue
					+ "get:" + get);
		}

		// ��ת��¼ҳ��
		t(text_login);
		solo.assertCurrentActivity(tag + ":register(): ��ת��¼ҳ��",
				Config.AcName_login);
		g();
		t(Config.text_homePage);

	}

	// ��¼����
	public void case_loginTest() {
		login();
		// ��¼ҳ��������ҳ�����ת
		t(text_forgetPWd);
		solo.assertCurrentActivity(tag + "testLogin():��¼ҳ��������ҳ�����ת",
				"RetrievePasswordActivity");
		g();
		t(text_register);
		solo.assertCurrentActivity(tag + "testLogin():��¼ҳ��������ҳ�����ת",
				"RegisterActivity");
		g();

		// ��¼�������ϲ����Ƶ��˻�
		clear(id_edit_login_pNum);
		enter(id_edit_login_pNum, Config.pNum_null);
		enter(id_edit_login_pwd, Config.pwd_cur);
		t(text_login_sure);
		solo.assertCurrentActivity(tag + ":testLogin():��¼�������ϲ����Ƶ��˻�",
				"ImprovePersonActivity");
		t(text_jump);
		// δ�����ֻ���
		t(Config.text_homePage);
		login();
		clear(id_edit_login_pNum);
		t(text_login_sure);
		toast_equals_string(tag + ":case_loginTest():δ�����ֻ���", log_nullPhongNum);
		// ��ʽ������ֻ���
		enter(id_edit_login_pNum, Config.pNum_err);
		t(text_login_sure);
		toast_equals_string(tag + ":case_loginTest():��ʽ������ֻ���", log_phoneErr);
		// ����δע����ֻ���
		clear(id_edit_login_pNum);
		enter(id_edit_login_pNum, Config.pNum_unReg);
		enter(id_edit_login_pwd, Config.pwd_cur);
		t(text_login_sure);
		toast_equals_string(tag + ":case_loginTest():����δע����ֻ���", log_pNumUnreg);

		// δ��������
		clear(id_edit_login_pNum);
		enter(id_edit_login_pNum, Config.pNum_reg);
		clear(id_edit_login_pwd);
		t(text_login_sure);
		toast_equals_string(tag + ":case_loginTest():δ��������", log_nullPassWord);

		// �����������
		enter(id_edit_login_pwd, Config.pwd_err);
		t(text_login_sure);
		toast_equals_string(tag + ":case_loginTest():�����������", log_pwdErr);

		// ��¼�����������Ƶ��˻�
		clear(id_edit_login_pNum);
		enter(id_edit_login_pNum, Config.pNum_reg);
		clear(id_edit_login_pwd);
		enter(id_edit_login_pwd, Config.pwd_cur);
		t(text_login_sure);
		solo.assertCurrentActivity(tag + ":testLogin():��¼�����������Ƶ��˻�",
				"MainActivity");
		t(Config.text_homePage);
	}

	// ��������ҳ��
	public void case_forgetPassword() {
		// ������������ҳ��
		login();
		t(text_forgetPWd);
		// δ��д�ֻ���
		t(text_finish);
		toast_equals_string(tag + ":case_()forgetPassword:δ��д�ֻ���",
				log_nullPhongNum);
		// ��ʽ������ֻ���
		enter(id_edit_phoneNum, Config.pNum_err);
		t(text_finish);
		toast_equals_string(tag + ":case_()forgetPassword:��ʽ������ֻ���",
				log_phoneErr);
		// δע����ֻ���
		clear(id_edit_phoneNum);
		enter(id_edit_phoneNum, Config.pNum_unReg);
		t(text_getVerification);
		toast_equals_string(tag + ":case_()forgetPassword:δע����ֻ���",
				log_pNumUnreg);

		// �����������������֤�룬����ͼƬ��֤��
		clear(id_edit_phoneNum);
		enter(id_edit_phoneNum, Config.pNum_reg);
		t(text_getVerification);
		if (!solo.searchText(text_anquanyanzheng, true)) {
			g();
			t(text_forgetPWd);
			enter(id_edit_phoneNum, Config.pNum_reg);
			t(text_getVerification);
		}
		if (!solo.searchText(text_anquanyanzheng, true)) {
			showErrLog(tag + ":case_forgetPassword():�����������������֤�룬����ͼƬ��֤��");
		}
		// û����дͼ����֤��
		solo.clickOnButton(Config.text_sure);
		if (!solo.searchText(log_nullPictureVerification, true)) {
			showErrLog(tag + ":case_forgetPassword() :û����дͼ����֤��");
		}
		// ͼ����֤�����
		enter(id_edit_enterPictureVerification, getRandomString(3));
		solo.clickOnButton(Config.text_sure);
		if (!solo.searchText(log_pictureVerification_err, true)) {
			showErrLog(tag + ":case_forgetPassword() :ͼ����֤�����");
		}
		solo.clickOnButton(Config.text_cancel);

		// δ��д��֤��
		t(text_finish);
		toast_equals_string(tag + ":case_()forgetPassword:δ��д��֤��",
				log_nullVerification);

		// δ��д������
		enter(id_edit_enterVerification, getRandomIntString(4));// ������Ǵ������֤��
		t(text_finish);
		toast_equals_string(tag + ":case_()forgetPassword:δ��д������",
				log_nullPassWord);

		// δ��дȷ������
		enter(id_edit_enterPassWord, Config.pwd_err);
		t(text_finish);
		toast_equals_string(tag + ":case_()forgetPassword:δ��дȷ������",
				log_nullSurePassWord);

		// ������ȷ�������ʽ����ȷС����λ
		enter(id_edit_enterSurePassWord, Config.pwd_err);
		t(text_finish);
		toast_equals_string(tag + ":case_()forgetPassword:������ȷ�������ʽ����ȷС����λ",
				log_shortPassWord);

		// ������ȷ�����벻һ��
		clear(id_edit_enterPassWord);
		enter(id_edit_enterPassWord, Config.pwd_cur);// �������Ϊ��ȷ������
		t(text_finish);
		toast_equals_string(tag + ":case_()forgetPassword: ������ȷ�����벻һ��",
				log_froget_differentPwd);

		// ��֤�����
		clear(id_edit_enterSurePassWord);
		enter(id_edit_enterSurePassWord, Config.pwd_cur);
		t(Config.text_finish);
		String get = getToast(2);
		if (!(get.equals(log_verification_overdue) | get
				.equals(log_verification_err))) {
			showErrLog(tag + ":case_()forgetPassword:��֤�����" + "aim:"
					+ log_verification_nofind + "or" + log_verification_overdue
					+ "get:" + get);
		}

		g();
		g();// ���ص��ҵ�ҳ��
	}
}
