package com.aop.test.flow.decorator;

import com.self.pro.learn.ProDemoApplication;
import com.self.pro.learn.decorator.FriedChickenDecorator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProDemoApplication.class)
public class DecoratorTest {
    @Resource
    private FriedChickenDecorator decorator;
    @Test
    public void testProcess() {
        decorator.makeFriedChicken();

    }

}