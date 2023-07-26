package com.self.pro.learn.chain.spring.generic.service.impl;

import com.self.pro.learn.chain.spring.generic.service.Chain;
import com.self.pro.learn.chain.spring.generic.service.ChainHandler;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
@Component
public class ChainImpl<T extends ChainHandler<K>,K> implements Chain<K> {
    private final List<T> handlers;

    @Nullable
    private Iterator<T> iterator;

    public ChainImpl(List<T> handlers) {
        this.handlers = handlers;
    }


    @Override
    public void doHandler(K params) {
        if (this.iterator == null) {
            this.iterator = this.handlers.iterator();
        }

        if (this.iterator.hasNext()) {
            T next = this.iterator.next();
            next.hander(params, this);
        }
    }
}
