package coding_test.nhap_practice;

import java.util.ArrayList;
import java.util.List;

public class NhTest_20220706_02 {

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        solution(n,k);
    }

    public static int[] solution(int n, int k) {
        int[] nums = new int[n+1];
        for(int i=0; i<n; i++) {
            nums[i] = i+1;
        }
        int[] answer = dfs(nums, k, 0, 0, 0, new ArrayList<>());
        answer = (answer != null) ? answer : new int[]{-1};
        for(int i=0; i<answer.length; i++) {
            System.out.print(answer[i] + " ");
        }

        return answer;
    }

    public static int[] dfs(int[] nums, int k, int start, int sum, int depth, List<Integer> selected) {
        if(k == depth) {
            if(sum % nums.length == 0) {
                int[] answer = new int[selected.size()];
                for(int i=0; i<answer.length; i++) {
                    answer[i] = selected.get(i);
                }
                return answer;
            }
            return null;
        }

        int[] result = null;
        for(int i=start; i<nums.length; i++) {
           selected.add(nums[i]);
           result = dfs(nums, k, i+1, sum+nums[i], depth+1, selected);
           if(result != null) break;

           selected.remove(selected.size()-1);
        }

        return result;
    }
}
