package coding_test.nhap_practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 모든 부분집합 구하기
 */
public class Subset {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        solution(nums);
    }

    public static void solution(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        for(int i=0; i<=nums.length; i++) {
            dfs(nums, i, 0, 0, new ArrayList<>(), results);
        }

        System.out.println(results);
    }

    public static void dfs(int[] nums, int m, int start, int depth, List<Integer> selected, List<List<Integer>> results) {
        if(m == depth) {
            results.add(new ArrayList<>(selected));
            return;
        }
        for(int i=start; i<nums.length; i++) {
            selected.add(nums[i]);
            dfs(nums, m, i+1, depth+1, selected, results);
            selected.remove(selected.size()-1);
        }
    }
}
