package programmers;

import java.util.ArrayList;
import java.util.List;

/*
    모의 고사
 */
public class test_42840 {
    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        int[] result = solution(answers);
        for(int i=0; i<result.length; i++) {
            System.out.print(result[i] + ", ");

        }

    }

    static public int[] solution(int[] answers) {
        int[] pattern1 = {1,2,3,4,5};
        int[] pattern2 = {2,1,2,3,2,4,2,5};
        int[] pattern3 = {3,3,1,1,2,2,4,4,5,5};
        int answer1=0, answer2 =0, answer3 =0;
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<answers.length; i++) {
            if(pattern1[i % pattern1.length] == answers[i]) answer1++;
            if(pattern2[i % pattern2.length] == answers[i]) answer2++;
            if(pattern3[i % pattern3.length] == answers[i]) answer3++;
        }

        int max = Math.max(Math.max(answer1, answer2), answer3);

        if(answer1 == max) result.add(1);
        if(answer2 == max) result.add(2);
        if(answer3 == max) result.add(3);

        int[] resultArr = new int[result.size()];
        for(int i=0; i<resultArr.length; i++) {
            resultArr[i] = result.get(i);
        }

        return resultArr;
    }

    static public int[] solution2(int[] answer) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];
        for(int i=0; i<answer.length; i++) {
            if(answer[i] == a[i%a.length]) {score[0]++;}
            if(answer[i] == b[i%b.length]) {score[1]++;}
            if(answer[i] == c[i%c.length]) {score[2]++;}
        }
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        ArrayList<Integer> list = new ArrayList<>();
        if(maxScore == score[0]) {list.add(1);}
        if(maxScore == score[1]) {list.add(2);}
        if(maxScore == score[2]) {list.add(3);}
        return list.stream().mapToInt(i->i.intValue()).toArray();
    }
}
