package inflearn_allinone;

import java.util.ArrayList;
import java.util.List;

/**
 * 완전탐색(재귀), dfs
 * nums에서 m개의 요소의 합이 target이 되면 true 반환
 */
public class Part4Test1 {

    public static void main(String[] args) {
        int[] nums = {4,9,7,5,1};
        int target = 15;

        // boolean answer = dfs(nums, target, 2, 0, new ArrayList<>());
        boolean answer = dfs2(nums, target, 3, 0, 0, 0);
        System.out.println(answer);
    }

    /**
     * solution1: 합산할 배열 selected를 전달하는 방식
      */
    public static boolean dfs(int[] nums, int target, int m, int start, List<Integer> selected) {
        // 멈추고 싶은 조건
        if(selected.size() == m) { // (순환 횟수) m개일 때
            // (리턴) 선택한 숫자의 합이 target 인지 여부
            int sum = 0;
            for(int n : selected) {
                sum += n;
            }
            return sum == target;
        }

        for(int i=start; i<nums.length; i++) {
            selected.add(nums[i]);
            if(dfs(nums, target,  m,i+1, selected)) {
                return true;
            }
            selected.remove(selected.size()-1); // 다음 노드 실행하려면 트리 위로 올라가기 위해 마지막 값 빼줘야 함
        }

        return false;
    }

    /**
     * solution2: sum을 파라미터로 넘기는 방식 (진행 횟수 알 수 없어서 depth 필요)
     */
    public static boolean dfs2(int[] nums, int target, int m, int start, int sum, int depth) {
        if(depth == m) {
            return sum == target;
        }
        for(int i=start; i<nums.length; i++) {
            if(dfs2(nums, target, m, i+1, sum+nums[i], depth+1)) {
                return true;
            }
        }
        return false;
    }

}
