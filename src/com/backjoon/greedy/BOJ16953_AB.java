package com.backjoon.greedy;

import java.io.*;
import java.util.*;

public class BOJ16953_AB {

    static int B;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        recursive(A, 1);

        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(answer);
    }

    static void recursive(long num, int depth) {
        if (num > B) return;
        else if (num == B && depth < answer) {
            answer = depth;
            return;
        }

        recursive(num * 2, depth + 1);
        recursive(num * 10 + 1, depth + 1);
    }
}
