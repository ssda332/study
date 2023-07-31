package com.backjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Integer.parseInt(br.readLine());
        String[] score = br.readLine().split(" ");

        int max = Arrays.stream(score)
                .mapToInt(Integer::parseInt)
                .max()
                .getAsInt();

        double average = Arrays.stream(score)
                .mapToDouble(data -> {
                    double result = Double.parseDouble(data) / (double)max * 100;
                    return result;
                })
                .average()
                .getAsDouble();

        System.out.println(average);

    }
}
