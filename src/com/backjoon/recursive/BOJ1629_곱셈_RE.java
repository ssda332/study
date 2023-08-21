package com.backjoon.recursive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1629_곱셈_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken()); // 자연수
        long B = Long.parseLong(st.nextToken()); // 제곱
        long C = Long.parseLong(st.nextToken()); // 나누는 수

        System.out.println(recursive(A, B, C));

    }

    static long recursive(long a, long b, long c) {
        // (a^(b/2) % c) * (a^(b/2) % c) = a^b % c
        // base condition
        if (b <= 1) {
            return a % c;
        }

        long value = recursive(a, b / 2, c);
        value = value * value % c;
        if (b % 2 == 0) return value;

        return value * a % c;
    }
}
