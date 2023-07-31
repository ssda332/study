package com.backjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Beakjoon10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer num = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            stack(list, Integer.parseInt(br.readLine()));
        }

        int sum = list.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(sum);

    }

    public static void stack(List<Integer> list, Integer input) {
        if (input == 0) {
            list.remove(list.size() - 1);
        } else {
            list.add(input);
        }
    }
}
