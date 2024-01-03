package com.backjoon.hash;

import java.io.*;
import java.util.*;

public class BOJ17219_비밀번호_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String url = st.nextToken();
            String password = st.nextToken();

            map.put(url, password);
        }

        for (int i = 0; i < M; i++) {
            String url = br.readLine();
            String password = map.get(url);
            sb.append(password).append("\n");
        }

        System.out.println(sb);
    }
}
