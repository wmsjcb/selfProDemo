package com.self.pro.decorator;

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
