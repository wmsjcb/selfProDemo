package com.self.pro.proxy.staticed;

/**
 * Created by chenbinbin1 on 2018/5/30.
 */
public class Son  implements Person{

    @Override
    public void findLove() {
        System.out.println("找个有钱的");
    }

    @Override
    public void findJob() {
        System.out.println("找个不加班的");
    }
}
