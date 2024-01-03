package com.backjoon.simulation;

import java.io.*;
import java.util.*;

public class BOJ18808_스티커_붙이기 {

    static int N;
    static int M;
    static int[][] notebook;
    static ArrayList<int[][]> stickers = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        // 0925 -> 1136
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        notebook = new int[N][M];

        // 스티커 붙이기 -> 4(회전수) * K -> 400

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int[][] sticker = new int[R][C];

            for (int j = 0; j < R; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < C; k++) {
                    sticker[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            stickers.add(sticker);
        }

        for (int i = 0; i < stickers.size(); i++) {
            int[][] sticker = stickers.get(i);
            boolean find = false;
            int rotateCount = 0;

            while (!find && rotateCount < 5) {

                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < M; k++) {
                        if (find) continue;
                        boolean isCheck = checkSticker(sticker, k, j, true);
                        if (isCheck) {
                            checkSticker(sticker, k, j, false);
                            find = true;

                        }
                    }
                }

                rotateCount++;
                sticker = rotateSticker(sticker, sticker.length, sticker[0].length);
            }

        }

        System.out.println(searchBlock());

    }

    static int[][] rotateSticker(int[][] sticker, int r, int c) {
        int[][] newSticker = new int[c][r];

        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                newSticker[i][j] = sticker[r - 1 - j][i];
            }
        }

        return newSticker;
    }

    // mod -> true : 스티커 체크, false : 스티커 붙이기
    static boolean checkSticker(int[][] sticker, int startX, int startY, boolean mod) {
        int R = sticker.length;
        int C = sticker[0].length;

        // 스티커 크기가 노트북 크기를 벗어나면 false 리턴
        if (startX + C > M || startY + R > N) return false;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (mod) {
                    // 스티커를 붙여야 할 칸에 스티커가 이미 있으면 붙일 수 없으므로 false 리턴
                    if (notebook[startY + i][startX + j] == 1 && sticker[i][j] == 1) return false;
                } else {
                    // 노트북 칸이 비었을때만 스티커 붙이고 이미 스티커가 붙여져있을때는 지나가기
                    if (notebook[startY + i][startX + j] == 0) notebook[startY + i][startX + j] = sticker[i][j];
                }
            }
        }

        return true;
    }

    static int searchBlock() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (notebook[i][j] == 1) count++;
            }
        }
        return count;
    }
}

/*
    문제 잘못읽음 (0도 회전해서 가능할 때까지 판단해보고, 90도 회전으로 넘어가야하는데
    0도 회전해서 안되면 바로 90도 회전해서 확인하는 코드여서 안되는 거였습니다 )
    문제를 잘못읽었는데 테케를 다 통과해버리는 어이없는 문제였음
 */