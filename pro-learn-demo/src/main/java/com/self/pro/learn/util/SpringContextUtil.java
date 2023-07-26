package com.self.pro.learn.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;
 
    
    @Override
    public void setApplicationContext(ApplicationContext applicationContext){
        SpringContextUtil.applicationContext = applicationContext;
    }
 
  
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
 
    /**
     * 获取bean 对象
     * @return  Object bean的实例对象
     */
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }
}