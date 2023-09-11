package com.backjoon.randomdefense;

import java.io.*;

public class BOJ1342_행운의_문자열 {

    static String str;
    static int[] alpha = new int[26];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        for (int i = 0; i < str.length(); i++) {
            alpha[str.charAt(i) - 'a']++;
        }

        dfs(26, 0);

        System.out.println(cnt);
    }

    static void dfs(int pre, int depth) {
        if (depth == str.length()) {
            cnt++;
            return;
        }

        for (int i = 0; i < 26; i++) {
            if (alpha[i] > 0 && i != pre) {
                alpha[i]--;
                dfs(i, depth + 1);
                alpha[i]++;
            }
        }
    }

}
