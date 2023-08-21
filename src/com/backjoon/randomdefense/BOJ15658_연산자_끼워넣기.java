package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15658_연산자_끼워넣기 {

    static int[] A;
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        int div = Integer.parseInt(st.nextToken());

        dfs(1, A[1], plus, minus, mul, div);
        System.out.println(max);
        System.out.println(min);
    }

    static void dfs(int depth, int sum, int plus, int minus, int mul, int div) {
        if (depth == N) {
            if (sum > max) max = sum;
            if (sum < min) min = sum;
            return;
        }

        if (plus != 0) {
            dfs(depth + 1, sum + A[depth + 1], plus - 1, minus, mul, div);
        }
        if (minus != 0) {
            dfs(depth + 1, sum - A[depth + 1], plus, minus - 1, mul, div);
        }
        if (mul != 0) {
            dfs(depth + 1, sum * A[depth + 1], plus, minus, mul - 1, div);
        }
        if (div != 0) {
            dfs(depth + 1, sum / A[depth + 1], plus, minus, mul, div - 1);
        }

    }
}
