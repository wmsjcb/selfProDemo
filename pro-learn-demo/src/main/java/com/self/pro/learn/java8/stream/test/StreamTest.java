package com.self.pro.learn.java8.stream.test;

import com.self.pro.learn.java8.stream.bean.Dish;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toSet;

public class StreamTest {
    public static void main(String[] args) {
        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH) );
          List<String> collect = menu.stream().filter(d -> d.getCalories() <= 800).map(Dish::getName).limit(3).collect(Collectors.toList());

        List<String> collects = menu.stream().filter(d -> d.getName().equals("pork")).map(d ->d.getName()).limit(3).collect(Collectors.toList());
        //        System.out.println(collects);
        List<String> title = Arrays.asList("Java8", "In", "Action");
        Stream t = title.stream();
//        t.forEach(System.out::println);
//        t.forEach(System.out::println);
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
//        numbers.stream().filter(i -> i%2 == 0).distinct().forEach(System.out::println);
       // List<String> collect1 = 
        List<Integer> collect1 = menu.stream()
                .filter(dish -> dish.getCalories() > 300).skip(3)
                .map(Dish::getName).map(String::length).collect(Collectors.toList());
//        System.out.println(collect1);

        String[] arrayOfWords = {"Goodbye", "World"};
        Stream<String> stream = Arrays.stream(arrayOfWords);
        List<String> collect2 = stream.map(word -> word.split((""))).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
       // System.out.println(collect2);
        if (menu.stream().noneMatch(d ->d.getCalories()>300)) {
           // System.out.println("The menu is (somewhat) vegetarian friendly!!");
        }
        Optional<Dish> any = menu.stream().filter(Dish::isVegetarian).findAny();
        boolean present = menu.stream().filter(Dish::isVegetarian).findAny().isPresent();
//        System.out.println(present);
        //menu.stream().filter(Dish::isVegetarian).findAny().ifPresent(d-> System.out.println(d.getName()));

        List<Integer> someNumbers = Arrays.asList(1, 2, 3, 4, 5);
        Optional<Integer> first = someNumbers.stream().map(x -> x*x).filter(x -> x % 3 == 0).findFirst();
//        System.out.println(first.get());

        Optional<Integer> reduce = someNumbers.stream().reduce(Integer::max);
        Optional<Integer> reduce1 = someNumbers.stream().reduce((t1, t2) -> t2 > t1 ? t2 : t1);
        Optional<Integer> reduce2 = someNumbers.stream().reduce((x, y) -> x + y);
//        System.out.println(reduce2.get());
        Integer reduce3 = menu.stream().map(Dish::getName).map(d -> 1).reduce(0, Integer::sum);
//        System.out.println(reduce3);
        long count = menu.stream().count();
//        System.out.println(count);
        OptionalInt max = menu.stream().mapToInt(Dish::getCalories).max();
//        System.out.println(max.getAsInt());
        OptionalDouble average = menu.stream().mapToInt(Dish::getCalories).average();
        int i = max.orElse(1);
//        System.out.println(i);
//        System.out.println(average.getAsDouble());
        IntStream intStream = IntStream.rangeClosed(1, 100).filter(x -> x % 2 == 0);
//        System.out.println(intStream.max());
        IntStream intStream1 = IntStream.range(1, 100).filter(n -> n % 2 == 0);
//        System.out.println(intStream1.max());
        Stream<String> streams = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
//        streams.forEach(s-> System.out.println(s.toUpperCase())   );
//        streams.map(String::toUpperCase).forEach(System.out::println);
//        menu.stream().collect(groupingBy());
        Long collect3 = menu.stream().collect(Collectors.counting());
//        System.out.println(collect3);
        Integer collect4 = menu.stream().collect(summingInt(Dish::getCalories));
//        System.out.println(collect4);
        Double collect5 = menu.stream().collect(averagingInt(Dish::getCalories));
//        System.out.println(collect5);
        String collect6 = menu.stream().map(Dish::getName).collect(joining(","));
//        System.out.println(collect6);
//        menu.stream().collect(joining());
        Integer collect7 = menu.stream().collect(reducing(0, Dish::getCalories, (a, b) -> a + b));
//        System.out.println(collect7);
        Map<Dish.Type, List<Dish>> collect8 = menu.stream().collect(groupingBy(Dish::getType));
//        System.out.println(collect8);
        Map<String, List<Dish>> collect9 = menu.stream().collect(groupingBy(d -> {
            if (d.getCalories() <= 400) {
                return "DIET";
            } else if (d.getCalories() <= 700) {
                return "NORMAL;";
            } else {
                return "FAT";
            }
//            return null;
        }));
        //System.out.println(collect9);

        Map<Dish.Type, Map<String, List<Dish>>> collect10 = menu.stream().collect(groupingBy(Dish::getType, groupingBy(d -> {
            if (d.getCalories() <= 400) {
                return "DIET";
            } else if (d.getCalories() <= 700) {
                return "NORMAL";
            } else {
                return "FAT";
            }
        })));
//        System.out.println(collect10);
        Map<Dish.Type, Long> collect11 = menu.stream().collect(groupingBy(Dish::getType, counting()));
//        System.out.println(collect11);
        Map<Dish.Type, List<String>> collect12 = menu.stream().collect(groupingBy(Dish::getType, Collectors.mapping(d -> {
            if (d.getCalories() <= 400) {
                return "DIET";
            } else if (d.getCalories() <= 700) {
                return "NORMAL";
            } else {
                return "FAT";
            }

        }, toCollection(ArrayList::new))));
//        System.out.println(collect12);
        Map<Dish.Type, Set<String>> collect13 = menu.stream().collect(groupingBy(Dish::getType, Collectors.mapping(d -> {
            if (d.getCalories() <= 400) {
                return "DIET";
            } else if (d.getCalories() <= 700) {
                return "NORMAL;";
            } else {
                return "FAT";
            }

        }, toSet())));
//        System.out.println(collect13);
        Map<Boolean, List<Dish>> collect14 = menu.stream().collect(partitioningBy(Dish::isVegetarian));
//        System.out.println(collect14);
        List<Dish> collect15 = menu.stream().filter(d -> !d.isVegetarian()).collect(Collectors.toList());
//        System.out.println(collect15);

         Map<String,String> map = new HashMap<>();
         map.put("a","A");
         map.put("b","B");
        map.forEach((k,v) -> {
            if (k.equals("a")){
                //System.out.println(v);
            }
        } );

    }
}
