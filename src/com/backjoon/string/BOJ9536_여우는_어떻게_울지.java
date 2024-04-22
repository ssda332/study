package com.backjoon.string;

import java.io.*;
import java.util.*;

public class BOJ9536_여우는_어떻게_울지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            StringTokenizer words = new StringTokenizer(br.readLine());
            HashSet<String> set = new HashSet<>();

            while (true) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                String sound = st.nextToken();

                if (type.equals("does")) break;
                set.add(sound);
            }

            while (words.hasMoreTokens()) {
                String word = words.nextToken();
                boolean flag = true;

                Iterator<String> iter = set.iterator();
                while (iter.hasNext()) {
                    String sound = iter.next();
                    if (sound.equals(word)) flag = false;
                }

                if (flag) sb.append(word).append(" ");

            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}
