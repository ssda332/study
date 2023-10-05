package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ1764_듣보잡 {

    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            set.add(name);
        }

        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (set.contains(name)) {
                answer.add(name);
            }
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        answer.forEach(System.out::println);
    }


}
