package com.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AsDoubleStreamAndBoxedExample {
    public static void main(String[] args) {

        int[] intArray = {1, 2, 3, 4, 5};

        IntStream stream = Arrays.stream(intArray);

        stream
                .asDoubleStream()
                .forEach(System.out::println);

        System.out.println();

        stream = Arrays.stream(intArray);

        stream
                .boxed()
                .forEach(s -> System.out.println(s.intValue()));


    }
}
