package com.lfq.zzuli.baidumapfirst;

import android.app.Application;
import com.baidu.mapapi.SDKInitializer;

/**
 * Created by Administrator on 2016/11/20 0020.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //在使用SDK各组件之前初始化context信息(就是在初始化android四大组件之前)，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
    }
}
