package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ7662_이중_우선순위_큐 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
//            PriorityQueue<Integer> queue = new PriorityQueue<>();
                TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int j = 0; j < N; j++) {
                String command = br.readLine();
//                System.out.println(command);
                st = new StringTokenizer(command);
                String str = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (str.equals("I")) {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                } else {
                    if (map.isEmpty()) continue;

                    /*if (n == 1) {
                        int maxKey = map.lastKey();
                        int maxValue = map.get(maxKey);
                        if (maxValue > 0) {
                            map.put(maxKey, maxValue - 1);
                        } else {
                            map.remove(maxKey);
                        }
                    } else {
                        int minKey = map.firstKey();
                        int minValue = map.get(minKey);
                        if (minValue > 1) {
                            map.put(minKey, minValue - 1);
                        } else {
                            map.remove(minKey);
                        }
                    }*/
                    int key = n == 1 ? map.lastKey() : map.firstKey();
                    int cnt = map.get(key);

                    if (cnt == 1) {
                        map.remove(key);
                    } else {
                        map.put(key, cnt - 1);
                    }

                }

            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }

        }

        System.out.println(sb);
    }
}
