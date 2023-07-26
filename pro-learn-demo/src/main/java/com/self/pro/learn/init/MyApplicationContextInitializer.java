package com.self.pro.learn.init;

import com.self.pro.learn.json.config.ConfigMapBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyApplicationContextInitializer implements ApplicationContextInitializer {
    @Autowired
    private ConfigMapBean configMapBean;
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {

//        System.out.println("-----MyApplicationContextInitializer initialize-----");
//        Map<String, String> student = configMapBean.getStudent();
//        Map<String, String> jsonData = configMapBean.getJsonData();
//        log.info("student,jsondata{} {}",student,jsonData);
//        ReflectUtils.convertFileAnn(Student.class, student);
//        ReflectUtils.convertFileAnn(JsonData.class, jsonData);
    }
}
