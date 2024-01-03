package com.backjoon.simulation;

import java.io.*;
import java.util.*;

public class BOJ12100_2048 {

    static int N;
    static int[][] map;
    static int max = Integer.MIN_VALUE;
    static boolean[][] combined;

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

        if (N == 1) {
            System.out.println(map[0][0]);
            return;
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
        combined = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (target[j][i] == 0) continue; // 대상 칸이 빈칸이면 다음 칸 확인
                int next = j - 1;
                int cur = j;

                while (next >= 0) {
                    if (target[next][i] == 0) {
                        target[next][i] = target[cur][i];
                        target[cur][i] = 0;
                        /*cur = next;
                        next = cur - 1;*/
                        cur--; next--;
                    } else {
                        if (combined[next][i]) break;
                        if (target[next][i] == target[cur][i]) {
                            target[next][i] *= 2; // 결합
                            combined[next][i] = true;
                            target[cur][i] = 0;
                        }
                        break; // 같지 않을 경우 다음 열로 넘어감
                    }
                }

            }
        }

    }

    static void moveBlock_left(int[][] target) {
        combined = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if (target[i][j] == 0) continue; // 대상 칸이 빈칸이면 다음 칸 확인
                int next = j - 1;
                int cur = j;

                while (next >= 0) {
                    if (target[i][next] == 0) {
                        target[i][next] = target[i][cur];
                        target[i][cur] = 0;
                        cur--; next--;
                    } else {
                        if (combined[i][next]) break;
                        if (target[i][next] == target[i][cur]) {
                            target[i][next] *= 2; // 결합
                            combined[i][next] = true;
                            target[i][cur] = 0;
                        }
                        break; // 같지 않을 경우 다음 열로 넘어감
                    }
                }
            }
        }
    }

    static void moveBlock_down(int[][] target) {
        combined = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0; j--) {
                if (target[j][i] == 0) continue; // 대상 칸이 빈칸이면 다음 칸 확인
                int next = j + 1;
                int cur = j;

                while (next < N) {
                    if (target[next][i] == 0) {
                        target[next][i] = target[cur][i];
                        target[cur][i] = 0;
                        cur++; next++;
                    } else {
                        if (combined[next][i]) break;
                        if (target[next][i] == target[cur][i]) {
                            target[next][i] *= 2; // 결합
                            combined[next][i] = true;
                            target[cur][i] = 0;
                        }
                        break; // 같지 않을 경우 다음 열로 넘어감
                    }
                }
            }
        }
    }

    static void moveBlock_right(int[][] target) {
        combined = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = N - 2; j >= 0; j--) {
                if (target[i][j] == 0) continue; // 대상 칸이 빈칸이면 다음 칸 확인
                int next = j + 1;
                int cur = j;

                while (next < N) {
                    if (target[i][next] == 0) {
                        target[i][next] = target[i][cur];
                        target[i][cur] = 0;
                        cur++; next++;
                    } else {
                        if (combined[i][next]) break;
                        if (target[i][next] == target[i][cur]) {
                            target[i][next] *= 2; // 결합
                            combined[i][next] = true;
                            target[i][cur] = 0;
                        }
                        break; // 같지 않을 경우 다음 열로 넘어감
                    }
                }
            }
        }
    }
}
