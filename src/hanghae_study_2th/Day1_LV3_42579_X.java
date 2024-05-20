package hanghae_study_2th;

import java.util.*;

/**
 * 24.5.20 (월)
 * [프로그래머스] LV3 코딩테스트>해시 - 베스트앨범
 */
public class Day1_LV3_42579_X {

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        solutionMe(genres, plays);
    }

    /* 실패 */
    public static int[] solutionMe(String[] genres, int[] plays) {
        int[] answer = {};
        ArrayList<Integer> answerList = new ArrayList<Integer>();

        // 1. 장르 분류한다 (hashset) -> 분류 필요 없음. hashmap에 합친 값 넣을 때 분류가 됨
        HashSet<String> genresSet = new HashSet<>();
        for(String g : genres) { genresSet.add(g); };
        System.out.println(genresSet.toString());

        // 2. 장르 별 총재생회수 구하고, 내림차순 정렬
        HashMap<String,Integer> genresCnt = new HashMap();
        ArrayList<Genre> genresOrder = new ArrayList<>();
        for(String gs : genresSet) {
            System.out.println(gs + " : ");

            for(int i=0; i<genres.length; i++) {
                if(genres[i].equals(gs)) {
                    if(genresCnt.containsKey(gs)) {
                        genresCnt.put(gs, genresCnt.get(gs) + plays[i]);
                    }else {
                        genresCnt.put(gs, plays[i]);
                    }
                }
            }
            System.out.println(genresCnt.get(gs));
        }
        for(String key : genresCnt.keySet()) {
            genresOrder.add(new Genre(key, genresCnt.get(key)));
        }

        Collections.sort(genresOrder);

        // 3. 장르 별 수록곡 내림차순 정렬하고 2곡 뽑기
        for(Genre go : genresOrder) { // 장르 정렬된 것
            int cnt = 0;
            ArrayList<Integer> genrePlay = new ArrayList();
            for(int i=0; i<genres.length; i++) {
                if(go.genres.equals(genres[i])){
                    genrePlay.add(plays[i]);
                }
            }
            Collections.sort(genrePlay, Collections.reverseOrder());

            for(int i=0; i<2; i++) {
                for(int j=0; j<plays.length; j++) {
                    if(cnt >= 2) break;
                    if(genrePlay.get(i) == plays[j]) {
                        answerList.add(j);
                        cnt++;
                    }
                }
            }
        }

        answer = answerList.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    static class Genre implements Comparable<Genre>{

        String genres;
        int totalPlays;

        Genre(String genres, int totalPlays) {
            this.genres = genres;
            this.totalPlays = totalPlays;
        }

        @Override
        public int compareTo(Genre g) {
            return g.totalPlays - this.totalPlays;
        }
    }

    /* 다른 성공 풀이 1 */
    public int[] solution(String[] genres, int[] plays) {
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

    /*
    스터디 풀이_지원자
    map.merge
    map.putIfAbsent
    map.entrySet() arrayList 인자로 넣어서 리스트로 만듦
    entrySet / keySet ?
    list to array : answer.stream().mapToInt(n->n).toArray()

    스터디 풀이_클럽장
    Music 클래스(index,장르,재생횟수) 활용
    Music 클래스 안에서 정렬코드를 완성해서 사용함

     */
}
