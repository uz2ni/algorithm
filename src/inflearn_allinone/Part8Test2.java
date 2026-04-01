package inflearn_allinone;

import java.util.*;

/**
 * 위상 정렬
 */
public class Part8Test2 {
    public static void main(String[] args) {
        int nodesNum = 6;
        int[][] edges = {
                {1, 0}, {2, 1}, {3, 1}, {5, 2}, {5, 3}, {5, 4}
        };
        int[] order = solution(nodesNum, edges);
        for(int i=0; i<order.length; i++) {
            System.out.print(order[i] + " ");
        }
    }

    public static int[] solution(int nodeNum, int[][] edges) {
        // 정점 -> 연결 리스트
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[nodeNum];
        for(int[] e : edges) {
            graph.putIfAbsent(e[1], new ArrayList<>());
            graph.get(e[1]).add(e[0]);
            indegree[e[0]]++; // 들어오는 차수 기록
        }

        Queue<Integer> q = new ArrayDeque<>();
        int[] order = new int[nodeNum]; // 노드 순서대로 담을 배열
        int count = 0;
        // indegree 0인 노드 큐에 삽입
        for(int i=0; i<indegree.length; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
                order[count++] = i;
            }
        }

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(graph.containsKey(cur)) {
                for(int nxt : graph.get(cur)) {
                    indegree[nxt]--;
                    if(indegree[nxt] == 0) {
                        order[count++] = nxt;
                        q.offer(nxt);
                    }
                }
            }
        }

        return order;
    }
}
