package com.algorithm.baaarkingdog.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5622_다이얼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};
        String str = br.readLine();
        int answer = 0;
        for (int i = 0; i < str.length(); i++) {
            int n = str.charAt(i) - 'A';
            answer += alpha[n];
        }

        System.out.println(answer);
    }
}
