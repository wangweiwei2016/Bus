package com.hqu.weil;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.amap.api.maps.AMap;
import com.hqu.weil.basic.BaseMapFragmentActivity;
import com.hqu.weil.location.LocationModeSourceActivity;

/**
 * 作者：www on 2016/8/10 15:29
 * 邮箱：2030730029@qq.com
 */
public class MyFragment2 extends Fragment implements View.OnClickListener,CompoundButton.OnCheckedChangeListener{
    //private AMap mMap;
    public MyFragment2(){

    }
   // MapView mMapView = null;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
       //super.onCreate(savedInstanceState);//activity
        // View view = inflater.inflate(R.layout.fg_content,container,false);
        View view = inflater.inflate(R.layout.fg_content_two,container,false);
        //获取地图控件引用
        //mMapView = (MapView) view.findViewById(R.id.map);
       // TextView txt_content = (TextView) view.findViewById(R.id.txt_content);
        //txt_content.setText("第二个Frament路线");
        Log.e("1234","2222");

        Button link_view1= (Button) view.findViewById(R.id.open_standard_map);
        link_view1.setOnClickListener(this);
        Button link_view2= (Button) view.findViewById(R.id.open_satellite_map);
        link_view2.setOnClickListener(this);
        Button link_view3= (Button) view.findViewById(R.id.open_night_map);
        link_view3.setOnClickListener(this);

        CheckBox traffic_box= (CheckBox) view.findViewById(R.id.traffic_box);
        traffic_box.setOnCheckedChangeListener(this);

        Button link_view4= (Button) view.findViewById(R.id.my_location);
        link_view4.setOnClickListener(this);
        //mMapView.onCreate(savedInstanceState);
        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.open_standard_map:
                BaseMapFragmentActivity.type=AMap.MAP_TYPE_NORMAL;
                startActivity(new Intent(getActivity(),BaseMapFragmentActivity.class));
                break;
            case R.id.open_satellite_map:
                BaseMapFragmentActivity.type=AMap.MAP_TYPE_SATELLITE;
                startActivity(new Intent(getActivity(), BaseMapFragmentActivity.class));
                break;
            case R.id.open_night_map:
                BaseMapFragmentActivity.type=AMap.MAP_TYPE_NIGHT;
                startActivity(new Intent(getActivity(),BaseMapFragmentActivity.class));
                break;
            case R.id.my_location:
                BaseMapFragmentActivity.type=AMap.MAP_TYPE_NORMAL;
                startActivity(new Intent(getActivity(), LocationModeSourceActivity.class));
                break;
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.traffic_box:
            if (compoundButton.isChecked()) {
                BaseMapFragmentActivity.traffic = true;
                //Toast.makeText(getActivity(), "显示交通状况", Toast.LENGTH_SHORT).show();
            } else {
                BaseMapFragmentActivity.traffic = false;
                //Toast.makeText(getActivity(), "不显示交通状况", Toast.LENGTH_SHORT).show();
            }
                break;
        }

    }

//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
//        mMapView.onDestroy();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        //在activity执行onResume时执行mMapView.onResume ()，实现地图生命周期管理
//        mMapView.onResume();
//    }
//
//    @Override
//    public void onPause() {
//        super.onPause();
//        //在activity执行onPause时执行mMapView.onPause ()，实现地图生命周期管理
//        mMapView.onPause();
//    }
//
//    @Override
//    public void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        //在activity执行onSaveInstanceState时执行mMapView.onSaveInstanceState (outState)，实现地图生命周期管理
//        mMapView.onSaveInstanceState(outState);
//    }
}
