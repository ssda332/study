package com.backjoon.simulation;

import java.io.*;
import java.util.*;

public class BOJ14888_연산자_끼워넣기 {

    static int N;
    static int[] A;
    static int[] O;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        O = new int[4];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            O[i] = Integer.parseInt(st.nextToken());
        }

        dfs(new int[4], 0, A[0]);
        System.out.println(max);
        System.out.println(min);

    }

    static void dfs(int[] o, int depth, int val) {
        if (depth == N - 1) {
            if (val > max) max = val;
            if (val < min) min = val;
            return;
        }

        for (int i = 0; i < 4; i++) {
            boolean flag = false;

            if (o[i] < O[i]) {
                flag = true;
                o[i]++;
                int nextVal = cal(val, depth, i);
                dfs(o, depth + 1, nextVal);
            }

            if (flag) o[i]--;
        }
    }

    static int cal(int val, int depth, int i) {
        if (i == 0) {
            val += A[depth + 1];
        } else if (i == 1) {
            val -= A[depth + 1];
        } else if (i == 2) {
            val *= A[depth + 1];
        } else {
            val /= A[depth + 1];
        }

        return val;
    }
}
