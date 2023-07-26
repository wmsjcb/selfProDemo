package com.aop.test.flow.clazz;

import com.self.pro.learn.ProDemoApplication;
import com.self.pro.learn.aop.flow.clazz.context.CashContext;
import com.self.pro.learn.aop.flow.clazz.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProDemoApplication.class)
public class IUserServiceImplTest {
    @Resource
    private IUserService iUserServiceImpl;
    @Test
    public void testProcess() {
        Map<String,Object> map = new HashMap<>();
        map.put("country","mxg");
        CashContext.setContext(map);
        //CashContext context = new CashContext();
        iUserServiceImpl.process();
    }

}