package inflearn_allinone.replay;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 완전 탐색 > 두 요소의 합이 target인 인덱스 반환
 */
public class Part3_무료행사 {
    public static void main(String[] args) {
        // solution1
        int[] nums = {7,1,2,3,6};
        int target = 10;

        int[] result = solution(nums, target);
        System.out.print("result1: ");
        for(int r : result) {
            System.out.print(r + " ");
        }

        System.out.println();

        // solution2
        int[] nums2 = {7,1,4,3,6};
        int target2 = 10;

        int result2 = solution2(nums2, target2);
        System.out.println("result2: " + result2);
    }

    // HashMap 사용, O(N)
    public static int[] solution(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) { // O(N) -> nums 길이
            int need = target - nums[i];
            if(map.containsKey(need)) { // O(1)
                return new int[]{map.get(need), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1,-1};
    }

    // 정렬 + two pointer, O(NLogN)
    // 반환: 모든 경우의 수
    public static int solution2(int[] nums, int target) {
        int cnt = 0;

        // 시간순 정렬 O(NLogN)
        Arrays.sort(nums);

        int left = 0;
        int right = nums.length-1;

        while(left < right) {
            int sum = nums[left] + nums[right];

            if(sum == target) {
                cnt++;
                left++;
                right--;
                continue;
            }

            if(sum < target) {
                left++;
            }else {
                right--;
            }
        }

        return cnt;
    }
}
