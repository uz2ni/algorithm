package leetcode;

import java.util.ArrayList;
import java.util.List;

/** 46. Permutations **/
public class Permutations_46 {
    public static List<List<Integer>> answers;
    public static void main(String[] args) {
        List<List<Integer>> result = permute(new int[]{1,2,3});
        System.out.println(result.toString());
    }

    public static List<List<Integer>> permute(int[] nums) {
        answers = new ArrayList<>();
        dfs(nums, new ArrayList<>(), new boolean[nums.length]);
        return answers;
    }

    public static void dfs(int[] nums, List<Integer> list, boolean[] visited) {
        if(list.size() == nums.length) {
            answers.add(new ArrayList<>(list));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(visited[i]) continue;

            list.add(nums[i]);
            visited[i] = true;

            dfs(nums, list, visited);

            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}
