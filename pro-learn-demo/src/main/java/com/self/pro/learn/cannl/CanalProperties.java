package com.self.pro.learn.cannl;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
//@ConfigurationProperties(prefix = "custom.canal")
@ConfigurationProperties(prefix = "custom.canal")
@Configuration
public class CanalProperties {

    private String  ip;//Canal IP
    private Integer port;//Canal Port
    // canal.properties 配置canal.destinations后，需要创建对应的文件夹，并各自有一份instance.properties
    private String  destination;// 目标配置 即放目标instance.properties的文件夹名字
    private String  username;//用户名
    private String  password;//密码

    private String subscribe;
}  
