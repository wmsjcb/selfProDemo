package com.self.pro.learn.util;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class GzipUtil {

    public static String uncompress(InputStream gzippedResponse) throws IOException {

        InputStream decompressedResponse = new GZIPInputStream(gzippedResponse);
        Reader reader = new InputStreamReader(decompressedResponse, "UTF-8");
        StringWriter writer = new StringWriter();

        char[] buffer = new char[10240];
        for(int length = 0; (length = reader.read(buffer)) > 0;){
            writer.write(buffer, 0, length);
        }

        writer.close();
        reader.close();
        decompressedResponse.close();
        gzippedResponse.close();

        return writer.toString();
    }

    public static String uncompressToString(byte[] bytes, String encoding) {
        if (bytes == null || bytes.length == 0) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        try {
            GZIPInputStream ungzip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = ungzip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            return out.toString(encoding);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String gzip(String data){
        try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {

            byte[] buffer = data.getBytes("utf-8");
            try (GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream)) {
                gzipOutputStream.write(buffer);
            }
            return new sun.misc.BASE64Encoder().encode(outputStream.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        // {mobile} 申请人的手机号
        // {task_id} 用户授权认证，创建运营商采集任务的任务ID
        // 请注意修改
        // 样例：URL url = new URL("https://api.51datakey.com/carrier/v3/mobiles/13100000000/mxdata?task_id=008ef370-5f11-11e6-909c-00163e004a23“);
        URL url = new URL("https://api.51datakey.com/carrier/v3/mobiles/18600350887/mxreport?name=张宇&idcard=211003199103150811&task_id=327f6f70-658c-11e9-8d7b-00163e0f4efb");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept-Encoding", "gzip,deflate,sdch");
        connection.setRequestProperty("Accept", "application/json");

        // value 为魔蝎分配的token
        // 请注意修改
        // 样例：connection.setRequestProperty("Authorization", "token 090b2fd02d034dbea409bbd5f9900bc2");
        connection.setRequestProperty("Authorization", "token " + "71fe08767f1540bc8494dd1a4e3d9126");
        connection.connect();
        System.out.println(uncompress(connection.getInputStream()));
        connection.disconnect();

    }
}
