package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2018_연속된_자연수의_합_구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;

        int N = Integer.parseInt(br.readLine());

        while (end_index != N) {
            if (sum == N) {
                end_index++;
                count++;
                sum = sum + end_index;
            } else if (sum > N) {
                sum = sum - start_index;
                start_index++;
            } else if (sum < N) {
                end_index++;
                sum = sum + end_index;
            }
        }

        System.out.println(count);
    }
}
