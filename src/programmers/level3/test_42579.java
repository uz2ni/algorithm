package programmers.level3;

import apple.laf.JRSUIUtils;

import java.sql.Array;
import java.util.*;

/*
    베스트앨범
 */
public class test_42579 {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(solution(genres, plays));
    }
    static public int[] solution(String[] genres, int[] plays) {
        int[] answer;
        ArrayList<Integer> answerList = new ArrayList<>();

        // 1. 속한 노래가 많이 재생된 장르를 먼저 수록
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i< genres.length; i++) {
            if(hm.containsKey(genres[i])) {
                hm.put(genres[i], hm.get(genres[i])+plays[i]);
            }else {
                hm.put(genres[i], plays[i]);
            }
        }
        // value 기준 내림차순 정렬
        List<String> keySet = new ArrayList<>(hm.keySet());
        Collections.sort(keySet, (o1, o2) -> (hm.get(o2).compareTo(hm.get(o1))));
        System.out.println(hm);

        // 2. 우선순위 장르 별 play수 많은 것 최대 2개 추출
        for(String key : keySet) {
            HashMap<Integer, Integer> genreLanking = new HashMap<>(); // play, index
            for(int i=0; i< genres.length; i++) {
                if(key.equals(genres[i])) {
                    genreLanking.put(i, plays[i]);
                }
            }

            List<Integer> lankKeySet = new ArrayList<>(genreLanking.keySet());
            Collections.sort(lankKeySet, (o1, o2) -> (genreLanking.get(o2).compareTo(genreLanking.get(o1))));
            int cnt = 0;
            for(Integer g : lankKeySet) {
                if(cnt > 1) break;
                answerList.add(g);
                cnt++;
            }
        }
        answer = new int[answerList.size()];
        for(int i=0 ;i<answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
