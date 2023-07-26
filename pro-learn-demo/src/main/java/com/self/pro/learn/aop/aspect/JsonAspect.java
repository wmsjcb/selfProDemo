package com.self.pro.learn.aop.aspect;

import com.self.pro.learn.annotation.Tp;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class JsonAspect {
    /**
     * 针对@Tp指标配置注解的逻辑实现
     */
    @Around("@annotation(com.self.pro.learn.annotation.Tp)")
    public Object timedMethod(ProceedingJoinPoint pjp) throws Throwable {
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        method = pjp.getTarget().getClass().getMethod(method.getName(), method.getParameterTypes());
        Tp tp = method.getAnnotation(Tp.class);
        tp.getClass();


        try {
            return pjp.proceed();
        } catch (Exception ex) {
            throw ex;
        } finally {
        }
    }
}