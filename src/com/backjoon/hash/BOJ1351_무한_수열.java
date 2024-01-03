package com.backjoon.hash;

import java.io.*;
import java.util.*;

public class BOJ1351_무한_수열 {

    static Map<Long, Long> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long Q = Long.parseLong(st.nextToken());

        map = new HashMap<>();
        map.put(0l, 1l);

        long answer = sequence(N, P, Q);
        System.out.println(answer);
    }

    static long sequence(long n, long p, long q) {
        if (n == 0) return 1l;
        long x = n / p;
        long y = n / q;

        if (map.get(n) == null) {
            map.put(n, sequence(x, p, q) + sequence(y, p, q));
        }

        return map.get(n);
    }


}
