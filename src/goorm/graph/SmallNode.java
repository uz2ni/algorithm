package goorm.graph;

import java.io.*;
import java.util.*;

/**
 * [구름] LV3. 작은 노드
 */
public class SmallNode {

    static boolean[] visited; // 방문 기록
    static List<List<Integer>> graph; // 인접 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]); // 노드 수
        int m = Integer.parseInt(input[1]); // 간선 수
        int startNode = Integer.parseInt(input[2]); // 시작 노드

        visited = new boolean[n + 1]; // 방문 기록 초기화

        graph = new ArrayList<>(); // 인접 리스트 초기화
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] line = br.readLine().split(" ");
            int a = Integer.parseInt(line[0]);
            int b = Integer.parseInt(line[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 각 리스트 오름차순 정렬
        for (int i = 0; i <= n; i++) {
            Collections.sort(graph.get(i));
        }

        int currentNode = startNode; // 현재 노드
        int visitCount = 1; // 노드 방문 수 (시작 노드 포함)

        // 첫 시작 노드 방문 처리
        visited[currentNode] = true;

        // 우선순위 큐를 사용하여 항상 최소 노드로 이동
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(currentNode);

        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            for (int neighbor : graph.get(currentNode)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    visitCount++;
                    queue.add(neighbor);
                    break; // 항상 가장 작은 노드로 이동
                }
            }
        }

        System.out.println(visitCount + " " + currentNode);
    }
}
