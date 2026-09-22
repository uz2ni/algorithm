package leetcode;

/** 209. Minimum Size Subarray Sum **/
public class Minimum_Size_Subarray_Sum_209 {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(7, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 0;
        int answer = Integer.MAX_VALUE;
        int sum = nums[left];

        while(left <= right && right < nums.length) {
            if(target <= sum) {
                answer = Math.min(answer, right-left+1);
                System.out.println("sum: " + sum + ", answer : " + answer);
                sum-=nums[left];
                left++;
            }else {
                right++;
                if(right < nums.length) sum+=nums[right];
            }
        }
        return (answer == Integer.MAX_VALUE) ? 0 : answer;
    }
}
