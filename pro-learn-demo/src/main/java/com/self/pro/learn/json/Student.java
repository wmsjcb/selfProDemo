package com.self.pro.learn.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.self.pro.learn.json.util.ReflectUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

//import com.test.json.config.YmlConstantsHelper;
@Data
@Slf4j
public class Student{
    @JSONField(name= "userName")
//    @JSONField(name="${json-map.student.name}")
    private String name;
    @JSONField(name="userge")
    private int age;
    @JSONField(format="yyyy-MM-dd HH:mm:ss",ordinal = 1)
    private Date hireDate;
    @JSONField(name= "address")
    private String addr;

    public static void main(String[] args) {
        convertCollectionToJson();
    }

    public static void convertCollectionToJson(){

        Map<String,String> fieldAnnMap = new HashMap<>();
        fieldAnnMap.put("name", "nick");
        fieldAnnMap.put("age", "nickAge");
        fieldAnnMap.put("hireDate", "date");
        ReflectUtils.convertFileAnn(Student.class, fieldAnnMap);

        Map<String,String> jsonDatafieldAnnMap = new HashMap<>();
        jsonDatafieldAnnMap.put("application", "userList");
        ReflectUtils.convertFileAnn(JsonData.class, jsonDatafieldAnnMap);

        List<Student> userList = new ArrayList<>();
        Student student = new Student();
        student.setAge(20);
        student.setName("tomcat");
        student.setHireDate(new Date());
        userList.add(student);

        Student student2 = new Student();
        student2.setAge(22);
        student2.setName("tomcat2");
        student2.setHireDate(new Date());
        userList.add(student2);
        JsonData jsonData = new JsonData();
        jsonData.setStudents(userList);
        String jsonString = JSON.toJSONString(jsonData);
        System.out.println(jsonString);

//        try {
//            String data = convertJson(jsonString, Class.forName("com.test.json.JsonData"));
//            System.out.println(data);
//            JSONObject jsonDatas = JSON.parseObject(data);
//            JSONArray applications = jsonDatas.getJSONArray("students");
//            System.out.println(applications);
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }


//        } catch (Exception e) {
//            e.printStackTrace();
//            //throw new HisignException("注解值修改失败!");
//        }




    }
    public static String convertJson(String json, Class jsonDataC){
        Object jsonData = JSON.parseObject(json, jsonDataC);
        Gson gson = new GsonBuilder().create();
        return gson.toJson(jsonData);
    }
}
