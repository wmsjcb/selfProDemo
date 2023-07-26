package com.self.pro.learn.json.config;

/**
 * 此类是将spring配置信息转换成静态属性
 */
//@Component
public class YmlConstantsHelper{
     static final String test = "test";
    static String NAME;
    static int AGE;

//    @Autowired
    public void setResouceUseTotalConfig(ResourceUseTotalConfig resourceUseTotalConfig) {
        NAME = resourceUseTotalConfig.getName();
        AGE = resourceUseTotalConfig.getAge();
    }
}