package inflearn_allinone.replay;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Part5_홍팀청팀_X {

    public static void main(String[] args) {
        // int[][] friends = {{1},{2},{0}}; // false
        int[][] friends = {{1,2},{0,3},{0},{1}}; // true
        System.out.println(solution(friends));
    }

    public static boolean solution(int[][] friends) {
        int[] visited = new int[friends.length];
        for(int i=0; i<friends.length; i++) {
            if(visited[i] != -1) {
                if(!bfs(friends, i, visited)) return false;
            }
        }
        return true;
    }

    public static boolean bfs(int[][] friends, int start, int[] visited) {
        Arrays.fill(visited, -1);

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = 1;

        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int nxt : friends[cur]) {
                if(visited[nxt] == visited[cur]) { // 이미 방문했는데 값이 같다면 false
                    return false;
                }
                if(visited[nxt] == -1) {
                    q.offer(nxt);
                    visited[nxt] = 1 - visited[cur]; // 미방문 상태면 반대 값 저장
                }
            }
        }

        return true; // while문에서 리턴되지 않으면 이분그래프라고 판단하고 true
    }
}
