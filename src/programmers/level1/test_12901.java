package programmers.level1;

import java.util.Calendar;

/*
	2016년
 */
public class test_12901 {
	public static void main(String[] args) {
	//	System.out.println(solution(5, 24)); // TUE
		System.out.println(solution2(5, 24));
	}

	// 1. Calendar API 이용
	public static String solution(int a, int b) { // 2016년 a월, b일 -> 요일 리턴
		String answer = "";
		String[] DAY = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2016);
		// 0:1월, 1:2월 ...
		cal.set(Calendar.MONTH, a-1);
		cal.set(Calendar.DATE, b);

		// 1:일요일, 2:월요일 ...
		int idx = cal.get(Calendar.DAY_OF_WEEK);

		answer = DAY[idx-1];
		return answer;
	}

	// 1. 계산법 이용
	public static String solution2(int a, int b) {
		// 2016. 1. 1 -> FRI
		String answer = "";
		int[] MONTH_PLUS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 2016년 2월은 윤달이라 29일
		String[] DAY = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
		int sum = 0;

		for(int i = 0; i<a-1; i++) {
			sum += MONTH_PLUS[i];
		}
		sum += (b-1);

		answer = DAY[sum%7];

		return answer;
	}
}
