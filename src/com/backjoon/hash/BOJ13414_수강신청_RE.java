package com.backjoon.hash;

import java.io.*;
import java.util.*;

public class BOJ13414_수강신청_RE {

    static int index = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> set = new LinkedHashSet();

        for (int i = 0; i < L; i++) {
            String student = br.readLine();
            if (set.contains(student)) {
                set.remove(student);
            }
            set.add(student);
        }

        set.forEach(s -> {
            if (index > K) return;
            sb.append(s).append("\n");
            index++;
        });

        System.out.println(sb);
    }
}
