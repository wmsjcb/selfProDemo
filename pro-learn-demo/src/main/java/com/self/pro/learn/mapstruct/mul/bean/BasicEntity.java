package com.self.pro.learn.mapstruct.mul.bean;

import lombok.Data;

import java.util.Date;

@Data
public class BasicEntity {

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private int _ROW;

}