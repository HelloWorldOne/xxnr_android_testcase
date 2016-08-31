package com.example.yu.test.RunTestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.yu.test.RunTestCase.*;

import android.app.ActionBar;
import android.os.SystemClock;
import android.text.AndroidCharacter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class Casetest extends BaseCase {
	public String tag = "Casetest";

	public void test_run() {
		if(!solo.searchText(Config.text_car, 1, false, true)){
			showLog("........");
			v(Config.id_close_huodong);
		}
	}

	
	
}