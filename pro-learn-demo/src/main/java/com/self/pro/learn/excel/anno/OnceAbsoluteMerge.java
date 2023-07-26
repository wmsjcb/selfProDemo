package com.self.pro.learn.excel.anno;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface OnceAbsoluteMerge {

    /**
     * 初始行
     *
     * @return
     */
    int firstRowIndex() default -1;

    /**
     * 最后一行
     *
     * @return
     */
    int lastRowIndex() default -1;

    /**
     * 初始列
     *
     * @return
     */
    int firstColumnIndex() default -1;

    /**
     * 最后一列
     *
     * @return
     */
    int lastColumnIndex() default -1;
}