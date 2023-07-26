package com.aop.test.springaopdemo;

import com.self.pro.learn.ProDemoApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProDemoApplication.class)
class SwitchTests {

//	@Autowired
//	private Conf conf;
//
//	@Test
//	void contextLoads() {
//		boolean isOpen = conf.isIsopen();
//		System.out.println(isOpen);
//	}


    @Test
    private void test() {
        List<Object> l1 = null;

        List<String> l2 = null;
        //通配符
        List<?> list = null;
         list = l2;
         list = l1;

        //l1 = l2;

        //test2(l1);

    }


//    private void test2(List<T> list) {
//
//    }

}
