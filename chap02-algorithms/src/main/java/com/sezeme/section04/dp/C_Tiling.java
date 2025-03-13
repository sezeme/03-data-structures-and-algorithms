package com.sezeme.section04.dp;

public class C_Tiling {
    public static int solution(int n) {
        int[] count = new int[n];
        count[0] = 1;
        count[1] = 2;

        for(int i = 2; i < n; i++){
            count[i] = (count[i-1] + count[i-2]) % 10007;
        }

        return count[n-1];
    }
}
