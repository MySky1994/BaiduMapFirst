package com.lfq.zzuli.baidumapfirst.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.baidu.mapapi.map.CircleOptions;
import com.baidu.mapapi.map.Stroke;

public class CircleOverlayActivity extends BaseActivity {

    @Override
    public void init() {
        CircleOptions circleOptions = new CircleOptions(); //创建一个圆形覆盖物参数
        circleOptions.center(latLngZhengQing); //圆心
        circleOptions.radius(1000)            //半径
                .stroke(new Stroke(20,0x55ff0000))
                .fillColor(0x55ff0000);//填充颜色
        baiduMap.addOverlay(circleOptions);//添加一个圆形覆盖物
    }
}
