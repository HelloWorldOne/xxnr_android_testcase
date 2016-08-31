package com.example.yu.test;

import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;

public class CaseMyNewFarmer extends BaseCase {

	public String tag = " CaseMyNewFarmer";

	public static CaseMyNewFarmer caseInstance(Solo solo1) {
		CaseMyNewFarmer instance = new CaseMyNewFarmer();
		instance.instance(solo1);
		return instance;
	}

	String text_tell = "�ͷ��绰";
	String text_call = "����";
	String text_set = "����";
	String text_headPortrait = "�ҵ�ͷ��";
	String text_clearing = "�������";
	String text_version_updating = "�汾����";
	String text_update_later = "�ݲ�����";
	String text_update_now = "��������";
	String text_recommend = "�Ƽ�����ũ�˸�����";
	String text_recommed_to = "����";
	String text_about = "����";
	String text_about_us = "��������";

	String log_clearing = "�����Ѿ�����ɾ��ˣ�";
	String log_new_version = "���°汾";

	public void test_run() {
		case_newFarmer_louout_jump();
		case_newFarmer_login_jump();
		case_newFarmer_setting();
	}

	/**
	 * δ��¼״̬���ҵ�ҳ��������ҳ��֮�����ת
	 */
	public void case_newFarmer_louout_jump() {
		/**
		 * δ��¼״̬�µ���ת
		 */
		logout();
		t(Config.text_mine);
		// δ��¼״̬�²�չʾ�ҵ�����
		if (solo.searchText(Config.text_myNet, 1, false, true)) {
			showErrLog(tag + ":case_newFarmer_louout_jump():δ��¼״̬�²�չʾ�ҵ�����");
		}
		// δ��¼״̬��ҳ�����ת
		v(Config.id_jump_myself);
		solo.assertCurrentActivity(tag + "case_newFarmer_louout_jump():��¼ҳ��",
				Config.AcName_login);
		g();
		t(Config.text_myOrder);
		solo.assertCurrentActivity(tag + "case_newFarmer_louout_jump():�ҵĶ���",
				Config.AcName_login);
		g();
		t(Config.text_pointStore);
		solo.assertCurrentActivity(tag + "case_newFarmer_louout_jump():�����̳�",
				Config.AcName_pointStore);
		g();
		t(Config.text_newFarmer_delegate);
		solo.assertCurrentActivity(tag + "case_newFarmer_louout_jump():��ũ����",
				Config.AcName_login);
		g();
		t(text_tell);
		if (!solo.searchText(text_call, 1, false, true)) {
			showErrLog(tag + ":case_newFarmer_louout_jump():�ͷ��绰");
		}
		t(Config.text_cancel);
		t(text_set);
		solo.assertCurrentActivity(tag + "case_newFarmer_louout_jump():����",
				Config.AcName_set);
		g();
		t(Config.text_homePage);
		solo.assertCurrentActivity(tag + "case_newFarmer_louout_jump():��ҳ",
				Config.AcName_homePage);
		t(Config.text_mine);
		t(Config.text_shoppingcart);
		solo.assertCurrentActivity(tag + "case_newFarmer_louout_jump():���ﳵ",
				Config.AcName_shoppingcart);
		t(Config.text_mine);
		t(Config.text_information);
		solo.assertCurrentActivity(tag + "case_newFarmer_louout_jump():��Ѷ",
				Config.AcName_information);
		t(Config.text_homePage);
	}

	/**
	 * �ҵ�ҳ���¼״̬�µ���ת
	 */
	public void case_newFarmer_login_jump() {
		login_sure(Config.pNum_reg);
		v(Config.id_jump_myself);
		if (!solo.searchText(text_headPortrait, 1, false, true)) {
			showErrLog(tag + ":case_newFarmer_login_jump():������Ϣ");
		}
		g();
		t(Config.text_myOrder);
		if (!solo.searchText(Config.text_myOrder, 1, false, true)) {
			showErrLog(tag + ":case_newFarmer_login_jump():�ҵĶ���");
		}
		g();
		t(Config.text_pointStore);
		solo.assertCurrentActivity(tag + "case_newFarmer_login_jump():�����̳�",
				Config.AcName_pointStore);
		g();
		t(Config.text_newFarmer_delegate);
		if (!solo.searchText(Config.text_newFarmer_delegate, 1, false, true)) {
			showErrLog(tag + ":case_newFarmer_login_jump():��½�����ũ����");
		}
		g();
		t(text_call);
		if (!solo.searchText(text_call, 1, false, true)) {
			showErrLog(tag + ":case_newFarmer_login_jump():�ͷ��绰");
		}
		t(Config.text_cancel);
		t(text_set);
		solo.assertCurrentActivity(tag + "case_newFarmer_login_jump():��½�������",
				"SettingActivity");
		g();
		t(Config.text_homePage);
		solo.assertCurrentActivity(tag + "case_newFarmer_login_jump():��½�����ҳ",
				Config.AcName_homePage);
		t(Config.text_mine);
		t(Config.text_add_shoppingcart);
		solo.assertCurrentActivity(tag + "case_newFarmer_login_jump():��½��Ĺ��ﳵ",
				Config.AcName_shoppingcart);
		t(Config.text_mine);
		t(Config.text_information);
		solo.assertCurrentActivity(tag + "case_newFarmer_login_jump():��½�����Ѷ",
				Config.AcName_information);
		t(Config.text_mine);
	}

	/**
	 * ����ҳ��
	 */
	public void case_newFarmer_setting() {
		t(text_set);
		// �ر���Ϣ֪ͨ
		if (solo.isCheckBoxChecked(0)) {
			solo.clickOnCheckBox(0);
			if (!solo.searchText(Config.text_sure, 1, false, true)) {
				showErrLog(tag + ":case_newFarmer_setting():�ر���Ϣ֪ͨ");
			}
			solo.clickOnButton(Config.text_sure);
			s();
		}
		solo.clickOnCheckBox(0);
		s();
		// �������
		t(text_clearing);
		if (!solo.searchText(Config.text_sure, 1, false, true)) {
			showErrLog(tag + ":case_newFarmer_setting():�������");
		}
		solo.clickOnButton(Config.text_sure);
		solo.sleep(1000);
		toast_equals_string(tag + ":case_newFarmer_setting():ȷ���������",
				log_clearing);
		// �汾����
		t(text_version_updating);
		if (solo.searchText(text_update_later, 1, false, true)) {
			t(text_update_later);
			t(text_version_updating);
			t(text_update_now);
		} else {
			t(text_version_updating);
			toast_equals_string(tag + ":case_newFarmer_setting():�汾�����°汾",
					log_new_version);
		}
		// �Ƽ�����ũ�˸�����
		t(text_recommend);
		if (!solo.searchText(text_recommed_to, 1, false, true)) {
			showErrLog(tag + ":case_newFarmer_setting():�Ƽ�����ũ�˸�����");
		}
		g();
		// ����
		t(text_about);
		if (!solo.searchText(text_about_us, 1, false, true)) {
			showErrLog(tag + ":case_newFarmer_setting():����");
		}
		g();
	}
}
