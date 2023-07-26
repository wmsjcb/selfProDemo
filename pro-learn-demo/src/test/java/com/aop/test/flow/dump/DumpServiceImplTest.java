package com.aop.test.flow.dump;

import com.self.pro.learn.ProDemoApplication;
import com.self.pro.learn.example.service.DumpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProDemoApplication.class)
public class DumpServiceImplTest {
    @Resource
   private DumpService dumpService;

    @Test
    public void testDump() {
        dumpService.dumpData();
    }
}