package programmers.level1;

/* 완주하지 못한 선수 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class test_42576_2 {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(solution2(participant, completion));
    }

    // 정확성:성공, 효율성:실패
    static public String solution(String[] participant, String[] completion) {
        String answer = "";
        ArrayList<String> arr = new ArrayList<>(Arrays.asList(participant));


        for(int i=0; i<completion.length; i++) {
            int idx = 0;
            while(arr.size() > 0) {
                if(arr.get(idx).equals(completion[i])) {
                    arr.remove(idx);
                    break;
                }
                idx++;
            }
        }

        return arr.get(0);
    }

    // 해시
    static public String solution2(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for(String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        for(String player : completion) {
            map.put(player, map.get(player) - 1);
        }

        for(String key : map.keySet()) {
            if(map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}
