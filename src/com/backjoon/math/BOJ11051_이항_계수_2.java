package com.backjoon.math;

import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ11051_이항_계수_2 {

    static int[][] D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        D = new int[11][11];

        System.out.println(bc(N, K));

    }

    static int bc(int n, int k) {
        if (D[n][k] > 0) {
            return D[n][k];
        }

        if (n == k || k == 0) {
            return D[n][k] = 1;
        }

        return D[n][k] = bc(n - 1, k) + bc(n - 1, k -1);
    }
}
