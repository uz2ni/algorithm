package programmers.topkit.bruteforce;

import java.util.ArrayList;
import java.util.List;

/** 84512
 * 코딩테스트 연습 > 완전탐색 > 모음사전
 */
public class test7 {

    static List<String> list;
    static String[] words = {"A", "E", "I", "O", "U"};

    public static void main(String[] args) {
        list = new ArrayList<>();
        System.out.println(solution("AAAAE"));
    }

    public static int solution(String word) {
        int answer = 0;
        dfs("", 0);
        // word == list.get(i)
        for(int i=0; i<list.size(); i++) {
            if(word.equals(list.get(i))) {
                answer = i;
                break;
            }
        }

        return answer;
    }

    public static void dfs(String str, int len) {
        list.add(str);
        if(len == words.length) return;
        for(int i=0; i<words.length; i++) {
            dfs(str + words[i], len+1);
        }
    }
}
