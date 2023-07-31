package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1427_내림차순 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int[] arr = new int[num.length()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = num.charAt(i) - '0';
        }

        for (int i = 0; i < arr.length - 1; i++) {
            int max = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[max] < arr[j]) {
                    max = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;
        }

        for (int i : arr) {
            System.out.print(i);
        }

    }

}
