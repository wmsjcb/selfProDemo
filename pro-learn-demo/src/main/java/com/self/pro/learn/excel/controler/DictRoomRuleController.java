package com.self.pro.learn.excel.controler;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.util.ListUtils;
import com.alibaba.excel.write.handler.CellWriteHandler;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.self.pro.learn.excel.bean.CellLineRange;
import com.self.pro.learn.excel.demo.Demo;
import com.self.pro.learn.excel.strategy.CustomCellWriteHandler;
import com.self.pro.learn.excel.strategy.ExcelFillCelColumnMergeStrategy;
import com.self.pro.learn.excel.utils.EasyExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@Lazy
@RestController
@RequestMapping(value = "/demo", produces = {"application/json;charset=UTF-8"})
@Slf4j
//@Api(tags = ApiSwaggerTags.DICT_ROOM_RULE_APPRAISAL,value = "规则管理")
public class DictRoomRuleController {

   static List<List<String>> headList = null;

 static {
      headList = head();
 }

    @PostMapping(value = "/exportMerge")
//    @ApiOperation(value = "导出测试信息")
//    @ApiResponses({
//            @ApiResponse(message = "导出测试信息", code = 200, response = Boolean.class)
//    })
    public void exportMerge(HttpServletResponse response, HttpServletRequest request) {
        try {
            ServletOutputStream outputStream = response.getOutputStream();

            List<Demo> list = new ArrayList<>();
            buildData(list);

            EasyExcelUtil.setExportExcelFormat(response, request,"测试数据");

            //需要合并的列
//            int[] mergeColumnIndex = {0, 1, 2, 3, 4};
            int[] mergeColumnIndex = {5, 6, 7,8};

            //设置第几行开始合并
            int mergeRowIndex = 1;

            // Excel单元格行合并处理策略
//            ExcelFillCellRowMergeStrategy rowMergeStrategy = new ExcelFillCellRowMergeStrategy(mergeRowIndex, mergeColumnIndex);

            //列合并的工具实体类
            ArrayList<CellLineRange> cellLineRanges=new ArrayList<>();
            cellLineRanges.add(new CellLineRange(0,3));
            // Excel单元格列合并处理策略
            ExcelFillCelColumnMergeStrategy celColumnMergeStrategy = new ExcelFillCelColumnMergeStrategy(0, cellLineRanges);

//            List<CellWriteHandler> cellWriteHandlerList = Stream.of(celColumnMergeStrategy, rowMergeStrategy).collect(Collectors.toList());
            List<CellWriteHandler> cellWriteHandlerList = Stream.of(celColumnMergeStrategy).collect(Collectors.toList());

            EasyExcelUtil.writeExcelMerge(outputStream, Demo.class, list, "测试数据", cellWriteHandlerList);

            outputStream.flush();
            outputStream.close();

        } catch (Exception e) {
            log.error("楼盘估价数据导出excel Exception", e);
            e.printStackTrace();
        }
    }

    /**
     * 构建数据
     * @param list
     */
    private void buildData (List<Demo> list){
        for (int i = 0; i < 5; i++) {
            Demo demo = new Demo();
            demo.setAppName("app1");
            demo.setCityName("app1");
            demo.setRegionName("app1");
            demo.setBusinessAreaName("深大");
            demo.setGardenName("大冲国际中心");
            demo.setBuildingName("一期");
            demo.setUnitName("A座");
            demo.setPrice(100000 + i);
            list.add(demo);
        }

        for (int i = 0; i < 2; i++) {
            Demo demo = new Demo();
            demo.setAppName("app2");
            demo.setCityName("深圳");
            demo.setRegionName("南山区");
            demo.setBusinessAreaName("前海湾");
            demo.setGardenName("前海中心大厦");
            demo.setBuildingName("一期");
            demo.setUnitName("B座");
            demo.setPrice(100000 + i);
            list.add(demo);
        }

        for (int i = 0; i < 2; i++) {
            Demo demo = new Demo();
            demo.setAppName("深圳");
            demo.setCityName("深圳");
            demo.setRegionName("深圳");
            demo.setBusinessAreaName("后海");
            demo.setGardenName("中国华润大厦");
            demo.setBuildingName("中国华润大厦");
            demo.setUnitName("A座");
            demo.setPrice(100000 + i);
            list.add(demo);
        }

        for (int i = 0; i < 1; i++) {
            Demo demo = new Demo();
            demo.setAppName("app3");
            demo.setCityName("深圳");
            demo.setRegionName("宝安区");
            demo.setBusinessAreaName("壹方城");
            demo.setGardenName("壹方中心");
            demo.setBuildingName("一期");
            demo.setUnitName("A座");
            demo.setPrice(100000 + i);
            list.add(demo);
        }
    }

    /**
     * 项目详情导出
     *
     * @return
     */
    @PostMapping("/export")
//    @PreAuthorize("@ss.hasPermi('system:project:stat:query')")
//    @ApiOperation("导出")
    public void export(HttpServletResponse response) throws IOException {
        String fileName = URLEncoder.encode("projectWorkingHour", "UTF-8").concat(".xlsx");
        //response输出文件流
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(fileName, "UTF-8"));
//        List<ResultExport> list = projectHourService.queryProjectHors(baseProjectDto);
        List<Demo> list = new ArrayList<>();
        buildData(list);

        //导出对象，输出数据流，CustomCellWriteHandler()是我写的简单的一个拦截器，下面会贴
        //可以看一下，不需要拦截器的话，把registerWriteHandler去掉就行了
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream())
                .registerWriteHandler(new CustomCellWriteHandler())
                .build();
//        创建sheet页，设置sheet页名称，同时写入表头信息
        WriteSheet writeSheet = EasyExcel.writerSheet(0, "测试数据")
                .head(headList)
                .build();
//                写入数据，并将sheet页对象传入

        excelWriter.write(list, writeSheet);
        //这一步很关键，不然文件会损坏
        excelWriter.finish();
    }

    /**
     * 设置表头
     *
     * @return
     */
//    public List<List<String>> buildHead() {
//        //创建表头集合
//        List<List<String>> headList = new ArrayList<>();
//        //第一列
//        List<String> title = new ArrayList<>(Arrays.asList("序号", "序号"));
//        head.add(title);
//        //第二列
//        List<String> title1 = new ArrayList<>(Arrays.asList("技术人员", "技术人员"));
//        head.add(title1);
//        //第三列
//        List<String> title2 = new ArrayList<>(Arrays.asList("月总工时", "月总工时"));
//        head.add(title2);
//        //动态生成列，也就是说这一部分的表头是动态生成的，
////        for (ExportHour exportHour : exportList) {
////            List<String> title3 = new ArrayList<>(Arrays.asList(bigTitle, "月工时", exportHour.getProjectName(), exportHour.getProjectName()));
////            head.add(title3);
////        }
//        List<String> title3 = new ArrayList<>(Arrays.asList( "测试", "测试"));
//        head.add(title3);
//        //列
//        List<String> title7 = new ArrayList<>(Arrays.asList( "月工时", "合计工时"));
//        head.add(title7);
//        //列
//        List<String> title5 = new ArrayList<>(Arrays.asList( "月工时", "核验"));
//        head.add(title5);
//        List<String> title6 = new ArrayList<>(Arrays.asList( "月工时", "单件"));
//        head.add(title6);
//        //最后直接把这些生成的表头集合返回就行了
//        return head;
//    }



    /**
     * 设置表头
     *
     * @param exportList
     * @return
     */
    public static List<List<String>> head() {
//        String time = exportList.get(0).getAppName();
//        String year = time.substring(0, 1);
//        String month = time.substring(0, 1);
        //初始化第一行表头
//        String bigTitle = "表头名字" + year + "年度" + month + "月工时分摊表";
        //创建表头集合
        List<List<String>> head = new ArrayList<>();
        //这里的每一个list都是代表一列，按照顺序来，相同的名称会自动合并单元格，比如说两个序号，
        //就是把第第一列的第二第三格合并到了一起
        //然后行单元格合并是同理的，可以看到bigTitle每一个list都有，都是在第一个，说明每一列的
        //第一个单元格都是这个值，所以最终的效果就是你生成的表格第一行全部合并，然后可以展示大表
        //头,
        //第一列
        List<String> title = new ArrayList<>(Arrays.asList("序号"));
        head.add(title);
        //第二列
        List<String> title1 = new ArrayList<>(Arrays.asList("技术人员"));
        head.add(title1);
        //第三列
        List<String> title2 = new ArrayList<>(Arrays.asList("月总工时"));
        head.add(title2);
        //动态生成列，也就是说这一部分的表头是动态生成的，
//        for (ExportHour exportHour : exportList) {
//            List<String> title3 = new ArrayList<>(Arrays.asList(bigTitle, "月工时", exportHour.getProjectName(), exportHour.getProjectName()));
//            head.add(title3);
//        }
        List<String> title3 = new ArrayList<>(Arrays.asList( "测试"));
            head.add(title3);
        //列
        List<String> title7 = new ArrayList<>(Arrays.asList( "月工时", "合计工时"));
        head.add(title7);
        //列
        List<String> title5 = new ArrayList<>(Arrays.asList( "月工时", "核验"));
        head.add(title5);
        List<String> title6 = new ArrayList<>(Arrays.asList( "月工时", "单件"));
        head.add(title6);
        List<String> title8 = new ArrayList<>(Arrays.asList( "月工时", "总价"));
        head.add(title8);
        //最后直接把这些生成的表头集合返回就行了
        return head;
    }

    /**
     * 写数据
     *
     * @param exportList
     * @param
     * @return
     */
//    private List data(List<ExportHour> exportList) {
//        int i = 1;
//        List<List<String>> list = ListUtils.newArrayList();
//        Integer size = getDates(exportList.get(0).getMonth()).size();
//        Integer sumHour = size * 8;
////        获取指定月份下的所有项目所涉及的人员
//        List<String> strings = projectHourService.queryUserList();
//        List<String> list1 = strings.stream().distinct().collect(Collectors.toList());
//        for (String userId : list1) {
//            List<String> head = ListUtils.newArrayList();
////            序号
//            head.add(i + "");
//            i++;
//            head.add(userService.selectUserById(Long.valueOf(userId)).getNickName());
////            月总工时
//            head.add(sumHour + "");
//            BigDecimal sumhour = BigDecimal.ZERO;
//            for (ExportHour exportHour : exportList) {
//                List<ProjectHorsInfo> userInfo = exportHour.getExportList();
//                List<ProjectHorsInfo> info = userInfo.stream().filter(a -> a.getUserId().toString().equals(userId))
//                        .collect(Collectors.toList());
//                if (info.size() > 0) {
//                    sumhour = sumhour.add(info.get(0).getSumUserHors());
////                    个人项目工时
//                    head.add(info.get(0).getSumUserHors().toString());
//                } else {
//                    head.add("");
//                }
//            }
//            //                合计工时
//            head.add(sumhour.toString());
//            BigDecimal result = sumhour.subtract(new BigDecimal(size * 8));
//            head.add(result + "");
//            list.add(head);
//        }
//
//        return list;
//    }
}