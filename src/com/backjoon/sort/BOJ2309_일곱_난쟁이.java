package com.backjoon.sort;

import java.util.*;
import java.io.*;

public class BOJ2309_일곱_난쟁이 {

    static int[] list;
    static int[] answer;
    static boolean visited[] = new boolean[9];
    static boolean flag = true;

    public static void main(String[] args) throws IOException{
        // 백트래킹 O(7!)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new int[9];
        answer = new int[7];

        for (int i = 0; i < 9; i++) {
            int height = Integer.parseInt(br.readLine());
            list[i] = height;
        }

        for (int i = 0; i < 9; i++) {
            dfs(i, 0);
        }

        Arrays.stream(answer).sorted().forEach(System.out::println);

    }

    static void dfs(int v, int depth) {
        if (!flag) return;
        visited[v] = true;
        answer[depth] = list[v];

        if (depth == 6) {
            int sum = 0;

            for (int i = 0; i < 7; i++) {
                if (answer[i] != 0) {
                    sum += answer[i];
                }
            }

            if (sum == 100) {
                flag = false;
                return;
            }

            visited[v] = false;
            answer[depth] = 0;

            return;
        }

        for (int i = v + 1; i < 9; i++) {
            if (visited[i]) continue;
            dfs(i, depth + 1);

            if (!flag) return;
        }

        visited[v] = false;
        answer[depth] = 0;
    }
}
