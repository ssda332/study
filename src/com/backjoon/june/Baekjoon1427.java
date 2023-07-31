package com.backjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] counting = new int[10];
        String N = br.readLine();


        for (int i = 0; i < N.length(); i++) {
            counting[ N.charAt(i) - 48 ]++;
        }

        for (int i = counting.length - 1; i >= 0; i--) {
            for (int j = 0; j < counting[i]; j++) {
                sb.append(i);
            }
        }

        System.out.println(sb);
    }
}
