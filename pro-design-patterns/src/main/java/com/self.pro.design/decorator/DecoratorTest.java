package com.self.pro.design.decorator;

public class DecoratorTest {
    public static void main(String[] args) {
        Component component = new ConcreteDecorator(new ConcretComponent());

        //Component component = new Decorator();

        component.kill();

    }
}
