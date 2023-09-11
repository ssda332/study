package com.backjoon.math;

import java.io.*;
import java.util.*;

public class BOJ17466_NMODP_1 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        long pactorial = 1;

        for (int i = 2; i <= N; i++) {
            pactorial = (pactorial * (i % P)) % P;
        }

        System.out.println(pactorial);
    }
}
