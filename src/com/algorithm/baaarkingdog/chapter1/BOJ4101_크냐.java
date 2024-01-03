package com.algorithm.baaarkingdog.chapter1;

import java.io.*;
import java.util.*;

public class BOJ4101_크냐 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;
            if (N > M) sb.append("Yes\n");
            else sb.append("No\n");
        }

        System.out.println(sb);

        int n = 1000000;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.println("ok");
            }
        }
    }
}
