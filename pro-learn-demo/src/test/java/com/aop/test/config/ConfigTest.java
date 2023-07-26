package com.aop.test.config;

import com.alibaba.fastjson.JSON;
import com.self.pro.learn.ProDemoApplication;
import com.self.pro.learn.config.SmsChannelsConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ProDemoApplication.class)
public class ConfigTest {
    @Autowired
    private SmsChannelsConfig smsChannelsConfig;
    @Test
    public void testConfig() {
//        List<String> channels = smsChannelsConfig.getChannels();
//        for (String chan : channels) {
//            String[] chanSplit = chan.split(",");
//            for (String s: chanSplit){
//                System.out.println(s);
//            }
//        }
//        System.out.println(channels);

        Map<String, String> channelMaps = smsChannelsConfig.getChannelMaps();
        Set<Map.Entry<String, String>> entries = channelMaps.entrySet();
        for (Map.Entry<String, String> entry : entries) {

            System.out.println("方法五的key为："+entry.getKey()+",value为："+entry.getValue());
        }


//        channelMaps.forEach((k,v) -> {
//
//
//
//                }
//                );


        String c0 = channelMaps.get("c0");
        System.out.println(c0);
    }

}