package com.backjoon.array;

import java.io.*;
import java.util.*;

public class BOJ1337_올바른_배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cnt = new int[N];
        ArrayList<Integer> A = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(A);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                if (!A.contains(A.get(i) + j)) cnt[i]++;
            }
        }

        System.out.println(Arrays.stream(cnt).min().getAsInt());
    }
}
