package goorm.dfsbfs;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * [구름] LV3. 대체 경로(BFS)
 */
public class AlternativeRoute {

    static List<List<Integer>> list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0]; // 도시 수
        int m = input[1]; // 도로 수
        int start = input[2]; // 출발 도시
        int end = input[3]; // 도착 도시

        list = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            list.add(new ArrayList<>());
        }
        for(int i=1; i<=m; i++) { // 그래프 리스트
            int[] line = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.get(line[1]).add(line[0]);
            list.get(line[0]).add(line[1]);
        }

        for(int i=1; i<=n; i++) {
            System.out.println(bfs(start, end, i, n));
        }

    }

    public static int bfs(int start, int end, int remove, int n) { // n: 도시 수
        Queue<int[]> q = new LinkedList<>(); // 수, 카운트 기록
        visited = new boolean[n+1]; // 방문 기록

        // -1 제약 사항
        int cnt = -1; // 두 도시 이동 불가한 경우
        if(start == remove || end == remove) return -1; // 출발 or 도착 도시 공사 중인 경우

        // 제거 도시 방문 처리
        visited[remove] = true;

        // 처음 값 큐 넣고 방문 처리
        q.add(new int[]{start, 1});
        visited[start] = true;

        while(!q.isEmpty()) {
            int[] node = q.poll();
            List nodeList = list.get(node[0]);

            if(node[0] == end) { // 도착점
                cnt = node[1];
                break;
            }

            for(int i=0; i<nodeList.size(); i++) {
                int now = (int)nodeList.get(i);
                if(!visited[now]) {
                    q.add(new int[]{now, node[1]+1});
                    visited[now] = true;
                }
            }
        }

        return cnt;
    }
}
