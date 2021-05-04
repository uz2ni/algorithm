package programmers.level1;

import java.util.Arrays;

/*
    예산
 */
public class test_12982 {
    public static void main(String[] args) {
        int[] d = {2,2,3,3};
        int budget = 10;
        System.out.println(solution(d, budget));
    }
    static public int solution(int[] d, int budget) {
        int answer = 0;
        int sum = 0;

        Arrays.sort(d);
        for(int i=0; i<d.length; i++) {
            sum+=d[i];
            if(sum > budget) {
                break;
            }
            answer++;
        }

        return answer;
    }
}
