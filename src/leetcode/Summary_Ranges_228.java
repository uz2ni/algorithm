package leetcode;

import java.util.ArrayList;
import java.util.List;

/** 228. Summary Ranges **/
public class Summary_Ranges_228 {

    public static void main(String[] args) {
        // List<String> answers = summaryRanges(new int[]{0,1,2,4,5,7});
        List<String> answers = summaryRanges(new int[]{0,2,3,4,6,8,9}); // "0","2->4","6","8->9"

        System.out.println(answers.toString());
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> answers = new ArrayList<>();

        int left = 0, right = 0;
        while(right < nums.length) {
            // right 다음 이동 가능하고, 연속 구간이라면 -> right++
            if(right+1 < nums.length && (nums[right+1]-nums[right] == 1)) {
                right++;
            }else {
                if(left == right) {
                    answers.add(String.valueOf(nums[left]));
                }else {
                    answers.add(nums[left] + "->" + nums[right]);
                }
                right++;
                left = right;
            }
        }

        return answers;
    }
}
