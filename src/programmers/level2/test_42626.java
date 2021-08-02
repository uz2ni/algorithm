package programmers.level2;

import javax.jnlp.IntegrationService;
import java.util.PriorityQueue;

/*
    더 맵게
 */
public class test_42626 {
    public static void main(String[] args) {
        int[] scoville = {1,2,3,9,10,12};
        int k = 7;
        System.out.println(solution(scoville, k));
    }
    static public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> p = new PriorityQueue<>();

        for(int i=0; i<scoville.length; i++) {
            p.add(scoville[i]);
        }

        while(p.peek() < K && p.size() > 1) {
            int newScov = p.poll() + (p.poll() * 2);
            p.add(newScov);
            answer++;
        }

        if(p.peek() < K) return -1;

        return answer;
    }
}
