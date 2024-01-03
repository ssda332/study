package com.backjoon.simulation;

import java.io.*;
import java.util.*;

public class BOJ12100_2048_test {

    static int N;
    static int[][] map;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // dfs 4방향

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(map,0);

        System.out.println(max);
    }

    static void dfs(int[][] next, int depth) {
        if (depth == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (next[i][j] > max) max = next[i][j];
                }
            }

            return;
        }

        // 4방향 dfs 0위 1아래 2왼쪽 3오른쪽
        for (int i = 0; i < 4; i++) {
            int[][] result = makeArr(makeNewArr(next), i);
            dfs(result, depth + 1);
        }
    }

    static int[][] makeNewArr(int[][] next) {
        int[][] nextArr = new int[N][N];
        for (int j = 0; j < N; j++) {
            nextArr[j] = next[j].clone();
        }

        return nextArr;
    }

    static int[][] makeArr(int[][] target, int type) {
        if (type == 0) {
            moveBlock_up(target);
        } else if (type == 1) {
            moveBlock_down(target);
        } else if (type == 2) {
            moveBlock_left(target);
        } else if (type == 3) {
            moveBlock_right(target);
        }

        return target;
    }

    static void moveBlock_up(int[][] target) {
        boolean[][] combined = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                int pre = j - 1;
                int cur = j;

                if (target[j][i] != 0) {
                    // 끝까지 방향 이동
                    // 끝까지 방향 이동했거나, 앞에 자리가 비어있지 않으면 break
                    while (pre >= 0 && target[pre][i] == 0) {
                        target[pre][i] += target[cur][i];
                        target[cur][i] = 0;
                        pre--;
                        cur--;
                    }

                    // 결합할수 있으면 결합
                    if (pre >= 0 && target[pre][i] == target[cur][i] && !combined[pre][i]) {
                        target[pre][i] += target[cur][i];
                        target[cur][i] = 0;
                        combined[pre][i]= true;
                    }
                }
            }
        }
    }

    static void moveBlock_down(int[][] target) {
        boolean[][] combined = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0; j--) {
                int pre = j + 1;
                int cur = j;

                if (target[j][i] != 0) {
                    // 끝까지 방향 이동
                    while (pre < N && target[pre][i] == 0) {
                        target[pre][i] += target[cur][i];
                        target[cur][i] = 0;
                        pre++;
                        cur++;
                    }

                    // 결합할수 있으면 결합
                    if (pre < N && target[pre][i] == target[cur][i] && !combined[pre][i]) {
                        target[pre][i] += target[cur][i];
                        target[cur][i] = 0;
                        combined[pre][i]= true;
                    }
                }
            }
        }
    }

    static void moveBlock_left(int[][] target) {
        boolean[][] combined = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                int pre = j - 1;
                int cur = j;

                if (target[i][j] != 0) {
                    // 끝까지 방향 이동
                    while (pre >= 0 && target[i][pre] == 0) {
                        target[i][pre] += target[i][cur];
                        target[i][cur] = 0;
                        pre--;
                        cur--;
                    }

                    // 결합할수 있으면 결합
                    if (pre >= 0 && target[i][pre] == target[i][cur] && !combined[i][cur]) {
                        target[i][pre] += target[i][cur];
                        target[i][cur] = 0;
                        combined[i][pre]= true;
                    }
                }
            }
        }
    }

    static void moveBlock_right(int[][] target) {
        boolean[][] combined = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0; j--) {
                int pre = j + 1;
                int cur = j;

                if (target[i][j] != 0) {
                    // 끝까지 방향 이동
                    while (pre < N && target[i][pre] == 0) {
                        target[i][pre] += target[i][cur];
                        target[i][cur] = 0;
                        pre++;
                        cur++;
                    }

                    // 결합할수 있으면 결합
                    if (pre < N && target[i][pre] == target[i][cur] && !combined[i][pre]) {
                        target[i][pre] += target[i][cur];
                        target[i][cur] = 0;
                        combined[i][pre]= true;
                    }
                }
            }
        }
    }
}

