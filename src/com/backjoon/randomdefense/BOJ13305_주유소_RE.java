package com.backjoon.randomdefense;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class BOJ13305_주유소_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] costs = new int[N];
        int[] cities = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }

        BigInteger sum = BigInteger.valueOf(cities[1]).multiply(BigInteger.valueOf(costs[1]));
        int min = cities[1];

        for (int i = 2; i < N; i++) {
            if (min > cities[i]) {
                min = cities[i];
                BigInteger minVal = BigInteger.valueOf(min).multiply(BigInteger.valueOf(costs[i]));
                sum = sum.add(minVal);
            } else {
                BigInteger minVal = BigInteger.valueOf(min).multiply(BigInteger.valueOf(costs[i]));
                sum = sum.add(minVal);
            }
        }

        System.out.println(sum);
    }
}
