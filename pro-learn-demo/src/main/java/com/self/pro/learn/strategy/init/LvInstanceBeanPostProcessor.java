package com.self.pro.learn.strategy.init;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LvInstanceBeanPostProcessor  implements InstantiationAwareBeanPostProcessor {

    @Autowired
    private ApplicationContext applicationContext;
//    @Autowired
//    private ConfigMapBean configMapBean;
   @Override
   public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
//       if(beanName.equals("primaryMemberStrategy")){
//            System.out.println("实例化前");
//         }
      return null;
   }
 
   @Override
   public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {

//      if(bean instanceof MemberStrategy){
//          ThreadLocalUtil.set(beanName,bean);
//         System.out.println("实例化后");
//      }
//       if(bean instanceof ConfigMapBean){
//           Map<String, String> student = configMapBean.getStudent();
//           Map<String, String> jsonData = configMapBean.getJsonData();
//           log.info("student,jsondata{} {}",student,jsonData);
//           ReflectUtils.convertFileAnn(Student.class, student);
//           ReflectUtils.convertFileAnn(JsonData.class, jsonData);
//           System.out.println("实例化后");
//       }
      return true;
   }
}