package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2659_십자카드_문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A = br.readLine().split(" ");
        String S = A[0] + A[1] + A[2] + A[3];

        int isCn = Integer.parseInt(S);
        for (int i = 0; i < 4; i++) {
            S = S.substring(1, 4) + S.substring(0, 1);
            int ano = Integer.parseInt(S);
            if (isCn > ano) {
                isCn = ano;
            }
        }

        int cnt = 0;

        for (int i = 1111; i <= isCn; i++) {
            String check = i + "";

            if(!clockNumber(check)) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    static boolean clockNumber(String N) {
        for (int i = 0; i < 4; i++) {
            if (N.substring(i, i + 1).equals(0)) {
                return false;
            }
        }

        int isCn = Integer.parseInt(N);
        for (int i = 0; i < 4; i++) {
            N = N.substring(1, 4) + N.substring(0, 1);
            int ano = Integer.parseInt(N);
            if (isCn > ano) {
                return true;
            }
        }

        return false;
    }
}
