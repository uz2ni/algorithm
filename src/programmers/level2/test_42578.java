package programmers.level2;

import java.util.HashMap;

/*
    위장
 */
public class test_42578 {
    public static void main(String[] args) {
        String[][] clothes = {
                {"yellowhat", "headgear"},
                {"bluesunglasses", "eyewear"},
                {"green_turban", "headgear"}
        };
        System.out.println(solution(clothes));
    }
    static public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> hm = new HashMap<>();
        for(String[] c : clothes) {
            hm.put(c[1], hm.getOrDefault(c[1], 0) + 1);
        }
        for(String key : hm.keySet()) {
            answer *= (hm.get(key)+1);
        }
        answer -= 1;

        return answer;
    }
}
