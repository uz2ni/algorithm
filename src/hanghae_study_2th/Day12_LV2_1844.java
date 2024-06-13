package hanghae_study_2th;

import java.util.*;

/**
 * 24.5.31 (금)
 * [프로그래머스] LV2 - d1844. 코딩테스트 연습 > DFS/BFS > 게임 맵 최단거리
 **/
public class Day12_LV2_1844 {

    static int answer = 0;
    static boolean[][] visited;

    public static void main(String[] args) {

        Queue<Integer> q = new LinkedList<>();
        q.add(5);
        q.add(2);
        q.add(10);
        System.out.println(q.toString());


    }

    public static int solution(int[][] maps) {


        visited = new boolean[maps.length][maps[0].length];

        return answer;
    }

    public static void dfs(int[][] maps, int x, int y, int cnt) {
        // 목표지점 도달하면 종료
        if((x == maps.length-1) && (y == maps[0].length-1)) {
            answer = cnt > answer ? cnt : answer;
            return;
        }

        // 좌표 외 구간이면 리턴
        if(x < 0 || maps.length >= x || y < 0 || maps[0].length >= y) {
            return;
        }

        // 이미 방문한 블럭이면 리턴
        if(visited[x][y]) {
            return;
        }

        dfs(maps, x, y+1,cnt+1); // 동
        dfs(maps, x, y-1,cnt+1); // 서
        dfs(maps, x+1, y,cnt+1); // 남
        dfs(maps, x-1, y,cnt+1); // 북
    }
}
