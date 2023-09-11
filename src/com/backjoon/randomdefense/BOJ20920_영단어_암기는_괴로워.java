package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class BOJ20920_영단어_암기는_괴로워 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] A = new String[N];
        for (int i = 0; i < N; i++) {
            A[i] = br.readLine();
        }

        TreeMap<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            if (A[i].length() < M) continue;

            if (map.get(A[i]) != null) {
                int num = map.get(A[i]);
                map.put(A[i], num + 1);
            } else {
                map.put(A[i], 1);
            }
        }

        List<String> words = map.keySet().stream()
                .collect(Collectors.toList());

        words.sort((o1, o2) -> {
            int times1 = map.get(o1);
            int times2 = map.get(o2);

            if (times1 == times2) {
                if (o1.length() == o2.length()) {
                    return o1.compareTo(o2);
                }

                return o2.length() - o1.length();
            }

            return times2 - times1;
        });


        words.stream()
                .forEach(s -> {
                    try {
                        bw.append(s).append("\n");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });

        bw.flush();
        bw.close();
    }


}

