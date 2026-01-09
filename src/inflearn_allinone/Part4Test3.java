package inflearn_allinone;

import java.util.ArrayList;
import java.util.List;

/**
 * 조합
 */
public class Part4Test3 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int m = 2;
        List<List<Integer>> ans = solution(nums, m);
        System.out.println(ans.toString());
    }

    public static List<List<Integer>> solution(int[] nums, int m) {
        return dfs(nums, m, 0, new ArrayList<>());
    }

    public static List<List<Integer>> dfs(int[] nums, int m, int start, List<Integer> curr) {
        List<List<Integer>> ans = new ArrayList<>();
        if(m == curr.size()) {
            ans.add(new ArrayList<>(curr));
            return ans;
        }

        for(int i=start; i<nums.length; i++) {
            curr.add(nums[i]);
            ans.addAll(dfs(nums, m, i+1, curr));
            curr.remove(curr.size()-1);
        }

        return ans;
    }
}
