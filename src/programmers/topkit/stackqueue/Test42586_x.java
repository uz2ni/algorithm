package programmers.topkit.stackqueue;

import java.util.*;

/**
 * 스택/큐 > 기능개발
 */
public class Test42586_x {

    public static void main(String[] args) {
//        int[] progresses = {93, 30, 55};
//        int[] speeds = {1, 30, 5};
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        int[] answers = solution(progresses, speeds);
        for(int a : answers) {
            System.out.print(a + " ");
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> answerList = new ArrayList<>();
        int[] answers;

        for(int i=0; i<progresses.length; i++) {
            int n = ((100-progresses[i])%speeds[i]) == 0 ? ((100-progresses[i])/speeds[i]) : ((100-progresses[i])/speeds[i]) + 1;
            queue.offer(n);
        }

        while(!queue.isEmpty()) {

            int q = queue.poll();
            int cnt = 1;

            while(!queue.isEmpty() && (queue.peek() <= q)) {
                queue.poll();
                cnt++;
            }
            answerList.add(cnt);
        }

        answers = answerList.stream().mapToInt(Integer::intValue).toArray();

        return answers;
    }
}
