package leetcode;

import java.util.ArrayList;
import java.util.List;

/** 39. Combination Sum **/
public class Combination_Sum_39 {
    public static List<List<Integer>> answers;

    public static void main(String[] args) {
        List<List<Integer>> result = combinationSum(new int[]{2,3,6,7}, 7);
        System.out.println(result);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        answers = new ArrayList<>();
        dfs(candidates, target, 0, 0, new ArrayList<>());
        return answers;
    }

    public static void dfs(int[] candidates, int target, int start, int sum, List<Integer> list) {
        if(target == sum) {
            answers.add(new ArrayList<>(list));
            return;
        }
        if(target < sum) {
            return;
        }

        for(int i=start; i<candidates.length; i++) {
            list.add(candidates[i]);
            dfs(candidates, target, i, sum+candidates[i], list);
            list.remove(list.size()-1);
        }
    }
}
