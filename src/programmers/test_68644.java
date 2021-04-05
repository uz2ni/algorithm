package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test_68644 {
	/*
	 * 두 개 뽑아 더하기
	 */

	public static void main(String[] args) {
		//int[] numbers = {2,1,3,4,1};
		int[] numbers = {5,0,2,7};
		int[] result = solution(numbers);

		for(int i=0; i<result.length; i++) {
			System.out.print(result[i] + ", ");
		}

	}

	public static int[] solution(int[] numbers) {
		List<Integer> list = new ArrayList<>();

		for(int i=0; i<numbers.length; i++) {
			for(int j=i+1; j<numbers.length; j++) {
				// 두 수를 탐색
				// 두 수의 합이 list에 없으면 list에 추가
				int sum = numbers[i] + numbers[j];
				if(!list.contains(sum)) list.add(sum);
			}
		}
		// list to 배열 변환
		int[] answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}
		// list 오름차순 정렬
		Arrays.sort(answer);

		return answer;
	}
}
