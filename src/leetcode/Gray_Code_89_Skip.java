package leetcode;

import java.util.ArrayList;
import java.util.List;

/** 89. Gray Code (보류) **/
public class Gray_Code_89_Skip {
    public static List<Integer> answers;
    public static void main(String[] args) {
        grayCode(3);
        System.out.println(answers.toString());
    }
    public static List<Integer> grayCode(int n) {
        answers = new ArrayList<>();
        dfs(n, "");
        return answers;
    }

    public static void dfs(int n, String code) {
        if(n == code.length()) {
            // answers.add(twoToTen(code)); // String code -> int 10진수 -> add
            answers.add(Integer.parseInt(code, 2));
            return;
        }
        dfs(n, code+"0");
        dfs(n,  code+"1");
    }

    public static int twoToTen(String code) {
        int index = 0;
        int sum = 0;
        for(int i=code.length()-1; i>=0; i--) {
            int num = code.charAt(i)-'0';
            sum += num * Math.pow(2,index++);
        }
        return sum;
    }
}
