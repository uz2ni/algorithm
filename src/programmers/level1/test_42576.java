package programmers.level1;

import java.util.*;

/*
    완주하지 못한 선수
 */
public class test_42576 {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};

        System.out.println(solution2(participant, completion));
    }

    public static String no_solution(String[] participant, String[] completion) {
        String answer = "";

        List<String> parList = new LinkedList<>();
        parList.addAll(Arrays.asList(participant));

        // 완주자를 순회한다
        for(String c : completion) {
            int size = parList.size();
            int i = 0;
            while(i < size) {
                // 참가자에 존재하면 해당 참가자 제거
                if(parList.get(i).equals(c)) {
                    parList.remove(i);
                    break;
                }
                i++;
            }

        }
        answer = parList.get(0);
        return answer;
    }

    public static String solution1(String[] participant, String[] completion) {
        String answer = "";
        String temp = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        int i = 0;

        while(i < completion.length) {
            if(!completion[i].equals(participant[i])) {
                temp = participant[i];
                break;
            }
            i++;
        }

        if(!temp.equals("")) {
            answer = temp;
        }else {
            answer = participant[participant.length-1];
        }

        return answer;
    }

    public static String solution2(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for(String player : participant) map.put(player, map.getOrDefault(player, 0) + 1);
        for(String player : completion) map.put(player, map.get(player) - 1);

        for(String key : map.keySet()) {
            if(map.get(key) != 0) {
                answer = key;
                break;
            }
        }
        return answer;
    }
}
