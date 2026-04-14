package inflearn_allinone;

import java.util.Arrays;

/**
 * 68. DP - Climbing Stairs
 */
public class Part8_Climbing_Stairs {

    public static void main(String[] args) {
        int n = 7;

        int answer = solution(n);
        System.out.println(answer);
    }

    public static int solution(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return dp(memo, n);
    }

    public static int dp(int[] memo, int n) {
        if(n == 1) {
            return 1;
        } else if(n == 2) {
            return 2;
        }else if(memo[n] == -1){
            memo[n] = dp(memo, n-1) + dp(memo, n-2);
        }
        return memo[n];
    }
}
