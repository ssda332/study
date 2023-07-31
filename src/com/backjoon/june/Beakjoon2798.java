package com.backjoon.june;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Beakjoon2798 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nm = sc.nextLine();
        String[] arr = nm.split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);

        String line = sc.nextLine();
        String[] cards = line.split(" ");
        List<Integer> collect = Arrays.stream(cards)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Integer minNum = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0; i < collect.size() - 2; i++) {
            for (int j = i + 1; j < collect.size() - 1; j++) {
                for (int k = j + 1; k < collect.size(); k++) {
                    int sum = collect.get(i) + collect.get(j) + collect.get(k);
//                    System.out.println("i : " + i + ", j : " + j + ", k : " + k);

                    if (Math.abs(M - sum) < minNum) {
//                        System.out.println("catch");
                        minNum = Math.abs(M - sum);
                        result = sum;
                    }
                }
            }
        }

        System.out.println(result);
    }
}
