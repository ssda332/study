package com.backjoon.dp;

import java.util.*;

public class PGM_N으로_표현 {

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(2, 2));

    }

}

class Solution {
    public int solution(int N, int number) {
        ArrayList<Set<Integer>> A = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            A.add(new HashSet<>());
        }

        A.get(1).add(N);

        for (int i = 2; i <= 8; i++) {
            Set<Integer> curSet = A.get(i);

            for (int j = 1; j < i; j++) {
                int left = i - j;
                int right = j;

                Set<Integer> leftSet = A.get(left);
                Set<Integer> rightSet = A.get(right);

                for (int n1 : leftSet) {
                    for (int n2 : rightSet) {
                        curSet.add(n1 + n2);
                        curSet.add(n1 - n2);
                        curSet.add(n1 * n2);
                        if (n1 != 0 && n2 != 0) curSet.add(n1 / n2);
                    }
                }
            }

            curSet.add(Integer.parseInt(String.valueOf(N).repeat(i)));
        }

        for (Set<Integer> set : A) {
            if (set.contains(number)) {
                return A.indexOf(set);
            }
        }

        return -1;
    }
}
