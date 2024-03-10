package com.backjoon.linkedlist;

import java.io.*;
import java.util.*;

public class BOJ1406_에디터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList<>();

        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }

        ListIterator<Character> it = list.listIterator();
        while (it.hasNext()) {
            it.next(); // 커서를 리스트의 끝으로 이동
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);
            if (command == 'L') {
                if (it.hasPrevious()) it.previous();
            } else if (command == 'D') {
                if (it.hasNext()) it.next();
            } else if (command == 'B') {
                if (it.hasPrevious()) {
                    it.previous();
                    it.remove();
                }
            } else if (command == 'P') {
                char next = st.nextToken().charAt(0);
                it.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : list) {
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
