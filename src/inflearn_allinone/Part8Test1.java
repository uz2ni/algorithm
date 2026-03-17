package inflearn_allinone;

import java.util.*;

/**
 * 다익스트라
 * start->end 까지 걸리는 비용 반환
 */
public class Part8Test1 {

    public static void main(String[] args) {

        Map<Integer, List<Edge>> graph = new HashMap<>();

        List<Edge> list1 = new ArrayList<>();
        list1.add(new Edge(2,2));
        list1.add(new Edge(4,1));
        graph.put(1, list1);

        List<Edge> list2 = new ArrayList<>();
        list2.add(new Edge(1,3));
        list2.add(new Edge(4,6));
        list2.add(new Edge(2,5));
        graph.put(2, list2);

        List<Edge> list3 = new ArrayList<>();
        list3.add(new Edge(4,6));
        graph.put(3, list3);

        List<Edge> list4 = new ArrayList<>();
        list4.add(new Edge(3,3));
        list4.add(new Edge(5,7));
        graph.put(4, list4);

        List<Edge> list5 = new ArrayList<>();
        list5.add(new Edge(1,8));
        graph.put(5, list5);

        List<Edge> list6 = new ArrayList<>();
        list6.add(new Edge(3,5));
        graph.put(6, list6);

        List<Edge> list7 = new ArrayList<>();
        list7.add(new Edge(7,6));
        list7.add(new Edge(6,8));
        graph.put(7, list7);

        List<Edge> list8 = new ArrayList<>();
        graph.put(8, list8);

        int result = dijkstra(graph, 1, 8);
        System.out.println("8 :" + result);

        int result2 = dijkstra(graph, 1, 5);
        System.out.println("5 :" + result2);

        int result3 = dijkstra(graph, 1, 3);
        System.out.println("3 :" + result3);
    }

    public static int dijkstra(Map<Integer, List<Edge>> graph, int start, int end) {

        int max = Integer.MAX_VALUE;
        int[] distance = new int[graph.size()+1];
        Arrays.fill(distance, max);

        Queue<Entry> q = new ArrayDeque<>();
        q.offer(new Entry(0,start));
        distance[start] = 0;

        while(!q.isEmpty()) {
            Entry cur = q.poll();
            if(distance[cur.node] < cur.distance) continue;

            for(Edge nxt : graph.get(cur.node)) {
                int newDist = cur.distance + nxt.distance;
                if(newDist < distance[nxt.to]) {
                    distance[nxt.to] = newDist;
                    q.offer(new Entry(newDist, nxt.to));
                }
            }

        }

        return distance[end];
    }

    public static class Entry {

        private int distance;
        private int node;

        public Entry(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }

    public static class Edge {

        private int distance;
        private int to;

        public Edge(int distance, int to) {
            this.distance = distance;
            this.to = to;
        }
    }

}
