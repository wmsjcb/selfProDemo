package com.self.pro.learn.chain.spring.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("secondFilterHandler")
@Slf4j
public class SecondFilterHandler extends AbstractFilterHandler {


    @Override
    public int handler() {
        log.error("第二环节处理");
        return 0;
    }

}