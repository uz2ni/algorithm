package hanghae_study_2th;

import java.util.HashSet;

/**
 * 24.5.20 (월)
 * [프로그래머스] LV1 코딩테스트>해시 - 포켓몬
 */
public class Day1_LV1_1845 {

    public static void main(String[] args) {
        // int[] nums = {3,1,2,3};
//        int[] nums = {3,3,3,2,2,4};
        int[] nums = {3,3,3,2,2,2};

        System.out.println(solution(nums));
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int max = nums.length / 2;

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        answer = (max < set.size() ? max : set.size());

        return answer;
    }
}
