package com.self.pro.learn.chain.spring.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("firstFilterHandler")
@Slf4j
public class FirstFilterHandler extends AbstractFilterHandler {

    @Override
    public int handler() {
        log.error("第一环节处理");
        if (true) {
            throw new RuntimeException("test error");
        }
        return 0;
    }

}