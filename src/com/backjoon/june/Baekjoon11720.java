package com.backjoon.june;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String N = br.readLine();

        int sum = 0;

        for (int i = 0; i < N.length(); i++) {
            sum += Integer.parseInt(N.charAt(i) + "");
        }

        System.out.println(sum);
    }
}
