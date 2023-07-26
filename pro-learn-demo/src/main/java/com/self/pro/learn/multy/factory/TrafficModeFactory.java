package com.self.pro.learn.multy.factory;

import com.self.pro.learn.multy.service.TrafficMode;
import com.self.pro.learn.multy.enums.TrafficCode;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 交通方式工厂类
 */
@Component
public class TrafficModeFactory implements ApplicationContextAware {

    private static Map<TrafficCode, TrafficMode> trafficBeanMap;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        Map<String, TrafficMode> map = applicationContext.getBeansOfType(TrafficMode.class);
        trafficBeanMap = new HashMap<>();
        map.forEach((key, value) -> trafficBeanMap.put(value.getCode(), value));
    }

    public static <T extends TrafficMode> T getTrafficMode(TrafficCode code) {
        return (T)trafficBeanMap.get(code);
    }

}
