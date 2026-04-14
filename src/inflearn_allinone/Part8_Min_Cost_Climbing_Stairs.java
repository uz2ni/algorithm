package inflearn_allinone;

import java.util.Arrays;

/**
 * 69. DP - Min Cost Climbing Stairs
 */
public class Part8_Min_Cost_Climbing_Stairs {

    public static void main(String[] args) {
        // int[] cost = {10,15,20};
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        int answer = solution(cost);
        System.out.println(answer);
    }

    public static int solution(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return dp(cost, memo, n);
    }

    public static int dp(int[] cost, int[] memo, int n) {
        if(n == 0 || n == 1) {
            return 0;
        }else if(memo[n] == -1) {
            memo[n] = Math.min(dp(cost, memo, n-1) + cost[n-1], dp(cost, memo, n-2)+cost[n-2]);
        }
        return memo[n];
    }
}
