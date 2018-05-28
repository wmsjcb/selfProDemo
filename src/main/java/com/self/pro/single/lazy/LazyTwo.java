package com.self.pro.single.lazy;

/**
 * Created by chenbinbin1 on 2018/5/25.
 */
public class LazyTwo {
    private LazyTwo(){}
    private static LazyTwo lazyTwo =null;
    public static synchronized   LazyTwo getInstance(){

        if(lazyTwo==null){
            lazyTwo= new LazyTwo();
        }
        
        return lazyTwo;
    }

}
