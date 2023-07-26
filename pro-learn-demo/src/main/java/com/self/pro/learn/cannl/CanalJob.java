package com.self.pro.learn.cannl;


//import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.protocol.Message;
//import com.carelinker.datax.biz.service.ICanalSubscribeTableService;
//import com.carelinker.datax.biz.utils.CanalClient;
//import com.carelinker.datax.biz.utils.ParseMessage;
//import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author liyue
 * @date 2020-04-20 18:11
 */
//@Slf4j
//@Configuration
//@EnableScheduling
@Component
public class CanalJob {

    private Boolean connectStatus = false;

    private CanalConnector canalConnector;

    private int subscribeTableCount = 0;


    @Resource
    private ParseMessage parseMessage;

//    @Resource
//    private ICanalSubscribeTableService canalSubscribeTableService;


    //@Scheduled(cron = "0/5 * * * * ?")
    public void canalJob() {

        //1、建立连接
        this.getCanalConnect();
        //2.获取需要订阅的表
        this.canalSubscribeTable();
        //3.获取消息
        Message message = this.getMessage();
        //4.解析消息
        this.parseMessage(message);

    }

    private void getCanalConnect() {

        if (!connectStatus) {
            // //获取指定数量的数据,但是不做确认,下次取还是会取到
            this.canalConnector = CanalClient.getConnect();
            this.connectStatus = true;
        }
    }

//    private void canalSubscribeTable() {
//
//        List<String> canalSubscribeTableList = canalSubscribeTableService.listTableName();
//        String join = StringUtils.join(canalSubscribeTableList.toArray(), ",");
//
//        if (CollectionUtil.isNotEmpty(canalSubscribeTableList) && canalSubscribeTableList.size() != subscribeTableCount) {
//            this.canalConnector.subscribe(join);
//            this.subscribeTableCount = canalSubscribeTableList.size();
//        }
//    }

    private void canalSubscribeTable() {
        CanalClient.subscribe("mxtest.order_info");
    }

    private Message getMessage() {

        Message message;

        try {
            message = canalConnector.getWithoutAck(5);
        } catch (Exception e) {

            e.printStackTrace();
//            log.error("canal估计是连接挂了", e);

            // 尝试重新获取连接
            CanalClient.disconnect();
            this.connectStatus = false;
            this.getCanalConnect();

            message = canalConnector.getWithoutAck(5);
        }

        return message;
    }


    private void parseMessage(Message message) {

        long batchId = message.getId();

        int size = message.getEntries().size();

        if (batchId < 0 || size == 0) {
            return;
        }

        if (batchId != -1) {

            try {
                //传入变化数据
                parseMessage.printEntity(message.getEntries());
                //提交确认
                canalConnector.ack(batchId);
            } catch (Exception e) {
                //处理失败 回滚数据
                canalConnector.rollback();
            }
        }
    }
}