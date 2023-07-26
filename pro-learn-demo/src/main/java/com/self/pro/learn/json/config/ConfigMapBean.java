package com.self.pro.learn.json.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Itmei
 * @Date 2022/8/28 11:20
 * @Version 1.0
 * 用于获取yml的配置文件
 */
@Component
/**添加为组件*/
@ConfigurationProperties(prefix = "json-map")/**获取yml前缀为itmei-map的配置 */
@Data
public class ConfigMapBean {

    //参数名称要对上yml的名称
    public Map<String,String> student;

    public Map<String,String> jsonData;

}
