package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ14225_부분수열의_합 {

    static int N;
    static int[] A;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        // 12/31
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        visited = new int[2000001];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        /*for (int i = 1; i <= N; i++) {
            int sum = 0;
            for (int j = i; j <= N; j++) {
                sum += A[j];
                visited[sum]++;
            }

            if (i == 1) {
                max = sum;
            }
        }*/
        for (int i = 1; i <= N; i++) {
            recursive(i, A[i]);
        }

        for (int i = 1; i <= visited.length; i++) {
            if (visited[i] == 0) {
                System.out.println(i);
                break;
            }
        }

    }

    static void recursive(int n, int sum) {
        visited[sum]++;
        for (int i = n + 1; i <= N; i++) {
            int plus = sum + A[i];
            recursive(i, plus);
        }
    }

}
