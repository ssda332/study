package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ3758_KCPC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int test = 0; test < T; test++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()); // 팀의 개수
            int k = Integer.parseInt(st.nextToken()); // 문제의 개수
            int t = Integer.parseInt(st.nextToken()); // 당신 팀의 id
            int m = Integer.parseInt(st.nextToken()); // 로그 엔트리의 개수

            int[][] A = new int[n + 1][2];
            int[] lastSubmit = new int[101];
            int[][][] teamScore = new int[101][101][2];

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());

                int id = Integer.parseInt(st.nextToken()); // i 팀 id
                int num = Integer.parseInt(st.nextToken()); // j 문제 번호
                int score = Integer.parseInt(st.nextToken()); // s 획득한 점수

                if (score > teamScore[id][num][0]) {
                    teamScore[id][num][0] = score;
                    teamScore[id][num][0]++;
                }

                lastSubmit[id] = i + 1;
            }

            Team[] result = new Team[n];

            // 총합 계산
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= k; j++) {
                    A[i][0] += teamScore[i][j][0];
                    A[i][1] += teamScore[i][j][1];
                }

                result[i] = new Team(i, A[i][0], A[i][1], lastSubmit[i]);
            }

            Arrays.sort(result, new Comparator<Team>() {

                @Override
                public int compare(Team o1, Team o2) {
                    // TODO Auto-generated method stub
                    if (o1.totalScore == o2.totalScore) {
                        if (o1.submitNum == o2.submitNum) {

                            return o1.lastSubmit - o2.lastSubmit;
                        }
                        return o1.submitNum - o2.submitNum;
                    }
                    return o2.totalScore - o1.totalScore;
                }
            });

            for (int i = 0; i < n; i++) {
                if (result[i].id == t) {
                    // 내 팀 찾음
                    sb.append(i + 1).append("\n");
                }
            }

        }

        System.out.println(sb);


    }

    static class Team {
        public int id;
        public int totalScore;
        public int submitNum;
        public int lastSubmit;

        public Team(int id, int totalScore, int submitNum, int lastSubmit) {
            this.id = id;
            this.totalScore = totalScore;
            this.submitNum = submitNum;
            this.lastSubmit = lastSubmit;
        }
    }
}
