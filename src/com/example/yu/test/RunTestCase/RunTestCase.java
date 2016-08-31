package com.example.yu.test.RunTestCase;

import com.example.yu.test.CaseClearing;
import com.example.yu.test.CaseFunction;
import com.example.yu.test.CaseHomePage;
import com.example.yu.test.CaseMyNewFarmer;

public class RunTestCase extends BaseCase{

	public void test_ren(){
		CaseHomePage.caseInstance(solo).test_run();
		CaseFunction.caseInstance(solo).test_run();
		CaseMyNewFarmer.caseInstance(solo).test_run();
	}

}
