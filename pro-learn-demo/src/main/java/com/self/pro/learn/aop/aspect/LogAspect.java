package com.self.pro.learn.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    //切点
    @Pointcut("execution(* com.self.pro.learn.aop.service.*.*(..))")
    public void pointMethod(){

    }
    //前置通知
    @Before("pointMethod()")
    public void before(JoinPoint joinPoint)
    {
        String name = joinPoint.getSignature().getName();
        System.out.println("The method befor===========");
    }
   /* //后置通知
    @After("pointMethod()")
    public void after(JoinPoint joinPoint)
    {
        String name = joinPoint.getSignature().getName();
        System.out.println("The method after===========");
    }*/
    //执行后的返回值
   /* @AfterReturning(value = "pointMethod()",returning = "s")
    public void afterReturning(JoinPoint joinPoint,String s){
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"The method return===========： "+s);
    }
    //返回后抛出异常
    @AfterThrowing(value = "pointMethod()",throwing = "e")
    public void afterthrowing(JoinPoint joinPoint,Exception e)
    {
        String name = joinPoint.getSignature().getName();
        System.out.println(name+"The method exception==========="+e.getMessage());
    }*/
    //环绕通知
    @Around("pointMethod()")
    public Object aorund(ProceedingJoinPoint proceedingJoinPoint){
        try {
            System.out.println("around beging =====");
            //方法之前执行通知，相当于前置通知
            //类似反射中的invoke方法
            Object proceed = proceedingJoinPoint.proceed();
            //方法之后执行通知，相当于后置通知
            System.out.println("around end =====");


            Object proceed1 = proceedingJoinPoint.proceed();
            return proceed;
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return  null;
    }
}

