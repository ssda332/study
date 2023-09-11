package com.algorithm.baaarkingdog.chapter1;

import java.util.*;

public class TEST2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        boolean[] visited = new boolean[N + 1];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {N, 0});
        visited[N] = true;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            if (poll[0] == 1) {
                System.out.println(poll[1]);
                break;
            }

            if (poll[0] % 3 == 0 && !visited[poll[0] / 3]) {
                queue.add(new int[] {poll[0] / 3, poll[1] + 1});
                visited[poll[0] / 3] = true;
            }

            if (poll[0] % 2 == 0 && !visited[poll[0] / 2]) {
                queue.add(new int[] {poll[0] / 2, poll[1] + 1});
                visited[poll[0] / 2] = true;
            }

            if (!visited[poll[0] - 1]) {
                queue.add(new int[] {poll[0] - 1, poll[1] + 1});
                visited[poll[0] - 1] = true;
            }
        }
    }
}
