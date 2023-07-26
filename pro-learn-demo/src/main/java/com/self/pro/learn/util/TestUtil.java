package com.self.pro.learn.util;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.DateUtil;

import java.util.Date;

public class TestUtil {
    public static void main(String[] args) {
        System.out.println(DateFormatUtils.format(new Date(1644980707252L),"yyyy-MM-dd HH:mm:ss") );
    }
}
