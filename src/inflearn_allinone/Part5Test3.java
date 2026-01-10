package inflearn_allinone;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 잠겨버린 사물함
 */
public class Part5Test3 {

    public static void main(String[] args) {
        /*
        int n = 4;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        int[][] edges = {{1,2},{3},{},{0}};

        for(int i=0; i<edges.length; i++) {
            for(int j=0; j<edges[i].length; j++) {
                graph.get(i).add(edges[i][j]);
            }
        }
         */

        /*
        int n = 6;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        int[][] edges = {{1,3},{2,4},{0},{4},{},{3,4}};

        for(int i=0; i<edges.length; i++) {
            for(int j=0; j<edges[i].length; j++) {
                graph.get(i).add(edges[i][j]);
            }
        }
         */

        int n = 4;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        int[][] edges = {{0,1},{0,1},{2,3},{2,3}};

        for(int i=0; i<edges.length; i++) {
            for(int j=0; j<edges[i].length; j++) {
                graph.get(i).add(edges[i][j]);
            }
        }

        // System.out.println(solution(graph));
        System.out.println(solution2(graph));
    }

    public static int solution(List<List<Integer>> graph) {

        boolean[] visited = new boolean[graph.size()];
        bfs(0, graph, visited);

        int cnt = 0;
        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) cnt++;
        }

        return cnt;
    }

    public static int solution2(List<List<Integer>> graph) {

        boolean[] visited = new boolean[graph.size()];
        int visitedCnt = bfs2(0, graph, visited);

        return graph.size()-visitedCnt;
    }

    public static void bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int nxt : graph.get(cur)) {
                if(!visited[nxt]) {
                    q.offer(nxt);
                    visited[nxt] = true;
                }
            }
        }
    }

    public static int bfs2(int start, List<List<Integer>> graph, boolean[] visited) {
        int cnt = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;
        cnt++;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int nxt : graph.get(cur)) {
                if(!visited[nxt]) {
                    q.offer(nxt);
                    visited[nxt] = true;
                    cnt++;
                }
            }
        }

        return cnt; // 방문 노드 개수 리턴
    }

}
