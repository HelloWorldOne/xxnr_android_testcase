package com.example.yu.test;

import com.example.yu.test.RunTestCase.BaseCase;
import com.robotium.solo.Solo;


public class CaseSpecial extends BaseCase {

	public String tag = " CaseSpecial";

	public static CaseSpecial caseInstance(Solo solo1) {
		CaseSpecial instance = new CaseSpecial();
		instance.instance(solo1);
		return instance;
	}

	public void test_run() {
		fertilizer();
		car();
	}

	// 化肥专场
	public void fertilizer() {
		t("化肥专场");
		// 上拉刷新商品
		solo.drag(500, 500, 1000, 650, 3);
		solo.drag(500, 500, 1000, 650, 3);

		// 下拉刷新商品
		solo.drag(500, 500, 650, 1000, 3);
		solo.drag(500, 500, 600, 1000, 3);
		
		// 返回顶部按钮
		solo.drag(400, 400, 1000, 650, 3);
		v("com.ksfc.newfarmer:id/return_top");

		// 进入商品详情页面并返回
		int x = (int) (Math.random() * 5);
		solo.clickInList(x);
		solo.assertCurrentActivity(tag + ":fertilizer():进入商品详情页面并返回",
				"GoodsDetailActivity");
		g();
		// 价格排序
		t("价格");
		t("价格");

		// 筛选品牌
		t("筛选");
		t("中化化肥");
		t("确定");

		// 筛选品类
		t("筛选");
		t("重置");
		t("有机肥");
		t("确定");

		// 价格筛选
		t("筛选");
		t("重置");
		t("2000-3000元");
		t("确定");

		// 多级筛选
		t("筛选");
		t("重置");
		t("好苗子");
		t("中化化肥");
		t("有机肥");
		t("复合肥");
		t("2000-3000元");
		t("确定");

		// 选择重置但是没有确定
		t("筛选");
		t("重置");
		g();
		solo.drag(500, 500, 1000, 650, 3);
		s();

		// 重置后确定
		v("com.ksfc.newfarmer:id/goods_shaixuan_rel");
		t("重置");
		t("确定");

		// 综合返回默认状态
		t("价格");
		t("综合");
		g();
	}

	// 汽车专场
	public void car() {
		// 上拉下滑刷新商品
		t("汽车专场");
		// 上拉刷新商品
		solo.drag(500, 500, 1000, 650, 3);
		s();
		solo.drag(500, 500, 1000, 650, 3);
		s();

		// 下拉刷新商品
		solo.drag(500, 500, 650, 1000, 3);
		s();
		solo.drag(500, 500, 600, 1000, 3);
		s();

		// 返回顶部按钮
		solo.drag(400, 400, 1000, 650, 3);
		v("com.ksfc.newfarmer:id/return_top");

		// 进入商品详情页面并返回
		int x = (int) (Math.random() * 5);
		solo.clickInList(x);
		solo.assertCurrentActivity(tag + ":car():进入商品详情页面并返回",
				"GoodsDetailActivity");
		g();

		// 价格排序
		t("价格");
		t("价格");

		// 筛选品牌
		t("筛选");
		t("江淮");
		t("确定");

		// 筛选车型
		t("筛选");
		t("重置");
		t("MPV");
		t("确定");

		// 价格筛选
		t("筛选");
		t("重置");
		t("5万-6万");
		t("确定");

		// 筛选车系
		t("筛选");
		t("江淮");
		t("瑞风S3");
		t("确定");

		// 多级筛选
		t("筛选");
		t("重置");
		t("江淮");
		t("奇瑞");
		t("SUV");
		t("轿车");
		t("瑞风S2");
		t("瑞风S5");
		t("6万-7万");
		t("确定");

		// 选择重置但是没有确定
		t("筛选");
		t("重置");
		g();
		solo.drag(500, 500, 1000, 650, 3);
		s();

		// 重置后确定
		v("com.ksfc.newfarmer:id/goods_shaixuan_rel");
		t("重置");
		t("确定");

		// 综合返回默认状态
		t("价格");
		t("综合");
		g();
	}
}