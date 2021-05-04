package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
	K번째 수
 */
public class test_42748 {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}; // i,j,k

		int[] result = solution(array, commands);

		for(int i=0; i< result.length; i++) {
			System.out.print(result[i] + ", ");
		}
	}
	// 내가 푼 풀이
	public static int[] solution(int[] array, int[][] commands) {
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

	// Arrays.copyOfRange
	public static int[] solution2(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for(int i=0; i<commands.length; i++) {
			int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
			Arrays.sort(temp);
			answer[i] = temp[commands[i][2]-1];
		}

		return answer;
	}
}
