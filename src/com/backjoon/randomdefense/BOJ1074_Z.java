package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1074_Z {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int result = z(N, r, c);
        System.out.println(result);
    }

    static int z(int size, int r, int c) {
        int pow = (int) Math.pow(2, size);
        int half = pow / 2;

        if (size == 0) return 0;

        if (r < half && c < half) {
            return z(size - 1, r, c);
        }else if (r >= half && c < half) {
            return 2 * half * half + z(size - 1, r - half, c);
        }else if (r < half && c >= half) {
            return half * half + z(size - 1, r, c - half);
        }else {
            return 3 * half * half + z(size - 1, r - half, c - half);
        }

    }
}
