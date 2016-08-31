package com.example.yu.test;


import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;
public class CaseNewFarmer_indent extends BaseCase {

	public String tag = " CaseNewFarmer_indent";

	public static CaseNewFarmer_indent caseInstance(Solo solo1) {
		CaseNewFarmer_indent instance = new CaseNewFarmer_indent();
		instance.instance(solo1);
		return instance;
	}

	public void test_run() {
	//	indent_null();
		indent_waitForPay_show();
	}

	/**
	 * null�˻�������ת��û�ж�����״̬
	 */
	
	
	public void indent_null(){
		login_sure(Config.pNum_null);
		//�ҵĶ���
		v("com.ksfc.newfarmer:id/my_order_ll");
		jump("�ҵĶ���ҳ��");
		g();
		//������ҳ��
		t("������");
		jump("������ҳ��");
		g();
		//������ҳ��
		t("������");
		jump("������ҳ��");
		g();
		//���ջ�ҳ��
		t("���ջ�");
		jump("���ջ�ҳ��");
		g();
		//�����ҳ��
		t("�����");
		jump("�����ҳ��");
		g();
	}
	
	/**
	 * �ҵĶ�����������չʾ
	 */
	
	public void indent_waitForPay_show(){
	//	login_sure(Config.pNum_reg);
		t("�ҵ�");
		t("�ҵĶ���");
		t("������");
		v("com.ksfc.newfarmer:id/ordering_item_img");
		g();
	}
	/**
	 * ����û�ж�����ҳ����ж��Լ���ת�����ʡ�����ר��
	 * @param text
	 */
	public void jump(String text){
		if(!solo.searchText("����û�ж���")){
			showErrLog(tag+":indent_null():��ת��"+text);
		}
		t("ȥ�򻯷�");
		if(!solo.searchText("����")){
			showErrLog(tag+":indent_null():"+text+"��ת������ר��");
		}
		g();
		t("ȥ������");
		if(!solo.searchText("����")){
			showErrLog(tag+":indent_null():"+text+"��ת������ר��");
		}
		g();
	}

}