package com.self.pro.learn.cannl;

import com.alibaba.otter.canal.protocol.CanalEntry;
//import com.carelinker.canal.api.enums.EntityEnums;
//import com.carelinker.datax.biz.handle.ContentStrategy;
//import com.carelinker.datax.biz.service.ICanalSubscribeTableService;
//import com.carelinker.datax.biz.strategy.BiBaseDataAgeGroupStrategy;
//import com.carelinker.datax.biz.strategy.BiBaseDataStoreMemberStrategy;
import com.google.protobuf.InvalidProtocolBufferException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liyue
 * @date 2020-04-26 10:57
 */
@Slf4j
@Component
public class ParseMessage {

//    @Resource(name = "biBaseDataAgeGroupStrategy")
//    private BiBaseDataAgeGroupStrategy biBaseDataAgeGroupStrategy;
//    @Resource(name = "biBaseDataStoreMemberStrategy")
//    private BiBaseDataStoreMemberStrategy biBaseDataStoreMemberStrategy;
//    @Resource
//    private ICanalSubscribeTableService canalSubscribeTableService;

    /**
     * 接受变化的数据
     *
     * @param entryList
     */
    public void printEntity(List<CanalEntry.Entry> entryList) {

        for (CanalEntry.Entry entry : entryList) {

            if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
                continue;
            }
            if (entry.getEntryType() != CanalEntry.EntryType.ROWDATA) {
                continue;
            }
            if (!entry.getHeader().getSchemaName().equals("tpdata")) {
                continue;
            }
            try {

                CanalEntry.RowChange rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
                String tableName = entry.getHeader().getTableName();
                try {
                    rowChange = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
                } catch (Exception e) {
                    throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(),
                            e);
                }
               CanalEntry.EventType eventType = rowChange.getEventType();
                System.out.println(String.format("================> binlog[%s:%s] , name[%s,%s] , eventType : %s",
                        entry.getHeader().getLogfileName(), entry.getHeader().getLogfileOffset(),
                        entry.getHeader().getSchemaName(), entry.getHeader().getTableName(),
                        eventType));

                for (CanalEntry.RowData rowData : rowChange.getRowDatasList()) {
                    //如果需要业务的处理可以在这边进行对应的处理，我这边是需要将多个数据库的数据同步到一个数据库中，会出现主键冲突的问题，所以在这里处理主键。正常只是做主从的话是不需要用到这里的
                    if (eventType == CanalEntry.EventType.DELETE) {
                        System.out.println("删除操作"+rowData.getBeforeColumnsList());
                    } else if (eventType == CanalEntry.EventType.INSERT) {
                        System.out.println("新增操作"+rowData.getAfterColumnsList());
                    } else {
                        System.out.println("-------> before");
                        printColumn(rowData.getBeforeColumnsList());
                        System.out.println("update----->"+rowData.getAfterColumnsList());

                    }
                }
//                List<String> canalSubscribeTableList = canalSubscribeTableService.listTableName();
//
//                if (!canalSubscribeTableList.contains(entry.getHeader().getSchemaName() + "." + tableName)) {
//                    continue;
//                }

//                log.info("表名为{}有数据开始进来了" + tableName);
//
//                ContentStrategy contentStrategy;
//
//                switch (Enum.valueOf(EntityEnums.class, tableName.toUpperCase())) {
//                    case BI_BASE_DATA_AGE_GROUP:
//                        contentStrategy = new ContentStrategy(biBaseDataAgeGroupStrategy);
//                        contentStrategy.excute(rowChange);
//                        break;
//                    case BI_BASE_DATA_STORE_MEMBER:
//                        contentStrategy = new ContentStrategy(biBaseDataStoreMemberStrategy);
//                        contentStrategy.excute(rowChange);
//                        break;
//                }

            } catch (InvalidProtocolBufferException e) {
                e.printStackTrace();
            }

        }
    }
    private void printColumn( List<CanalEntry.Column> columns) {
        for (CanalEntry.Column column : columns) {
            System.out.println(column.getName() + " : " + column.getValue() + "    update=" + column.getUpdated());
        }
    }

    public static void main(String[] args) {

    }
}

