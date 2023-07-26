package com.self.pro.learn.excel.demo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentStyle;
import com.alibaba.excel.enums.poi.HorizontalAlignmentEnum;
import com.alibaba.excel.enums.poi.VerticalAlignmentEnum;
import lombok.Data;

import java.io.Serializable;

@Data
public class Demo implements Serializable {

    @ExcelProperty(value = "商户名称", index = 5)
    @ColumnWidth(15)
//    @ContentStyle(verticalAlignment = VerticalAlignmentEnum.CENTER, horizontalAlignment = HorizontalAlignmentEnum.CENTER)
    private String appName;

    @ExcelProperty(value = "城市名称", index = 1)
    @ColumnWidth(15)
//    @ContentStyle(verticalAlignment = VerticalAlignmentEnum.CENTER, horizontalAlignment = HorizontalAlignmentEnum.CENTER)
//    @ContentLoopMerge(eachRow = 2, columnExtend = 3)
    private String cityName;

    @ExcelProperty(value = "区域名称", index = 2)
    @ColumnWidth(15)
//    @ContentStyle(verticalAlignment = VerticalAlignmentEnum.CENTER, horizontalAlignment = HorizontalAlignmentEnum.CENTER)
    private String regionName;

    @ExcelProperty(value = "商圈名称", index = 3)
    @ColumnWidth(15)
//    @ContentStyle(verticalAlignment = VerticalAlignmentEnum.CENTER, horizontalAlignment = HorizontalAlignmentEnum.CENTER)
    private String businessAreaName;

    @ExcelProperty(value = "楼盘名称", index = 4)
    @ColumnWidth(15)
//    @ContentStyle(verticalAlignment = VerticalAlignmentEnum.CENTER, horizontalAlignment = HorizontalAlignmentEnum.CENTER)
    private String gardenName;

    @ExcelProperty(value = "楼栋名称", index = 0)
    @ColumnWidth(15)
//    @ContentStyle(verticalAlignment = VerticalAlignmentEnum.CENTER, horizontalAlignment = HorizontalAlignmentEnum.CENTER)
    private String buildingName;

    @ExcelProperty(value = "单元名称", index = 6)
    @ColumnWidth(15)
//    @ContentStyle(verticalAlignment = VerticalAlignmentEnum.CENTER, horizontalAlignment = HorizontalAlignmentEnum.CENTER)
    private String unitName;

    @ExcelProperty(value = "价格", index = 7)
    @ColumnWidth(15)
//    @ContentStyle(verticalAlignment = VerticalAlignmentEnum.CENTER, horizontalAlignment = HorizontalAlignmentEnum.CENTER)
    private Integer price;

}