package inflearn_allinone;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Part3. 필수 자료구조 > 4. 점진적 과부하
 */
public class Part3Test4_x {

    public static void main(String[] args) {

        // int[] weights = {25, 23, 31, 28, 25, 25, 27, 29};
        int[] weights = {45, 42, 50, 48, 46, 52, 49};
        int[] answers = solution1(weights);

        for(int i=0; i<answers.length; i++) {
            System.out.print(answers[i] + " ");
        }

    }

    /**
     * 완전 탐색
     * 시간복잡도: O(N^2) 시간초과
     */
    public static int[] solution1(int[] weights) {

        int[] answers = new int[weights.length];

        for(int i=0; i<weights.length; i++) {
            int cnt = 0;
            for(int j=i+1; j<weights.length; j++) {
                cnt++;
                if(weights[i] < weights[j]) {
                    answers[i] = cnt;
                    break;
                }
            }
        }
        return answers;
    }

    /**
     * 단조 스택
     * 시간복잡도: O(N)
     */
    public static int[] solution2(int[] weights) {

        int[] answers = new int[weights.length];
        Deque<int[]> stack = new ArrayDeque<>();

        for(int cur=0; cur<weights.length; cur++) {
            int w = weights[cur];
            while(!stack.isEmpty() && (stack.peek()[1] < w)) {
                int[] top = stack.pop();
                answers[top[0]] = cur - top[0];
            }
            stack.push(new int[]{cur, w});
        }

        return answers;
    }
}
