package coding_test.nhap_practice;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BfsDfs {

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

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0 ; i<8; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0 ; i<edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        solution(graph);

        System.out.println("======");

        solution2(graph);
    }

    public static void solution(List<List<Integer>> graph) {
        boolean visited[] = new boolean[graph.size()];

        bfs(graph, 0, visited);
    }

    public static void bfs(List<List<Integer>> graph, int start, boolean visited[]) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            System.out.println(cur);

            for(int nxt : graph.get(cur)) {
                if (!visited[nxt]) {
                    q.offer(nxt);
                    visited[nxt] = true;
                }
            }
        }
    }

    public static void solution2(List<List<Integer>> graph) {
        boolean visited[] = new boolean[graph.size()];
        dfs(graph, 0, visited);
    }

    public static void dfs(List<List<Integer>> graph, int start, boolean[] visited) {
        visited[start] = true;
        System.out.println(start);

        for(int nxt : graph.get(start)) {
            if(!visited[nxt]) {
                dfs(graph, nxt, visited);
            }
        }
    }
}
