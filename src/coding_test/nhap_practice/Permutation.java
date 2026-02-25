package coding_test.nhap_practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 순열
 * 배열의 m개를 조합해 순서를 고려한 모든 경우의 수
 */
public class Permutation {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int m = 2;
        solution(nums,m);
    }

    public static void solution(int[] nums, int m) {
        List<List<Integer>> results = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, m, 0, visited, new ArrayList<>(), results);
        System.out.println(results);
    }

    public static void dfs(int[] nums, int m, int depth, boolean[] visited, List<Integer> selected, List<List<Integer>> results) {
        if(m == depth) {
            results.add(new ArrayList<>(selected));
            return;
        }
        for(int i=0; i<nums.length; i++) {
            if(!visited[i]) {
                selected.add(nums[i]);
                visited[i] = true;
                dfs(nums, m, depth+1, visited, selected, results);
                selected.remove(selected.size()-1);
                visited[i] = false;
            }
        }
    }
}
