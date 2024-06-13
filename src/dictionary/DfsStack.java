package dictionary;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/**
 * DFS : 깊이 우선 탐색 - 스택
 */
public class DfsStack {

    static Stack<Integer> s = new Stack<>();
    static boolean[] visited = new boolean[9];
    static int[][] graph = {{}, {2,3,8}, {1,6,8}, {1,5}, {5,7}, {3,4,7}, {2}, {4,5}, {1,2}};
    static ArrayList<Integer> result = new ArrayList<>();


    public static void main(String[] args) {

        dfsByStack();

        for(Integer i : result) {
            System.out.print(i + " ");
        }

    }

    public static void dfsByStack() {
        // 시작 노드 삽입
        s.push(1);
        // 시작 노드 방문 처리
         visited[1] = true;

        while(!s.isEmpty()) {

            // 1. 스택에서 하나를 뺀다
            int nodeIndex = s.pop();

            // 2. 방문 노드 출력
            result.add(nodeIndex);

            // 2. 스택 값의 인접 노드가 방문 배열에 없는 경우 -> 스택에 넣는다
            for (int node : graph[nodeIndex]) {
                if (!visited[node]) {
                    s.push(node);
                    visited[node] = true;
                }
            }

        }
    }
}