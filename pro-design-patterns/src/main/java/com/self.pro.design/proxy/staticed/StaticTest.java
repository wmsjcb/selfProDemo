package com.self.pro.design.proxy.staticed;

/**
 * Created by chenbinbin1 on 2018/5/30.
 */
public class StaticTest {
    public static void main(String[] args) {
        Father f = new Father(new Son());
        f.findLove();

    }
}
