package com.self.pro.design.single.seriable;

import java.io.Serializable;

public class Seriable implements Serializable {
    private Seriable(){}

    private static final   Seriable seriable = new Seriable();

    public  static Seriable getInstace(){
        return seriable;
    }

    //JDK 会自动调用，防止读流破坏单例
    private  Object readResolve(){
        return  seriable;
    }


}
