package com.sezeme.section07.heap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class Practice2 {
// 가방 하나당 한 개의 보석만 넣을 수 있음.
//  해당 가방에 들어갈 수 있는 가장 무거운 것 중 가격이 제일 비싼 것
    public static class Jewelry implements Comparable<Jewelry> {
        int m; // 무게
        int v; // 가격

        public Jewelry(int m, int v) {
            this.m = m;
            this.v = v;
        }

        @Override
        public int compareTo(Jewelry o) {
            if (m == o.m) return o.v - v;
            return m - o.m;
        }
    }

    public long solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 보석 개수
        int k = Integer.parseInt(st.nextToken());   // 가방 개수

        Jewelry[] jewelries = new Jewelry[n];   // 보석 저장 배열
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            jewelries[i] = new Jewelry(weight, price);
        }

        int[] bags = new int[k];    // 가방 무게 저장 배열
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewelries);
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long totalValue = 0;
        int jewelryIndex = 0;
        for(int i = 0; i < k ; i++){
            int bagCapacity = bags[i];

            //현재 가방의 무게보다 작거나 같은 보석을 모두 우선순위 큐에 넣음.
            while (jewelryIndex < n && jewelries[jewelryIndex].m <= bagCapacity){
                pq.offer(jewelries[jewelryIndex].v);
                jewelryIndex++;
            }

            if(!pq.isEmpty()){
                totalValue += pq.poll();
            }
        }
        return totalValue;
    }
}
