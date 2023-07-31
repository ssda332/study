package com.backjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;

public class Baekjoon25305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        String[] inputScore = br.readLine().split(" ");

        AtomicInteger idx = new AtomicInteger(0);

        Arrays.stream(inputScore)
                .mapToInt(Integer::parseInt)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .forEach(data -> {
                    if (idx.get() == Integer.parseInt(input[1]) - 1) {
                        System.out.println(data);
                    }
                    idx.getAndIncrement();
                });
    }
}
