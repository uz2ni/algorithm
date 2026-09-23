package leetcode;

import java.util.ArrayList;
import java.util.List;

/** 22. Generate Parentheses **/
public class Generate_Parentheses_22 {
    public static List<String> answers;
    public static void main(String[] args) {
        List<String> result = generateParenthesis(3);
        System.out.println(result.toString());
    }

    public static List<String> generateParenthesis(int n) {
        answers = new ArrayList<>();
        dfs(n, 0, 0, "");
        return answers;
    }

    public static void dfs(int n, int left, int right, String str) {
        if(left == n && right == n) {
            answers.add(str);
            return;
        }
        if(left > n || right > n || left < right) return;

        dfs(n, left+1, right, str+"(");
        dfs(n, left, right+1, str+")");
    }
}
