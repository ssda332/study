package com.backjoon.greedy;

import java.io.*;
import java.util.*;

public class BOJ1802_종이_접기 {

    static int[] paper;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            String line = br.readLine();
            paper = new int[line.length()];
            for (int i = 0; i < line.length(); i++) {
                paper[i] = line.charAt(i) - '0';
            }

            if (paper.length == 1 || dac(0, paper.length - 1)) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");

        }

        System.out.println(sb);
    }

    static boolean dac(int start, int end) {
        int mid = (start + end) / 2;
        if (!check(start, end, mid)) return false;

        if (mid - start <= 1) return true;
        return (dac(start, mid - 1) && dac(mid + 1, end));
    }

    static boolean check(int start, int end, int mid) {
        for (int i = 0; i < mid - start; i++) {
            if (paper[start + i] + paper[end - i] != 1) return false;
        }

        return true;
    }
}
