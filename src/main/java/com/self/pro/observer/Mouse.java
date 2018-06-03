package com.self.pro.observer;

import com.self.pro.observer.core.EventLisenter;

//被观察者对象
public class Mouse extends EventLisenter {

    public  void click(){
        System.out.println("鼠标单击");
        this.trigger(MouseEventType.ON_CLICK);
    }

    public  void doubleCick(){
        System.out.println("鼠标双击");
        this.trigger(MouseEventType.ON_DOUBLE_CLICK);
    }

    public  void up(){
        System.out.println("鼠标弹起");
        this.trigger(MouseEventType.ON_UP);
    }
}
