package com.example.zz.eventbusnewdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zz.eventbusnewdemo.event.FirstEvent;
import com.example.zz.eventbusnewdemo.event.StickyEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/**
 * 类描述：优先级别较低的接受者 / 粘性事件的发送者
 * 创建人：zz
 * 创建时间：2017/8/29 14:23
 */
public class MainActivity extends Activity {

    private Button buttonFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        EventBus.getDefault().register(this);
    }

    /**
     * 初始化UI
     */
    private void initView() {
        buttonFirst = ((Button) findViewById(R.id.button_first));
        buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(new StickyEvent("粘性测试"));
             startActivity(new Intent(getApplicationContext(),SecondActivity.class));
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN,priority = 60)
    public void onEvent(FirstEvent event){
        if(event != null){
            String message = event.getMessage();
           buttonFirst.setText(message);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
