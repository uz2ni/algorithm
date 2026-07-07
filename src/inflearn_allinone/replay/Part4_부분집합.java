package inflearn_allinone.replay;

import java.util.ArrayList;
import java.util.List;

public class Part4_부분집합 {
    public static List<List<Integer>> list;
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        List<List<Integer>> answer = solution(nums);
        for(int i=0; i<answer.size(); i++) {
            System.out.println(answer.get(i).toString());
        }
    }

    public static List<List<Integer>> solution(int[] nums) {
        list = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return list;
    }

    public static void dfs(int[] nums, int start, List<Integer> selected) {
        list.add(new ArrayList<>(selected));
        for(int i=start; i<nums.length; i++) {
            selected.add(nums[i]);
            dfs(nums, i+1, selected);
            selected.remove(selected.size()-1);
        }
    }
}
