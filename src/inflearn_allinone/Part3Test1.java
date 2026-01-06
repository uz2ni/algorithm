package inflearn_allinone;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Part3. 필수 자료구조 > 1. 무료행사
 */
public class Part3Test1 {

    public static void main(String[] args) {

        int[] prices = {4,1,9,7,5,3,16};
        int target = 14; // answer: 1

//        int[] prices = {2, 1, 5, 7};
//        int target = 14; // answer: 0


        int answer = Solution3(prices, target);

        System.out.println("==============");
        System.out.println(answer);

    }

    /**
     * Solution1. 완전 탐색
     * 시간복잡도: O(N^2) -> 시간초과
     */
    public static int Solution1(int[] prices, int target) {

        int answer = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (target == (prices[i] + prices[j])) {
                    System.out.println(i + ", " + j);
                    answer++;
                }
            }
        }

        return answer;
    }

    /**
     * Solution2. 정렬 + two pointer
     * 시간복잡도: O(NLogN)
     */
    public static int Solution2(int[] prices, int target) {

        int answer = 0;

        // 정렬
        Arrays.sort(prices);

        int first = 0;
        int last = prices.length - 1;

        while (first < last) {

            int sum = prices[first] + prices[last];

            if (target > sum) {
                first++;
            }else if (target < sum) {
                last--;
            }else {
                answer++;
                // 같은 쌍 쓰지 않도록 투 포인터 모두 이동
                first++;
                last--;
            }
        }

        return answer;
    }

    /**
     * Solution3. 해시테이블(해시셋)
     * 시간복잡도: O(N)
     * 설명: 전체 요소를 모두 set에 넣고 체크하는 경우 중복/동일값 존재, 중복 카운팅 발생.
     *      요소 돌면서 값 찾지 못하는 경우만 현재 요소 add 하기.
     */
    public static int Solution3(int[] prices, int target) {

        int answer = 0;
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<prices.length; i++) {
            if(set.contains(target-prices[i])) {
                answer++;
            }else {
                set.add(prices[i]);
            }
        }

        return answer;

    }
}
