package com.backjoon.hash;

import java.io.*;
import java.util.*;

public class BOJ9375_패션왕_신해빈 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();

                if (map.containsKey(type)) {
                    int val = map.get(type);
                    map.put(type, val + 1);
                } else {
                    map.put(type, 1);
                }

            }

            int result = 1;

            for (int val : map.values()) {
                result *= (val + 1);
            }

            sb.append(result - 1).append("\n");
        }

        System.out.println(sb);
    }
}
