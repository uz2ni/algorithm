package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
	나누어 떨어지는 숫자 배열
 */
public class test_12910 {
	public static void main(String[] args) {
		int[] arr = {5, 9, 7, 10};
		int divisor = 5;
		int[] result = solution(arr, divisor);

		for(int num : result) {
			System.out.print(num + ", ");

		}
	}

	public static int[] solution(int[] arr, int divisor) {
		int[] answer;
		List<Integer> list = new ArrayList<>();

		// arr 순회
		for(int pick : arr) {
			if(pick%divisor == 0) { // arr 중 divisior 로 나뉘는 수 있으면 list 삽입
				list.add(pick);
			}
		}

		// 하나도 없으면 -1
		if(list.isEmpty()) { list.add(-1); }

		// list to answer
		answer = new int[list.size()];
		for(int i=0; i<list.size(); i++) {
			answer[i] = list.get(i);
		}

		// answer 정렬
		Arrays.sort(answer);

		return answer;
	}
}
