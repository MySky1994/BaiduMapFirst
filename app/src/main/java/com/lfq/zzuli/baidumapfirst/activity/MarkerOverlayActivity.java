package com.lfq.zzuli.baidumapfirst.activity;

import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.model.LatLng;
import com.lfq.zzuli.baidumapfirst.R;

public class MarkerOverlayActivity extends BaseActivity {


    @Override
    public void init() {
        MarkerOptions markerOptions = new MarkerOptions();
        BitmapDescriptor icon = BitmapDescriptorFactory.fromResource(R.mipmap.icon_eat);
        markerOptions.position(latLngZhengQing) //位置
        .title("吃") //title
        .icon(icon) //图标
        .draggable(true); //设置图标可以拖动
        baiduMap.addOverlay(markerOptions);

        // 添加一个向北的标志
        markerOptions = new MarkerOptions().icon(icon)
                .title("向北")
                .position(new LatLng(latLngZhengQing.latitude + 0.001, latLngZhengQing.longitude))
                .draggable(true);
        baiduMap.addOverlay(markerOptions);

        // 添加一个向东的标志
        markerOptions = new MarkerOptions().icon(icon)
                .title("向东")
                .position(new LatLng(latLngZhengQing.latitude, latLngZhengQing.longitude + 0.001))
                .draggable(true);
        baiduMap.addOverlay(markerOptions);

        // 添加一个向西南的标志
        markerOptions = new MarkerOptions().icon(icon)
                .title("向西南")
                .position(new LatLng(latLngZhengQing.latitude - 0.001, latLngZhengQing.longitude - 0.001))
                .draggable(true);
        baiduMap.addOverlay(markerOptions);
    }
}
