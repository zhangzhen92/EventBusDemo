package com.example.zz.eventbusnewdemo;

import android.app.Application;

import com.afei.test.MyEventBusIndex;

import org.greenrobot.eventbus.EventBus;

/**
 * 类描述：application  开启EventBus  加速模式
 * 创建人：zz
 * 创建时间： 2017/8/29 14:34
 */


public class EventApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.builder().addIndex(new MyEventBusIndex()).installDefaultEventBus();        //开启加速模式
    }
}
