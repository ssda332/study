package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2960_에라토스테네스의_체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int result = 0;
        boolean[] visited = new boolean[N + 1];

        for (int i = 2; i <= N; i++) {
            if (visited[i]) continue;

            for (int j = i; j <= N; j += i) {
                if (visited[j]) continue;
                visited[j] = true;
                result++;
                if (result == K) {
                    System.out.println(j);
                    return;
                }
            }


        }
    }
}
