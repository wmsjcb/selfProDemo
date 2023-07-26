package com.aop.test.flow;

import com.self.pro.learn.ProDemoApplication;
import com.self.pro.learn.aop.flow.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProDemoApplication.class)
public class UserServiceImplTest {
    @Resource(name ="userServiceImpl")
   private UserService userService;

    @Test
    public void testQuery() {
        userService.query();
    }
}