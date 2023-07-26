package com.self.pro.learn.excel.strategy;

import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.util.BooleanUtils;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.handler.context.CellWriteHandlerContext;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.stereotype.Component;

/**
 * @author: zbh19
 * @date: 2022/5/5 1:57
 * @description: 表头样式拦截器
 */
 
@Slf4j
@Component
public class CustomCellWriteHandler implements CellWriteHandler {
    @Override
    public void afterCellDataConverted(CellWriteHandlerContext context) {
 
    }
 
    @Override
    public void afterCellDispose(CellWriteHandlerContext context) {
        WriteCellData<?> cellData = context.getFirstCellData();
        int rowNum = context.getRow().getRowNum();
        Integer columnIndex = context.getColumnIndex();
        Sheet sheet = context.getWriteSheetHolder().getSheet();
        Cell cell = context.getCell();
 
        if (BooleanUtils.isTrue(context.getHead())) {
            WriteCellStyle writeCellStyle = cellData.getWriteCellStyle();
//            CellStyle cellStyle = workbook.createCellStyle()
            //字体
            WriteFont writeFont = writeCellStyle.getWriteFont();
            if (columnIndex == 4 || columnIndex == 5 || columnIndex == 6 ) {
                writeFont.setColor(IndexedColors.GREEN.getIndex());
            } else {
                writeFont.setColor(IndexedColors.BLACK.getIndex());
            }
            //背景颜色
            writeCellStyle.setFillForegroundColor(IndexedColors.WHITE.getIndex());
            writeCellStyle.setFillPatternType(FillPatternType.SOLID_FOREGROUND);
            //字体大小
            writeFont.setFontHeightInPoints((short) 16);
            //字体加粗
            writeFont.setBold(true);
            writeCellStyle.setWriteFont(writeFont);
            //列宽，行高
            sheet.setColumnWidth(cell.getColumnIndex(), 4000);
            sheet.setDefaultRowHeight((short) 400);
        }
    }
}