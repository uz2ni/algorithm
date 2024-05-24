package hanghae_study_2th;

import java.util.ArrayList;

/**
 * 24.5.23 (목)
 * [프로그래머스] LV3 코딩테스트>스택/큐 - 주식가격
 *
 * - int[] prices : 주식 가격(초 단위로 기록)
 * - 가격이 떨어지지 않은 기간은 몇초?
 * - 주의: 해당 가격 이후 바로 떨어지지 않은 기간만 세야 함. 떨어졌다가 오르면 뒤 기간은 x
 */
public class Day4_LV3_42584 {

    public static void main(String[] args) {
        int[] prices = {1,2,3,2,3};
        int[] solution1 = solution1(prices);

        // print
        for(int i=0; i< solution1.length; i++) {
            System.out.print(solution1[i] + " ");
        }

    }

    /**
     * solution1 : 시간 복잡도 안좋음 O(n^2)
     */
    public static int[] solution1(int[] prices) {
        int[] answer = new int[prices.length];

        // 배열 돌면서 가격 같거나 늘면 +1 해서 결과에 담기
        for(int i=0; i<prices.length; i++) {
            int cnt = 0;
            for(int j=i+1; j< prices.length; j++) {
                cnt++;
                if(prices[i] > prices[j]) break;
            }
            answer[i] = cnt;
        }
        return answer;
    }
}
