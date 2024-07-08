package programmers.level2;

/** 42842
 * 코딩테스트 연습 > 완전탐색 > 카펫
 */
public class test_42842_X {

    public static void main(String[] args) {
        int[] result = solution(24,24);
        System.out.println(result[0] + ", " + result[1]);
    }

    public static int[] solution(int brown, int yellow) {
        int answer[] = new int[2]; // 가로, 세로

        int sum = brown + yellow;

        for(int i=3; i<sum; i++) { // 세로 3 이상
            int j = sum / i; // i:세로, j:가로

            if((sum % i != 0) || (j < 3)) continue; // 가로 3 이하이면 해당 X

            // 옐로우 크기가 일치하면 리턴
            if(((j-2)*(i-2)) == yellow) {
                answer[0] = j;
                answer[1] = i;
                return answer;
            }
        }

        return answer;
    }

}
