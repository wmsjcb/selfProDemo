package com.self.pro.learn.chain.spring.generic.handler;

import com.self.pro.learn.chain.spring.generic.service.Chain;
import com.self.pro.learn.chain.spring.generic.dto.DismissDTO;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class DismissHandler2 implements DismissHandler {

    @Override
    public void hander(DismissDTO params, Chain chain) {
        System.out.println("解散班组条件2通过");
        chain.doHandler(params);
    }
}

