package com.sezeme.section03.greedy;

public class A_SugarDelivery {
    public static int solution(int n) {
        /* 내 풀이 */
//        for (int i = n / 5; i >= 0; i--) {
//            if ((n - 5 * i) % 3 == 0) {
//                return i + (n - 5 * i) / 3;
//            }
//        }

        /* 선생님 풀이 */
        /* 3키로와 5키로 봉지로 가져갈 수 있는 최소 봉지 수 */
        int count = 0;

        while(true){
            /* n을 5키로 봉지로 모두 가져갈 수 있다면? */
            if (n % 5 == 0) {
                return n / 5 + count;
            } else if(n < 0) { // 3 or 5 조합으로 해결 안되는 상황
                return -1;
            } else if(n == 0) { // 3키로 봉지로만 해결
                return count;
            }

            /* 5키로로 나누어 떨어지지 않는다면 3키로 봉지 사용 해보기 */
            n = n - 3;
            count++;
        }

//        return -1;
    }
}
