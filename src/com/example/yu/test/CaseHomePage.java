package com.example.yu.test;

import android.view.View;
import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;

public class CaseHomePage extends BaseCase {
	public static String tag = "CaseHomePage";

	public static CaseHomePage caseInstance(Solo solo1) {
		CaseHomePage instance = new CaseHomePage();
		instance.instance(solo1);
		return instance;
	}

	String id_viewPager = "com.ksfc.newfarmer:id/iv";

	String text_qiandaoSuccess = "ǩ���ɹ�";

	String log_qiaodao = "��������ǩ���ɹ������������ϣ�";

	// ����
	public void test_run() {
		close_huodong();
		case_homePage_qiandao();
		case_homePager_jump();
		case_homePage_information();
	}

	/**
	 * ��ҳ:ǩ��
	 */
	public void case_homePage_qiandao() {

		// δ��¼�����ǩ��
		logout();
		v(Config.id_title_right_img);
		solo.assertCurrentActivity(tag + ":case_homePage_qiandao():δ��¼�����ǩ��",
				Config.AcName_login);
		g();
		// ��¼�����ǩ��
		login_sure(Config.pNum_reg);
		t(Config.text_homePage);
		v(Config.id_title_right_img);
		if (!solo.waitForText(log_qiaodao)) {
			search_text(tag + ": case_homePage_qiandao()��¼�����ǩ��",
					text_qiandaoSuccess, 1, false);
		}
		v(Config.id_title_right_img);
		toast_equals_string(tag + ": case_homePage_qiandao():��¼�����ǩ��",
				log_qiaodao);
	}

	/**
	 * ��ҳ����ת
	 */
	public void case_homePager_jump() {
		// ��ҳ�ֲ������ת��
		View view = solo.getView(id_viewPager);
		for (int a = 0; a < 4; a++) {
			dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);
		}

		// ��������ר��������
		t(Config.text_car);
		solo.assertCurrentActivity(tag + ":case_homePager_jump():��������ר��������",
				Config.AcName_special);
		g();

		// ����ר��������
		t(Config.text_fertilizer);
		solo.assertCurrentActivity(tag + ":homePage():����ר��������",
				Config.AcName_special);
		g();
		t(Config.text_information);
		solo.assertCurrentActivity(tag + ":homePage():��Ѷ",
				Config.AcName_information);
		t(Config.text_homePage);
		t(Config.text_shoppingcart);
		solo.assertCurrentActivity(tag + ":homePage():���ﳵ",
				Config.AcName_shoppingcart);
		t(Config.text_homePage);
		t(Config.text_mine);
		solo.assertCurrentActivity(tag + ":homePage():�ҵ�", Config.AcName_mine);
		t(Config.text_homePage);
		v("com.ksfc.newfarmer:id/huafei_img");
		solo.assertCurrentActivity(tag + ":homePage():��Ʒ����",
				"GoodsDetailActivity");
		g();// ����ĳ����Ʒ����Ʒ����ҳ��
	}

	/**
	 * ��Ѷ
	 */
	public void case_homePage_information() {
		t(Config.text_information);
		for (int a = 0; a < 3; a++) {
			int x = (int) (Math.random() * 5);
			solo.clickInList(x);
			solo.assertCurrentActivity(tag + ":case_homePage_information()",
					"ArticleActivity");
			g();
		}
		int x = (int) (Math.random() * 5);
		solo.clickInList(x);
		v(Config.id_title_right_img);
		g();
		g();
		t(Config.text_homePage);
	}
}
