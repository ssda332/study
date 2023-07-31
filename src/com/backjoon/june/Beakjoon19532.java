package com.backjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beakjoon19532 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        int[] input = Arrays.stream(arr)
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = -999; i <= 999; i++) {
            for (int j = -999; j <= 999; j++) {
                if ((input[0] * i) + (input[1] * j) == input[2] && (input[3] * i) + (input[4] * j) == input[5]) {
                    System.out.println(i + " " + j);
                }
            }
        }


    }
}
