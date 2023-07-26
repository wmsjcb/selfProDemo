package com.self.pro.learn.aop.flow.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userServiceImpl")
@Slf4j
public class UserServiceImpl implements UserService{
    //@Autowired(v"blQueryServiceImpl")
    @Resource(name = "blQueryServiceImpl")
    private QueryService queryService;
    @Override
    public void query() { log.info(">>>>>>>>>>>query starts");
        queryService.queryUser();

    }

    @Override
    public void save() {
        log.info(">>>>>>>>>>>save starts");
    }
}
