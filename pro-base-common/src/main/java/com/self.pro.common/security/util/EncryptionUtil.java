package com.self.pro.common.security.util;

import lombok.extern.slf4j.Slf4j;

import java.security.MessageDigest;

/**
 * 加密工具
 */
@Slf4j
public class EncryptionUtil {

    /**
     * 对字符串进行md5加密
     *
     * @param str
     * @return
     */
    public static String md5(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            return byteToHex(md.digest());
        } catch (Exception e) {
            log.error("md5 error:{}",str, e );
            throw new RuntimeException(e);
        }
    }

    /**
     * 对字符串进行sha256加密
     *
     * @param str
     * @return
     */
    public static String sha256(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(str.getBytes());
            return byteToHex(md.digest());
        } catch (Exception e) {
            log.error("sha256 error:{}",str, e );
            throw new RuntimeException(e);
        }
    }

    /**
     * 对字符串进行sha1加密
     *
     * @param str
     * @return
     */
    public static String sha1(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(str.getBytes());
            return byteToHex(md.digest());
        } catch (Exception e) {
            log.error("sha1 error:{}",str, e );
            throw new RuntimeException(e);
        }
    }

    /**
     * 字节数组转16进制字符串
     *
     * @param data
     * @return
     */
    public static String byteToHex(byte[] data) {
        final StringBuilder builder = new StringBuilder();
        for(byte b : data) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
