package com.stream;

import java.util.Arrays;

public class LoopingExample {
    public static void main(String[] args) {

        int[] intArr = {1, 2, 3, 4, 5};

        System.out.println("peek()를 마지막에 호출한 경우");
        int total = Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)
                .peek(System.out::println)
                .sum();

        System.out.println("total = " + total);
    }
}
