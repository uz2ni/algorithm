package hanghae_study_2th;

import java.util.HashSet;
import java.util.Set;

/**
 * 24.5.29 (수)
 * [프로그래머스] LV2 - 42839. 코딩테스트 연습 > 완전탐색 > 소수찾기
 **/
public class Day10_LV2_42839_X {

    static Set<Integer> set;
    static boolean[] visited = new boolean[7]; // 길이 1~7 문자열

    public static void main(String[] args) {
        System.out.println(solution("17"));
    }

    public static int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        dfs(numbers,"",0);

        for(Integer num : set) {
            if(isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(String numbers, String s, int depth) {
        if(depth > numbers.length()) {
            return;
        }

        for(int i=0; i<numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                set.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers, s + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }

        for(int i=2; i<=(int) Math.sqrt(n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
