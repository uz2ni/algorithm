package programmers;

public class test_12903 {
	/*
	 * 가운데 글자 가져오기
	 */
	public static void main(String[] args) {
		String s = "qwemrd";
		System.out.println(solution(s));
	}

	public static String solution(String s) {
		int length = s.length();
		int mid = s.length()/2;
		return length%2 == 0 ? s.substring(mid-1,mid+1) : s.substring(mid, mid+1);
	}

}