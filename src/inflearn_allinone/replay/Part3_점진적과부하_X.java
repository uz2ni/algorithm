package inflearn_allinone.replay;

import java.util.*;

public class Part3_점진적과부하_X {

    public static void main(String[] args) {
        // int[] weights = {1,7,2,9,5};
        int[] weights = {5,4,3,2,1};
        int[] answers = solution(weights);
        for(int i : answers) {
            System.out.print(i + " ");
        }
    }

    public static int[] solution(int[] weights) {
        int[] answer = new int[weights.length];
        Deque<int[]> stack = new ArrayDeque<>();

        for(int cur=0; cur<weights.length; cur++) {
            int w = weights[cur];
            while(!stack.isEmpty() && stack.peek()[1] < w) {
                int[] prevInfo = stack.pop();
                int prev = prevInfo[0];
                answer[prev] = cur - prev;
            }
            stack.push(new int[]{cur, w});
        }

        return answer;
    }
}
