package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ14003_가장_긴_증가하는_부분_수열_5_wrong {
    static int N;
    static int[] A;
    static int[] LIS;
    static int[] idxArr;
    static StringBuilder answer = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        LIS = new int[1000000];
        idxArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(LIS, Integer.MIN_VALUE);
        Arrays.fill(idxArr, -1);
        LIS[0] = A[0];
        idxArr[0] = 0;
        int lisIdx = 1;
        for (int i = 1; i < N; i++) {
            if (A[i] > LIS[lisIdx - 1]) {
                LIS[lisIdx] = A[i];
                idxArr[i] = lisIdx;
                lisIdx++;
            } else if (A[i] <= LIS[lisIdx - 1]) {
                int idx = binarySearch(lisIdx, i);
                LIS[idx] = A[i];
                idxArr[i] = idx;
            }
        }
        output();
        System.out.println(answer);
    }
    static int binarySearch(int idx, int i) {
        int lo = -1;
        int hi = idx - 1;
        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2;
            if (check(mid, i)) hi = mid;
            else lo = mid;
        }
        return hi;
    }
    static boolean check(int target, int i) {
        if (LIS[target] >= A[i]) return true;
        return false;
    }
    static void output() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (LIS[i] != Integer.MIN_VALUE) {
                count++;
            }
            else break;
        }
        answer.append(count).append("\n");
        int idx = count - 1;
        Stack<Integer> stack = new Stack();
        for (int i = N - 1; i >= 0; i--) {
            if (idxArr[i] == idx) {
                stack.push(A[i]);
                idx--;
            }
        }
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            answer.append(pop).append(" ");
        }
    }
}
