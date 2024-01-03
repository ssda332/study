package com.algorithm.baaarkingdog;

import java.io.*;
import java.util.*;

public class BOJ9205_맥주_마시면서_걸어가기 {

    static class Node {
        int x;
        int y;
        int depth;

        public Node(int x, int y, int depth) {
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    static Node[] stores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            Node start = new Node(startX, startY, 0);

            stores = new Node[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                stores[i] = new Node(X, Y, 0);
            }

            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            Node end = new Node(endX, endY, 0);

            int mapX = getCal(startX, endX);
            int mapY = getCal(startY, endY);


        }
    }

    static int getCal(int i1, int i2) {
        if (i1 > 0 && i2 > 0) return Math.abs(i1 - i2);
        if (i1 < 0 && i2 < 0) return Math.abs(i1 - i2);

        return Math.abs(i1 + i2);
    }
}
