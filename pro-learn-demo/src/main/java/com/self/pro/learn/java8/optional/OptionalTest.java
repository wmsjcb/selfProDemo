package com.self.pro.learn.java8.optional;

import com.self.pro.learn.java8.stream.bean.Car;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Car car = null;
        Optional<Car> optCar = Optional.empty();
//        Optional<Car> cars = Optional.of(car);
//        System.out.println(cars.get());
//        Optional<Car> cars = Optional.ofNullable(car);
//        System.out.println(cars);
        System.out.println(optCar);

    }
}
