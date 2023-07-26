package com.self.pro.learn.java8;

import java.util.Arrays;
import java.util.List;

public class LambdaTest {

    public static void main(String[] args) {
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(">>>>>>>>>>>>>>>>strating");
//            }
//        };
////        runnable.run();
//        int a = 10;
//        Runnable runnable1 = () -> System.out.println(a +">>>>>>>>>>>>>>>>strating111");
//        process(runnable1);


        List<String> str = Arrays.asList("a","b","A","B");
        str.sort((s1, s2) -> s1.compareTo(s2));

//        str.sort(String::compareTo);
//        System.out.println(str);


    }

    public static void process(Runnable r){
        r.run();
    }
}
