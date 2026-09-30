package leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/** 994. Rotting Oranges **/
public class Rotting_Oranges_994 {
    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}}; // 4
        // int[][] grid = {{2,1,1},{0,1,1},{1,0,1}}; // -1
        // int[][] grid = {{0,2}}; // 0
        // int[][] grid = {{2,1,1},{1,1,1},{0,1,2}}; // 2

        System.out.println(orangesRotting(grid));
    }
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};
    public static int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        Queue<int[]> q = new ArrayDeque<>();

        // 큐에 2(썩은)인 위치 모두 삽입
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                }
            }
        }

        int answer = bfs(grid, r, c, q);

        // 썩지 않은 오렌지 있나 체크
        for(int i=0; i<r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }

        return answer;
    }

    public static int bfs(int[][] grid, int r, int c, Queue<int[]> q) {
        int maxMinute = -1;

        if(q.isEmpty()) return 0;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                int[] cur = q.poll();

                for(int j=0; j<4; j++) {
                    int nx = cur[0]+dx[j];
                    int ny = cur[1]+dy[j];

                    if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
                    if(grid[nx][ny] != 1) continue;

                    q.offer(new int[]{nx,ny});
                    grid[nx][ny] = 2;
                }
            }
            maxMinute++;
        }
        return maxMinute;
    }
}
