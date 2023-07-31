package com.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MatchExample {
    public static void main(String[] args) {
        int[] intArr = {2, 4, 6};

        IntStream intStream = Arrays.stream(intArr);

        boolean bool = intStream
                .noneMatch(a -> a % 2 == 1); // allMatch, anyMatch, noneMatch

        System.out.println(bool);
    }
}
