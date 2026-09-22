package leetcode;

import java.util.HashMap;
import java.util.Map;

/** 3. Longest Substring Without Repeating Characters **/
public class Longest_Substring_Without_Repeating_Characters_3 {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
    }

    // 1. 문자열 구간 잘라서 판별 (not best)
    // 시간 O(N^2), 공간 O(N):window 크기 최대 N
    // 구간 순서가 중요하지 X, 판별만 하면 되기 때문에 구간 관리 엄격히 안해도 됨. substring, window 로 개발하면 시간/공간복잡도 비효율
    public static int lengthOfLongestSubstring1(String s) {
        int left = 0;
        int answer = 0;
        String window = "";

        for(int right=0; right<s.length(); right++) { // O(N^2) = for문 N번인데 하위에서 K^2. K<=N 이므로 N^2로 수렴

            char ch = s.charAt(right);

            System.out.println(window + ", " + ch + ", " + answer);

            while(window.indexOf(ch) != -1) { // while문 전체적으로 O(K^2)
                window = window.substring(1); // 맨앞문자 제거. O(K)
                left++; // O(1)
            }

            window += ch; // O(N)
            answer = Math.max(answer, window.length());
        }

        return answer;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int left = 0;
        int answer = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int right=0; right<s.length(); right++) {
            char ch = s.charAt(right);
            if(map.containsKey(ch) && left <= map.get(ch)) { // map에는 방문한 문자의 최신 위치를 기록하고있음. 구간 아니더라도 존재할 수 있기 때문에 left 이후 구간인지 확인
                left = map.get(ch)+1; // 윈도우 내 중복 문자를 제거하기 위해 중복 문자의 다음부터 시작
            }
            map.put(ch, right);
            answer = Math.max(answer, right-left+1);
        }
        return answer;
    }
}
