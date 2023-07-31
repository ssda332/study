package com.algorithm.baaarkingdog.chapter1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int result = (int) func4(N);
        System.out.println(result);
    }

    private static double func4(int N) {
        double result = 1;

        for (int i = 1; Math.pow(2, i) <= N; i++) {
            result = Math.pow(2, i);

        }

        return result;
    }
}
