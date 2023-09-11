package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ1620_나는야_포켓몬_마스터_이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<Integer, String> mapToNum = new HashMap<>();
        HashMap<String, Integer> mapToName = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            mapToNum.put(i, str);
            mapToName.put(str, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            char c = str.charAt(0);
            if (str.charAt(0) < 58) {
                String answer = mapToNum.get(Integer.parseInt(str));
                sb.append(answer).append("\n");
            } else {
                int answer = mapToName.get(str);
                sb.append(answer).append("\n");
            }
        }

        System.out.println(sb);

    }
}
