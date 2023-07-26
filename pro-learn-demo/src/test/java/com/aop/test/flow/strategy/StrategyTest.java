package com.aop.test.flow.strategy;

import com.self.pro.learn.ProDemoApplication;
import com.self.pro.learn.strategy.service.impl.PrimaryMemberStrategy;
import com.self.pro.learn.strategy.util.ThreadLocalUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProDemoApplication.class)
public class StrategyTest {
//    @Autowired
//    private MemberStrategy memberStrategy;
    @Test
    public void testProcess() {

        PrimaryMemberStrategy memberStrategy = (PrimaryMemberStrategy) ThreadLocalUtil.getThreadLocal().get("primaryMemberStrategy");
        System.out.println(">>>>>>>>>test" + memberStrategy.calcPrice(100,2));

    }

}