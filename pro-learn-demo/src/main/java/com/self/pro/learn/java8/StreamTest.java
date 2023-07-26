package com.self.pro.learn.java8;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
//        List<String> list = Arrays.asList("a", "b", "c");
//        // 创建一个顺序流
//        Stream<String> stream = list.stream();
//       // 创建一个并行流
//        Stream<String> parallelStream = list.parallelStream();
//        System.out.println(parallelStream.collect(Collectors.toList()));
//        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);
//        stream.iterator(0, (x) -> x+3);

        JSONObject jsonData = JSON.parseObject("{requestData:1}");
        System.out.println(jsonData.toJSONString());


    }
}
