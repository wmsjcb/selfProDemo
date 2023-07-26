package com.self.pro.learn.json;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;
@Data
public class JsonData {
    @JSONField(name="dueStraitSeptemberNobody")
    private List<Student> students;

}
