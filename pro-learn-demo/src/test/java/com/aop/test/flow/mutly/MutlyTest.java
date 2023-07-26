package com.aop.test.flow.mutly;

import com.self.pro.learn.ProDemoApplication;
import com.self.pro.learn.multy.enums.TrafficCode;
import com.self.pro.learn.multy.factory.TrafficModeFactory;
import com.self.pro.learn.multy.service.TrafficMode;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProDemoApplication.class)
public class MutlyTest {
//    @Autowired
//    private MemberStrategy memberStrategy;
@Test
public void testGetTrafficMode() {
    TrafficMode mode = TrafficModeFactory.getTrafficMode(TrafficCode.BUS);
    Assert.assertEquals(mode.getFee().intValue(), 10000);

    mode = TrafficModeFactory.getTrafficMode(TrafficCode.TRAIN);
    Assert.assertEquals(mode.getFee().intValue(), 9000);
}


}