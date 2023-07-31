package com.backjoon.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ2667_단지번호붙이기 {

    static ArrayList<Integer[]>[][] A;
    static boolean[][] visited;
    static int houses = 0;
    static ArrayList<Integer> house = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        A = new ArrayList[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                A[i][j] = new ArrayList<>();
                int address = line.charAt(j) - '0';

                if (i != 0 && address == 1) {
                    Integer[] arr = {i - 1, j};
                    A[i][j].add(arr);
                }
                if (j != 0 && address == 1) {
                    Integer[] arr = {i, j - 1};
                    A[i][j].add(arr);
                }
                if (i != N - 1 && address == 1) {
                    Integer[] arr = {i + 1, j};
                    A[i][j].add(arr);
                }
                if (j != N - 1 && address == 1) {
                    Integer[] arr = {i, j + 1};
                    A[i][j].add(arr);
                }

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && A[i][j].size() > 0) {
                    houses++;
                    BFS(i, j);
                }
            }
        }

        System.out.println(houses);
        Collections.sort(house);
        for (int i : house) {
            System.out.println(i);
        }

    }

    static void BFS(int i, int j) {
        Integer[] node = {i, j};
        Queue<Integer[]> queue = new LinkedList<>();
        int cnt = 0;

        visited[i][j] = true;
        cnt++;
        queue.add(node);

        while (!queue.isEmpty()) {
            Integer[] new_Node = queue.poll();
            for (Integer[] arr : A[new_Node[0]][new_Node[1]]) {
                int x = arr[0];
                int y = arr[1];

                if (!visited[x][y] && A[x][y].size() > 0) {
                    visited[x][y] = true;
                    cnt++;
                    queue.add(arr);
                }
            }
        }

        house.add(cnt);
    }
}
