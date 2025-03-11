package com.sezeme.section02.searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/* BFS는 먼저 방문한 노드를 기준으로 가장 가까운 노드부터 탐색한다.
 * 즉, 시작점에서 출발하여 거리 1짜리 노드를 모두 방문한 후,
 * 거리 2짜리 노드를 방문하는 방식으로 진행 된다.
 * 따라서 어떤 노드에 도달했을 때, 처음 도달한 순간이 곧 최단 거리가 된다.
 * DFS는 한 방향으로 깊게 들어간 후, 막다른 길에 도달하면 다시 되돌아오므로
 * 최단 경로가 아닌 먼 길을 돌아 도착하는 경우도 생길 수 있다.
 * */
public class C_ShortestPath {

    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static int[] dirX = {0, 0, -1, 1};
    static int[] dirY = {-1, 1, 0, 0};
    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static Queue<Node> q = new LinkedList<>();

    public static int solution(String input) throws IOException {
        BufferedReader br = new BufferedReader(new StringReader(input));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for(int j = 0; j < ch.length; j++) {
                map[i][j] = Character.getNumericValue(ch[j]);   // '1' -> 숫자 1
            }
        }

        /* 0, 0 에서 출발 */
        bfs(0, 0);

        /* 도착지의 값을 반환 (도착 할 때까지의 최적의 경로 단계 수) */
        return map[N - 1][M -  1];
    }

    static void bfs(int x, int y) {
        q.add(new Node(x, y));
        visit[x][y] = true;

        /* 시작 지점에서부터 큐를 이용해서 큐에 담기는 노드가 제거 될 때까지 너비 우선 탐색을 진행한다.*/
        while(!q.isEmpty()) {

            /* 현재 탐색을 진행할 노드 */
            Node n = q.poll();

            /* 해당 정점에서 상하좌우를 살펴보는 반복문 */
            for(int i = 0; i < 4; i++) {
                int cx = n.x + dirX[i];
                int cy = n.y + dirY[i];

                /* 좌표가 전체 범위를 넘어간다면 확인이 불필요하므로 다음 방향 확인 */
                if(cx < 0 || cy < 0 || cx >= N || cy >= M) continue;

                /* 방문 했던 좌표이거나 벽이면 확인이 불필요하므로 다음 방향 확인 */
                if(visit[cx][cy] || map[cx][cy] == 0) continue;

                q.offer(new Node(cx, cy));
                visit[cx][cy] = true;
                map[cx][cy] = map[n.x][n.y] + 1;

                /* 디버깅용 출력 */
                System.out.println("cx = " + cx + ", cy = " + cy);
                System.out.println("map[cx][cy] = " + map[cx][cy]);
            }
        }
    }
}
