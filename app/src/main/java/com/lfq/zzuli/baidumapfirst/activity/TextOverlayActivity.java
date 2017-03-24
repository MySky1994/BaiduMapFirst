package com.lfq.zzuli.baidumapfirst.activity;

import com.baidu.mapapi.map.TextOptions;

public class TextOverlayActivity extends BaseActivity {

    @Override
    public void init() {
        TextOptions textOptions = new TextOptions();
        textOptions.position(latLngZhengQing) //文字位置
        .text("这里是郑州轻工业学院") //文字内容
        .fontSize(20) //文字大小
        .fontColor(0xFF000000) //文字颜色
        .bgColor(0x55ff0000) //文字的背景颜色
        .rotate(30); //旋转角度
        baiduMap.addOverlay(textOptions);
    }
}
