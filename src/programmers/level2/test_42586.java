package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    기능 개발
 */
public class test_42586 {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] result = solution(progresses,speeds);
        for(int r : result) {
            System.out.print(r + ", ");
        }
    }
    static public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // days 계산
        for(int i=0; i<progresses.length; i++) {
            int day = ((100 - progresses[i]) % speeds[i] == 0 ? (100 - progresses[i]) / speeds[i] : ((100 - progresses[i]) / speeds[i]) + 1);
            queue.add(day);
        }

        while(!queue.isEmpty()) {
            int q = queue.poll();
            int cnt = 1;

            while(!queue.isEmpty() && (q >= queue.peek())) {
                queue.remove();
                cnt++;
            }
            result.add(cnt);
        }

        int[] answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
