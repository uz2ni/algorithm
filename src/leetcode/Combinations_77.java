package leetcode;

import java.util.ArrayList;
import java.util.List;

/** 77. Combinations **/
public class Combinations_77 {
    public static List<List<Integer>> answers = new ArrayList<>();

    public static void main(String[] args) {
        List<List<Integer>> result = combine(4,2);
        System.out.println(result.toString());
    }

    public static List<List<Integer>> combine(int n, int k) {
        answers = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<>());
        return answers;
    }

    public static void dfs(int n, int k, int start, List<Integer> list) {
        if(list.size() == k) {
            answers.add(new ArrayList<>(list));
            return;
        }

        for(int i=start; i<=n; i++) {
            list.add(i);
            dfs(n, k, i+1, list);
            list.remove(list.size()-1);
        }
    }
}
