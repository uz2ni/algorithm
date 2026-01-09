package inflearn_allinone;

import java.util.ArrayList;
import java.util.List;

/**
 * 부분 집합
 */
public class Part4Test4 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(solution(nums));
    }

    public static List<List<Integer>> solution(int[] nums) {
        return dfs(nums, 0, new ArrayList<>());
    }

    public static List<List<Integer>> dfs(int[] nums, int start, List<Integer> curr) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(curr));

        for(int i=start; i<nums.length; i++) {
            curr.add(nums[i]);
            ans.addAll(dfs(nums, i+1, curr));
            curr.remove(curr.size()-1);
        }

        return ans;
    }
}
