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

	String text_alter_pwd = "修改密码";
	String text_finish = "完成";

	String id_edit_oldPwd = "com.ksfc.newfarmer:id/backedit1";// 修改密码页面输入旧密码
	String id_edit_newPwd = "com.ksfc.newfarmer:id/backnewpassword";// 修改密码页面输入新密码
	String id_edit_surePwd = "com.ksfc.newfarmer:id/confimPasword";// 修改密码页面输入确认密码

	String log_nullOldPwd = "请输入旧密码";
	String log_nullNewPwd = "请输入新密码";
	String log_nullSurePwd = "请输入确认密码";
	String log_oldPwd_err = "旧密码输入错误";
	String log_pwd_same = "新密码与旧密码不能一致";
	String log_pwd_different = "两次密码不一致，请重新输入";
	String log_pwd_short = "密码需不小于6位";
	String log_alter_success = "修改密码成功";

	public void test_ren() {
		case_alter_pwd();

	}

	/**
	 * 修改密码
	 */
	public void case_alter_pwd() {
		login_sure(Config.pNum_reg);
		v(Config.id_jump_myself);
		t(text_alter_pwd);
		// 未输入任何密码
		t(text_finish);
		toast_equals_string(tag + ":case_alter_pwd():未输入任何密码", log_nullOldPwd);

		// 只输入旧密码
		enter(id_edit_oldPwd, Config.pwd_err);
		t(text_finish);
		toast_equals_string(tag + ":case_alter_pwd():只输入旧密码", log_nullNewPwd);

		// 未输入确认密码
		enter(id_edit_newPwd, Config.pwd_cur);
		t(text_finish);
		toast_equals_string(tag + log_nullSurePwd, log_nullSurePwd);

		// 输入错误的旧密码
		enter(id_edit_surePwd, Config.pwd_cur);
		t(text_finish);
		toast_equals_string(tag + ":case_alter_pwd():输入错误的旧密码", log_oldPwd_err);

		// 输入的新旧密码一致
		clear(id_edit_oldPwd);
		enter(id_edit_oldPwd, Config.pwd_cur);
		t(text_finish);
		toast_equals_string(tag + ":case_alter_pwd():输入的新旧密码一致", log_pwd_same);

		// 新密码和确认密码不一致
		clear(id_edit_newPwd);
		enter(id_edit_newPwd, Config.pwd_err);
		t(text_finish);
		toast_equals_string(tag + ":case_alter_pwd(): 新密码和确认密码不一致",
				log_pwd_different);

		// 新密码与确认密码小于6位
		clear(id_edit_surePwd);
		enter(id_edit_surePwd, Config.pwd_err);
		t(text_finish);
		toast_equals_string(tag + ":case_alter_pwd(): 新密码与确认密码小于6位",
				log_pwd_short);

		// 修改密码成功
		clear(id_edit_newPwd);
		enter(id_edit_newPwd, Config.pwd_new);
		clear(id_edit_surePwd);
		enter(id_edit_surePwd, Config.pwd_new);
		t(text_finish);
		toast_equals_string(tag + ":case_alter_pwd(): 修改密码成功",
				log_alter_success);

	}
}
