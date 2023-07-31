package com.backjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];

        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        double asDouble = Arrays.stream(arr)
                .average()
                .getAsDouble();

        int[] sortedArray = Arrays.stream(arr)
                .sorted()
                .toArray();

        System.out.println((int)asDouble);
        System.out.println(sortedArray[2]);

    }
}
