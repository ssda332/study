package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ15558_점프_게임 {
    static int N;
    static int k;
    static int[][] A;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        // visited 체크를 안해줘서 메모리 초과가 발생했음
        // 불필요한 움직임 : 기존 로직은 한번 앞으로 갔다가 다시 제자리로 오는 경우의 수가 있었음
        // 그렇게 될 시, while문을 true로 빠져나갈때까지 무한으로 로직이 반복되고 N의 수가 많아질수록
        // 새로운 Status 객체를 할당하게 되고 결국 메모리 초과가 발생하게 된다.

        //

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        String line1 = br.readLine();
        String line2 = br.readLine();
        // 0 위험한칸 1 안전한칸

        A = new int[N][2];
        visited = new boolean[N][2];
//        depth = new int[N][2];

        for (int i = 0; i < N; i++) {
            A[i][0] = Integer.parseInt(line1.substring(i, i + 1));
            A[i][1] = Integer.parseInt(line2.substring(i, i + 1));
            if (line1.substring(i, i + 1).equals("0")) {
                visited[i][0] = true;
            }
            if (line2.substring(i, i + 1).equals("0")) {
                visited[i][1] = true;
            }
        }

        int answer = isClear(new Status(0, 0, 0));

        System.out.println(answer);
    }

    static int isClear(Status status) {
        visited[0][0] = true;
        Queue<Status> queue = new LinkedList<>();
        queue.add(status);

        while (!queue.isEmpty()) {
            Status poll = queue.poll();

            int back = poll.index - 1;
            int front = poll.index + 1;
            int jump = poll.index + k;

            int next;

            if (poll.line == 0) {
                next = 1;
            } else {
                next = 0;
            }

            if (back > poll.time && A[back][poll.line] == 1 && !visited[back][poll.line]) {
                visited[back][poll.line] = true;
                queue.add(new Status(back, poll.line, poll.time + 1));
            }

            if (front >= N) {
                return 1;
            } else if (A[front][poll.line] == 1 && !visited[front][poll.line]) {
                visited[front][poll.line] = true;
                queue.add(new Status(front, poll.line, poll.time + 1));
            }

            if (jump >= N) {
                return 1;
            } else if (A[jump][next] == 1 && !visited[jump][next]) {
                visited[jump][next] = true;
                queue.add(new Status(jump, next, poll.time + 1));
            }

        }

        return 0;
    }

    static class Status {
        public int index;
        public int line;
        public int time;

        public Status(int index, int line, int time) {
            this.index = index;
            this.line = line;
            this.time = time;
        }
    }
}
