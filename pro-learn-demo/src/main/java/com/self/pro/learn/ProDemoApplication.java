package com.self.pro.learn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@MapperScan("com.self.pro.learn.example.mapper")
@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = "com.self.pro.learn")
public class ProDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProDemoApplication.class, args);
	}

}
