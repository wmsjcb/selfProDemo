package com.self.pro.proxy.test;

import com.self.pro.proxy.lazy.LazyOne;

/**
 * Created by chenbinbin1 on 2018/5/25.
 */
public class TimeTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for(int i=0;i<=100000;i++){

            System.out.println(LazyOne.getInstance());
        }
        System.out.println("耗时："+(System.currentTimeMillis()-start));

    }
}
