package com.self.pro.learn.mapstruct.bean;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class Person {

   private String describe;

    private String id;

    private String name;

    private int age;

    private BigDecimal source;

    private double height;

    private Date createTime;
    //嵌套
    private Child personChild;
	
}



