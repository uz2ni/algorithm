package programmers;

import java.util.ArrayList;
import java.util.List;

/*
    모의 고사
 */
public class test_42840 {
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        solution(answers);

    }

    static public int[] solution(int[] answers) {
        int[] pattern1 = {1,2,3,4,5};
        int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] cnt = {0,0,0};
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<answers.length; i++) {
            if(answers[i % answers.length] == pattern1[i % pattern1.length]) cnt[0]++;
            if(answers[i % answers.length] == pattern2[i % pattern1.length]) cnt[1]++;
            if(answers[i % answers.length] == pattern3[i % pattern1.length]) cnt[2]++;
        }

        // max 구하기
        int max = cnt[0];
        for(int i=1; i<=2; i++) {
            if(cnt[i] > max) max = cnt[i];
        }
        // 오름차순
        for(int i=0; i<3; i++) {
            if(cnt[i] == max) result.add(i+1);
        }

        int[] resultArr = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            resultArr[i] = result.get(i);
        }


        return resultArr;
    }
}
