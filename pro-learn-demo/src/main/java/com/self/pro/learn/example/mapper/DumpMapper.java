package com.self.pro.learn.example.mapper;

import org.apache.ibatis.annotations.Param;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:20
 */
public interface DumpMapper {

    void backupLog(@Param("createTime")String createTime, @Param("tableName")String tableName, @Param("currenTableName")String currenTableName);

}
