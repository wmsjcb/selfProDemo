package com.self.pro.proxy.test;

import com.self.pro.proxy.hungry.Hungry;

import java.util.concurrent.CountDownLatch;

/**
 * Created by chenbinbin1 on 2018/5/25.
 */
public class HungryTest {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(100);
        for(int i=0;i<=latch.getCount();i++)
            new Thread() {
                @Override
                public void run() {
                    //System.out.println("时间："+System.currentTimeMillis()+ LazySingle.getInstance());
                    System.out.println("时间："+System.currentTimeMillis()+ Hungry.getInstance());
                }
            }.start();



    }
}
