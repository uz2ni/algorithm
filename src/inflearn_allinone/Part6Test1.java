package inflearn_allinone;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * [암시적그래프] 구름의 개수1
 */
public class Part6Test1 {
    public static void main(String[] args) {
        int[][] sky = {
                {0,1,1,1,0},
                {1,0,1,1,0},
                {1,0,0,0,0},
                {0,0,0,1,0}
        }; // output: 3
        System.out.println(solution(sky));
    }

    public static int solution(int[][] sky) {
        boolean[][] visited = new boolean[sky.length][sky[0].length];
        int count = 0;

        for(int i=0; i<sky.length; i++) {
            for(int j=0; j<sky[0].length; j++) {
                if(!visited[i][j] && (sky[i][j] == 1)) {
                    // bfs(sky, new int[]{i,j}, visited);
                    bfs2(sky, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    // 시간 초과
    public static void bfs(int[][] sky, int[] start, boolean[][] visited) {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            System.out.println("start: " + start[0] + start[1] + "/ poll: " + cur[0] + ", " + cur[1]);

            // cur의 상하좌우 중 갈 수 있는 길 & visited 안한 길을 q에 넣기
            int[] r = {-1, 1, 0, 0};
            int[] c = {0, 0, -1, 1};
            int w = sky[0].length;
            int h = sky.length;

            for(int i=0; i<r.length; i++) {
                int[] sub = new int[]{cur[0]+r[i], cur[1]+c[i]};
                System.out.println("sub:" + sub[0] + ","+sub[1]);
                if((sub[0] >= 0 && sub[0] < h && sub[1] >= 0 && sub[1] < w) && (sky[sub[0]][sub[1]] == 1) && (!visited[sub[0]][sub[1]])) {
                    q.offer(sub);
                    visited[sub[0]][sub[1]] = true;
                    System.out.println("sub offer:" + sub[0] + ","+sub[1]);
                }
            }

        }
    }

    public static void bfs2(int[][] sky, int r, int c, boolean[][] visited) { {
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{r,c});
        visited[r][c] = true;

        // 상하좌우 방향 배열
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        int h = sky.length;
        int w = sky[0].length;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i=0; i<4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];

                if(0 <= nr && nr < h && 0 <= nc && nc < w) { // 경계 검사
                    if(!visited[nr][nc] && sky[nr][nc] == 1) { // 방문 여부 검사 & 길(1)인지 확인
                        q.offer(new int[]{nr,nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }

    }}
}
