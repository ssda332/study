package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ1890_점프 {

    static int N;
    static int[][] A;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        // 1042
        // 해당 문제는 bfs로 풀면 메모리 초과가 발생할수 밖에 없음
        // DP로 접근
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(st.nextToken());
                A[i][j] = num;
            }
        }

        bfs();

        System.out.println(cnt);

    }

    static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int x = poll[1];
            int y = poll[0];

            System.out.println("x : " + x + ", y : " + y);
            if (A[y][x] == 0) {
                cnt++;
            } else {
                if (x + A[y][x] < N) {
                    queue.add(new int[] {y, x + A[y][x]});
                }

                if (y + A[y][x] < N) {
                    queue.add(new int[] {y + A[y][x], x});
                }
            }
        }
    }
}
