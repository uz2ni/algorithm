package programmers.level1;

import java.util.*;


/*
    문자열 내 마음대로 정렬하기
 */
public class test_12915 {
    public static void main(String[] args) {
        String[] strings = {"abce", "abcd", "cdx"};
        int n = 2;
        String[] answer = solution(strings, n);
        for(String a : answer) {
            System.out.println(a);
        }
    }

    static public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        // n인덱스 문자를 각 문자열 맨 앞에 붙여서 정렬한다.
        for(int i=0; i< strings.length; i++) {
            answer[i] = strings[i].charAt(n) + strings[i];
        }
        Arrays.sort(answer);
        for(int i=0; i< answer.length; i++) {
            answer[i] = answer[i].substring(1);
        }

        return answer;
    }
}
