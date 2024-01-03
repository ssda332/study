package com.backjoon.hash;

import java.io.*;
import java.util.*;

public class BOJ16165_걸그룹_마스터_준석이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, String> map = new TreeMap<>(Comparator.naturalOrder());

        for (int i = 0; i < N; i++) {
            String teamName = br.readLine();
            int n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                String name = br.readLine();
                map.put(name, teamName);
            }
        }

        for (int i = 0; i < M; i++) {
            String quiz = br.readLine();
            int type = Integer.parseInt(br.readLine());

            if (type == 0) {
                map.forEach((key, val) -> {
                    if (val.equals(quiz)) {
                        sb.append(key).append("\n");
                    }
                });
            } else {
                map.forEach((key, val) -> {
                    if (key.equals(quiz)) {
                        sb.append(val).append("\n");
                    }
                });
            }
        }

        System.out.println(sb);

    }
}
