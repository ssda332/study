package com.backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class BOJ2110_공유기_설치 {

    static int N;
    static int C;
    static int[] house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int answer = upper_bound();
        System.out.println(answer);
    }

    static int upper_bound() {
        int lo = -1;
        int hi = 1000000001;

        while (lo + 1 < hi) {
            int mid = (lo + hi) / 2; // 가장 인접한 두 공유기의 최대거리

            if (check(mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }

        return hi - 1;
    }

    static boolean check(int target) {
        int count = 1;
        int pre = 0;
        for (int i = 1; i < N; i++) {
            int length = house[i] - house[pre];

            if (length >= target) {
                pre = i;
                count++;
            }
        }

        if (count < C) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 *  인접거리의 최대공유기수 규칙을 알아내는게 힘들었음 : 최적화 -> 결정 문제로 바꾸는 과정에서 그리디하게 규칙을 만드는 생각이 필요함
 *  무조건 첫번째 집에 공유기를 설치한다고 가정하는 이유 -> 직전에 설치했던 집을 기준으로 잡고 거리를 구하기 때문에
 *  첫번째 집부터 설치하고 쭉 순회를 돌아 최적화시킬수 있음.
 *  ex) 거리가 3 1 1 1 1 1 1... 일때 최소가 4가 되야할경우
 *      첫번째에 설치하고 그다음것은 3+1 인 세번째에 설치되어야함 (그리디)
 *
 */