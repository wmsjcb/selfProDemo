package com.self.pro.learn.cannl;


import java.net.InetSocketAddress;
import java.util.List;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.protocol.Message;
import com.alibaba.otter.canal.protocol.CanalEntry.Column;
import com.alibaba.otter.canal.protocol.CanalEntry.Entry;
import com.alibaba.otter.canal.protocol.CanalEntry.EntryType;
import com.alibaba.otter.canal.protocol.CanalEntry.EventType;
import com.alibaba.otter.canal.protocol.CanalEntry.RowChange;
import com.alibaba.otter.canal.protocol.CanalEntry.RowData;
import com.alibaba.otter.canal.client.*;

/**
 * @author zhang ho jian
 * @date 2021/4/8
 * @time 10:16
 * @Description :测试Canal
 */
public class CanalTest {


    public static void main(String[] args) {
        //ip和端口换成自己的canal默认是11111
        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress("192.168.20.28",
                11111), "com/self/pro/learn/example", "", "");
        int batchSize = 1000;
        try {
            connector.connect();
            //connector.subscribe(".*\\..*");
            connector.subscribe("mxtest.order_info");
            connector.rollback();
            while (true) {
                Message message = connector.getWithoutAck(batchSize); // 获取指定数量的数据
                long batchId = message.getId();
                int size = message.getEntries().size();
                if (batchId == -1 || size == 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    printEntry(message.getEntries());
                }
                connector.ack(batchId); // 提交确认
                // connector.rollback(batchId); // 处理失败, 回滚数据
            }
        } finally {
            connector.disconnect();
        }
    }

    private static void printEntry( List<Entry> entrys) {
        for (Entry entry : entrys) {
            if (entry.getEntryType() == EntryType.TRANSACTIONBEGIN || entry.getEntryType() == EntryType.TRANSACTIONEND) {
                continue;
            }
            RowChange rowChage = null;
            try {
                rowChage = RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(),
                        e);
            }
            EventType eventType = rowChage.getEventType();
            System.out.println(String.format("================> binlog[%s:%s] , name[%s,%s] , eventType : %s",
                    entry.getHeader().getLogfileName(), entry.getHeader().getLogfileOffset(),
                    entry.getHeader().getSchemaName(), entry.getHeader().getTableName(),
                    eventType));

            for (RowData rowData : rowChage.getRowDatasList()) {
                 //如果需要业务的处理可以在这边进行对应的处理，我这边是需要将多个数据库的数据同步到一个数据库中，会出现主键冲突的问题，所以在这里处理主键。正常只是做主从的话是不需要用到这里的
                if (eventType == EventType.DELETE) {
                    System.out.println("删除操作"+rowData.getBeforeColumnsList());
                } else if (eventType == EventType.INSERT) {
                    System.out.println("新增操作"+rowData.getAfterColumnsList());
                } else {
                    System.out.println("-------> before");
                    printColumn(rowData.getBeforeColumnsList());
                    System.out.println("update----->"+rowData.getAfterColumnsList());

                }
            }
        }
    }

    private static void printColumn( List<Column> columns) {
        for (Column column : columns) {
            System.out.println(column.getName() + " : " + column.getValue() + "    update=" + column.getUpdated());
        }
    }

    }
