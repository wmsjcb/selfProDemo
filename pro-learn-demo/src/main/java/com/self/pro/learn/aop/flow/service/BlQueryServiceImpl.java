package com.self.pro.learn.aop.flow.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("blQueryServiceImpl")
@Slf4j
public class BlQueryServiceImpl implements QueryService {
    @Override
    public List<String> queryUser() {
        log.info(">>>>>>>>>>>BlQueryService");
        return null;
    }
}
