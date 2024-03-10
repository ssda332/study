package com.backjoon.linkedlist;

import java.io.*;
import java.util.*;

public class BOJ5397_키로거 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < N; t++) {
            LinkedList<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            String str = br.readLine();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '<') {
                    if (iter.hasPrevious()) iter.previous();
                } else if (c == '>') {
                    if (iter.hasNext()) iter.next();
                } else if (c == '-') {
                    if (list.size() != 0 && iter.hasPrevious()) {
                        iter.previous();
                        iter.remove();
                    }
                } else {
                    iter.add(c);
                }
            }

            if (list.size() != 0) {
                for (char c : list) {
                    sb.append(c);
                }

                sb.append("\n");
            }

        }

        System.out.println(sb);


    }
}
