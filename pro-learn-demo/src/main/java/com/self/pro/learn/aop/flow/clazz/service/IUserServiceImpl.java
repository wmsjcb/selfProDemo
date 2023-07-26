package com.self.pro.learn.aop.flow.clazz.service;

import com.self.pro.learn.aop.flow.clazz.abstra.AbstractUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service("iUserServiceImpl")
public class IUserServiceImpl implements IUserService{
    @Resource(name = "blUser")
    private AbstractUser user;

    @Override
    public void process() {
//        Map<String, Object> map = CashContext.getContext();
//		if (!map.isEmpty()) {
//			String country = (String) map.get("country");
//            log.info(">>>>>>>>>country" + country);
//		}
        user.process();
    }
}
