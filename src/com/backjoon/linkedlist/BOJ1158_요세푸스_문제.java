package com.backjoon.linkedlist;

import java.io.*;
import java.util.*;

public class BOJ1158_요세푸스_문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!list.isEmpty()) {
            for (int i = 0; i < K; i++) {
                if (i == K - 1) {
                    if (list.size() > 1) {
                        sb.append(list.remove()).append(", ");
                    } else {
                        sb.append(list.remove()).append(">");
                    }
                } else {
                    list.add(list.remove());
                }
            }
        }

        System.out.println(sb);
    }
}
