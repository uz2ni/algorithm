package hanghae_study_2th;

import java.util.Arrays;

/**
 * 24.5.26 (일)
 * [프로그래머스] LV2 코딩테스트>정렬 - 가장 큰 수
 **/
public class Day7_LV2_42746_X {

    public static void main(String[] args) {

        int[] numbers = {3, 30, 34, 5, 9};

        System.out.println(solution(numbers));


    }

    public static String solution(int[] numbers) {
        String[] numbersStr = new String[numbers.length];

        for(int i=0; i<numbers.length; i++) {
            numbersStr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numbersStr, (o1, o2) -> (o2+o1).compareTo(o1+o2));

        if(numbersStr[0].equals("0")) return "0";

        return String.join("",numbersStr);
    }
}