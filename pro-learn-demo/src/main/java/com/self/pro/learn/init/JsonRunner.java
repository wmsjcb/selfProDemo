package com.self.pro.learn.init;

import com.self.pro.learn.json.config.ConfigMapBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Order(value = 1)
public class JsonRunner implements ApplicationRunner {
    @Autowired
    private ConfigMapBean configMapBean;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        //包
        System.out.println(">>>>>>>>>>>>>>run json method 执行方法");
//        Map<String, String> student = configMapBean.getStudent();
//        Map<String, String> jsonData = configMapBean.getJsonData();
//
//        log.info("student,jsondata{} {}",student,jsonData);
//        ReflectUtils.convertFileAnn(Student.class, student);
//        ReflectUtils.convertFileAnn(JsonData.class, jsonData);
        System.out.println("实例化后");
    }
}