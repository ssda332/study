package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ2133_타일_채우기 {

    static int[] D;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        D = new int[N + 8];

        D[0] = 1; D[2] = 3; D[4] = 11; D[6] = 41; D[8] = 153;
        // D[i] = 3xi 번째에 1x2 와 2x1 타일로 채워넣을수 있는 경우의 수
        // 홀수 = 0
        // D[i] = (D[i - 2] * D[2]) + (D[i - 4] * 2) ... (D[2] * 2) + (D[0] * 2)

        if (N <= 9) {
            System.out.println(D[N]);
            return;
        }

        for (int i = 10; i <= N; i++) {
            D[i] = D[i - 2] * D[2];
            for (int j = i - 4; j >= 0; j-=2) {
                D[i] += D[j] * 2;
            }
        }

        System.out.println(D[N]);


    }

}
