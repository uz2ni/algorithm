package programmers.topkit.stackqueue;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 스택/큐 > 프로세스
 */
public class Test42587 {

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities, location));
    }

    /**
     * 개선 방안: 실행한 큐를 모아둔 process queue 필요 없음. 프로세스 실행 시 바로 answer++ 시키고, location과 같은 프로세스인지 판단하여 리턴하면 됨
     */
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<int[]> queue = new ArrayDeque<>(); // [index,weight]

        for(int i=0; i<priorities.length; i++) {
            queue.add(new int[]{i, priorities[i]});
        }

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            boolean check = false;

            // 남은 큐에 우선순위 높은 값 있는지 체크
            for(int[] q : queue) {
                if(cur[1] < q[1]) {
                    check = true;
                    break;
                }
            }

            if(check) { // 꺼낸게 우선순위 낮은 경우 뒤에 추가
                queue.offer(cur);
            }else {
                answer++;
                if(cur[0] == location) return answer;
            }

        }

        return -1;
    }
}
