package inflearn_allinone;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * [암시적 그래프] 응급차 최단거리2
 */
public class Part6Test2 {

    public static void main(String[] args) {
//        int[][] city = {
//                {0, 0, 1, 0},
//                {1, 0, 1, 0},
//                {1, 0, 0, 0}
//        };

        int[][] city = {
                {0, 1, 0},
                {0, 1, 0},
                {0, 0, 0},
                {1, 1, 0},
                {0, 0, 0}
        };

        System.out.println(solution(city));
    }

    public static int solution(int[][] city) {
        boolean[][] visited = new boolean[city.length][city[0].length];
        int answer = bfs(city, 0, 0, visited);
        return answer;
    }

    public static int bfs(int[][] city, int r, int c, boolean[][] visited) {

        if(city[r][c] == 1) return -1;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r,c,1});
        visited[r][c] = true;

        int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
        int w = city[0].length;
        int h = city.length;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            // if cur이 (맨오른,아래칸) 일치한다면 cur[2] 리턴
            if((cur[0]==(h-1)) && (cur[1]==(w-1))) {
                return cur[2];
            }

            for(int i=0; i<8; i++) {
                int nr = cur[0]+dr[i];
                int nc = cur[1]+dc[i];

                if((0 <= nr) && (nr < h) && (0 <= nc && (nc < w))) {
                    if(!visited[nr][nc] && (city[nr][nc] == 0)) {
                        q.offer(new int[]{nr,nc,cur[2]+1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return -1;
    }
}
