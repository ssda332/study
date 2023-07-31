package com.backjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        int[] arr = new int[num];
        int[] counting = new int[10001];

        for (int i : arr) {
            arr[i] = Integer.parseInt(br.readLine());
            counting[ arr[i] ]++;
        }

        for (int i = 1; i < counting.length; i++) {
            for (int j = 0; j < counting[i]; j++) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb);

    }
}
