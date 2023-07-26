package com.self.pro.design.single.lazy;

/**
 * Created by chenbinbin1 on 2018/5/25.
 */
public class LazyOne {
    private LazyOne(){}
    private static LazyOne lazyOne =null;
    public static  LazyOne getInstance(){

        if(lazyOne==null){
            lazyOne= new LazyOne();
        }

        return lazyOne;
    }

}
