package programmers;

import java.util.Arrays;

/*
    문자열 내림차순으로 배치하기
 */
public class test_12917 {
    public static void main(String[] args) {
        String s = "Zbcdefg";
        System.out.println(solution(s));
    }
    static public String solution(String s) {
        char[] sChar = s.toCharArray();
        Arrays.sort(sChar); // 오름차순
        StringBuilder answer = new StringBuilder(new String(sChar));
        return answer.reverse().toString();
    }
}