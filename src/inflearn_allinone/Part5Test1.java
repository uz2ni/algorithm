package inflearn_allinone;

import java.util.*;

/**
 * BFS, DFS
 */
public class Part5Test1 {

    public static void main(String[] args) {
        int n = 8;
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

        solution(graph);
    }

    public static void solution(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        System.out.print("bfs: ");
        bfs(0, graph, visited);
        System.out.println();

        boolean[] visited2 = new boolean[graph.size()];
        System.out.print("dfsRecursion: ");
        dfsRecursion(0, graph, visited2);
        System.out.println();
    }

    public static void bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true; // 큐에 넣을 때 방문 처리 (같은 노드를 여러 경로에서 중복 도달 가능하기 때문에 미리 배제)

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");
            for(int nxt : graph.get(cur)) {
                if(!visited[nxt]) {
                    queue.offer(nxt);
                    visited[nxt] = true;
                }
            }
        }
    }

    public static void dfsRecursion(int start, List<List<Integer>> graph, boolean[] visited) {
        visited[start] = true;
        System.out.print(start + " ");

        for(int nxt : graph.get(start)) {
            if(!visited[nxt]) {
                dfsRecursion(nxt, graph, visited);
            }
        }
    }
}
