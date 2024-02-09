package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class BOJ20040_사이클_게임 {

    static int[] parents;
    static int[] cntArr;
    static boolean flag = false;
    static boolean flag2 = false;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parents = new int[N];
        cntArr = new int[N];

        IntStream.range(0, N).forEach(i -> parents[i] = i);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (!flag2) union(x, y);

            if (flag) {
                answer = i + 1;
                flag2 = true;
                flag = false;
            }

        }

        System.out.println(answer);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parents[y] = x;
        } else {
            flag = true;
        }

    }

    static int find(int v) {
        if (parents[v] == v) return v;
        return parents[v] = find(parents[v]);
    }
}
