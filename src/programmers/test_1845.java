package programmers;

import java.util.HashSet;
import java.util.Set;

/*
    폰켓몬
    nums 중 N/2 를 뽑는데 중복되지 않는 최대 갯수를 구해라.
 */
public class test_1845 {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,2}; // answer: 2
        System.out.println(solution(nums));
    }
    static public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int half = nums.length/2;
        for(int n : nums) { set.add(n); }
        return set.size() <= half ? set.size() : half;
    }
}
