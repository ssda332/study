package com.backjoon.dp;

import java.io.*;
import java.util.*;

public class BOJ1915_가장_큰_정사각형 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 1][m + 1];
        int[][] D = new int[n + 1][m + 1];
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= m; j++) {
                int num = s.charAt(j - 1) - '0';
                map[i][j] = num;
                D[i][j] = D[i - 1][j] + D[i][j - 1] - D[i - 1][j - 1] + num;
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == 1) {
                    int result = 1;
                    int idx = 1;
                    while (i + idx <= n && j + idx <= m) {
                        int val = D[i + idx][j + idx] - D[i + idx][j - 1] - D[i - 1][j + idx] + D[i - 1][j - 1];
                        idx++;
                        if (val != idx * idx) break;


                        result = idx * idx;
                    }

                    answer = Math.max(result, answer);
                }
            }
        }

        System.out.println(answer);
    }
}
