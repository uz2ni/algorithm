package programmers;

/*
	체육복
 */
public class test_42862 {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2,4};
		int[] reserve = {3};
		solution(n,lost,reserve);
	}

	static public int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;

		// 여벌체육복가져온 학생이 도난당했을 경우 빌려줄 수 없다. // point: 이 과정 먼저해야함
		for(int i=0; i<lost.length; i++) {
			for(int j=0; j< reserve.length; j++) {
				if(lost[i] == reserve[j]) {
					lost[i] = reserve[j] = -1; // point: list[i], reserve[i] 둘다 -1 (잃어버린것(lost)을 상쇄시키고 빌려주지(reserve) 못하도록 둘다 -1)
					answer++; // lost에서 제외되므로 answer 증가
					break;
				}
			}
		}

		// 도난당한 학생의 왼,오른쪽 번호 학생만 여벌 체육복을 빌려줄 수 있다.
		for(int i=0; i<lost.length; i++) {
			for(int j=0; j< reserve.length; j++) {
				if(reserve[j] == lost[i]-1 || reserve[j] == lost[i]+1) {
					reserve[j] = -1;
					answer++;
					break;
				}
			}
		}
		System.out.println(answer);

		return answer;
	}

}
