package com.self.pro.learn.aop.config;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Config {
    /**
     * 国家
     */
    private String contry;
    /**
     * 白名单（客户id）
     */
    private List<String> whitelist;
    /**
     * 开关是否打开 true:打开；false:关闭
     */
    private boolean isopen;
    /**
     * 白名单是否开启 true:打开；false:关闭
     */
    private boolean iswhite;

    public static void main(String[] args) {

        String json = buildJson();
        System.out.println(json);
        Config config = JSON.parseObject(json, Config.class);
//        for (String s : config.getWhitelist()){
//            System.out.println(s);
//        }

        //System.out.println(config.isopen);
    }

    private static String buildJson() {
        Config config = new Config();
        config.setContry("mxg");
        config.setIsopen(true);
        config.setIswhite(true);
        List<String> ls = new ArrayList<>();
        ls.add("123");
        ls.add("456");
        config.setWhitelist(ls);
        String json = JSON.toJSONString(config);
        return json;
    }
}
