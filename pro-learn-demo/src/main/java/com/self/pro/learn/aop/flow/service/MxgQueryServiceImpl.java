package com.self.pro.learn.aop.flow.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("mxgQueryService")
@Slf4j
public class MxgQueryServiceImpl implements QueryService {
    @Override
    public List<String> queryUser() {
        log.info(">>>>>>>>>>>MxgQueryService");
        return null;
    }
}
