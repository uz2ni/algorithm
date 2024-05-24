package hanghae_study_2th;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 24.5.24 (금)
 * [프로그래머스] LV3 코딩테스트>힙 - 더 맵게
 *
 * 모든 음식이 스코빌 지수 k 이상 될 때까지 반복해서 섞기
 * 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
 * 최소 섞는 횟수 리턴
 */
public class Day5_LV2_42626 {

    public static void main(String[] args) {
        int[] scoville = {12, 2, 3, 9, 10, 12};
        int k = 7;
        System.out.println(solution2(scoville, k)); // 2
    }

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        // 1. 우선순위큐 요소 넣기 (최소힙)
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++) {
            minQueue.add(scoville[i]);
        }

        // 2. 힙에 값이 없을 때 까지 반복
        while(!minQueue.isEmpty()) {
            if(minQueue.peek() >= K) { // 2-1. 요소가 K 이상이면 뺀다 (안섞음)
                minQueue.poll();
            }else {                     // 2-2. 요소가 K 미만이면
                // 2-2-1. 요소 1개라면, return -1
                if(minQueue.size() < 2) return -1;
                else {
                    // 2-2-2. 최소 2개라면, 섞고 횟수+1
                    minQueue.add(minQueue.poll() + (minQueue.poll() * 2));
                    answer++;
                }
            }
        }

        return answer;
    }

    public static int solution2(int[] scoville, int K) {
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
