package leetcode;

import java.util.ArrayList;
import java.util.List;

/** 17. Letter Combinations of a Phone Number **/
 public class Letter_Combinations_of_a_Phone_Number_17 {
    public static List<String> answers;
    public static char[][] letters = {
            {},
            {},
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };

    public static void main(String[] args) {
        // List<String> result = letterCombinations("23");
        List<String> result = letterCombinations("2");
        System.out.println(result);
    }

    public static List<String> letterCombinations(String digits) {
        answers = new ArrayList<>();
        combination(digits, "");
        return answers;
    }

    public static void combination(String digits, String str) {
        int index = str.length();
        if(digits.length() == index) {
            answers.add(str);
            return;
        }

        // int number = Integer.parseInt(String.valueOf(digits.charAt(index)));
        int number = digits.charAt(index) - '0';

        for(char c : letters[number]) {
            combination(digits, str+c);
        }
    }
}