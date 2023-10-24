package com.backjoon.bfs;

import java.io.*;
import java.util.*;

public class BOJ13913_숨바꼭질_4 {

    static int N;
    static int K;
    static int[] map = new int[100001];
    static StringBuilder sb = new StringBuilder();
    static int[] answer;
    static boolean flag = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            sb.append(0).append("\n").append(N);
            System.out.println(sb);
            return;
        }

        Arrays.fill(map, -1);
        bfs();

        answer = new int[map[K] + 1];
        dfs(K, map[K]);

        sb.append(map[K]).append("\n");
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }

    static void bfs() {
        Queue<Subin> queue = new LinkedList<>();
        queue.add(new Subin(N, 0));
        map[N] = 0;

        while (!queue.isEmpty()) {
            Subin poll = queue.poll();

            for (int i = 0; i < 3; i++) {
                int move = getDistance(poll.cur, i, true);

                if (move == K) {
                    map[move] = poll.depth + 1;
                    return;
                }

                if (move >= 0 && move <= 100000) {
                    if (map[move] == -1) {
                        queue.add(new Subin(move, poll.depth + 1));
                        map[move] = poll.depth + 1;
                    }
                }
            }

        }

    }

    static void dfs(int v, int depth) {
        answer[depth] = v;

        if (depth == 0) {
            flag = false;
            return;
        }

        for (int i = 0; i < 3; i++) {
            int move = getDistance(answer[depth], i, false);

            if (move >= 0 && move <= 100000) {
                if (map[move] == depth - 1 && flag) {
                    dfs(move, depth - 1);
                }
            }
        }

    }

    static int getDistance(int num, int type, boolean mod) {
        if (type == 0) {
            return num - 1;
        } else if (type == 1) {
            return num + 1;
        } else {
            if (mod) return num * 2;
            else return num / 2;
        }
    }

    static class Subin {
        public int cur;
        public int depth;

        public Subin(int cur, int depth) {
            this.cur = cur;
            this.depth = depth;
        }
    }
}

/*
    나는 문제풀이를 동생을 찾는 최단거리를 BFS로 구한 후,
    depth를 배열에 메모해서 얻은 값들로 백트래킹해 경로를 구하였다.
    다른 사람이 풀은 코드를 보니 depth를 메모하는것보단, 움직이기 전 좌표(부모 좌표)를 따로 메모하고
    DFS로 따라 들어가는 방식으로 풀었는데, 해당 방식이 더 쉽게 구현할수 있는 방법 같다.
    구현 자체가 어려운것은 아니고 해당 문제를 풀 때에도 DFS방식에 문제가 있어 디버깅에 많은 시간을 소요하지도 않아서,
    두 방식 중 아무거나 선택해도 차이는 그렇게 크지 않을것 같지만 그래도 구현하기가 그나마 더 쉬운
    부모 좌표를 메모하는것으로 생각하는것을 처음 문제풀때부터 길들여놓는것이 좋아보인다.
 */