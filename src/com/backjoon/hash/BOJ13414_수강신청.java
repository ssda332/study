package com.backjoon.hash;

import java.io.*;
import java.util.*;

public class BOJ13414_수강신청 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> list = new HashMap<>();

        for (int i = 0; i < L; i++) {
            String student = br.readLine();
            list.put(student, i);
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(list.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {

                return o1.getValue() - o2.getValue();
            }
        });

        int size = K;
        if (K > entries.size()) {
            size = entries.size();
        }

        for (int i = 0; i < size; i++) {
            sb.append(entries.get(i).getKey()).append("\n");
        }



        System.out.println(sb);


    }
}
