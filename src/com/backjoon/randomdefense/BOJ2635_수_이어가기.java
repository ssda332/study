package com.backjoon.randomdefense;

import java.util.*;

public class BOJ2635_수_이어가기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int answer = 0;
        ArrayList<Integer> answer2 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = N / 2; i <= N; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(N);
            list.add(i);

            while (list.get(list.size() - 2) - list.get(list.size() - 1) >= 0) {
                list.add(list.get(list.size() - 2) - list.get(list.size() - 1));
            }

            if (answer < list.size()) {
                answer = list.size();
                answer2 = list;
            }
        }

        System.out.println(answer);
        answer2.forEach(n -> {
            sb.append(n).append(" ");
        });
        System.out.println(sb);

    }
}
