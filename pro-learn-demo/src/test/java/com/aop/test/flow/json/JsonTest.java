package com.aop.test.flow.json;

import com.alibaba.fastjson.JSON;
import com.self.pro.learn.ProDemoApplication;
import com.self.pro.learn.json.JsonData;
import com.self.pro.learn.json.config.ConfigMapBean;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProDemoApplication.class)
public class JsonTest {
    @Autowired
    private ConfigMapBean configMapBean;
    @Test
    public void testJson() {
//        Map<String, String> student = configMapBean.getStudent();
//
//        Map<String, String> jsonData = configMapBean.getJsonData();
//        log.info("student,jsondata{} {}",student,jsonData);
//
//        ReflectUtils.convertFileAnn(Student.class, student);
//        ReflectUtils.convertFileAnn(JsonData.class, jsonData);

        String jsonDatas = "{\"dueStraitSeptemberNobody\":[{\"address\":\"beijing\",\"stuAge\":20,\"stuName\":\"tomcat\",\"stuTime\":\"2023-03-06 15:39:50\"}]}";
        JsonData data = JSON.parseObject(jsonDatas, JsonData.class);
        System.out.println(data);

//        List<Student> userList = new ArrayList<>();
//        Student stu = new Student();
//        stu.setAge(20);
//        stu.setName("tomcat");
//        stu.setHireDate(new Date());
//        stu.setAddr("beijing");
//        userList.add(stu);
//        JsonData data = new JsonData();
//        data.setStudents(userList);
//        String jsonString = JSON.toJSONString(data);
//        System.out.println(jsonString);

    }

}