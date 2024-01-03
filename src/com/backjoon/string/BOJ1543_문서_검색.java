package com.backjoon.string;

import java.io.*;

public class BOJ1543_문서_검색 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        String search = br.readLine();
        int size = search.length();
        boolean[] visited = new boolean[target.length()];
        int start;
        int end;
        int answer = 0;

        for (int i = 0; i < target.length() - size + 1; i++) {
            start = i;
            end = start + size - 1;
            boolean flag = true;

            for (int j = 0; j < size; j++) {
                if (visited[start + j] || target.charAt(start + j) != search.charAt(j)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                for (int j = start; j <= end; j++) {
                    visited[j] = true;
                }

                answer++;
            }

        }

        System.out.println(answer);
    }
}
