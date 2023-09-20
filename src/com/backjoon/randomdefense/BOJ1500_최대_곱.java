package com.backjoon.randomdefense;

import java.io.*;
import java.math.*;
import java.util.*;

public class BOJ1500_최대_곱 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int div = S / K;
        int mod = S % K;

        long max = 1;
        for (int i = 0; i < K; i++) {
            if (mod > 0) {
                max *= (div + 1);
                mod--;
            } else {
                max *= div;
            }
        }

        System.out.println(max);


    }
}
