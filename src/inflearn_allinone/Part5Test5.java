package inflearn_allinone;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 잔돈교환2
 * 놓친 포인트: amount+1 만큼 visited 배열 만들어서 방문 처리
 * 잔돈 별 visited 체크 이유: 그 잔돈까지의 최단거리는 현재시점. 이후에는 최단일 수 없기 때문에 거르기 위해
 */
public class Part5Test5 {

    public static void main(String[] args) {
        // int[] coins = {10, 5, 25, 1};
        // int amount = 30;
        int[] coins = {9, 4, 1};
         int amount = 12;

        System.out.println(solution(coins,amount));
    }

    public static int solution(int[] coins, int amount) {
        return bfs(coins, amount);
    }

    public static int bfs(int[] coins, int amount) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[amount+1];

        q.offer(new int[]{amount,0});
        visited[amount] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0] == 0) {
                return cur[1];
            }else if(cur[0] < 0) {
                continue;
            }

            for(int i=0; i<coins.length; i++) {
                int nxtAmount = cur[0]-coins[i];
                if((nxtAmount >= 0) && !visited[nxtAmount]) { // 하위 노드 탐색 가능
                    q.offer(new int[]{cur[0]-coins[i], cur[1]+1});
                    visited[nxtAmount] = true;
                }
            }
        }

        return -1;
    }
}
