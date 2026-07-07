package inflearn_allinone.replay;

import java.util.ArrayList;
import java.util.List;

public class Part4_조합 {
    public static List<List<Integer>> list;
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int m = 2;
        List<List<Integer>> answer = solution(nums, m);
        for(int i=0; i<answer.size(); i++) {
            System.out.println(answer.get(i).toString());
        }
    }

    public static List<List<Integer>> solution(int[] nums, int m) {
        list = new ArrayList<>();
        combination(nums, m, 0, new ArrayList<>());
        return list;
    }

    public static void combination(int[] nums, int m, int start, List<Integer> selected) {
        if(selected.size() == m) {
            list.add(new ArrayList<>(selected));
            return;
        }

        for(int i=start; i<nums.length; i++) {
            selected.add(nums[i]);
            combination(nums, m, i+1, selected);
            selected.remove(selected.size()-1);
        }
    }
}
