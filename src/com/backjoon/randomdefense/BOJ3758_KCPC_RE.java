package com.backjoon.randomdefense;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ3758_KCPC_RE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[n];
            for (int i = 0; i < n; i++) {
                teams[i] = new Team(i + 1, new int[k + 1], 0, 0);
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                int score = Integer.parseInt(st.nextToken());

                teams[id - 1].setTotalScore(score, num, i + 1);
            }

            Arrays.sort(teams, new Comparator<Team>() {
                @Override
                public int compare(Team o1, Team o2) {
                    if (o1.getTotalScore() == o2.getTotalScore()) {
                        if (o1.submitCnt == o2.submitCnt) {
                            return o1.lastSubmit - o2.lastSubmit;
                        }

                        return o1.submitCnt - o2.submitCnt;
                    }
                    return o2.getTotalScore() - o1.getTotalScore();
                }
            });

/*            Arrays.stream(teams)
                    .forEach(System.out::println);*/

            for (int i = 0; i < teams.length; i++) {
                if (teams[i].id == t) {
                    sb.append(i + 1).append("\n");
                }
            }
        }

        System.out.println(sb);
    }

    static class Team {
        public int id;
        public int[] totalScore;
        public int submitCnt;
        public int lastSubmit;

        public Team(int id, int[] totalScore, int submitCnt, int lastSubmit) {
            this.id = id;
            this.totalScore = totalScore;
            this.submitCnt = submitCnt;
            this.lastSubmit = lastSubmit;
        }

        public int getTotalScore() {
            return Arrays.stream(this.totalScore)
                    .sum();
        }

        public void setTotalScore(int score, int num, int time) {
            if (totalScore[num] < score) {
                totalScore[num] = score;
                submitCnt++;
                lastSubmit = time;
            } else {
                submitCnt++;
                lastSubmit = time;
            }
        }
/*
        @Override
        public String toString() {
            return "Team{" +
                    "totalScore=" + Arrays.toString(totalScore) +
                    ", submitCnt=" + submitCnt +
                    ", lastSubmit=" + lastSubmit +
                    '}';
        }*/
    }
}

