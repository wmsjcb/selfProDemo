package com.self.pro.learn.rest;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.self.pro.learn.json.JsonData;
import com.self.pro.learn.json.Student;
import com.self.pro.learn.json.util.ReflectUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@Slf4j
@RequestMapping("/test")
public class TestJsonController {

    @RequestMapping(value = "/testJson", method = RequestMethod.GET)
    public void testJson(@RequestParam("flag")String flag){
        Map<String, String>  studentMap = new HashMap<>();//configMapBean.getStudent();
        Map<String, String> jsonDataMap = new HashMap<>();//configMapBean.getJsonData();
        if (flag.equals("1")) {
//            student = new HashMap<>();
            studentMap.put("name","tomname");
            studentMap.put("age","tomage");
//            jsonData = new HashMap<>();
            jsonDataMap.put("students","tomstudents");
        } else {
//            student = new HashMap<>();
            studentMap.put("name","jackname");
            studentMap.put("age","jackage");
//            jsonData = new HashMap<>();
            jsonDataMap.put("students","jackstudents");
        }

//        Class<?> clazz = new Student().getClass();
        ReflectUtils.convertFileAnn(Student.class , studentMap);
        ReflectUtils.convertFileAnn(JsonData.class , jsonDataMap);
        log.info("student,jsondata{} {}",studentMap,jsonDataMap);
//        try {
//            ReflectUtils.convertFileAnn(Class.forName("com.test.json.Student") , student);
//            ReflectUtils.convertFileAnn(Class.forName("com.test.json.JsonData") , jsonData);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        List<Student> userList = new ArrayList<>();
        Student stu = new Student();
        stu.setAge(20);
        stu.setName("tomcat");
        stu.setHireDate(new Date());
        userList.add(stu);
        JsonData data = new JsonData();
        data.setStudents(userList);
        String jsonString = JSON.toJSONString(data);
//        String  s = new Gson().toJson(data);
        System.out.println(jsonString);
//        System.out.println(s);


//        List<Student> userList = new ArrayList<>();
//        Student stu = new Student();
//        stu.setAge(10);
//        stu.setName("tom");
//        stu.setHireDate(new Date());
//        stu.setAddr("beijing");
//        userList.add(stu);
//        JsonData data = new JsonData();
//        data.setStudents(userList);
//        String jsonString = JSON.toJSONString(data);
//        System.out.println(jsonString);
    }

}
