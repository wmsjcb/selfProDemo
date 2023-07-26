package com.self.pro.learn.chain.handler;

public abstract class AbstractFilterHandler {

    /**
     * 定义下一用当前抽象类来接收
     */
    protected AbstractFilterHandler next;

    public void setNext(AbstractFilterHandler next) {
        this.next = next;
    }

    public abstract int handler();
}

