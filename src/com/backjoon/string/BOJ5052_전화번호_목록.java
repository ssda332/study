package com.backjoon.string;

import java.io.*;
import java.util.*;

public class BOJ5052_전화번호_목록 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            String[] list = new String[N];

            for (int i = 0; i < N; i++) {
                list[i] = br.readLine();
            }

            boolean flag = false;

            for (int i = 0; i < N; i++) {

                for (int j = 0; j < N; j++) {
                    if (i == j) continue;

                    if (list[i].contains(list[j])) {
                        flag = true;
                        break;
                    }
                }

                if (flag) break;
            }

            if (flag) {
                sb.append("NO").append("\n");
            } else {
                sb.append("YES").append("\n");
            }
        }

        System.out.println(sb);
    }
}
