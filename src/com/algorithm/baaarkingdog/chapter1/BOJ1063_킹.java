package com.algorithm.baaarkingdog.chapter1;

import java.io.*;
import java.util.*;

public class BOJ1063_킹 {

    static int[][] map = new int[8][8];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String kPos = st.nextToken();
        String cPos = st.nextToken();
        int N = Integer.parseInt(st.nextToken());

        int colK = kPos.charAt(0) - 'A';
        int rowK = kPos.charAt(1) - '1';

        int colC = cPos.charAt(0) - 'A';
        int rowC = cPos.charAt(1) - '1';

        map[colK][rowK] = 1; // 1 : 킹, 2 : 돌
        map[colC][rowC] = 2;

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            moveKing(command);
        }

        String answerKing = "";
        String answerPiece = "";

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                String plus = String.valueOf((char)(i + 'A'));

                if (map[i][j] == 1) {
                    answerKing = answerKing + plus + (j + 1);
                }

                if (map[i][j] == 2) {
                    answerPiece = answerPiece + plus + (j + 1);
                }
            }
        }

        System.out.println(answerKing);
        System.out.println(answerPiece);

    }

    static void moveKing(String command) {

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (map[i][j] == 1) {

                    int iMove = i;
                    int jMove = j;
                    for (int k = 0; k < command.length(); k++) {
                        if (command.charAt(k) == 'R') iMove++;
                        if (command.charAt(k) == 'L') iMove--;
                        if (command.charAt(k) == 'B') jMove--;
                        if (command.charAt(k) == 'T') jMove++;
                    }
                    if (iMove < 0 || iMove >= 8 || jMove < 0 || jMove >= 8) continue;

                    int iMoveC = iMove;
                    int jMoveC = jMove;

                    if (map[iMove][jMove] == 2) {
                        for (int k = 0; k < command.length(); k++) {
                            if (command.charAt(k) == 'R') iMoveC++;
                            if (command.charAt(k) == 'L') iMoveC--;
                            if (command.charAt(k) == 'B') jMoveC--;
                            if (command.charAt(k) == 'T') jMoveC++;
                        }

                        if (iMoveC < 0 || iMoveC >= 8 || jMoveC < 0 || jMoveC >= 8) continue;

                        map[iMoveC][jMoveC] = 2;
                        map[iMove][jMove] = 0;
                    }

                    map[iMove][jMove] = 1;
                    map[i][j] = 0;
                    return;
                }
            }
        }
    }




}
