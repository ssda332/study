package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ13305_주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] cities = new int[N];
        int[] roads = new int[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            roads[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }

        // D
        /*int cost = cities[0] * roads[0];
        String s = String.valueOf(cost);*/
        BigInteger sum = new BigInteger("0");

        for (int i = 0; i < N - 1; i++) {
            if (cities[i] < cities[i + 1]) {
                cities[i + 1] = cities[i];
            }

            long cost = (long) cities[i] * roads[i];
            BigInteger bigInteger = BigInteger.valueOf(cost);

            BigInteger add = sum.add(bigInteger);
            sum = add;

        }

        System.out.println(sum);

    }
}
