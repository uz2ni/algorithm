package inflearn_allinone.replay;

import java.util.ArrayList;
import java.util.List;

public class Part4_순열_X {
    public static List<List<Integer>> answer;
    public static void main(String[] args) {
        int[] nums = {5,2,3,6,1};
        int size = 2;
        solution(nums, size);
    }

    public static void solution(int[] nums, int size) {
        answer = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, size, visited, new ArrayList<>());
        for(List<Integer> a : answer) {
            System.out.println(a.toString());
        }
    }

    public static void dfs(int[] nums, int size, boolean[] visited, List<Integer> selected) {
        if(selected.size() == size) {
            answer.add(new ArrayList<>(selected));
            return;
        }

        for(int i=0; i<nums.length; i++) {
            if(!visited[i]) {
                selected.add(nums[i]);
                visited[i] = true;
                dfs(nums, size, visited, selected);
                selected.remove(selected.size()-1);
                visited[i] = false;
            }
        }
    }
}
