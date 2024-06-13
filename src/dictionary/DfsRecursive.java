package dictionary;

import java.util.ArrayList;

/**
 * DFS : 깊이 우선 탐색 - 재귀
 */
public class DfsRecursive {

    static boolean[] visited = new boolean[9];
    static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
    static ArrayList<Integer> result = new ArrayList<>();


    public static void main(String[] args) {

        dfsByRecursive(1);

        for(Integer i : result) {
            System.out.print(i + " ");
        }

    }

    public static void dfsByRecursive(int nodeIndex) {
        // 방문 처리
        visited[nodeIndex] = true;

        // 방문 노드 결과 삽입
        result.add(nodeIndex);

        // 인접 노드 찾기
        for(int node : graph[nodeIndex]) {
            if(!visited[node]) {
                dfsByRecursive(node);
            }
        }
    }
}