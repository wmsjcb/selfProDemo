package com.self.pro.design.prototype.gzhs;

public class Client {

    public static void main(String[] args) { 
        Thing thing = new Thing(); //产生一个对象
        Thing cloneThing = thing.clone(); //拷贝一个对象
    }
}