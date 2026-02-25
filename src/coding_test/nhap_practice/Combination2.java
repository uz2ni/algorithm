package coding_test.nhap_practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 조합
 * 주어진 배열의 수로 M개 조합 모두 구하기
 */
public class Combination2 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int m = 2;
        solution(nums,m);
    }

    public static void solution(int[] nums, int m) {
        List<List<Integer>> results = new ArrayList<>();
        dfs(nums, m, 0, 0, new ArrayList<>(), results);
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
