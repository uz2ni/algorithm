package programmers.level2;

import java.util.ArrayList;

public class test_86971_X {

    static ArrayList<Integer>[] graph;
    static int min;

    public static void main(String[] args) {
        // int[][] wires = {{1,2},{2,3},{3,4}};
        int[][] wires = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
        System.out.println(solution(7, wires));
    }

    public static int solution (int n, int[][] wires) {
        graph = new ArrayList[n+1];
        min = n;

        // 1. ArrayList 초기화
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 2. 양방향 그래프 초기화
        for(int i=0; i<wires.length; i++) {
            int v1 = wires[i][0];
            int v2 = wires[i][1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        // 3. 간선 하나씩 빼면서 dfs 돌리기
        for(int i=0; i<wires.length; i++) {
            boolean[] visited = new boolean[n+1]; // 방문 노드 기록

            // 간선 빼기
            int removeV1 = wires[i][0];
            int removeV2 = wires[i][1];
            graph[removeV1].remove(Integer.valueOf(removeV2));
            graph[removeV2].remove(Integer.valueOf(removeV1));

            int cnt = dfs(1,visited);

            int diff = Math.abs(cnt-(n-cnt));
            min = Math.min(diff, min);

            // 간선 다시 넣기 (다음 포문에서 삭제한 간선 사용 할 수 있도록)
            graph[removeV1].add(removeV2);
            graph[removeV2].add(removeV1);
        }

        return min;
    }

    public static int dfs(int v, boolean[] visited) {
        visited[v] = true;
        int cnt = 1;

        for(int next : graph[v]) {
            if(!visited[next]) {
                cnt += dfs(next, visited); // 방문할때마다 cnt(1)씩 증가
            }
        }
        return cnt;
    }
}
