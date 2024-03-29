package com.self.pro.common.security;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.self.pro.common.security.util.AES;
import com.self.pro.common.security.util.ConvertUtils;
import com.self.pro.common.security.util.EncryUtil;
import com.self.pro.common.security.util.RSA;
//import com.weilu.loan.security.util.AES;
//import com.weilu.loan.security.util.ConvertUtils;
//import com.weilu.loan.security.util.EncryUtil;
//import com.weilu.loan.security.util.RSA;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 模拟测试 RSA签名、验签，AES 加密 整个业务流程
 */
public class TestMain {
    public static final String clientPrivateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKbNojYr8KlqKD/y" +
            "COd7QXu3e4TsrHd4sz3XgDYWEZZgYqIjVDcpcnlztwomgjMj9xSxdpyCc85GOGa0" +
            "lva1fNZpG6KXYS1xuFa9G7FRbaACoCL31TRv8t4TNkfQhQ7e2S7ZktqyUePWYLlz" +
            "u8hx5jXdriErRIx1jWK1q1NeEd3NAgMBAAECgYAws7Ob+4JeBLfRy9pbs/ovpCf1" +
            "bKEClQRIlyZBJHpoHKZPzt7k6D4bRfT4irvTMLoQmawXEGO9o3UOT8YQLHdRLitW" +
            "1CYKLy8k8ycyNpB/1L2vP+kHDzmM6Pr0IvkFgnbIFQmXeS5NBV+xOdlAYzuPFkCy" +
            "fUSOKdmt3F/Pbf9EhQJBANrF5Uaxmk7qGXfRV7tCT+f27eAWtYi2h/gJenLrmtke" +
            "Hg7SkgDiYHErJDns85va4cnhaAzAI1eSIHVaXh3JGXcCQQDDL9ns78LNDr/QuHN9" +
            "pmeDdlQfikeDKzW8dMcUIqGVX4WQJMptviZuf3cMvgm9+hDTVLvSePdTlA9YSCF4" +
            "VNPbAkEAvbe54XlpCKBIX7iiLRkPdGiV1qu614j7FqUZlAkvKrPMeywuQygNXHZ+" +
            "HuGWTIUfItQfSFdjDrEBBuPMFGZtdwJAV5N3xyyIjfMJM4AfKYhpN333HrOvhHX1" +
            "xVnsHOew8lGKnvMy9Gx11+xPISN/QYMa24dQQo5OAm0TOXwbsF73MwJAHzqaKZPs" +
            "EN08JunWDOKs3ZS+92maJIm1YGdYf5ipB8/Bm3wElnJsCiAeRqYKmPpAMlCZ5x+Z" +
            "AsuC1sjcp2r7xw==";

    public static final String clientPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCmzaI2K/Cpaig/8gjne0F7t3uE" +
            "7Kx3eLM914A2FhGWYGKiI1Q3KXJ5c7cKJoIzI/cUsXacgnPORjhmtJb2tXzWaRui" +
            "l2EtcbhWvRuxUW2gAqAi99U0b/LeEzZH0IUO3tku2ZLaslHj1mC5c7vIceY13a4h" +
            "K0SMdY1itatTXhHdzQIDAQAB";

    public static final String serverPrivateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALIZ98KqgLW8IMt4" +
            "G+N+4d3DiOiEa+5s6lCMSGE/NbU9stJEqw0EuCP54MY6JkT0HCYTCrLXqww6rSQy" +
            "WF7BNCVGssk2XDcvSKiCz1ZMgabd6XVK5kvIycySydXQ0Ky6rnfxw8w2mllHABFv" +
            "s1eamaHQozv18n/XGqemjW2BFy/jAgMBAAECgYAxT3FCi3SBXKnzy7hk/z9H6Bhi" +
            "0C8V3z/stzpe+mJDYOa+wtZdD15wT4HFQFpSIwgcHo+Kvp2UEDbZ27qN2Y43AZbF" +
            "9LOalWTRUzYtr8wL8MIbgtew/QQ9YFNWdkTZ6MxCItjD/mSz3Lrkcphvbsx4VoCV" +
            "YIJ04r+Loi0t9g0guQJBANvkpfrq0bLVRYWfaigjkx47mr0trJkB7mjADe69Iqts" +
            "M/2x5dHPpClDK78yzAWxU2BrYzOd31QIOm32iMIvRxUCQQDPWJPMOzcq8Jqs1PAM" +
            "7D0hxnvF3tSJB0CJCQWdGFkJiuIYSbrWnCVF78jJyU2AK1H3RDi9BzGPL2Z3i2Si" +
            "+9kXAkAPnKtAJl3fEY9PDmNuGCCA3AB/f/eqIV345/HVSm5kt1j1oSTNAa4JE/DO" +
            "MWAU42MlDFrNtl69y5vCZOeOyeaFAkBOJieGmWcAozDZJWTYqg2cdk/eU08t2nLj" +
            "c2gPPscIRrVSzC9EhhOyWV8HVv0D6s/471inPlfajNYFBp/Goj+/AkEAiejHX/58" +
            "Vv8+ccW22RMZmyxiHcZpTw9hz7vHUCWv03+fyVGtGMhJ4xuPt8UaZm91yHSPWWar" +
            "M8Xa7errKaXN9A==";
    public static final String serverPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCyGffCqoC1vCDLeBvjfuHdw4jo" +
            "hGvubOpQjEhhPzW1PbLSRKsNBLgj+eDGOiZE9BwmEwqy16sMOq0kMlhewTQlRrLJ" +
            "Nlw3L0iogs9WTIGm3el1SuZLyMnMksnV0NCsuq538cPMNppZRwARb7NXmpmh0KM7" +
            "9fJ/1xqnpo1tgRcv4wIDAQAB";

    public static void main(String[] args) throws Exception {
        List<String> fileNames = new ArrayList<>();
        fileNames.add("public.key");
        fileNames.add("private.key");
        String path = "D:\\key";
//        RSA.createKeyAndSavePath(path,fileNames);
//        String privateContent = RSA.readKeyFromPath(path,"private.key");
//        String publicContent = RSA.readKeyFromPath(path,"public.key");
//        System.out.println(publicContent);

        Map<String, Object> params = new LinkedHashMap<>();
        params.put("userid", "152255855");
        params.put("phone", "18965621420");
//        String info = JSON.toJSONString(params);
//        //生成AES密钥
//        String aesKey = AES.generateSecret(256);
//        //加密
//        String encryptData = AES.encryptToBase64(info, aesKey);
//        //解密
//        String decryptData = AES.decryptFromBase64(encryptData,aesKey);
//        System.out.println(decryptData);

        //模拟业务端
        client(params);
        //模拟支付服务端
       server();
    }

    public static void client(Map<String, Object> params) throws Exception {
        // 生成RSA签名(业务私钥进行签名)
        String sign = EncryUtil.sign(params, clientPrivateKey);
        params.put("sign", sign);
        String info = JSON.toJSONString(params);
        //生成AES密钥
        String aesKey = AES.generateSecret(256);
        //AES加密数据 （传输的参数数据和签名）
        String data = AES.encryptToBase64(ConvertUtils.stringToHexString(info), aesKey);
        // 使用RSA算法将商户自己随机生成的AESkey加密（支付服务公钥加密）
        String encryptkey = RSA.encrypt(aesKey, serverPublicKey);

        Req.data = data;
        Req.encryptkey = encryptkey;

        System.out.println("加密后的请求数据:\n" + new Req().toString());
    }

    public static void server() throws Exception {

        // 验签
        boolean passSign = EncryUtil.verifySignAndCheckDecrypt(Req.data,
                Req.encryptkey, clientPublicKey, serverPrivateKey);

        if (passSign) {
            // 验签通过
            String aeskey = RSA.decrypt(Req.encryptkey,
                    serverPrivateKey);
            String data = ConvertUtils.hexStringToString(AES.decryptFromBase64(Req.data,
                    aeskey));

            JSONObject jsonObj = JSONObject.parseObject(data);
            String userid = jsonObj.getString("userid");
            String phone = jsonObj.getString("phone");

            System.out.println("解密后的明文:userid:" + userid + " phone:" + phone);

        } else {
            System.out.println("验签失败");
        }
    }

    static class Req {
        public static String data;
        public static String encryptkey;

        @Override
        public String toString() {
            return "data:" + data + "\nencryptkey:" + encryptkey;
        }
    }
}
