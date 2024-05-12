package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ1477_휴게소_세우기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        boolean[] H = new boolean[L + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int restArea = Integer.parseInt(st.nextToken());
            H[restArea] = true;
        }

        /**
         *  1. L번 반복해서 N-1개 구간과 최대값 획득 1000
         *  2.
         *  3.
         *
         */
    }
}
