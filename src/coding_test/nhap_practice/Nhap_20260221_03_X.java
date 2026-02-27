package coding_test.nhap_practice;

import java.util.*;

/**
 * 실전 문제 3번 예상 풀이 (안풀려서 보류)
 */
public class Nhap_20260221_03_X {

    public static void main(String[] args) {

    }

    public static void solution(String[] theme, int[][] relation) {
        // relation->graph 변환했다고 치자

        // graph init
        List<List<Integer>> graph = new ArrayList<>();

        graph.add(new ArrayList<>()); // 0

        List<Integer> g1 = new ArrayList<>();
        g1.add(2); g1.add(4);
        graph.add(g1);

        List<Integer> g2 = new ArrayList<>();
        g2.add(1);
        graph.add(g2);

        List<Integer> g3 = new ArrayList<>();
        g3.add(4); g3.add(5);
        graph.add(g3);

        List<Integer> g4 = new ArrayList<>();
        g4.add(1); g4.add(3); g4.add(5);
        graph.add(g4);

        List<Integer> g5 = new ArrayList<>();
        g5.add(4); g5.add(6);
        graph.add(g5);

        List<Integer> g6 = new ArrayList<>();
        g6.add(5); g6.add(7);
        graph.add(g6);

        List<Integer> g7 = new ArrayList<>();
        g7.add(6);
        graph.add(g7);

        // dfs 실행
        int[] answer = dfs(theme, graph);
    }

    public static int[] dfs(String[] theme, List<List<Integer>> graph) {
        int[] answer = new int[theme.length]; // 일자별 인원수

        Queue<Visitor> q = new ArrayDeque<>(); // 현재 일자에 방문할 노드

        // 1일차 노드 삽입
        Set<String> firstSet = new HashSet<>();
        firstSet.add(theme[0]);
        q.offer(new Visitor(1, firstSet, true));

        for(int i=0; i<theme.length; i++) {

            // i일차 집계
            answer[i] = q.size();

            if (q.size() == 0) break;

            // 같은 날 중복 막기용
            Set<Integer> reserved = new HashSet<>();

            for(int j=0; j<q.size(); j++) { // 현재 일자 큐 노드수 만큼만 처리 (큐에서 일자에 해당하는 노드 구분)
                Visitor cur = q.poll();
                if(cur.isNext) {
                    for(int nxt : graph.get(cur.id)) {

                        if(reserved.contains(nxt)) continue; // 이미 내일 방문 예약되어있으면 pass

                        String nxtTheme = theme[cur.id];
                        if(cur.seenThemes.contains(nxtTheme)) { // 같은 테마 2회차

                        }else { // 같은 테마 1회차

                        }
                    }
                }
            }

        }

        return answer;
    }

    public static class Visitor {
        private int id;
        private Set<String> seenThemes;
        private boolean isNext;

        public Visitor(int id, Set<String> seenTemes, boolean isNext) {
            this.id = id;
            this.seenThemes = seenThemes;
            this.isNext = isNext;
        }
    }
}
