package com.aop.test.flow.mybatis;

import com.self.pro.learn.ProDemoApplication;
import com.self.pro.learn.example.entity.User;
import com.self.pro.learn.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProDemoApplication.class)
public class DBTest {
    @Resource(name = "uService")
    private UserService userService;
    @Test
    public void testProcess() {
        User user = userService.Sel(1);
        System.out.println(user);

    }

}