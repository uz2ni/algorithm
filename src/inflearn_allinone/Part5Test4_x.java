package inflearn_allinone;

import java.util.*;

/**
 * 홍팀청팀
 */
public class Part5Test4_x {

    public static void main(String[] args) {

//         int[][] friends = {{1},{2},{0}}; // false
        int[][] friends = {{1,2},{0,3},{0},{1}}; // true

        // System.out.println(solutionFail2(friends));
        System.out.println(solution(friends));

    }

    public static boolean solution(int[][] friends) {
        int[] visited = new int[friends.length];
        Arrays.fill(visited, -1);

        for(int i=0; i<friends.length; i++) {
            if(visited[i] == -1) {
                visited[i] = 0;
                if(!dfs(i,friends,visited)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solution2(int[][] friends) {
        int[] visited = new int[friends.length];
        Arrays.fill(visited, -1);

        for(int i=0; i<friends.length; i++) {
            if(visited[i] == -1) {
                if(!bfs(i,friends,visited)) {
                    return false;
                }
            }
        }

        return true;
    }

    // 시간초과
    public static boolean bfsFail1(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = true;

        List<Integer> teamA = new ArrayList<>();
        List<Integer> teamB = new ArrayList<>();

        while(!q.isEmpty()) {
            int cur = q.poll();

            boolean chk = false;
            // teamA에 내 인접리스트와 겹치는게 있나?
            for(int i=0; i<teamA.size(); i++) {
                if(graph.get(cur).contains(teamA.get(i))) { // 있음!
                    chk = true;
                    break;
                }
            }

            if(!chk) {
                teamA.add(cur);
            }else {
                for (int i = 0; i < teamB.size(); i++) {
                    if (graph.get(cur).contains(teamB.get(i))) { // 있음!
                        return false; // A,B팀 둘다 cur의 친구 존재하면 아무대도 소속 불가하여 실패
                    }
                }
                teamB.add(cur);
            }

            System.out.println("----");
            System.out.println("teamA: " + teamA.toString());
            System.out.println("teamB: " + teamB.toString());

            for(int nxt : graph.get(cur)) {
                if(!visited[nxt]) {
                    q.offer(nxt);
                    visited[nxt] = true;
                }
            }
        }

        return true;
    }

    // 시간초과
    public static boolean bfs(int start, int[][] friends, int[] visited) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int nxt : friends[cur]) {
                int nxtTeam = visited[cur] == 0 ? 1 : 0; // nxt의 팀 배정
                if(visited[nxt] < 0) { // 아직 미방문
                    q.offer(nxt);
                    visited[nxt] = nxtTeam;
                }else if(visited[nxt] != nxtTeam) { // 이미 방문했는데 팀 배정 불일치 (false)
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean dfs(int cur, int[][] friends, int[] visited) {
        for(int nxt : friends[cur]) {
            if(visited[nxt] == visited[cur]) return false;
            if(visited[nxt] == -1) {
                visited[nxt] = 1-visited[cur];
                if(!dfs(nxt, friends, visited)) {
                    return false;
                }
            }
        }
        return true;
    }
}
