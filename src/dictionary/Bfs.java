package dictionary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS : 너비 우선 탐색
 */
public class Bfs {

    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) {

        int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
        boolean[] visited = new boolean[9];

        bfs(1, graph, visited);

        for(Integer i : result) {
            System.out.print(i + " ");
        }
    }

    public static void bfs(int start, int[][] graph, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()) {

            int nodeIndex = q.poll();
            result.add(nodeIndex);

            for(int node : graph[nodeIndex]) {
                if(!visited[node]) {
                    q.add(node);
                    visited[node] = true;
                }
            }

        }

    }
}
