package com.self.pro.learn.json.util;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;
@Slf4j
public class ReflectUtils{

    public static void convertFileAnn(Class<?> clazz,Map<String,String> fileAnnMap) {
        try {
            //拿到所有字段
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                // 获取注解
                JSONField jsonField = field.getAnnotation(JSONField.class);
                if (jsonField == null) {
                    continue;
                }

                String before = jsonField.name();
                log.info("之前的值 {}", before);
                //反射获取注解的代理对象
                InvocationHandler invocationHandler = Proxy.getInvocationHandler(jsonField);
                //获取代理对象的 memberValues 字段
                Field declaredField = invocationHandler.getClass().getDeclaredField("memberValues");
                //访问私有属性 (private可访问)
                declaredField.setAccessible(true);
                // 获取 memberValues
                Map memberValues = (Map) declaredField.get(invocationHandler);
                if (fileAnnMap.containsKey(field.getName())) {
                    memberValues.put("name", fileAnnMap.get(field.getName()));
                }

                // 修改注解的值
//                if (field.getName().equals("name")) {
//                    memberValues.put("name", "testName");
//                } else if (field.getName().equals("age")) {
//                    memberValues.put("name", "testAge");
//                }
                String after = jsonField.name();
                log.info("之后的值 {}", after);
            }
        } catch (Exception e) {
            log.error("jsonData jsonFiled convert error {}", clazz);
            e.printStackTrace();
        }

    }

    public static Object convertFileAnnClazz(Class<?> clazz,Map<String,String> fileAnnMap) {
        Object obj = null;
        try {
            //拿到所有字段
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                // 获取注解
                JSONField jsonField = field.getAnnotation(JSONField.class);
                if (jsonField == null) {
                    continue;
                }
//                String before = excel.name();
//                log.info("之前的值 {}", before);
                //反射获取注解的代理对象
                InvocationHandler invocationHandler = Proxy.getInvocationHandler(jsonField);
                //获取代理对象的 memberValues 字段
                Field declaredField = invocationHandler.getClass().getDeclaredField("memberValues");
                //访问私有属性 (private可访问)
                declaredField.setAccessible(true);
                // 获取 memberValues
                Map memberValues = (Map) declaredField.get(invocationHandler);
                if (fileAnnMap.containsKey(field.getName())) {
                    memberValues.put("name", fileAnnMap.get(field.getName()));
                }

                // 修改注解的值
//                if (field.getName().equals("name")) {
//                    memberValues.put("name", "testName");
//                } else if (field.getName().equals("age")) {
//                    memberValues.put("name", "testAge");
//                }
//                String after = excel.name();
//                log.info("之后的值 {}", after);
            }
            obj = clazz.newInstance();
        } catch (Exception e) {
            log.error("jsonData jsonFiled convert error {}", clazz);
            e.printStackTrace();
        }
        return obj;
    }
}
