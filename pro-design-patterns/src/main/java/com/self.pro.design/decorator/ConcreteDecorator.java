package com.self.pro.design.decorator;

public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void kill() {
        System.out.println("ready?go!");
        //this.component.kill();
        super.kill();
    }
}
