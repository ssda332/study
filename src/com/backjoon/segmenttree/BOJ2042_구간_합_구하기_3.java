package com.backjoon.segmenttree;

import java.io.*;
import java.util.*;

public class BOJ2042_구간_합_구하기_3 {

    static long[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int treeHeight = 0;
        int length = N;

        while (length != 0) {
            length /= 2;
            treeHeight++;
        }
        int treeSize = (int) Math.pow(2, treeHeight + 1);
        int startIdx = treeSize / 2 - 1;

        A = new long[treeSize + 1];

        for (int i = startIdx + 1; i <= N + startIdx; i++) {
            A[i] = Long.parseLong(br.readLine());
        }

        setTree(treeSize - 1);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1L) {
                changeVal(startIdx + b, c);
            } else if (a == 2L){
                long sum = getSum(b + startIdx, (int) c + startIdx);
                System.out.println(sum);
            } else {
                return;
            }
        }

    }

    static long getSum(int s, int e) {
        long answer = 0;

        while (s <= e) {
            if (s % 2 == 1) {
                answer += A[s];
                s++;
            }
            if (e % 2 == 0) {
                answer += A[e];
                e--;
            }

            s /= 2;
            e /= 2;
        }

        return answer;
    }

    static void changeVal(int b, long val) {
        long diff = val - A[b];
        while (b > 0) {
            A[b] = A[b] + diff;
            b /= 2;
        }
    }

    static void setTree(int i) {
        while (i != 1) {
            A[i / 2] += A[i];
            i--;
        }
    }
}
