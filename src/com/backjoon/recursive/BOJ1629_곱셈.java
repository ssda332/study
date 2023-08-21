package com.backjoon.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629_곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(multi(A, B, C));
    }

    static long multi(long a, long b, long c) {
        if (b <= 1) {
            return a % c;
        }

        long val = multi(a, b / 2, c);
        val = val * val % c;

        if (b % 2 == 0 ) return val;
        return val * a % c;
    }
}
