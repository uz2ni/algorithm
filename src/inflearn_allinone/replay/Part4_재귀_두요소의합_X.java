package inflearn_allinone.replay;

import java.util.*;

/**
 * (틀은 잡았는데 못풀었고, 강의 이해하고 풀림)
 */
public class Part4_재귀_두요소의합_X {
    public static int[] answer;
    public static void main(String[] args) {
        int[] nums = {4,9,7,5,1};
        int m = 2;
        int target = 10;
        int[] result = solution(nums, target, m);
        for(int i=0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }

    public static int[] solution(int[] nums, int target, int m) {
        answer = new int[m];
        dfs(nums, target, m, 0, 0, new ArrayList<>());
        return answer;
    }

    public static boolean dfs(int[] nums, int target, int m, int start, int curSum, List<Integer> selected) {
        // basecase
        if(m == selected.size()) {
            // 합산 해보고 target 일치하면 answer에 저장
            if(curSum == target) {
                for(int i=0; i<m; i++) {
                    answer[i] = selected.get(i);
                }
                return true;
            }
            return false;
        }
        // recursive
        for(int i=start; i<nums.length; i++) {
            selected.add(i);
            if(dfs(nums, target, m, i+1, curSum+nums[i], selected)) {
                return true;
            }
            selected.remove(selected.size()-1);
        }
        return false;
    }
}
