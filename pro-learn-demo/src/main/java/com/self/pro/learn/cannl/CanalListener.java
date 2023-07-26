package com.self.pro.learn.cannl;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry;
import com.alibaba.otter.canal.protocol.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

import java.net.InetSocketAddress;
import java.util.List;

@Slf4j
@Configuration
public class CanalListener implements ApplicationRunner {

    private static CanalProperties properties;

    @Autowired
    public void setProperties(CanalProperties properties) {
        this.properties = properties;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Thread workThread = new Thread(this::dowork);
        workThread.setName("canal-thread");
        //flag = true;
        workThread.start();
        //开始干活 
        //dowork();
    }

    //官方示例代码
    public void dowork(){
        // 创建链接  
        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress(properties.getIp(),
                properties.getPort()), properties.getDestination(), properties.getUsername(), properties.getPassword());
        int batchSize = 1000;
        try {

            connector.connect();

            connector.subscribe(properties.getSubscribe());
            connector.rollback();
            while (true) {
                Message message = null;
                try {
                    message = connector.getWithoutAck(batchSize);
                } catch (Exception e) {
                    log.error("############connect cannl faill!!!",e);
                    while (message != null) {
                        message = connector.getWithoutAck(batchSize);
                        log.error(">>>>>>>>>>>>>>>>>>retry connect cannl faill!!!");
                    }
                }
                log.error(">>>>>>>>>>>>>get message {}", message);
                // 获取指定数量的数据
                long batchId = message.getId();
                int size = message.getEntries().size();
                if (batchId == -1 || size == 0) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        log.error("cannal wait error");
                    }
                } else {
                    run(message.getEntries());
                }
                connector.ack(batchId); // 提交确认接收成功
//                    connector.rollback(batchId); // 处理失败, 回滚数据 ,下次还能接收到这条数据
            }
        } finally {  
            connector.disconnect();  
        }  
    }
    
    public void run(List<CanalEntry.Entry> entrys) {
        for (CanalEntry.Entry entry : entrys) {
            String tableName = entry.getHeader().getTableName();
            System.out.println("------>" + tableName);
            if (entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONBEGIN || entry.getEntryType() == CanalEntry.EntryType.TRANSACTIONEND) {
                continue;
            }

            CanalEntry.RowChange rowChage = null;
            try {
                rowChage = CanalEntry.RowChange.parseFrom(entry.getStoreValue());
            } catch (Exception e) {
                throw new RuntimeException("ERROR ## parser of eromanga-event has an error , data:" + entry.toString(),
                        e);
            }

            CanalEntry.EventType eventType = rowChage.getEventType();
            System.out.println(String.format("================> binlog[%s:%s] , name[%s,%s] , eventType : %s",
                    entry.getHeader().getLogfileName(), entry.getHeader().getLogfileOffset(),
                    entry.getHeader().getSchemaName(), entry.getHeader().getTableName(),
                    eventType));

            for (CanalEntry.RowData rowData : rowChage.getRowDatasList()) {
                if (eventType == CanalEntry.EventType.DELETE) {
                    printColumn(rowData.getBeforeColumnsList());
                } else if (eventType == CanalEntry.EventType.INSERT) {
                    printColumn(rowData.getAfterColumnsList());
                } else {
//                    System.out.println("-------> before");
                    log.info("-------> before");
                    printColumn(rowData.getBeforeColumnsList());
//                    System.out.println("-------> after");
                    log.info("-------> after");
                    printColumn(rowData.getAfterColumnsList());
                }
            }
        }
    }

    private void printColumn(List<CanalEntry.Column> columns) {
        for (CanalEntry.Column column : columns) {
            System.out.println(column.getName() + " : " + column.getValue() + "    update=" + column.getUpdated());
        }
    }
}  
