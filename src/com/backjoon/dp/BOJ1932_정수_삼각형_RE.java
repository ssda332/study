package com.backjoon.dp;

import java.util.*;
import java.io.*;

public class BOJ1932_정수_삼각형_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(br.readLine());
        int answer = 0;


        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (n == target) answer++;
        }

        System.out.println(answer);

    }
}
