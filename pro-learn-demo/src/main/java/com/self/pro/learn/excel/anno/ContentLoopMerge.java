package com.self.pro.learn.excel.anno;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ContentLoopMerge {

    /**
     * 合并行
     *
     * @return
     */
    int eachRow() default 1;

    /**
     * 合并列
     *
     * @return
     */
    int columnExtend() default 1;
}