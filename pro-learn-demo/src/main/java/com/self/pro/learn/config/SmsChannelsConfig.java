package com.self.pro.learn.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "sms-channels")
//@RefreshScope
@Data
public class SmsChannelsConfig {
    private LinkedList<String> channels;

    private Map<String,String> channelMaps;
}
