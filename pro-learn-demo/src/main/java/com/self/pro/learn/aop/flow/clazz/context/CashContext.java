package com.self.pro.learn.aop.flow.clazz.context;

import java.util.Map;

public class CashContext {
    // 构造方法私有化
    private CashContext(){};

    private static final ThreadLocal<Map<String,Object>> context = new ThreadLocal<>();
 
    /**
     * 存放用户信息
     * @param map
     */
    public static void setContext(Map<String,Object> map){
        context.set(map);
    }

    /**
     * 获取用户信息
     * @return
     */
    public static Map<String,Object> getContext(){
        return context.get();
    }

    /**
     * 清除当前线程内引用，防止内存泄漏
     */
    public static void remove(){
        context.remove();
    }
}