package com.aop.test.springaopdemo;

import com.self.pro.learn.ProDemoApplication;
import com.self.pro.learn.aop.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProDemoApplication.class)
class ProDemoApplicationTests {

	@Autowired
	private UserService userService;

	@Test
	void contextLoads() {
		//userService.getUserById(99);
		userService.deleteUserById(99);
	}



}
