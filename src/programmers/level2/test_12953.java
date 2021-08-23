package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
    N개의 최소공배수
 */
public class test_12953 {
    public static void main(String[] args) {
        int[] arr = {2,6,8,14};
        System.out.println(solution(arr));
    }
    public static int solution(int[] arr) {
        int answer = 0;
        List<Integer> mock = new ArrayList<>();

        Arrays.sort(arr);
        int min=arr[0], max=arr[arr.length-1];

        for(int i=min; i<=max; i++) {
            boolean bool = false;
            for(int j=0; j<arr.length; j++) {
                // 나누어떨어지는지 판단
                if(arr[j]/i == 0) {
                    arr[i] /= i;
                    bool = true;
                }
            }
            if(bool == true) {
                // 몫 배열에 삽입
                mock.add(i);
            }
        }

        return answer;
    }

    public static int[] recur(int[] arr) {

        return arr;
    }
}
