package com.sezeme.section04.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;

public class F_StairClimbing {
    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        int n = Integer.parseInt(br.readLine());
        int[] stairs = new int[n];
        for (int i = 1; i < n + 1; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[n];
        dp[1] = stairs[1];
        if (n >= 2) dp[2] = dp[1] + stairs[2];

        for (int i = 3; i < n; i++) {
            // 가능 상황 1. 직전 계단에서 올라오는 상황 -> 연달아 세 개의 계단을 밟지 않아야 하므로 i-3 -> i-1 -> i로 이동해야만 함.
            // 가능 상황 2. 두 계단 전에서 올라오는 상황 -> i-2 이전의 상황을 고려할 필요 x
            // 1번 : dp[i-3] + arr[i-1] vs 2번 : dp[i-2]
            dp[i] = stairs[i] + Math.max(dp[i-3] + stairs[i-1], dp[i-2]);
        }
        System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
}
