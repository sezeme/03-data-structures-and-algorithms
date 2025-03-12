package com.sezeme.section03.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

/* 갖고 있는 동전들이 서로 배수, 약수이기 때문에 그리디가 가능함. */
public class B_CoinChange {
    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] coins = new int[N];
        for(int i = 0; i < coins.length; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

//        int idx = coins.length - 1;
//        while (K >= 0) {
//            if(K == 0) return count;
//
//            if(K - coins[idx] < 0){
//                if(idx == 0) return -1;
//                idx--;
//            }
//            else {
//                K -= coins[idx];
//                count++;
//            }
//        }

        for(int i = coins.length - 1; i >= 0; i--) {
            if(K < coins[i]) continue;
            K += K/coins[i];
            K %= coins[i];
        }












        return 0;
    }
}
