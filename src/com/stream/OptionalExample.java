package com.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalExample {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        OptionalDouble average = list.stream()
                .mapToInt(Integer::intValue)
                .average();

        if(average.isPresent()) {
            System.out.println("평균 : "+ average.getAsDouble());
        }else {
            System.out.println("평균 : 0.0");
        }

        double asDouble = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println("asDouble = " + asDouble);

        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(System.out::println);
    }
}
