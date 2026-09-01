package leetcode;

/** 11. Container With Most Water **/
public class Container_With_Most_Water_11 {

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
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
}
