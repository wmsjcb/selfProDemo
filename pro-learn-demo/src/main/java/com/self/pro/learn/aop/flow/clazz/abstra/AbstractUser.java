package com.self.pro.learn.aop.flow.clazz.abstra;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public abstract class AbstractUser {

    public void query() {
        log.info(">>>>>>>>>>>query starts");
    }

    public void save(){};

    public final void process() {
        query();
        save();
    }

}
