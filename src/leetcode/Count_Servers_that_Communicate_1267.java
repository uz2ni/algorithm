package leetcode;

/** 1267. Count Servers that Communicate **/
public class Count_Servers_that_Communicate_1267 {
    public static void main(String[] args) {
        // int[][] grid = {{1,0}, {0,1}};
        int[][] grid = {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
        System.out.println(countServers(grid));
    }
    public static int countServers(int[][] grid) {
        // 각 행, 열의 서버 수 세기
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int count = 0;
        // 각 셀에 서버가 있다면, 셀에 해당하는 행,열에 다른 서버가 있는지 확인, 있다면 +1
        for(int i=0; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    if(row[i] > 1 || col[j] > 1) {
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
