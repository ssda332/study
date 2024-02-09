package com.backjoon.randomdefense;

import java.util.*;

public class BOJ23971_ZOAC_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int x = H / (N + 1) + ((H % (N + 1) != 0) ? 1 : 0);
        int y = W / (M + 1) + ((W % (M + 1) != 0) ? 1 : 0);

        System.out.println(x * y);

    }
}
