package inflearn_allinone.replay;

public class Part5_잔돈교환2 {
    public static int cnt;
    public static void main(String[] args) {
        // int[] coins = {9,4,1};
        // int amount = 12; // 3
        int[] coins = {10, 5, 25, 1};
        int amount = 30; // 2

        System.out.println(solution(coins, amount));
    }

    public static int solution(int[] coins, int amount) {
        cnt = Integer.MAX_VALUE;
        dfs(coins, amount, 0);
        return(cnt == Integer.MAX_VALUE ? -1 : cnt);
    }

    // 1. 완전탐색 DFS -> 시간복잡도 O(N^amount)
    public static void dfs(int[] coins, int amount, int depth) {
        if(amount == 0) {
            cnt = Math.min(cnt, depth);
            return;
        }
        if(amount < 0) {
            return;
        }

        for(int i=0; i<coins.length; i++) {
            dfs(coins, amount-coins[i], depth+1);
        }
    }
}
