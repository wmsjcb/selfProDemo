package com.self.pro.learn.cannl;

import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;

/**
 * @author liyue
 * @date 2020-04-13 16:28
 */
//@Slf4j
@Component
public class CanalClient {

    private static String SERVER_ADDRESS = "192.168.20.28";

    /**
     * canal server 端口号
     */
    private static Integer PORT = 11111;

    /**
     * DESTINATION 你配置的监听文件名称 这个是你canal下面的 文件夹的名称。如果你没写名称的话
     */
    private static String DESTINATION = "com/self/pro/learn/example";

    /**
     * canal 用户名
     */
    private static String USERNAME = "";

    /**
     * canal 密码
     */
    private static String PASSWORD = "";

    private static CanalConnector canalConnector;

    private static CanalClient canalClient;

    @PostConstruct
    public void init() {
        canalClient = this;
    }

    public static CanalConnector getConnect() {

        if (canalConnector == null) {
            canalConnector = CanalConnectors.newSingleConnector(new InetSocketAddress(SERVER_ADDRESS,
                    PORT), DESTINATION, USERNAME, PASSWORD);
            canalConnector.connect();
        }

        System.out.println(canalConnector.checkValid());
        return canalConnector;
    }

    public static void disconnect() {

        canalConnector.disconnect();
        canalConnector = null;
    }

    public static void subscribe(String filter) {

        //订阅 所有的变化都会获取
        //canalConnector.subscribe(".*\\..*");
        //canalConnector.subscribe("tpdata\\\\.bi.*");
        // canalConnector.subscribe("tpdata.bi_base_data_age_group");
        canalConnector.subscribe(filter);
        //回到以前状态，回到之前同步的位置
        canalConnector.rollback();
    }
}

