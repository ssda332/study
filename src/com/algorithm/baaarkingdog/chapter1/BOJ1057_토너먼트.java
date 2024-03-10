package com.algorithm.baaarkingdog.chapter1;

import java.io.*;
import java.util.*;

public class BOJ1057_토너먼트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int kim = Integer.parseInt(st.nextToken());
        int lim = Integer.parseInt(st.nextToken());
        int count = 1;

        // 5 5 4
        // 3 3 2
        // 2 2 1

        while (true) {
            if (kim < lim && kim % 2 == 1 && lim % 2 == 0 && lim - kim == 1) break;
            if (kim > lim && kim % 2 == 0 && lim % 2 == 1 && kim - lim == 1) break;
            if (N < 1) {
                System.out.println(-1);
                return;
            }

            if (kim % 2 == 1) kim = kim / 2 + 1;
            else kim = kim / 2;
            if (lim % 2 == 1) lim = lim / 2 + 1;
            else lim = lim / 2;
            if (N % 2 == 1) N = N / 2 + 1;
            else N = N / 2;

            count++;

        }

        System.out.println(count);
    }
}
