package com.backjoon.tree;

import java.io.*;
import java.util.*;

public class BOJ1991_트리_순회_RE {

    static int[][] tree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        tree = new int[3][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = st.nextToken().charAt(0) - 'A';
            int l = st.nextToken().charAt(0) - 'A';
            int r = st.nextToken().charAt(0) - 'A';

            tree[0][p] = p;
            if (l != -19) tree[1][p] = l;
            else tree[1][p] = -1;
            if (r != -19) tree[2][p] = r;
            else tree[2][p] = -1;
        }

        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        sb.append("\n");
        System.out.println(sb);
    }

    static void preOrder(int v) {
        if (v == -1) return;
        sb.append((char)(v + 'A'));
        preOrder(tree[1][v]);
        preOrder(tree[2][v]);
    }

    static void inOrder(int v) {
        if (v == -1) return;
        inOrder(tree[1][v]);
        sb.append((char)(v + 'A'));
        inOrder(tree[2][v]);
    }

    static void postOrder(int v) {
        if (v == -1) return;
        postOrder(tree[1][v]);
        postOrder(tree[2][v]);
        sb.append((char)(v + 'A'));
    }
}
