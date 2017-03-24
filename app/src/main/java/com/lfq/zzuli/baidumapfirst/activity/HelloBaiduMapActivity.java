package com.lfq.zzuli.baidumapfirst.activity;
import android.util.Log;
import android.view.KeyEvent;


import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;

public class HelloBaiduMapActivity extends BaseActivity {

    private String TAG = "HelloBaiduMapActivity";


    @Override
    public void init() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        //        5.	更新地图状态
        switch (keyCode){
            case KeyEvent.KEYCODE_1:
//        1)	缩小
                mapStatusUpdate = MapStatusUpdateFactory.zoomOut();
                break;
            case KeyEvent.KEYCODE_2:
//        2)	放大
                mapStatusUpdate = MapStatusUpdateFactory.zoomIn();
                break;
            case KeyEvent.KEYCODE_3:
//        3)	旋转（0 ~ 360），每次在原来的基础上再旋转30度
                MapStatus currentMapStatus = baiduMap.getMapStatus();  //获取地图的当前状态
                float rotate = currentMapStatus.rotate + 30;   //得到地图的当前角度
                Log.d(TAG,"currentMapStatus" + rotate);
                mapStatus = new MapStatus.Builder().rotate(rotate).build();
                mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mapStatus);
                break;
            case KeyEvent.KEYCODE_4:
//        4)	俯仰（0 ~ -45），每次在原来的基础上再俯仰-5度
                MapStatus overlookStatus = baiduMap.getMapStatus();  //获取地图的当前状态
                float overLookStatus = overlookStatus.overlook - 5;
                mapStatus = new MapStatus.Builder().overlook(overLookStatus).build();
                mapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mapStatus);
                break;
            case KeyEvent.KEYCODE_5:
//        5)	移动
                mapStatusUpdate = MapStatusUpdateFactory.newLatLng(latLngBJ);
                baiduMap.animateMapStatus(mapStatusUpdate,2000);
                //通过return语句，不执行下面的 baiduMap.setMapStatus(mapStatusUpdate)语句，使地图缓慢进行移动
                return super.onKeyDown(keyCode, event);
            default:
                break;
        }
        baiduMap.setMapStatus(mapStatusUpdate);
        return super.onKeyDown(keyCode, event);
    }

}
