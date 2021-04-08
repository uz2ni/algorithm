package programmers;

import java.util.Calendar;

/*
	2016년
 */
public class test_12901 {
	public static void main(String[] args) {
		System.out.println(solution(5, 24)); // TUE
	}

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
}
