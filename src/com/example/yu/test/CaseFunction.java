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
	 * 注册页面
	 */
	String text_register = "立即注册";// 立即注册按钮
	String text_getVerification = "免费获取验证码";// 注册页面免费获取验证码按钮
	String text_sure = "确定";// 确定按钮
	String text_anquanyanzheng = "安全验证";
	String text_forgetPWd = "忘记密码?";
	String text_login = "登录";
	String text_jump = "跳过";

	String log_nullPhongNum = "请输入手机号";// 注册页面未输入手机号的提示log
	String log_phoneReg = "该手机号已注册，请重新输入";// 注册页面输入已注册手机号的提示Log
	String log_phoneErr = "请输入正确的手机号";// 注册页面填写错误手机号的提示log
	String log_nullVerification = "请输入验证码";// 注册页面未输入验证码的提示Log
	String log_nullPassWord = "请输入密码";// 注册页面未输入密码提示log
	String log_nullSurePassWord = "请输入确认密码";// 注册页面未输入确认密码提示log
	String log_shortPassWord = "密码长度不小于6位";// 注册页面密码和确认密码不足六位提示log
	String log_differentPassWord = "两次密码不一致，请重新输入";// 注册页面两次密码不一致提示log
	String log_verification_overdue = "验证码已过期，请重新获取";// 验证码过期提示log
	String log_verification_nofind="没有查找到验证码";
	String log_verification_err = "验证码输入错误";// 验证码错误提示log
	String log_nullPictureVerification = "请输入图形验证码";// 未输入图形验证码提示log
	String log_pictureVerification_err = "图形验证码错误";// 图形验证码错误提示log

	String id_edit_phoneNum = "com.ksfc.newfarmer:id/backedit1";// 注册页面输入手机号
	String id_edit_enterPictureVerification = "com.ksfc.newfarmer:id/sms_auth_code_et";// 注册页面出入图形验证码
	String id_edit_enterVerification = "com.ksfc.newfarmer:id/backyanzhengma";// 注册页面输入验证码
	String id_edit_enterPassWord = "com.ksfc.newfarmer:id/backnewpassword";// 注册页面输入密码
	String id_edit_enterSurePassWord = "com.ksfc.newfarmer:id/confimPasword";// 注册页面输入确认密码
	String id_checkBok = "com.ksfc.newfarmer:id/check_box";// 注册页面复选框

	/**
	 * 登录页面
	 */
	String id_edit_login_pNum = "com.ksfc.newfarmer:id/login_layout_phone";// 输入手机号
	String id_edit_login_pwd = "com.ksfc.newfarmer:id/login_layoutpassword";// 输入密码

	String text_login_sure = "确认登录";// 确认登录按钮

	String log_pNumUnreg = "该手机号未注册，请重新输入";// 输入未注册的手机号
	String log_pwdErr = "密码错误，请重新输入";// 输入错误的密码

	/**
	 * 忘记密码页面
	 */
	String text_finish = "完成";

	String log_froget_differentPwd = "两次密码不一致，请重新输入";

	// 运行
	public void test_run() {
		close_huodong();
		case_register();
		case_loginTest();
		case_forgetPassword();
	}

	/**
	 * 注册页面
	 */
	public void case_register() {
		// 进入注册界面
		login();
		t(text_register);
		// 未填写手机号
		t(text_register);
		toast_equals_string(tag + ":case_register() :未填写手机号", log_nullPhongNum);

		// 已注册的手机号
		enter(id_edit_phoneNum, Config.pNum_reg);
		t(text_getVerification);
		toast_equals_string(tag + ":case_register()已注册的手机号:", log_phoneReg);

		// 格式错误的手机号
		clear(id_edit_phoneNum);
		enter(id_edit_phoneNum, Config.pNum_err);
		t(text_register);
		toast_equals_string(tag + ":case_register():格式错误的手机号", log_phoneErr);

		// 需要填写图形验证码，弹出图形验证码窗口
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
			showErrLog(tag + ": case_register():需要填写图形验证码，弹出图形验证码窗口");
		}
		// 没有填写图形验证码
		solo.clickOnButton(text_sure);
		if (!solo.searchText(log_nullPictureVerification, true)) {
			showErrLog(tag + ":case_register() :没有填写图形验证码");
		}
		// 图形验证码错误
		enter(id_edit_enterPictureVerification, getRandomString(3));
		solo.clickOnButton(text_sure);
		if (!solo.searchText(log_pictureVerification_err, true)) {
			showErrLog(tag + ":case_register() :图形验证码错误");
		}
		solo.clickOnButton(Config.text_cancel);
		// 未填写验证码
		t(text_register);
		toast_equals_string(tag + ":case_register():未填写验证码",
				log_nullVerification);
		// 未填写密码
		enter(id_edit_enterVerification, getRandomIntString(4));
		t(text_register);
		toast_equals_string(tag + ":case_register():未填写密码", log_nullPassWord);

		// 未填写确认密码
		enter(id_edit_enterPassWord, Config.pwd_err);
		t(text_register);
		toast_equals_string(tag + ":case_register():未填写确认密码",
				log_nullSurePassWord);
		// 密码和确认密码低于六位
		enter(id_edit_enterSurePassWord, Config.pwd_err);
		t("立即注册");
		toast_equals_string(tag + ":case_register():密码和确认密码低于六位",
				log_shortPassWord);
		// 密码与确认密码不一致
		clear(id_edit_enterPassWord);
		enter(id_edit_enterPassWord, Config.pwd_cur);
		t(text_register);
		toast_equals_string(tag + ":case_register():密码与确认密码不一致",
				log_differentPassWord);
		// 未勾选用户协议
		clear(id_edit_enterSurePassWord);
		enter(id_edit_enterSurePassWord, Config.pwd_cur);
		if (solo.isCheckBoxChecked(0)) {
			v(id_checkBok);
		}
		t(text_register);
		toast_equals_string(tag + ":case_register():未勾选用户协议", "请同意网站使用协议");
		// 查看用户协议
		v("com.ksfc.newfarmer:id/register_layoutxieyi");
		g();
		// 验证码错误或没有查找到验证码
		v(id_checkBok);
		t(text_register);
		String get=getToast(2);
		if (!(get.equals(log_verification_overdue) | get
				.equals(log_verification_nofind))) {
			showErrLog(tag + ":case_()forgetPassword:验证码错误" + "aim:"
					+ log_verification_err + "or" + log_verification_overdue
					+ "get:" + get);
		}

		// 跳转登录页面
		t(text_login);
		solo.assertCurrentActivity(tag + ":register(): 跳转登录页面",
				Config.AcName_login);
		g();
		t(Config.text_homePage);

	}

	// 登录测试
	public void case_loginTest() {
		login();
		// 登录页面与其它页面的跳转
		t(text_forgetPWd);
		solo.assertCurrentActivity(tag + "testLogin():登录页面与其它页面的跳转",
				"RetrievePasswordActivity");
		g();
		t(text_register);
		solo.assertCurrentActivity(tag + "testLogin():登录页面与其它页面的跳转",
				"RegisterActivity");
		g();

		// 登录个人资料不完善的账户
		clear(id_edit_login_pNum);
		enter(id_edit_login_pNum, Config.pNum_null);
		enter(id_edit_login_pwd, Config.pwd_cur);
		t(text_login_sure);
		solo.assertCurrentActivity(tag + ":testLogin():登录个人资料不完善的账户",
				"ImprovePersonActivity");
		t(text_jump);
		// 未输入手机号
		t(Config.text_homePage);
		login();
		clear(id_edit_login_pNum);
		t(text_login_sure);
		toast_equals_string(tag + ":case_loginTest():未输入手机号", log_nullPhongNum);
		// 格式错误的手机号
		enter(id_edit_login_pNum, Config.pNum_err);
		t(text_login_sure);
		toast_equals_string(tag + ":case_loginTest():格式错误的手机号", log_phoneErr);
		// 输入未注册的手机号
		clear(id_edit_login_pNum);
		enter(id_edit_login_pNum, Config.pNum_unReg);
		enter(id_edit_login_pwd, Config.pwd_cur);
		t(text_login_sure);
		toast_equals_string(tag + ":case_loginTest():输入未注册的手机号", log_pNumUnreg);

		// 未输入密码
		clear(id_edit_login_pNum);
		enter(id_edit_login_pNum, Config.pNum_reg);
		clear(id_edit_login_pwd);
		t(text_login_sure);
		toast_equals_string(tag + ":case_loginTest():未输入密码", log_nullPassWord);

		// 输入错误密码
		enter(id_edit_login_pwd, Config.pwd_err);
		t(text_login_sure);
		toast_equals_string(tag + ":case_loginTest():输入错误密码", log_pwdErr);

		// 登录个人资料完善的账户
		clear(id_edit_login_pNum);
		enter(id_edit_login_pNum, Config.pNum_reg);
		clear(id_edit_login_pwd);
		enter(id_edit_login_pwd, Config.pwd_cur);
		t(text_login_sure);
		solo.assertCurrentActivity(tag + ":testLogin():登录个人资料完善的账户",
				"MainActivity");
		t(Config.text_homePage);
	}

	// 忘记密码页面
	public void case_forgetPassword() {
		// 进入忘记密码页面
		login();
		t(text_forgetPWd);
		// 未填写手机号
		t(text_finish);
		toast_equals_string(tag + ":case_()forgetPassword:未填写手机号",
				log_nullPhongNum);
		// 格式错误的手机号
		enter(id_edit_phoneNum, Config.pNum_err);
		t(text_finish);
		toast_equals_string(tag + ":case_()forgetPassword:格式错误的手机号",
				log_phoneErr);
		// 未注册的手机号
		clear(id_edit_phoneNum);
		enter(id_edit_phoneNum, Config.pNum_unReg);
		t(text_getVerification);
		toast_equals_string(tag + ":case_()forgetPassword:未注册的手机号",
				log_pNumUnreg);

		// 连续两次申请短信验证码，出现图片验证码
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
			showErrLog(tag + ":case_forgetPassword():连续两次申请短信验证码，出现图片验证码");
		}
		// 没有填写图形验证码
		solo.clickOnButton(Config.text_sure);
		if (!solo.searchText(log_nullPictureVerification, true)) {
			showErrLog(tag + ":case_forgetPassword() :没有填写图形验证码");
		}
		// 图形验证码错误
		enter(id_edit_enterPictureVerification, getRandomString(3));
		solo.clickOnButton(Config.text_sure);
		if (!solo.searchText(log_pictureVerification_err, true)) {
			showErrLog(tag + ":case_forgetPassword() :图形验证码错误");
		}
		solo.clickOnButton(Config.text_cancel);

		// 未填写验证码
		t(text_finish);
		toast_equals_string(tag + ":case_()forgetPassword:未填写验证码",
				log_nullVerification);

		// 未填写新密码
		enter(id_edit_enterVerification, getRandomIntString(4));// 输入的是错误的验证码
		t(text_finish);
		toast_equals_string(tag + ":case_()forgetPassword:未填写新密码",
				log_nullPassWord);

		// 未填写确认密码
		enter(id_edit_enterPassWord, Config.pwd_err);
		t(text_finish);
		toast_equals_string(tag + ":case_()forgetPassword:未填写确认密码",
				log_nullSurePassWord);

		// 密码与确认密码格式不正确小于六位
		enter(id_edit_enterSurePassWord, Config.pwd_err);
		t(text_finish);
		toast_equals_string(tag + ":case_()forgetPassword:密码与确认密码格式不正确小于六位",
				log_shortPassWord);

		// 密码与确认密码不一致
		clear(id_edit_enterPassWord);
		enter(id_edit_enterPassWord, Config.pwd_cur);// 将密码改为正确的密码
		t(text_finish);
		toast_equals_string(tag + ":case_()forgetPassword: 密码与确认密码不一致",
				log_froget_differentPwd);

		// 验证码错误
		clear(id_edit_enterSurePassWord);
		enter(id_edit_enterSurePassWord, Config.pwd_cur);
		t(Config.text_finish);
		String get = getToast(2);
		if (!(get.equals(log_verification_overdue) | get
				.equals(log_verification_err))) {
			showErrLog(tag + ":case_()forgetPassword:验证码错误" + "aim:"
					+ log_verification_nofind + "or" + log_verification_overdue
					+ "get:" + get);
		}

		g();
		g();// 返回到我的页面
	}
}
