package com.self.pro.learn.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.util.*;
import java.nio.file.Path;

public class JsonDiff {
    //排序
    public static JSONArray sortJsonArray(JSONArray array) {
        List<Object> list = array.toJavaList(Object.class);
        list.sort(Comparator.comparing(Object::toString));
        return JSON.parseArray(JSON.toJSONString(list));
    }

    static Map<String,Object> appendMap = new HashMap<>();

    public static void jsonDiff(Path p1, Path p2){
        String j1="",j2="";
        try {
            j1 = FileUtils.readFileToString(p1.toFile(), Charset.defaultCharset());
            j2 = FileUtils.readFileToString(p2.toFile(), Charset.defaultCharset());
//            JsonObject jsonObject = JsonParser.parseString (j2).getAsJsonObject();
//            String str = "#/purpose/awakeBraveContribution#request";
//
//            String parentKey[] = str.split("#");
//            JsonObject jsonObject1 = jsonObject;
//            for (String key : parentKey) {
//                if (StringUtils.isNotBlank(key)) {
//                    jsonObject1 =jsonObject1.get(key).getAsJsonObject();
//                }
//            }
//            jsonObject1.addProperty("test","123");
//            JsonObject request = jsonObject.get("/purpose/awakeBraveContribution").getAsJsonObject()
//                    .get("request").getAsJsonObject();
//            request.addProperty("test","123");

//            System.out.println(jsonObject);
        } catch (IOException e) {
            System.out.println("文件读取异常！"+e.getMessage());
            return;
        }
        Map<String,Object> map1=null,map2=null;
        try{
            map1 = JSON.parseObject(j1, Map.class);
            appendMap.putAll(map1);
            map2 = JSON.parseObject(j2, Map.class);
        }catch (Exception e){
            System.out.println("文件格式异常!"+e.getMessage());
            return;
        }
        if(map1!=null&&map2!=null){
            resolvingMap(map1,map2,"");
        }
    }

    public static void resolvingMap(Map<String,Object> map1,Map<String,Object> map2,String parent){
        map2.forEach((k,v)->{
            if(!map1.containsKey(k)){
                System.out.println("新增字段{"+parent+"=="+k+"}"+" 值：" + v);
                if (StringUtils.isNotBlank(parent)) {
                    Map<String,Object> nodeMap = new HashMap<>();
                    nodeMap.put(k,v);
                    appendMap.put(parent,nodeMap);
                } else {
                    appendMap.put(k,v);
                }
            }else{
                if(v instanceof JSONObject){
                    resolvingMap(JSON.parseObject(JSON.toJSONString(map1.get(k)),Map.class),
                            JSON.parseObject(JSON.toJSONString(v),Map.class),parent+"#"+k);
                }

//                else if(v instanceof JSONArray){
//                    try{
//                        JSONArray object2 = sortJsonArray((JSONArray) v);
//                        JSONArray object1 = sortJsonArray(JSON.parseArray(JSON.toJSONString(map1.get(k))));
//                        for (int i = 0; i < object1.size(); i++) {
//                            HashMap<String, Object> hs1 = new HashMap<>();
//                            HashMap<String, Object> hs2 = new HashMap<>();
//                            hs1.put(String.valueOf(i),object1.get(i));
//                            try {
//                                hs2.put(String.valueOf(i),object2.get(i));
//                            }catch (Exception e){
//                                System.out.println("数组字段存在问题{"+parent+"/"+k+"["+i+"]}");
//                            }
//                            resolvingMap(hs1,hs2,parent+"/"+k);
//                        }
//                    }catch (Exception e){
//                        System.out.println("数组信息错误{"+parent+"/"+k+"}");
//                    }
//                }
//                else {
//                    if(!v.equals(map1.get(k))){
//                        System.out.println("字段值不一致{"+parent+"/"+k+"}");
//                        System.out.println(v+"====>"+map2.get(k));
//                        System.out.println("-------------------------");
//                    }
//                }
            }
        });
    }


    public static void appendDiff(Path p1, Path p2){
        String j1="",j2="";
        try {
            j1 = FileUtils.readFileToString(p1.toFile(), Charset.defaultCharset());
            j2 = FileUtils.readFileToString(p2.toFile(), Charset.defaultCharset());
        } catch (IOException e) {
            System.out.println("文件读取异常！"+e.getMessage());
            return;
        }
        Map<String,Object> map1=null,map2=null;
        try{
            map1 = JSON.parseObject(j1, Map.class);
            map2 = JSON.parseObject(j2, Map.class);
        }catch (Exception e){
            System.out.println("文件格式异常!"+e.getMessage());
            return;
        }
        if(map1!=null&&map2!=null){
            String oldJson = getJson();
            JsonObject oldJsonObject = JsonParser.parseString (oldJson).getAsJsonObject();
            JsonObject appendJsonObject = oldJsonObject;
            buildMap(map1,map2,"",appendJsonObject);
            System.out.println("appendJsonObject >>>>>>>" + appendJsonObject);
        }
    }

    public static void buildMap(Map<String,Object> oldJsonMap,Map<String,Object> newJsonMap,String parent,JsonObject appendJsonObject) {
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
                    buildMap(JSON.parseObject(JSON.toJSONString(oldJsonMap.get(key)), Map.class ),
                            JSON.parseObject(JSON.toJSONString(val), Map.class), parent + "#" + key,appendJsonObject);
                }
            }

        }

        /*map2.forEach((k, v) -> {
            if (!map1.containsKey(k)) {
                System.out.println("新增字段{" + parent + "==" + k + "}" + " 值：" + v);
                if (StringUtils.isNotBlank(parent)) {
                    String parentKey[] = parent.split("#");
                    for (String key : parentKey) {
                        if (StringUtils.isNotBlank(key)) {
                            appendJsonObject =appendJsonObject.get(key).getAsJsonObject();
                        }
                    }
                    appendJsonObject.addProperty(k,v.toString());
                } else {
                    appendJsonObject.addProperty(k,v.toString());
//                    appendMap.put(k, v);
                }
                System.out.println("appendJson>>>>>" + appendJsonObject);
            } else {
                if (v instanceof JSONObject) {
                        buildMap(JSON.parseObject(JSON.toJSONString(map1.get(k)), Map.class),
                                JSON.parseObject(JSON.toJSONString(v), Map.class), parent + "#" + k);
                }
            }
        });*/
    }

    private static String getJson() {
        String oldJson = "";
        try {
             oldJson = FileUtils.readFileToString(Paths.get("/Users/chenbin/test/old_cfecredito.json").toFile(), Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return oldJson;
    }

    public static String appendJson(String oldJson, String newJson) {
        Object oldJsonObject = JSONObject.parse(oldJson);
        Object newJsonObject = JSONObject.parse(newJson);
        Map<String, Object> resultMap = new HashMap<>();
        JSONObject appendObject = (JSONObject) oldJsonObject;
       // addJson(SYS_ROOT, oldJsonObject, newJsonObject, resultMap,appendObject);
        String resultStr = JSON.toJSONString(resultMap.get(""), new SerializerFeature[]{SerializerFeature.WriteMapNullValue});
        return resultStr;
    }

    public static void  add(String oldJson,String newJson) {
        Object oldJsonObject = JSONObject.parse(oldJson);
        Object newJsonObject = JSONObject.parse(newJson);
        JSONObject object = (JSONObject) oldJsonObject;
         addJson("",oldJsonObject,newJsonObject,object);

    }
    Map<String,Object> keyMap = new HashMap<>();
    private static void addJson(String dir,Object oldJsonObj,Object newJsonObj,Object appendobject) {
        JSONObject appendjsonObject = (JSONObject) appendobject;
        if (oldJsonObj instanceof JSONObject) {
            JSONObject newjsonObject = (JSONObject) newJsonObj;
            JSONObject oldjsonObject = (JSONObject) oldJsonObj;
            Iterator<String> iterator = newjsonObject.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                Object oldObj = oldjsonObject.get(key);
                Object newObj = newjsonObject.get(key);
                Object appendObj = appendjsonObject.get(key);
                addJson(key,oldObj, newObj,appendObj);
            }


        }else {
            if (oldJsonObj == null) {
                appendjsonObject.put(dir,newJsonObj);
            }
        }

    }

    /**
     * 追加差异字段
     * @param oldJsonObject 原始json对象
     * @param newJsonObject 新json对象
     * @return 追加完的json对象
     */
    public static JSONObject appendJsonContent(JSONObject oldJsonObject,JSONObject newJsonObject) {
        Iterator<String> iterator = newJsonObject.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            Object oldObj = oldJsonObject.get(key);
            Object value = newJsonObject.get(key);
            if (oldObj == null){
                oldJsonObject.put(key, value);
            } else {
                if (value instanceof JSONObject) {
                    JSONObject valueJson = (JSONObject) value;
                    appendJsonContent((JSONObject) oldJsonObject.get(key),valueJson);
                } else {
                    oldJsonObject.put(key,value);
                }
            }
        }
        return oldJsonObject;
    }



 public static void main(String[] args) {
     String oldJson = JsonUtils.getJson(Paths.get("/Users/chenbin/test/old_cfecredito.json"));
     String newJson = JsonUtils.getJson(Paths.get("/Users/chenbin/test/new_cfecredito.json"));

//     add(oldJson,newJson);
//     System.out.println(appendMap);
//     String str = "#/purpose/awakeBraveContribution#request";
//     System.out.println(str.split("#")[2]);
     JSONObject oldJsonObject = JSONObject.parseObject(oldJson);
     JSONObject  newJsonObject = JSONObject.parseObject(newJson);

//     JSONObject appendOb = appendJsonContent(oldJsonObject, newJsonObject);
//     System.out.println(appendOb);



    }

}
