package com.example.zz.eventbusnewdemo.event;

/**
 * 类描述：EventBus  事件
 * 创建人：zz
 * 创建时间： 2017/8/29 13:27
 */


public class FirstEvent {
    private String message;
    private int id;

    public FirstEvent(String message) {
        this.message = message;
    }

    public FirstEvent(String message, int id) {
        this.message = message;
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
