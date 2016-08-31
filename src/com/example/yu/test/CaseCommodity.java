package com.example.yu.test;

import android.view.View;
import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;

public class CaseCommodity extends BaseCase {
	public static String tag = "CaseCommodity";

	public static CaseCommodity caseInstance(Solo solo1) {
		CaseCommodity instance = new CaseCommodity();
		instance.instance(solo1);
		return instance;

	}

	String text_bay_now = "立即购买";
	String text_canshu = "详细参数";
	String text_shuoming = "服务说明";

	String id_imageView = "imageView";// 商品图片
	String id_jia = "pop_discount_jia";// 商品属性页面加号
	String id_jian = "pop_discount_jian";// 商品属性页面减号
	String id_edit_num = "pop_discount_geshu";// 商品属性页面数量输入框

	String log_max_jia = "商品数量不能大于9999";
	String log_min_jian = "商品数量不能再减少了";
	String log_nullAttribute = "请选择商品信息";
	String log_joinShoppingCart_success = "添加购物车成功";

	public void test_run() {
		close_huodong();
		case_commodityParticulars_show();
		case_alter_num();
		case_logout_nullAttribute_join();
		case_logout_choseAttribute_join();
		case_login_nullAttribute_join();
		case_login_choseAttribute_join();
		case_logout_bay();
		case_login_nullAttribute_bay();
		case_login_choseAttribute_bay();

	}

	/**
	 * 商品详情页面的展示
	 */
	public void case_commodityParticulars_show() {
		join_commodityParticulars();
		// 左右滚动商品图片信息
		View view = solo.getView(id_imageView);
		dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);
		dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);
		dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);

		// 点击放大图片
		solo.clickOnScreen(360, 500);
		g();

		// 向下活动进入商品描述
		solo.drag(460, 460, 900, 400, 3);
		solo.drag(460, 460, 900, 400, 3);
		search_text(tag + ":case_commodityParticulars_show():向下活动进入商品描述",
				text_canshu, 1, false);

		// 切换商品详情描述
		solo.drag(460, 460, 900, 400, 3);
		t(text_canshu);
		t(text_shuoming);
		g();
		g();
	}

	/**
	 * 商品详情页面修改商品数量
	 */
	public void case_alter_num() {
		join_commodityParticulars();
		// 通过“+-”来修改商品数量
		t(Config.text_add_shoppingcart);
		int i = 0;
		int j = 0;
		while (i < 3) {
			int num = Integer.parseInt(getEditTextString(id_edit_num));
			v(id_jia);
			int num_add = Integer.parseInt(getEditTextString(id_edit_num));
			if (num + 1 != num_add) {
				showErrLog(tag + "case_alter_num():通过“+-”来修改商品数量");
			}
			i++;
		}
		while (j < 3) {
			int num = Integer.parseInt(getEditTextString(id_edit_num));
			v(id_jian);
			int num_add = Integer.parseInt(getEditTextString(id_edit_num));
			if (num - 1 != num_add) {
				showErrLog(tag + "case_alter_num():通过“+-”来修改商品数量");
			}
			j++;
		}

		// 商品数量为9999时继续增加
		clear(id_edit_num);
		enter(id_edit_num, "9999");
		v(id_jia);
		toast_equals_string(tag + ":case_alter_num():商品数量为9999时继续增加",
				log_max_jia);

		// 商品数量为1时点击继续减少
		clear(id_edit_num);
		enter(id_edit_num, "1");
		v(id_jian);
		toast_equals_string(tag + ":case_alter_num(): 商品数量为1时点击继续减少",
				log_min_jian);

		// 将商品数量改为0
		clear(id_edit_num);
		enter(id_edit_num, "0");
		String num = getEditTextString(id_edit_num);
		showLog(num);
		if (num != "1") {
			showErrLog(tag + ":case_alter_num():用数字键盘将商品数量改为0");
		}

		// 输入随机的正确的商品数量
		int x = 1 + (int) (Math.random() * 9999);
		String number = x + "";
		clear(id_edit_num);
		enter(id_edit_num, number);
		String num2 = getEditTextString(id_edit_num);
		int a = Integer.parseInt(num2);
		if (a != x) {
			showErrLog(tag + ":case_alter_num():用数字键盘输入正确的商品数量");
		}
		g();
		g();
		g();
	}

	/**
	 * 未登录情况下商品属性未选择完全就加入购物车
	 */
	public void case_logout_nullAttribute_join() {
		logout();
		join_commodityParticulars();
		t(Config.text_add_shoppingcart);
		t(Config.text_sure);
		toast_equals_string(tag
				+ "case_logout_nullAttribute_join():未登录情况下商品属性未选择完全就加入购物车",
				log_nullAttribute);
		g();
		g();
		g();
	}

	/**
	 * 未登录选择商品属性后加入购物车
	 */
	public void case_logout_choseAttribute_join() {
		logout();
		join_commodityParticulars();
		t(Config.text_add_shoppingcart);
		t("2.0T 自动（6DCT）");
		t("智能型");
		t("拉菲红");
		t(Config.text_sure);
		toast_equals_string(tag
				+ "case_logout_choseAttribute_join():未登录情况下选择完商品属性后加入购物车",
				log_joinShoppingCart_success);
		g();
		g();
	}

	/**
	 * 登陆后商品属性未选择完就加入购物车
	 */
	public void case_login_nullAttribute_join() {
		login_sure(Config.pNum_reg);
		t(Config.text_homePage);
		join_commodityParticulars();
		t(Config.text_add_shoppingcart);
		t(Config.text_sure);
		toast_equals_string(tag
				+ "case_login_nullAttribute_join():登陆后商品属性未选择完就加入购物车",
				log_nullAttribute);
		g();
		g();
		g();
	}

	/**
	 * 登陆后商品属性选择完并加入购物车
	 */
	public void case_login_choseAttribute_join() {
		login_sure(Config.pNum_reg);
		t(Config.text_homePage);
		join_commodityParticulars();
		t(Config.text_add_shoppingcart);
		t("2.0T 自动（6DCT）");
		t("智能型");
		t("拉菲红");
		t(Config.text_sure);
		toast_equals_string(tag
				+ "case_login_choseAttribute_join():未登录情况下选择完商品属性后加入购物车",
				log_joinShoppingCart_success);
		g();
		g();
	}

	/**
	 * 未登录立即购买
	 */
	public void case_logout_bay() {
		logout();
		join_commodityParticulars();
		t(text_bay_now);
		t(Config.text_sure);
		solo.assertCurrentActivity(tag + ":case_logout_bay():未登录立即购买",
				"LoginActivity");
		g();
		g();
		g();
		g();
	}

	/**
	 * 登录后商品属性未选择完全就立即购买
	 */
	public void case_login_nullAttribute_bay() {
		login_sure(Config.pNum_reg);
		t(Config.text_homePage);
		join_commodityParticulars();
		t(text_bay_now);
		t(Config.text_sure);
		toast_equals_string(tag
				+ "case_login_nullAttribute_bay():登录后商品属性未选择完全就立即购买",
				log_nullAttribute);
		g();
		g();
		g();
	}

	/**
	 * 登陆后选择完商品属性后确认立即购买
	 */
	public void case_login_choseAttribute_bay() {
		login_sure(Config.pNum_reg);
		t(Config.text_homePage);
		join_commodityParticulars();
		t(text_bay_now);
		t("2.0T 自动（6DCT）");
		t("智能型");
		t("拉菲红");
		t(Config.text_sure);
		solo.assertCurrentActivity(tag
				+ ":case_login_choseAttribute_bay():登陆后选择完商品属性后确认立即购买",
				"AddOrderActivity");

	}

	/**
	 * 进入商品详情页面
	 */
	void join_commodityParticulars() {
		t(Config.text_car);
		solo.clickInList(2);
	}
}