package com.self.pro.common.security.util;

import com.self.pro.common.security.config.EncryptAndDecryptConfig;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class AES {
    /**
     * 加密
     * @param data 需要加密的内容
     * @param key  加密密码
     * @return 密文
     */
   public static byte[] encrypt(byte[] data, byte[] key) {
       try {
           SecretKeySpec secretKey = getKey(key);
           Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
           cipher.init(Cipher.ENCRYPT_MODE, secretKey);
           return cipher.doFinal(data);
       } catch (Exception e) {
           throw new RuntimeException("encrypt fail!", e);
       }
   }
    /**
     * 解密
     * @param data 待解密内容
     * @param key  解密密钥
     * @return 明文
     */
    public static byte[] decrypt(byte[] data, byte[] key) {
        try {
            SecretKeySpec secretKey = getKey(key);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(data);
        } catch (Exception e) {
            throw new RuntimeException("decrypt fail!", e);
        }
    }

    /**
     * AES 加密的key
     * @param key 原始key
     * @return 封装后的key 对象
     */
    private static SecretKeySpec getKey(byte[] key) {
        try {
            MessageDigest sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            return new SecretKeySpec(key, "AES");
        } catch (Exception e) {
            throw new RuntimeException("getKey fail!", e);
        }
    }

    /**
     * 生成随机密钥
     * @param keySize 密钥大小推荐128 256
     * @return 生成的密钥
     */
    public static String generateSecret(int keySize) {
        try {
            KeyGenerator generator = KeyGenerator.getInstance("AES");
            generator.init(keySize, new SecureRandom());
            SecretKey key = generator.generateKey();
            return byteToHexString(key.getEncoded());
        } catch (Exception e) {
            throw new RuntimeException("generateSecret fail!", e);
        }
    }

    /**
     * byte数组转化为16进制字符串
     * @param bytes 需要转换的字节数组
     * @return 16进制字符串
     */
    private static String byteToHexString(byte[] bytes){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            String strHex=Integer.toHexString(bytes[i]);
            if(strHex.length() > 3){
                sb.append(strHex.substring(6));
            } else {
                if(strHex.length() < 2){
                    sb.append("0" + strHex);
                } else {
                    sb.append(strHex);
                }
            }
        }
        return  sb.toString();
    }

    /**
     * 把数据加密后转换成base64
     * @param data 明文
     * @param key 密钥
     * @return 明文加密后的密文的base64
     */
    public static String encryptToBase64(String data, String key) {
        try {
            byte[] valueByte = encrypt(data.getBytes(EncryptAndDecryptConfig.CHAR_ENCODING), key.getBytes(EncryptAndDecryptConfig.CHAR_ENCODING));
            return new String(Base64.encode(valueByte));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("encryptToBase64 fail!", e);
        }

    }
    /**
     * 把加密后的数据解密后转换成base64
     * @param data 密文
     * @param key 密钥
     * @return 密文解密后的明文的base64
     */
    public static String decryptFromBase64(String data, String key) {
        try {
            byte[] originalData = Base64.decode(data.getBytes());
            byte[] valueByte = decrypt(originalData, key.getBytes(EncryptAndDecryptConfig.CHAR_ENCODING));
            return new String(valueByte, EncryptAndDecryptConfig.CHAR_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("decryptFromBase64 fail!", e);
        }
    }

    public static String encryptWithKeyBase64(String data, String key) {
        try {
            byte[] valueByte = encrypt(data.getBytes(EncryptAndDecryptConfig.CHAR_ENCODING), Base64.decode(key.getBytes()));
            return new String(Base64.encode(valueByte));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("encryptWithKeyBase64 fail!", e);
        }
    }

    public static String decryptWithKeyBase64(String data, String key) {
        try {
            byte[] originalData = Base64.decode(data.getBytes());
            byte[] valueByte = decrypt(originalData, Base64.decode(key.getBytes()));
            return new String(valueByte, EncryptAndDecryptConfig.CHAR_ENCODING);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("decryptWithKeyBase64 fail!", e);
        }
    }

    public static byte[] genarateRandomKey() {
        KeyGenerator keygen = null;
        try {
            keygen = KeyGenerator.getInstance(EncryptAndDecryptConfig.AES_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(" genarateRandomKey fail!", e);
        }
        SecureRandom random = new SecureRandom();
        keygen.init(random);
        Key key = keygen.generateKey();
        return key.getEncoded();
    }

    public static String genarateRandomKeyWithBase64() {
        return new String(Base64.encode(genarateRandomKey()));
    }

}
