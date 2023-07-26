package com.self.pro.learn.proxy.cjlib;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

//import com.test.json.config.YmlConstantsHelper;
@Data
@Slf4j
public class Student {
    @JSONField(name= "userName")
//    @JSONField(name="${json-map.student.name}")
    private String name;
    @JSONField(name="userge")
    private int age;
    @JSONField(format="yyyy-MM-dd HH:mm:ss",ordinal = 1)
    private Date hireDate;
    @JSONField(name= "address")
    private String addr;
}
