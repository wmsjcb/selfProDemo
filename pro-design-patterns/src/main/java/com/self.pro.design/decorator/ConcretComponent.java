package com.self.pro.design.decorator;

//具体实现类
public class ConcretComponent implements Component {
    @Override
    public void kill() {
        System.out.println("我是标准原始的杀手");
    }
}
