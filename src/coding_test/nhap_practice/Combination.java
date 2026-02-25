package coding_test.nhap_practice;

import java.util.ArrayList;
import java.util.List;

/**
 * m개 조합이 target이 되면 모든 조합한 수 반환
 */
public class Combination {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int m = 3;
        int target = 9;

        solution(nums, target, m);

    }

    public static void solution(int[] nums, int target, int m) {
        List<List<Integer>> results = new ArrayList<>(); // 찾은 조합들
        bfs(nums, target, m, 0, 0, 0, new ArrayList<>(), results);
        System.out.println(results);
    }

    public static void bfs(int[] nums, int target, int m, int start, int sum, int depth, List<Integer> selected, List<List<Integer>> results) {

        if(depth == m) {
            if(sum == target) {
                results.add(new ArrayList<>(selected));
            }
            return;
        }

        for(int i=start; i<nums.length; i++) {
            if(sum+nums[i] > target) continue; // [옵션] 성능 최적화
            selected.add(nums[i]);
            bfs(nums, target, m, i+1, sum+nums[i], depth+1, selected, results);
            selected.remove(selected.size()-1);
        }

    }
}
