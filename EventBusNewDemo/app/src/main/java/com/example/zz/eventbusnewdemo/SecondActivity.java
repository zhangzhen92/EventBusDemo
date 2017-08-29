package com.example.zz.eventbusnewdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zz.eventbusnewdemo.event.FirstEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/**
 * 类描述：优先级别较高的接受者
 * 创建人：zz
 * 创建时间：2017/8/29 14:22
 */
public class SecondActivity extends Activity {

    private Button buttonSecond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        EventBus.getDefault().register(this);
        initView();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        buttonSecond = ((Button) findViewById(R.id.button_second));
        buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ThirdActivity.class));
            }
        });
    }

    /**
     * TODO  优先级高的终止后续操作，threadmode必须是跟发送者同一个线程
     * MAIN 在UI主线程
     * BACKGROUND 后台线程，仅当发布者在UI线程时才会新建一个后台线程执行
     * POSTING 和发布者处在同一个线程
     * ASYNC 异步线程，无论发布者在哪个线程都重新建一个线程执行
     */
    @Subscribe(threadMode = ThreadMode.POSTING, priority = 1000)
    public void onSecondEvent(FirstEvent event) {
        if (event != null) {
            String secondMessage = event.getMessage();
            buttonSecond.setText(secondMessage);
            EventBus.getDefault().cancelEventDelivery(event);                 //终止后续操作
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
