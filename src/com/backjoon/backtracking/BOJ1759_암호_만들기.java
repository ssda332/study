package com.backjoon.backtracking;

import java.io.*;
import java.util.*;

public class BOJ1759_암호_만들기 {

    static int L;
    static int C;
    static String[] A;
    static boolean[] visited;
    static String[] password;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        A = new String[C + 1];
        visited = new boolean[C + 1];
        password = new String[L + 1];

        st = new StringTokenizer(br.readLine());
        A[0] = "";
        for (int i = 1; i <= C; i++) {
            A[i] = st.nextToken();
        }

        Arrays.sort(A, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

//        Arrays.stream(A).forEach(System.out::println);
        dfs(0, 0, 0, 0);

        System.out.println(sb);
    }

    static void dfs(int v, int depth, int con, int vow) {
        visited[v] = true;
        password[depth] = A[v];

        if (depth == L) {
            if (con >= 2 && vow >= 1) {
                for (int i = 1; i <= L; i++) {
                    sb.append(password[i]);
                }
                sb.append("\n");
            }
            visited[v] = false;
            return;
        }

        for (int i = v + 1; i <= C; i++) {
            String select = A[i];
            int nextCon = con;
            int nextVow = vow;

            if (select.equals("a") || select.equals("e") || select.equals("i") || select.equals("o") || select.equals("u")) {
                // 모음일 경우
                nextVow++;
            } else {
                nextCon++;
            }

            if (visited[i]) continue;
            dfs(i, depth + 1, nextCon, nextVow);
        }

        visited[v] = false;


    }
}
