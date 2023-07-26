package com.self.pro.learn.chain.entry;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FilterEntity {
    /**
     * handlerId
     */
    private Integer handlerId;

    /**
     * 处理器名称
     */
    private String name;

    /**
     * 处理器 包名 + 类名
     */
    private String conference;

    /**
     * 上一个处理器
     */
    private Integer preHandlerId;

    /**
     * 下一个处理器
     */
    private Integer nextHandlerId;
}

