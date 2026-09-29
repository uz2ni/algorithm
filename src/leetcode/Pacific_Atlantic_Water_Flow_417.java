package leetcode;

import java.util.ArrayList;
import java.util.List;

/** 417. Pacific Atlantic Water Flow **/
public class Pacific_Atlantic_Water_Flow_417 {
    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> results = pacificAtlantic(heights);
        System.out.println(results.toString());
    }

    public static List<List<Integer>> answers;
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        answers = new ArrayList<>();
        int r = heights.length;
        int c = heights[0].length;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                dfs(heights, r, c, i, j, i, j, new boolean[r][c], new boolean[2]);
            }
        }
        return answers;
    }

    public static boolean dfs(int[][] heights, int r, int c, int sX, int sY, int x, int y, boolean[][] visited, boolean[] ocean) {

        if(checkAndGetOcean(x, y, r, c, ocean)) {
            answers.add(new ArrayList<>(List.of(sX, sY)));
            return true;
        }

        visited[x][y] = true;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= r || ny >= c || visited[nx][ny]) continue;
            if(heights[x][y] < heights[nx][ny]) continue;

            if(dfs(heights, r, c, sX, sY, nx, ny, visited, ocean)) {
                return true;
            }
        }

        return false;
    }

    public static boolean checkAndGetOcean(int x, int y, int r, int c, boolean[] ocean) {
        if(!ocean[0]) { // pacific false일 때만 검사
            if(x == 0 || y == 0) {
                ocean[0] = true;
            }
        }
        if(!ocean[1]) { // atlantic false일 때만 검사
            if(x == r-1 || y == c-1) {
                ocean[1] = true;
            }
        }
        return ocean[0] && ocean[1];
    }
}
