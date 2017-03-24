package com.lfq.zzuli.baidumapfirst.activity;


import android.view.KeyEvent;
import com.baidu.mapapi.map.BaiduMap;

public class MapLayerActivity extends BaseActivity {

    @Override
    public void init() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_BUTTON_1:
                //显示普通地图
                baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                baiduMap.setTrafficEnabled(false);
                break;
            case KeyEvent.KEYCODE_BUTTON_2:
                //显示卫星图
                baiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
                baiduMap.setTrafficEnabled(false);
                break;
            case KeyEvent.KEYCODE_BUTTON_3:
                //显示交通图
                baiduMap.setTrafficEnabled(true);
                break;
            default:
                break;
        }
        return super.onKeyDown(keyCode,event);
    }
}
