package com.self.pro.single.test;

import java.util.concurrent.CountDownLatch;

/**
 * Created by chenbinbin1 on 2018/5/25.
 */
public class CountDownLanchTest {
    public static void main(String[] args) {
        final CountDownLatch downLatch = new CountDownLatch(2);
        for(int i=0;i<=downLatch.getCount();i++){
         new Thread(){
           @Override
           public void run() {
               try {
                   System.out.println("子线程："+Thread.currentThread().getName()+"正在执行");
                   Thread.sleep(3000);
                   System.out.println("子线程："+Thread.currentThread().getName()+"执行完毕");
                   downLatch.countDown();
                   //System.out.println("子线程 count值："+downLatch.getCount());
               }catch (Exception e){
                   e.printStackTrace();
               }
           }
           }.start();
        }

//       new Thread(){
//           @Override
//           public void run() {
//               try {
//                   System.out.println("子线程："+Thread.currentThread().getName()+"正在执行");
//                   Thread.sleep(3000);
//                   System.out.println("子线程："+Thread.currentThread().getName()+"执行完毕");
//                   downLatch.countDown();
//                   System.out.println("子线程 count值1："+downLatch.getCount());
//               }catch (Exception e){
//                   e.printStackTrace();
//               }
//           }
//       }.start();
//
//        new Thread(){
//            public void run() {
//                try {
//                    System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
//                    Thread.sleep(3000);
//                    System.out.println("子线程"+Thread.currentThread().getName()+"执行完毕");
//                    downLatch.countDown();
//                    System.out.println("子线程 count值2："+downLatch.getCount());
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            };
//        }.start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            downLatch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




    }

}
