package com.algorithm.baaarkingdog.chapter1;

import java.io.*;
import java.util.*;

public class BOJ10810_공_넣기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int Z = Integer.parseInt(st.nextToken());

            for (int j = X; j <= Y; j++) {
                A[j - 1] = Z;
            }
        }

        Arrays.stream(A)
                .forEach(n -> {
                    System.out.print(n + " ");
                });
    }
}
