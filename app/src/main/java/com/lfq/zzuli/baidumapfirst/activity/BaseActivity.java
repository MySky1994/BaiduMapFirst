package com.lfq.zzuli.baidumapfirst.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.lfq.zzuli.baidumapfirst.R;
import com.lfq.zzuli.baidumapfirst.util.Util;

/**
 * Created by Administrator on 2017/2/21 0021.
 */

/**
 * 在屏幕中央显示一个Toast
 */

public abstract class BaseActivity extends Activity {

    private static final String TAG = "BaseActivity";
    MapStatusUpdate mapStatusUpdate = null;
    MapStatus mapStatus = null;
    //郑州轻工业学院经纬度
    protected LatLng latLngZhengQing = new LatLng(34.817762,113.515791);
    //天安门地理经纬度
    protected  LatLng latLngBJ = new LatLng(39.715112,116.303963);
    public BaiduMap baiduMap = null;
    private MapView mapView;


    //这里加final是为了不让子类覆盖此方法，原因是预防这里一些类还没初始化的时候就被子类调用
    @Override
    protected final void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //获取地图控件引用
        mapView = (MapView) findViewById(R.id.bmapView);

        //获取地图控制器（例如将地图放大、缩小、旋转等操作）
        baiduMap = mapView.getMap();

        //  1.	隐藏缩放按钮、比例尺
          //隐藏比例尺，默认是显示的
        mapView.showScaleControl(false);
        //隐藏缩放按钮，默认也是显示的
        mapView.showZoomControls(false);

        //2.	获取获取最小（3）、最大缩放级别（20）
        float maxZoomLevel = baiduMap.getMaxZoomLevel();//获取地图最大缩放级别
        float minZoomLevel = baiduMap.getMinZoomLevel();//获取地图最大缩放级别
        Log.d(TAG,"maxZoomLevel = " + maxZoomLevel + ", minZoomLevel = " + minZoomLevel);

        //3.设置地图中心点为郑州轻工业学院科学校区
        mapStatusUpdate = MapStatusUpdateFactory.newLatLng(latLngZhengQing);
        //MapStatusUpdate mapStatusUpdate = MapStatusUpdateFactory.newLatLng(latLngBJ);
        baiduMap.setMapStatus(mapStatusUpdate);

        //4.	设置地图缩放为15
        mapStatusUpdate = MapStatusUpdateFactory.zoomTo(15);
        baiduMap.setMapStatus(mapStatusUpdate);

//        6、获取地图Ui控制器，隐藏指南针
//        UiSettings uiSettings = baiduMap.getUiSettings();
//        uiSettings.setCompassEnabled(false);

        init();
    }

    public abstract void init();


    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mapView.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mapView.onDestroy();
    }

    //  把Toast显示在屏幕中央
    public void showToast(CharSequence text){
          Util.showToast(this,text);
    }
}
