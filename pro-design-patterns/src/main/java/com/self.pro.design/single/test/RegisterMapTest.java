package com.self.pro.design.single.test;


import com.self.pro.design.single.register.RegisterMap;

import java.util.concurrent.CountDownLatch;

/**
 * Created by chenbinbin1 on 2018/5/25.
 */
public class RegisterMapTest {
    public static void main(String[] args) {
        final CountDownLatch downLatch = new CountDownLatch(1000);
        for(int i=0;i<=downLatch.getCount();i++){
            new Thread(){
                @Override
                public void run() {
                    try {
                        System.out.println(System.currentTimeMillis()+":"+Thread.currentThread().getName()+":"+ RegisterMap.getInstance("test"));
                        Thread.sleep(3000);
                        downLatch.countDown();
                        //System.out.println("子线程 count值："+downLatch.getCount());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }.start();
        }

        try {
            downLatch.await();
            System.out.println("执行完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
