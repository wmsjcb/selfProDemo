package com.self.pro.learn.aop.flow.clazz.abstra;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("blUser")
public class BlUser extends AbstractUser{

    @Override
    public void save() {
        log.info(">>>>>>>>>>>blUser save");

    }
}
