package com.self.pro.proxy.hungry;

/**
 * Created by chenbinbin1 on 2018/5/25.
 */
public class Hungry {
    private  Hungry(){

    }

    private static  final Hungry hugry = new Hungry();
    public static Hungry getInstance(){
        return hugry;
    }
}
