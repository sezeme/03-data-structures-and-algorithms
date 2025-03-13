package com.sezeme.section04.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E_TriangleMaxSum {
    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        int n = Integer.parseInt(br.readLine());
        int[][] t = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];

        for(int i = 1; i<= n ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= i; j++){
                t[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = t[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }

        int answer = 0;
        for(int i = 1; i <= n ;i++){
            answer = Math.max(answer, dp[dp.length-1][i]);
        }
        return answer;
    }
}
