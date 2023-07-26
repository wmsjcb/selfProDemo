package com.self.pro.learn.mapstruct.bean;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class PersonEntry  implements Serializable {
 @Column(name = "describe")
   private String describe;
   @Id
    private String id;
 @Column(name = "name")
    private String name;
 @Column(name = "age")
    private int age;
 @Column(name = "source")
    private BigDecimal source;
 @Column(name = "height")
    private double height;
 @Column(name = "createTime")
    private Date createTime;
	
}



