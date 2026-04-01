package inflearn_allinone;

import java.util.*;

/**
 * 다익스트라 - 64. Network Delay Time
 * 신호가 k에서 출발해 모든 노드에 도달하는 최소 시간 구하기 (하나의 노드라도 방문 못하면 -1 반환)
 */
public class Part8Test3 {

    public static void main(String[] args) {
        int[][] times = {{2, 1, 2}, {2, 3, 5}, {2, 4, 1}, {4, 3, 3}}; // [u, v, w] (u->v 가중치 w)
//        int n = 4; // 노드 개수
//        int k = 2; // 시작 노드

        int n = 4; // 노드 개수
        int k = 4; // 시작 노드

        System.out.println(solution(times, n, k));

    }

    public static int solution(int[][] times, int n, int start) {
        // 간선 -> 연결 그래프 변환
        Map<Integer, List<Edge>> graph = new HashMap<> ();
        for(int[] t : times) {
            graph.putIfAbsent(t[0], new ArrayList<>());
            graph.get(t[0]).add(new Edge(t[2],t[1]));
        }

        // 노드 별 방문여부,이동길이 초기화
        Visit[] visit = new Visit[n+1];
        Arrays.fill(visit, new Visit(false, Integer.MAX_VALUE));

        // 시작 노드 큐에 넣기
        Queue<Entry> q = new PriorityQueue<>();
        q.offer(new Entry(0, start));
        visit[start] = new Visit(true, 0);

        // 큐 꺼내면서 다음 이동할 노드 넣기
        while(!q.isEmpty()) {
            Entry cur = q.poll();
            if(visit[cur.node].distance < cur.distance) continue;

            if(graph.containsKey(cur.node)) {
                for (Edge nxt : graph.get(cur.node)) {
                    int totalDistance = cur.distance + nxt.distance;
                    if (totalDistance < visit[nxt.to].distance) {
                        visit[nxt.to] = new Visit(true, totalDistance);
                        q.offer(new Entry(totalDistance, nxt.to));
                    }
                }
            }
        }

        // 방문 안한 노드 있다면 -1 반환, 없다면 최대 방문 회수 반환
        int result = -1;
        for(int i=1; i<visit.length; i++) {
            if(!visit[i].visited) return -1;
            if(result < visit[i].distance) {
                result = visit[i].distance;
            }
        }
        return result;
    }

    public static class Edge {
        private int distance;
        private int to;

        public Edge(int distance, int to) {
            this.distance = distance;
            this.to = to;
        }
    }

    public static class Entry implements Comparable<Entry> {
        private int distance;
        private int node;

        public Entry(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }

        @Override
        public int compareTo(Entry o) {
            return o.distance - this.distance; // 오름차순
        }
    }

    public static class Visit {
        private boolean visited;
        private int distance;

        public Visit(boolean visited, int distance) {
            this.visited = visited;
            this.distance = distance;
        }
    }
}
