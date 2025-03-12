package com.sezeme.section03.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.StringTokenizer;

/* 최소 신장 트리
 * 주어진 그래프의 모든 정점을 연결하는 부분 그래프 중 가중치의 값이 최소인 트리
 * 크루스칼 알고리즘
 * 간선을 오름차순으로 정렬하고, 사이클을 형성하지 않도록 최소 신장 트리를 구성하는 방법
 * (union & find 자료구조를 통해 사이클 여부 확인)
 * */
public class F_KruskalAlgorithm {
    static int[] parent;

    // 간선 정보 클래스
    static class Edge implements Comparable<Edge> {
        int u, v, weight;
        Edge(int u, int v, int weight) {
            this.u = u;                 // 정점 1
            this.v = v;                 // 정점 2
            this.weight = weight;       // 가중치
        }

        @Override
        public int compareTo(Edge o) {  // 간선 정렬 시 가중치 오름차순 적용
            return this.weight - o.weight;
        }
    }

    /* 특정 원소가 속한 집합을 찾는 연산
     * 이를 통해 집합의 대표 원소(루트 노드)를 찾고, 대표 원소를 알면 두 원소가 같은 집합에 속하는지 확인할 수 있다. */
    static int find(int x) {
        if(parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    /* 두 개의 집합을 하나로 합치는 연산. 두 집합의 대표 원소를 비교하여 두 집합이 연결 되도록 함.*/
    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        // 앞쪽 원소를 root로 하는 기준으로 작성
        if(rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    public static Long solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(u, v, weight);
        }

        return 0L;
    }
}
