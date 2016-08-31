package com.example.yu.test;

import java.util.ArrayList;

import android.view.View;
import com.example.yu.test.RunTestCase.BaseCase;
import com.example.yu.test.RunTestCase.Config;
import com.robotium.solo.Solo;
import android.widget.TextView;

public class CaseShoppingCar extends BaseCase {

	String tag = "CaseShoppingCar";

	public static CaseShoppingCar caseInstance(Solo solo1) {
		CaseShoppingCar instance = new CaseShoppingCar();
		instance.instance(solo1);
		return instance;
	}

	String text_bianji = "编辑";
	String text_delete = "删除";
	String text_finish = "完成";

	String id_add = "com.ksfc.newfarmer:id/ordering_item_jia1";// 购物车页面+按钮
	String id_jian = "com.ksfc.newfarmer:id/ordering_item_jian1";// 购物车页面—按钮
	String id_jump_alter_num = "com.ksfc.newfarmer:id/ordering_item_geshu";// 购物车页面弹出修改数量窗口
	String id_edit_alter_num = "com.ksfc.newfarmer:id/dialog_item_geshu";// 修改数量
	String id_shoppingcart_goods_view = "com.ksfc.newfarmer:id/ordering_item_img";// 购物车页面商品View
	String id_num = "ordering_item_geshu";// 购物车页面显示商品数量的textView

	String log_numErr = "请输入正确的商品数量呦";
	String log_numMin = "商品不能再减少了哦";
	String log_numMax = "商品数量不能大于9999";
	String log_choose_goods = "请您至少选择一件商品";

	public void test_run() {
		close_huodong();
		case_shoppingCar_jump();
		case_shoppingCar_number();
		case_shoppingCar_delete();
		case_toClearing();
	}
	
	// 往购物车内添加商品并返回购物车
	public void add() {
		t(Config.text_homePage);
		t(Config.text_car);
		solo.clickInList(3);
		t(Config.text_add_shoppingcart);
		t(Config.text_sure);
		g();
		g();
		t(Config.text_fertilizer);
		solo.clickInList(2);
		t(Config.text_add_shoppingcart);
		t(Config.text_sure);
		g();
		g();
		t(Config.text_shoppingcart);
	}

	/**
	 * 购物车页面的跳转
	 */
	public void case_shoppingCar_jump() {

		// 保证购物车为空
		t(Config.text_shoppingcart);
		if (!solo.searchText(Config.text_bay_fertilizer, 1, false, true)) {
			t(text_bianji);
			v(Config.id_checkButton_all);
			v(Config.id_shoppingcart_jiesuan);
			solo.clickOnButton(Config.text_yes);
		}
		t(Config.text_homePage);
		solo.assertCurrentActivity(tag + ":case_shoppingCar_jump():首页",
				Config.AcName_homePage);
		t(Config.text_shoppingcart);
		t(Config.text_information);
		solo.assertCurrentActivity(tag + ":case_shoppingCar_jump():资讯",
				Config.AcName_information);
		t(Config.text_shoppingcart);
		t(Config.text_mine);
		solo.assertCurrentActivity(tag + ":case_shoppingCar_jump():我的",
				Config.AcName_mine);
		t(Config.text_shoppingcart);
		t(Config.text_bay_fertilizer);
		solo.assertCurrentActivity(tag + ":case_shoppingCar_jump():化肥专场",
				Config.AcName_special);
		g();
		t(Config.text_bay_car);
		solo.assertCurrentActivity(tag + ":case_shoppingCar_jump():汽车专场",
				Config.AcName_special);
		g();
	}

	/**
	 * 修改商品数量
	 */
	public void case_shoppingCar_number() {
		// 向购物车中添加写死的商品
		add();
		// 通过“+-”来修改商品数量
		int i = 0;
		int j = 0;
		while (i < 3) {
			int num = Integer.parseInt(getTextViewString(id_num));
			v(id_add);
			int num_add = Integer.parseInt(getTextViewString(id_num));
			if (num + 1 != num_add) {
				showErrLog(tag
						+ "case_acase_shoppingCar_numberlter_num():通过“+-”来修改商品数量");
			}
			i++;
		}
		while (j < 3) {
			int num = Integer.parseInt(getTextViewString(id_num));
			v(id_jian);
			int num_add = Integer.parseInt(getTextViewString(id_num));
			if (num - 1 != num_add) {
				showErrLog(tag + "case_shoppingCar_number():通过“+-”来修改商品数量");
			}
			j++;
		}

		// 将商品数量删除
		v(id_jump_alter_num);
		clear(id_edit_alter_num);
		t(Config.text_sure);
		toast_equals_string(tag + ":case_shoppingCar_number():将商品数量删除",
				log_numErr);
		// 将商品数量改为0
		clear(id_edit_alter_num);
		enter(id_edit_alter_num, "0");
		t(Config.text_sure);
		if (!solo.searchText(log_numErr)) {
			showErrLog(tag + ":case_shoppingCar_number():将商品数量改为0");
		}

		// 输入随机的正确的商品数量
		int x = 1 + (int) (Math.random() * 9999);
		String number = x + "";
		clear(id_edit_alter_num);
		enter(id_edit_alter_num, number);
		t(Config.text_sure);
		TextView tv = (TextView) solo.getView(id_edit_alter_num);
		String s = (String) tv.getText();
		int a = Integer.parseInt(s);
		if (a != x) {
			showErrLog(tag + ":case_shoppingCar_number():用数字键盘输入正确的商品数量");
		}

		// 商品数量为1时点击继续减少
		v(id_jump_alter_num);
		clear(id_edit_alter_num);
		enter(id_edit_alter_num, "1");
		t(Config.text_sure);
		v(id_jian);
		toast_equals_string(tag + ":case_shoppingCar_number(): 商品数量为1时点击继续减少",
				log_numMin);

		// 商品数量为9999时继续增加
		v(id_jump_alter_num);
		clear(id_edit_alter_num);
		enter(id_edit_alter_num, "9999");
		t(Config.text_sure);
		v(id_add);
		toast_equals_string(tag + ":case_shoppingCar_number():商品数量为9999时继续增加",
				log_numMax);
	}

	/**
	 * 删除商品
	 */
	public void case_shoppingCar_delete() {
		add();
		// 向左滑动删除某个商品
		if (solo.searchText(text_finish, 1, false, true)) {
			t(text_finish);
		}
		View view = solo.getView(id_shoppingcart_goods_view);
		dragView(view, 0.8f, 0.5f, 0.3f, 0.5f);
		search_text(tag + ":case_shoppingCar_delete():向左滑动删除某个商品", text_delete,
				1, false);
		t(text_delete);
		t(Config.text_yes);

		// 通过编辑批量删除商品
		// 通过取消全选，在没有选中任何商品的情况下删除
		t(text_bianji);
		ArrayList<android.widget.CheckBox> checkBox = solo
				.getCurrentViews(android.widget.CheckBox.class);
		int a = (checkBox.size() - 1);
		if (solo.isCheckBoxChecked(0)) {
			solo.clickOnCheckBox(0);
		}
		solo.clickOnCheckBox(a);
		solo.clickOnCheckBox(a);
		v(Config.id_shoppingcart_jiesuan);
		toast_equals_string(tag
				+ ":case_shoppingCar_delete():通过取消全选，在没有选中任何商品的情况下删除",
				log_choose_goods);

		// 随机选择删除部分商品
		int x = (int) (Math.random() * a);
		solo.clickOnView(checkBox.get(x));
		v(Config.id_shoppingcart_jiesuan);
		t(Config.text_yes);
		t(Config.text_homePage);
	}

	/**
	 * 购物车页面的去结算操作
	 */

	public void case_toClearing() {
		logout();
		t(Config.text_shoppingcart);
		// 判断购物车内还有没有商品没有则添加
		if (solo.searchText(Config.text_bay_fertilizer, 1, false, true)) {
			add();
		}

		// 未登录且未选择任何商品的情况下选择去结算
		v(Config.id_shoppingcart_jiesuan);
		solo.assertCurrentActivity(tag + ":case_toClearing():未登录情况下选择商品去结算",
				Config.AcName_login);
		g();

		// 未登录情况下选择商品去结算
		solo.clickOnCheckBox(0);
		v(Config.id_shoppingcart_jiesuan);
		solo.assertCurrentActivity(tag + ":case_toClearing():未登录情况下选择商品去结算",
				Config.AcName_login);
		// 登录情况下未选择任何商品去结算
		login_sure(Config.pNum_reg);
		add();
		v(Config.id_shoppingcart_jiesuan);
		toast_equals_string(tag + ":case_toClearing():登录情况下未选择任何商品去结算",
				log_choose_goods);
		// 登陆后选择一件商品去结算
		ArrayList<android.widget.CheckBox> checkBox2 = solo
				.getCurrentViews(android.widget.CheckBox.class);
		int a = (checkBox2.size() - 1);
		solo.clickOnView(checkBox2.get(1));
		v(Config.id_shoppingcart_jiesuan);
		solo.assertCurrentActivity(tag + ":case_toClearing():登陆后选择一件商品去结算",
				Config.AcName_clearing);
		g();

		// 登陆后选择全部商品去结算
		solo.clickOnView(checkBox2.get(a));
		v(Config.id_shoppingcart_jiesuan);
		solo.assertCurrentActivity(tag + ":case_toClearing():登陆后选择全部商品去结算",
				Config.AcName_clearing);

	}

}
