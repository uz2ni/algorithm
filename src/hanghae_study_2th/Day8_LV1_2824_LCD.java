package hanghae_study_2th;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 24.5.27 (월)
 * [릿코드] LV1 - 2824. Count Pairs Whose Sum is Less than Target
 **/
public class Day8_LV1_2824_LCD {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(-6); // -6,2,5,-2,-7,-1,3
        nums.add(2);
        nums.add(5);
        nums.add(-2);
        nums.add(-7);
        nums.add(-1);
        nums.add(3);

        int target = -2;

        System.out.println(countPairs(nums, target));
    }
    public static int countPairs(List<Integer> nums, int target) {
        int answer = 0;
        for(int i=0; i<nums.size()-1; i++) {
            for(int j=i+1; j<nums.size(); j++) {
                if(nums.get(i) + nums.get(j) < target) {
                    answer++;
                }
            }
        }
        return answer;
    }
}
