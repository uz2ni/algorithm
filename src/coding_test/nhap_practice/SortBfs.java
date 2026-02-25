package coding_test.nhap_practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 지정 원소까지 최단거리 길이 구하기 (bfs)
 */
public class SortBfs {

    public static void main(String[] args) {
        int[][] edges = {
                {0,1},{0,3},{0,6},
                {1,3},
                {2,3},
                {3,7},
                {4,5},
                {5,6},{5,7}
        };
        int n = 8;
        int k = 7;

        System.out.println(solution(edges, n, k));
    }

    public static int solution(int[][] edges, int n, int k) {

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u); // 무방향
        }

        boolean[] visited = new boolean[n];

        int answer = bfs(graph, k, 0, visited);
        return answer;
    }

    public static int bfs(List<List<Integer>> graph, int k, int start, boolean[] visited) {
        Queue<int[]> q = new ArrayDeque<>(); // [원소,거리]
        q.offer(new int[]{start,0});
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

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
