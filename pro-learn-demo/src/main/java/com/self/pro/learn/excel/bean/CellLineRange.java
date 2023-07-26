package com.self.pro.learn.excel.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CellLineRange {

    /**
     * 起始列
     */
    private int firstCol;

    /**
     * 结束列
     */
    private int lastCol;
}