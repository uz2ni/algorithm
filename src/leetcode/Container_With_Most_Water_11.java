package leetcode;

/** 11. Container With Most Water **/
public class Container_With_Most_Water_11 {

    public static void main(String[] args) {
        System.out.println(maxArea2(new int[]{1,8,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {

        int left = 0, right = height.length-1;
        int max = 0;

        while(left < right) {

            int w = right-left;
            int h = Math.min(height[left], height[right]);
            max = Math.max(max, w*h);

            if(height[left] < height[right]) {
                left++;
            }else {
                right--;
            }

        }

        return max;
    }

    public static int maxArea2(int[] height) {
        int answer = 0;
        int left = 0;
        int right = height.length-1;

        while(left < right) {
            if(height[left] < height[right]) {
                answer = Math.max(answer, (right-left) * height[left]);
                left++;
            }else {
                answer = Math.max(answer, (right-left) * height[right]);
                right--;
            }
        }
        return answer;
    }
}
