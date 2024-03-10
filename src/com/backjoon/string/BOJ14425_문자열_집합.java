package com.backjoon.string;

import java.io.*;
import java.util.*;

public class BOJ14425_문자열_집합 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(str, 1);
        }

        int answer = 0;

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (map.containsKey(str)) answer++;
        }

        System.out.println(answer);
    }
}
