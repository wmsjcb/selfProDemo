package com.self.pro.common.security.util;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.commons.lang.StringUtils;

@Slf4j
public class EncryUtil {
	/**
	 * 生成RSA签名
	 */
	public static String sign(Map<String, Object> map,
							  String privateKey) {
		StringBuffer sbuffer = new StringBuffer();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			sbuffer.append(entry.getValue());
		}
		String signTemp = sbuffer.toString();

		String sign = "";
		if (privateKey != null && privateKey.length() >0) {
			sign = RSA.sign(signTemp, privateKey);
		}
		return sign;
	}

	/**
	 * 返回的结果进行验签
	 * 
	 * @param data
	 *            业务数据密文
	 * @param encrypt_key
	 *            对ybAesKey加密后的密文
	 * @param clientPublicKey
	 *            客户端公钥
	 * @param serverPrivateKey
	 *            服务器私钥
	 * @return 验签是否通过
	 * @throws Exception
	 */
	public static boolean verifySignAndCheckDecrypt(String data, String encrypt_key,
													String clientPublicKey, String serverPrivateKey) throws Exception {

		/** 1.使用serverPrivateKey解开aesEncrypt。 */
		String AESKey = "";
		try {
			AESKey = RSA.decrypt(encrypt_key, serverPrivateKey);
		} catch (Exception e) {
			/** AES密钥解密失败 */
			log.error(e.getMessage(), e);
			return false;
		}

		/** 2.用aeskey解开data。取得data明文 */
		String realData = ConvertUtils.hexStringToString(AES.decryptFromBase64(data, AESKey));
		
		Map<String, String> map = JSON.parseObject(realData,
				new TypeReference<LinkedHashMap<String, String>>() {});

		/** 3.取得data明文sign。 */
		String sign = StringUtils.trimToEmpty(map.get("sign"));

		/** 4.对map中的值进行验证 */
		StringBuffer signData = new StringBuffer();
		Iterator<Entry<String, String>> iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Entry<String, String> entry = iter.next();

			/** 把sign参数隔过去 */
			if (StringUtils.equals((String) entry.getKey(), "sign")) {
				continue;
			}
			signData.append(entry.getValue() == null ? "" : entry.getValue());
		}
		
		/** 5. result为true时表明验签通过 */
		boolean result = RSA.verifySign(signData.toString(), sign,
				clientPublicKey);

		return result;
	}

	/**
	 * 生成hmac
	 */
	public static String handleHmac(TreeMap<String, String> map, String hmacKey) {
		StringBuffer sbuffer = new StringBuffer();
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sbuffer.append(entry.getValue());
		}
		String hmacTemp = sbuffer.toString();

		String hmac = "";
		if (StringUtils.isNotEmpty(hmacKey)) {
			hmac = Digest.hmacSHASign(hmacTemp, hmacKey, Digest.ENCODE);
		}
		return hmac;
	}
}
