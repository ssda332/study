package com.backjoon.hash;

import java.io.*;
import java.util.*;

public class BOJ19583_싸이버개강총회 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = getTime(st.nextToken()); // 개강총회를 시작한 시간
        int E = getTime(st.nextToken()); // 개강총회를 끝낸 시간
        int Q = getTime(st.nextToken()); // 개강총회 스트리밍을 끝낸 시간

        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        String str = null;

//        for (int i = 0; i < 100000; i++) {
        while((str = br.readLine()) != null) {
            st = new StringTokenizer(str);
            if (!st.hasMoreTokens()) break;

            int time = getTime(st.nextToken());
            String id = st.nextToken();

            if (time <= S) map.put(id, 1);
            if (time >= E && time <= Q && map.containsKey(id)) {
                if (map.get(id) == 1) {
                    map.put(id, 2);
                    count++;
                }
            }
//        }
        }

        System.out.println(count);

    }

    static int getTime(String S) {
        String time = S.substring(0, 2) + S.substring(3, 5);
        int number = Integer.parseInt(time);

        return number;
    }


}
