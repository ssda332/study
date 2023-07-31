package com.backjoon.july;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2023_신기한_소수 {

    static int N;
    static StringBuffer sb = new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);

        System.out.println(sb);
        br.close();
    }

    static void dfs(int num, int digit) {
        if (digit == N && isPrime(num)) {
            sb.append(num + "\n");
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (isPrime(num * 10 + i)) {
                int target = num * 10 + i;
                dfs(target, digit + 1);
            }
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    /*static boolean isPrime2(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            for (int j = i + i; j <)
        }
    }*/
}
