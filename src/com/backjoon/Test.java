package com.backjoon;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        /*List<String> strings = Arrays.asList("10, 20, 30", "40, 50, 60");

        strings.stream()
                .forEach(System.out::println);*/

        int[] arr = {30, 40, 45, 20, 65, 10};
/*
        선택 정렬
        for (int i = 1; i <= arr.length; i++) {
            int key = i;
            while (key > 1 && arr[key - 2] > arr[key - 1]) {
                int temp = arr[key - 2];
                arr[key - 2] = arr[key - 1];
                arr[key - 1] = temp;
                key--;
            }
        }
*/

        Arrays.stream(arr)
                .forEach(System.out::println);
    }
}
