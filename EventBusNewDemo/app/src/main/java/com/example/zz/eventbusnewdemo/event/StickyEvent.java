package com.example.zz.eventbusnewdemo.event;

/**
 * 类描述：粘性Event事件
 * 创建人：zz
 * 创建时间： 2017/8/29 14:21
 */


public class StickyEvent {
    private String content;

    public StickyEvent(String content) {
        this.content = content;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
