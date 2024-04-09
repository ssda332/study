package com.backjoon.recursive;

import java.io.*;
import java.util.*;

public class BOJ1629_곱셈_RE_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(recursive(A, B, C));
    }

    static long recursive(long val, long exp, long mod) {
        if (exp <= 1) return val % mod;

        long result = recursive(val, exp / 2, mod);
        result = result * result % mod;

        if (exp % 2 == 1) {
            return result * val % mod;
        }

        return result;
    }


}
