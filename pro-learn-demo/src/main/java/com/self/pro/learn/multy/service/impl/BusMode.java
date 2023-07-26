package com.self.pro.learn.multy.service.impl;

import com.self.pro.learn.multy.enums.TrafficCode;
import com.self.pro.learn.multy.service.TrafficMode;
import org.springframework.stereotype.Component;

/**
 * 汽车方式
 */
@Component
public class BusMode implements TrafficMode {

    @Override
    public TrafficCode getCode() {
        return TrafficCode.BUS;
    }

    @Override
    public Integer getFee() {
        return 10000;
    }

}
