package com.self.pro.learn.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class JsonUtils {

    private static final String SYS_ROOT = "sys_root";
    private static final String NEW_FIELD = "new_field";
    private static final String OLD_FIELD = "old_field";

    /**
     * 比较json差异
     * @param oldJsonObject 原始json对象
     * @param newJsonObject 新json 对象
     * @param objectMap 比较结果map
     */
    private static void compareJson(JSONObject oldJsonObject, JSONObject newJsonObject, Map<String, Object> objectMap) {
        Iterator<String> iterator = newJsonObject.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object oldJson = oldJsonObject.get(key);
            Object newJson = newJsonObject.get(key);
            compareJson(key, oldJson, newJson, objectMap);
        }
    }

    /**
     * 比较json差异
     * @param key 比较结果的map key，唯一就行
     * @param oldJson 原始json文件
     * @param newJson 新json 文件
     * @param resultMap 比较结果map
     */
    private static void compareJson(String key, Object oldJson, Object newJson, Map<String, Object> resultMap) {
        if (oldJson instanceof JSONObject) {
            Map<String, Object> objectMap = new HashMap<>();
            compareJson((JSONObject) oldJson, (JSONObject) newJson, objectMap);
            if (objectMap.size() > 0) {
                resultMap.put(key, objectMap);
            }

        } else if ((oldJson == null && newJson != null) || (oldJson != null && !oldJson.equals(newJson))) {
            Map<String, Object> compareMap = new HashMap<>();
            compareMap.put(NEW_FIELD, newJson);
            compareMap.put(OLD_FIELD, oldJson);
            resultMap.put(key, compareMap);
        }
    }


    /**
     * json差异比较
     * @param oldJson 原始json文件
     * @param newJson 新json 文件
     * @return 比较差异的json 结果
     */
    public static String compareJson(String oldJson, String newJson) {
        Object oldJsonObject = JSONObject.parse(oldJson);
        Object newJsonObject = JSONObject.parse(newJson);
        Map<String, Object> resultMap = new HashMap<>();
        compareJson(SYS_ROOT, oldJsonObject, newJsonObject, resultMap);
        String resultStr = JSON.toJSONString(resultMap.get(SYS_ROOT), new SerializerFeature[]{SerializerFeature.WriteMapNullValue});
        return resultStr;
    }


    /**
     * 追加新的json 字段
     * @param oldJsonMap 老的jsonMap
     * @param newJsonMap 新的jsonMap
     * @param parent json 解析路径目录
     * @param appendJsonObject 追加的json Object对象
     */
    public static void appendJsonContent(Map<String,Object> oldJsonMap, Map<String,Object> newJsonMap, String parent,
                                         JsonObject appendJsonObject) {
        for (Map.Entry<String, Object> entry:newJsonMap.entrySet()) {
            String key = entry.getKey();
            Object val =  entry.getValue();
            if (!oldJsonMap.containsKey(key)) {
                System.out.println("新增字段{" + parent + "==" + key + "}" + " 值：" + val);
                if (StringUtils.isNotBlank(parent)) {
                    String parentKey[] = parent.split("#");
                    for (String index : parentKey) {
                        if (StringUtils.isNotBlank(index)) {
                            appendJsonObject =appendJsonObject.get(index).getAsJsonObject();
                        }
                    }
                    appendJsonObject.addProperty(key,val.toString());
                } else {
                    appendJsonObject.addProperty(key,val.toString());
                }
            } else {
                if (val instanceof JSONObject) {
                    appendJsonContent(JSON.parseObject(JSON.toJSONString(oldJsonMap.get(key)), Map.class ),
                            JSON.parseObject(JSON.toJSONString(val), Map.class), parent + "#" + key,appendJsonObject);
                }
            }
        }
    }

    public static String getJson(Path path) {
        String json = "";
        try {
            json = FileUtils.readFileToString(path.toFile(), Charset.defaultCharset());
            //json = FileUtils.readFileToString(Paths.get("/Users/chenbin/test/old_cfecredito.json").toFile(), Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return json;
    }


    public static void main(String[] args) {
        String oldJson = getJson(Paths.get("/Users/chenbin/test/old_cfecredito.json"));
        String newJson = getJson(Paths.get("/Users/chenbin/test/new_cfecredito.json"));
//        String oldJson = getJson(Paths.get("/Users/chenbin/test/old.json"));
//        String newJson = getJson(Paths.get("/Users/chenbin/test/new.json"));
        Map<String,Object> oldJsonMap = JSON.parseObject(oldJson, Map.class);
        Map<String,Object> newJsonMap = JSON.parseObject(newJson, Map.class);
//        appendJsonContent(oldJson,newJson);

        if (oldJsonMap != null && newJsonMap != null) {
            //追加的测试
//            JSONObject oldJsonObject = JsonParser.parseString (oldJson).getAsJsonObject();
            JSONObject oldJsonObject = (JSONObject) JSONObject.parse(oldJson);
            String resultStr = compareJson(oldJson, newJson);
            System.out.println(resultStr);
//            appendJsonContent(oldJson,resultStr);
        }

    }


    public static void createJSON() throws IOException{
        JsonObject object = new JsonObject(); // 创建一个json对象

        object.addProperty("cat", "it");    // 为json对象添加属性

        JsonArray languages = new JsonArray(); // 创建json数组

        JsonObject language = new JsonObject();

        language.addProperty("id", 1);

        language.addProperty("ide", "Eclipse");

        language.addProperty("name", "java");

        languages.add(language);        // 将json对象添加到数组

        language = new JsonObject();

        language.addProperty("id", 2);

        language.addProperty("ide", "XCode");

        language.addProperty("name", "Swift");

        languages.add(language);

        language = new JsonObject();

        language.addProperty("id", 3);

        language.addProperty("ide", "Visual Studio");

        language.addProperty("name", "C#");

        languages.add(language);

        object.add("languages", languages);  // 将数组添加到json对象

        object.addProperty("pop", true);
        JsonObject purpose = new JsonObject();
        purpose.addProperty("type","form");

        JsonObject request = new JsonObject();
        request.addProperty("name","test");
        purpose.add("request",request);

        object.add("/purpose/awakeBraveContribution",purpose);

        String jsonStr = object.toString();  // 将json对象转化成json字符串
        System.out.println(jsonStr);

//        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("data.json")));
//
//        pw.print(jsonStr);
//
//        pw.flush();
//
//        pw.close();

    }



}
