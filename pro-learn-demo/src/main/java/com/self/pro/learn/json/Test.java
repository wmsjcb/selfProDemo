package com.self.pro.learn.json;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        String originalFilename = "01_cfecredito.json";
//        String fileName = originalFilename.split("_")[1];
//        String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
//
//        System.out.println(suffix);
        Map<String,Map<String,String>> fieldMap = new HashMap<>();
        Map<String,String> studentMap = new HashMap<>();
        studentMap.put("name","username");
        studentMap.put("age","userage");
        fieldMap.put("student", studentMap);
        Map<String,String> jsonDataMap = new HashMap<>();
        jsonDataMap.put("application","studentlist");
        fieldMap.put("jsonData", jsonDataMap);
        String str = JSON.toJSONString(fieldMap);
        System.out.println(str);
        Map<String,Map<String,String>> fMap = JSON.parseObject(str, Map.class);
        System.out.println(fMap);



    }
}
