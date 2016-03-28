package com.yhd.activity;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.model.LatLng;
import com.yhd.R;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LocationCityActivity extends BaseActivity{
	
	@SuppressWarnings("unused")
	private TextView tv_longtitude,tv_latitude,tv_city;
	// 定位相关
	LocationClient mLocClient;
	public MyLocationListenner myListener = new MyLocationListenner();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_location_city);
		initView();
		initData();
	}

	private void initView() {
		tv_longtitude = (TextView) findViewById(R.id.tv_longtitude);
		tv_latitude = (TextView) findViewById(R.id.tv_latitude);
		tv_city = (TextView) findViewById(R.id.tv_city);
	}
	
	private void initData() {
		// 定位初始化
		mLocClient = new LocationClient(this);
		mLocClient.registerLocationListener(myListener);
		LocationClientOption option = new LocationClientOption();
		option.setOpenGps(true);// 打开gps
		option.setCoorType("bd09ll"); // 设置坐标类型
		option.setScanSpan(1000);
		mLocClient.setLocOption(option);
		mLocClient.start();		
	}
	
	/**
	 * 定位SDK监听函数
	 */
	public class MyLocationListenner implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
                @SuppressWarnings("unused")
				LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());
                Log.v("Location: ", String.valueOf(location));
                Log.v("longitude: ", String.valueOf(location.getLongitude()));
                Log.v("latitude: ", String.valueOf(location.getLatitude()));
            }
        }

		public void onReceivePoi(BDLocation poiLocation) {
		}
}
