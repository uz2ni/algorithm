package programmers.level1;

import java.util.*;

public class test_68644 {
	/*
	 * 두 개 뽑아 더하기
	 */

	public static void main(String[] args) {
		long start = System.currentTimeMillis();

		int[] numbers = {2,1,3,4,1,2,5,7,3,1,4,2};
		//int[] numbers = {5,0,2,7};

		int[] result = solution2(numbers);

		for(int i=0; i<result.length; i++) {
			System.out.print(result[i] + ", ");
		}

		long end = System.currentTimeMillis();

		System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초"); //최종 실행시간

	}

	// ArrayList
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

	// TreeSet
	// 장점 : 정렬하면서 set에 추가된다. 중복은 무시된다.
	// 단점 : ArrayList 보다 실행 시간 느리다.
	public static int[] solution2(int[] numbers) {
		Set<Integer> list = new TreeSet<>();

		for(int i=0; i<numbers.length; i++) {
			for(int j=i+1; j<numbers.length; j++) {
				list.add(numbers[i] + numbers[j]);
			}
		}

		int[] result = new int[list.size()];
		int cnt = 0;

		Iterator<Integer> ir = list.iterator();
		while(ir.hasNext()) {
			result[cnt++] = ir.next();
		}

		return result;

	}

}
