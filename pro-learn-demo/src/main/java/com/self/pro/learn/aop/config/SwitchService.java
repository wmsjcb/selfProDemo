package com.self.pro.learn.aop.config;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class SwitchService {
    /**
     * 判断开关是否打开
     * @param custId 客户id
     * @return true:打开；false：关闭
     */
    public boolean isOpen(String custId) {
        //从nacos 配置获取
        String json = "{\"contry\":\"mxg\",\"isopen\":true,\"iswhite\":true,\"whitelist\":[\"123\",\"456\"]}";
        Config config = JSON.parseObject(json, Config.class);
        if (config != null) {
            if (config.isIsopen()) {
                if (config.isIswhite() && !CollectionUtils.isEmpty(config.getWhitelist())) {
                    if (config.getWhitelist().contains(custId)) {
                        return true;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
