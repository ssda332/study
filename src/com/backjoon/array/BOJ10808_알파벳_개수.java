package com.backjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10808_알파벳_개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] alpha = new int[26];

        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 'a';

            alpha[num]++;
        }

        for (int i : alpha) {
            System.out.print(i + " ");
        }
    }
}
