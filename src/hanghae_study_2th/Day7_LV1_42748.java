package hanghae_study_2th;

import java.util.Arrays;
import java.util.Collections;

/**
 * 24.5.26 (일)
 * [프로그래머스] LV1 코딩테스트>정렬 - K번째수
 **/
public class Day7_LV1_42748 {

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {
                {2, 5, 3},
                {4, 4, 1},
                {1, 7, 3},
        };
        solution(array, commands);
    }

    public static int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++) {
            int[] command = commands[i];
            int[] newArray = new int[command[1]-command[0]+1];

            int start = command[0]-1;
            int end = command[1]-1;
            int idx = 0;
            while(start <= end) {
                newArray[idx++] = array[start];
                start++;
            }

            Arrays.sort(newArray);
            answer[i] = newArray[command[2]-1];

        }

        return answer;
    }
}
/*
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		List<Integer> list;

		for(int l=0; l<commands.length; l++) {
			list = new ArrayList<>();

			// i~j 번째 자르기
			int i = commands[l][0];
			int j = commands[l][1];
			int k = commands[l][2];
			for(int a=i-1; a<j; a++) { list.add(array[a]); }

			// 정렬하기
			Collections.sort(list);

			// k번째 수 answer에 담기
			answer[l] = list.get(k-1);
		}
		return answer;
    }
}
 */