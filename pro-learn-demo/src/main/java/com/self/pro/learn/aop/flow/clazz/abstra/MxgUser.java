package com.self.pro.learn.aop.flow.clazz.abstra;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component("mxgUser")
public class MxgUser extends AbstractUser{

    @Override
    public void save() {
//        Map<String, Object> map = CashContext.getContext();
//        if (!map.isEmpty()) {
//            String country = (String) map.get("country");
//            log.info(">>>>>>>>>country" + country);
//        }
        log.info(">>>>>>>>>>>mxgUser save");

    }
}
