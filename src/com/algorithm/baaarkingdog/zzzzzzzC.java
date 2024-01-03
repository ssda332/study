package com.algorithm.baaarkingdog;

import java.io.*;
import java.util.*;

public class zzzzzzzC {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Long[] damage = new Long[N];

        for (int i = 0; i < N; i++) {
            damage[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(damage, Collections.reverseOrder());

        Boss[] bosses = new Boss[K + 1];
        bosses[0] = new Boss(0, 0);

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            bosses[i] = new Boss(Long.parseLong(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

//        Arrays.sort(bosses);

        // D[i][j][k] = i번 캐릭터로 k초동안 j보스 잡아서 얻을수있는 최대 골드
        int[][][] D = new int[M][K + 1][901];

        for (int i = 0; i < M; i++) {
            for (int j = 1; j <= K; j++) {
                for (int k = 1; k <= 900; k++) {

                    if (k * damage[i] >= bosses[j].hp) {
//                        System.out.println("damage : " + k * damage[i] + ", i : " + i + ", j : " + j + ", k : " + k);
                        D[i][j][k] = Math.max(D[i][j - 1][k], D[i][j - 1][k - (int)Math.ceil(((double)bosses[j].hp / (double)damage[i]))] + bosses[j].q);
                    } else {
                        D[i][j][k] = D[i][j - 1][k];
                    }


                }
            }
        }

        /*for (int i = 1; i <= 900; i++) {
            System.out.println(D[0][3][i]);
        }*/

        int sum = 0;
        for (int i = 0; i < M; i++) {
//            System.out.println("damage : " + damage[i] + ", money : " + D[i][K - 1][900]);
//            System.out.println("D[" + i + "][" + K + "][900] : " + D[i][K - 1][900]);
            sum += D[i][K][900];
        }
//        System.out.println(D[0][2][899]);

        System.out.println(sum);


    }

    static class Boss implements Comparable<Boss>{
        public long hp;
        public int q;

        public Boss(long hp, int q) {
            this.hp = hp;
            this.q = q;
        }

        @Override
        public int compareTo(Boss o) {
            return (int)(this.hp - o.hp);
        }
    }
}
