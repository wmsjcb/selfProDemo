package com.self.pro.learn.json.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 资源使用总数限制
 * @author Wxp
 * @date 2019-08-27
 */
//@Component
@Data
//@ConfigurationProperties(prefix = "student")
public class ResourceUseTotalConfig {
    private final String name;
    private  int age;

}