package inflearn_allinone;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 원하는 원소까지 최단 거리 구하기 (bfs)
 */
public class Part5Test2 {

    public static void main(String[] args) {
        int n = 8;
        int k = 7; // 찾을 값
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        int[][] edges = {
                {0,1},{0,3},{0,6},
                {1,3},
                {2,3},
                {3,7},
                {4,5},
                {5,6},{5,7}
        };

        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u); // 무방향
        }

        System.out.println(solution(graph, k));
    }

    public static int solution(List<List<Integer>> graph, int k) {
        boolean[] visited = new boolean[graph.size()];
        int answer = bfs(0, graph, visited, k);
        return answer;
    }

    public static int bfs(int start, List<List<Integer>> graph, boolean[] visited, int k) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start, 0}); // 노드번호, 거리
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            // 찾은 경우
            if(cur[0] == k) {
               return cur[1];
            }

            for(int nxt : graph.get(cur[0])) {
                if(!visited[nxt]) {
                    q.offer(new int[]{nxt, cur[1]+1});
                    visited[nxt] = true;
                }
            }
        }

        return -1;
    }
}
