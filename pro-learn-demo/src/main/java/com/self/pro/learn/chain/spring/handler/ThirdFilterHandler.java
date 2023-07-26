package com.self.pro.learn.chain.spring.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("thirdFilterHandler")
@Slf4j
public class ThirdFilterHandler extends AbstractFilterHandler {


    @Override
    public int handler() {
        log.error("第三环节处理");
        return 0;
    }

}