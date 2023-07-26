package com.self.pro.learn.mapstruct.bean;

import lombok.Data;

import java.util.Date;

@Data
public class PersonDTO {

    private String describe;

    private Long id;

    private String personName;

    private String age;

    private String source;

    private String height;

    private Date createTime;

    //嵌套
    private Child child;

}