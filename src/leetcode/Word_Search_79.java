package leetcode;

/** 79. Word Search **/
public class Word_Search_79 {
    public static int[] dx = {-1,1,0,0};
    public static int[] dy = {0,0,-1,1};

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board, "ABCCED"));
    }

    public static boolean exist(char[][] board, String word) {
        int r = board.length;
        int c = board[0].length;

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                boolean[][] visited = new boolean[r][c];
                visited[i][j] = true;
                if(dfs(board, r, c, i, j, word, String.valueOf(board[i][j]), visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean dfs(char[][] board, int r, int c, int x, int y, String word, String str, boolean[][] visited) {
        System.out.println("x: " + x + ", y: " + y + ", str: " + str);
        if(word.equals(str)) {
            return true;
        }
        if(!word.startsWith(str)) {
            return false;
        }
        if(word.length() <= str.length()) {
            return false;
        }

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= r || ny >= c) continue;
            if(visited[nx][ny]) continue;

            visited[nx][ny] = true;
            if(dfs(board, r, c, nx, ny, word, str+board[nx][ny], visited)) {
                return true;
            }
            visited[nx][ny] = false;
        }

        return false;
    }
}
