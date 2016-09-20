package com.hqu.weil.basic;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.SupportMapFragment;
import com.hqu.weil.R;

public class BaseMapFragmentActivity extends FragmentActivity {
	private AMap mMap;
	public static int type=AMap.MAP_TYPE_NORMAL;//默认为标准地图
	public static boolean traffic =false;//默认为不开启交通状况
	//public static boolean buildings =false;//默认为不开启交通状况
	//public static boolean maptext =false;//默认为不开启交通状况
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.basemap_fragment_activity);
		setUpMapIfNeeded();
	}

	@Override
	protected void onResume() {
		super.onResume();
		setUpMapIfNeeded();
	}
	
	@Override
	protected void onDestroy(){
		super.onDestroy();
	}

	private void setUpMapIfNeeded() {
		if (mMap == null) {
			mMap = ((SupportMapFragment) getSupportFragmentManager()
					.findFragmentById(R.id.map)).getMap();
		}
		mMap.setMapType(type);
		mMap.setTrafficEnabled(traffic);
		mMap.moveCamera(CameraUpdateFactory.zoomTo(17));//将地图的缩放级别调整到17级
//		mMap.setLocationSource(BaseMapFragmentActivity.this);// 设置定位监听
//		mUiSettings.setMyLocationButtonEnabled(true); // 显示默认的定位按钮
//		mMap.setMyLocationEnabled(true);// 可触发定位并显示定位层
		//mMap.setIndoorBuildingInfo(buildings);
		//mMap.setMapTextZIndex(maptext);
	}


}
