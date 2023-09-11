package com.backjoon.randomdefense;

import java.util.*;
import java.io.*;

public class BOJ1449_수리공_항승 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int cnt = 0;
        boolean[] pipe = new boolean[1001];

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int position = Integer.parseInt(st.nextToken());
            pipe[position] = true;
        }

        for (int i = 1; i < pipe.length; i++) {
            if (pipe[i]) {
                for (int j = 0; j < L; j++) {
                    if (i + j < pipe.length) {
                        pipe[i + j] = false;
                    }
                }
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
