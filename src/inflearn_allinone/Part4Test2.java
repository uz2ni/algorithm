package inflearn_allinone;

import java.util.ArrayList;
import java.util.List;

/**
 * 순열
 */
public class Part4Test2 {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int m = 2;
        System.out.println(solution(arr, m));
    }

    public static List<List<Integer>> solution(int[] arr, int m) {
        return dfs(arr, m, new ArrayList<>(), new boolean[arr.length]);
    }

    public static List<List<Integer>> dfs(int[] arr, int m, List<Integer> list, boolean[] visited) {
        List<List<Integer>> ans = new ArrayList<>();

        if(list.size() == m) {
            ans.add(new ArrayList<>(list));
        }

        for(int i=0; i<arr.length; i++) {
            if(!visited[i]) { // 현재 방문한 값은 제외하고 추가

                list.add(arr[i]);
                visited[i] = true;

                ans.addAll(dfs(arr, m, list, visited));

                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }

        return ans;
    }
}
