package com.example.zz.eventbusnewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.zz.eventbusnewdemo.event.FirstEvent;
import com.example.zz.eventbusnewdemo.event.StickyEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
/**
 * 类描述：粘性Event测试类
 * 创建人：zz
 * 创建时间：2017/8/29 14:29
 */
public class ThirdActivity extends Activity {

    private Button buttonThird;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        initView();
        EventBus.getDefault().register(this);
    }

    /**
     * 初始化UI
     */
    private void initView() {
        buttonThird = ((Button) findViewById(R.id.button_third));
        buttonThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(new FirstEvent("Post Content"));
            }
        });

    }

    /**
     * 粘性Event事件测试
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN,sticky = true)
    public void onStickyEvent(StickyEvent event){
        if(event != null){
            buttonThird.setText(event.getContent());
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
