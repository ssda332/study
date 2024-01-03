package com.backjoon.hash;

import java.io.*;
import java.util.*;

public class BOJ7785_회사에_있는_사람 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> log = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String action = st.nextToken();

            if (action.equals("enter")) {
                log.put(name, action);
            } else {
              log.remove(name);
            }
        }

        List<String> sortedKeys = new ArrayList<>(log.keySet());
        Collections.sort(sortedKeys, Collections.reverseOrder());

        for (String key : sortedKeys) {
            System.out.println(key);
        }

    }
}
