package inflearn_allinone.replay;

public class Part5_잠겨버린_사물함 {
    public static int cnt;
    public static void main(String[] args) {
        // int[][] lockers = {{1,2}, {3}, {}, {0}}; // return: 0
        // int[][] lockers = {{1,3}, {2,4}, {0}, {4}, {}, {3,4}}; // return: 1
        int[][] lockers = {{0,1}, {0,1}, {2,3}, {2,3}}; // return: 2
        System.out.println(solution(lockers));
    }

    public static int solution(int[][] lockers) {
        cnt = 0;
        boolean[] visited = new boolean[lockers.length];
        dfs(lockers, 0, visited);
        return lockers.length - cnt;
    }

    public static void dfs(int[][] lockers, int start, boolean[] visited) {
        visited[start] = true;
        cnt++;
        for(int nxt : lockers[start]) {
            if(visited[nxt]) continue;
            dfs(lockers, nxt, visited);
        }
    }
}
