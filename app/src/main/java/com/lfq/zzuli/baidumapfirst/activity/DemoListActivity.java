package com.lfq.zzuli.baidumapfirst.activity;

import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.baidu.mapapi.SDKInitializer;
import com.lfq.zzuli.baidumapfirst.util.Util;


public class DemoListActivity extends ListActivity {

    BroadcastReceiver receiver;

    ClassAndName[] datas = {
        new ClassAndName(HelloBaiduMapActivity.class,"HelloBaiduMap"),
        new ClassAndName(MapLayerActivity.class,"地图图层"),
        new ClassAndName(CircleOverlayActivity.class,"圆形覆盖物"),
        new ClassAndName(TextOverlayActivity.class,"文字覆盖物"),
        new ClassAndName(MarkerOverlayActivity.class,"标志覆盖物"),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerSDKCheckReceiver();
        ArrayAdapter<ClassAndName> adapter =
                new ArrayAdapter<ClassAndName>(this,android.R.layout.simple_list_item_1,datas);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        //取出单击位置的ClassAndName
        ClassAndName classAndName = (ClassAndName)l.getItemAtPosition(position);
        Intent intent = new Intent(DemoListActivity.this,classAndName.clazz);
        startActivity(intent);
    }

    class ClassAndName{
        public Class<?> clazz;
        public String name;

        public ClassAndName(Class<?> cls, String name) {
            this.clazz = cls;
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }


    //用广播组件监听网络相关、以及密钥等信息
    private void registerSDKCheckReceiver(){
        receiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR.equals(action)){
                    Util.showToast(DemoListActivity.this,"网络错误!");
                }else if(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR.equals(action)){
                    Util.showToast(DemoListActivity.this,"key验证失败!");
                }
            }
        };
        IntentFilter filter = new IntentFilter();
        //监听网络错误的Action
        filter.addAction(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
        //监听百度地图的sdk的key是否正确的Action
        filter.addAction(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR);
        registerReceiver(receiver,filter);
    }

    protected void onDestroy() {
        super.onDestroy();
        //去掉广播注册
        unregisterReceiver(receiver);
    }
}
