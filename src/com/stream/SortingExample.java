package com.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class SortingExample {
    public static void main(String[] args) {

        int[] arr = {5, 1, 3, 2, 4};

        IntStream intStream = Arrays.stream(arr);
        intStream
                .boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);

    }
}
