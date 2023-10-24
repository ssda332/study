package com.backjoon.randomdefense;

import java.io.*;
import java.util.*;

public class BOJ5430_AC {

    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            flag = true;
            String commands = br.readLine();

            int N = Integer.parseInt(br.readLine());
            Deque<Integer> deque = new ArrayDeque<>();

            String s = br.readLine();
            s = s.substring(1, s.length() - 1);
            StringTokenizer st = new StringTokenizer(s, ",");

            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                deque.add(num);
            }

            boolean errorFlag = false;

            for (int i = 0; i < commands.length(); i++) {
                String command = commands.substring(i, i + 1);

                if (command.equals("R")) {
                    flag = !flag;
                    
                } else {
                    if (!deque.isEmpty()) {
                        pollDeque(deque);
                    } else {
                        sb.append("error").append("\n");
                        errorFlag = true;
                        break;
                    }
                }
            }

            if (!errorFlag) {
                sb.append("[");
                while (!deque.isEmpty()) {
                    int poll = pollDeque(deque);
                    if (deque.isEmpty()) {
                        sb.append(poll);
                    } else {
                        sb.append(poll).append(",");
                    }
                }

                sb.append("]").append("\n");
            }

        }

        System.out.println(sb);
    }

    private static Integer pollDeque(Deque<Integer> deque) {
        if (flag) return deque.pollFirst();
        else return deque.pollLast();
    }

    static class Number {
        public int val;
        public int idx;

        public Number(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }
}
