package com.self.pro.decorator;

//装饰类
public class Decorator implements Component {
    protected Component component;

    public Decorator(){

    }

    public  Decorator(Component component){
         this.component = component;
    }

    @Override
    public void kill() {
        System.out.println("我是个装饰的杀手");

    }
}
