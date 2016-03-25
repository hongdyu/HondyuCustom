package com.yhd.activity;

import com.yhd.R;

import android.os.Bundle;
import android.widget.TextView;

public class LocationCityActivity extends BaseActivity{
	
	private TextView tv_longtitude,tv_latitude,tv_city;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location_city);
		initView();
	}

	private void initView() {
		tv_longtitude = (TextView) findViewById(R.id.tv_longtitude);
		tv_latitude = (TextView) findViewById(R.id.tv_latitude);
		tv_city = (TextView) findViewById(R.id.tv_city);
	}

}
