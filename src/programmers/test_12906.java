package programmers;

import java.util.ArrayList;
import java.util.List;

public class test_12906 {
	/*
	 * 같은 숫자는 싫어
	 */
	public static void main(String[] args) {
		int[] arr = {1,1,3,3,0,1,1};
		int[] result  = solution(arr);

		for(int r : result) {
			System.out.print(r + ",");
		}


	}

	public static int[] solution(int []arr) {

		List<Integer> list = new ArrayList<>();
		for(int i=0; i<arr.length; i++) {
			int size = list.size();
			if(size == 0 || list.get(size-1) != arr[i]) {
				list.add(arr[i]);
			}
		}

		int[] answer = new int[list.size()];


		return answer;
	}
}
