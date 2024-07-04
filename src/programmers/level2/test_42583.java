package programmers.level2;

import java.util.*;

/** 42583
 * 코딩테스트 연습 > 스택/큐 > 다리를 지나는 트럭
 */
public class test_42583 {

    public static void main(String[] args) {
        int[] truck_weight = {7,4,5,6};
        System.out.println(solution(2, 10, truck_weight));
    }

    /**
     * 모든 트럭이 다리 건널 때 최소 몇초가 걸리냐
     * 트럭은 최대 bridge_length대 올라감
     * weight 이하 무게 견딜 수 있음
     *
     */
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int totalWeight = 0;
        Queue<Integer> bridgeQueue = new LinkedList<>(); // 다리 위의 트럭 상태를 저장하는 큐

        // 다리를 빈 공간으로 초기화
        for(int i=0; i<bridge_length; i++) {
            bridgeQueue.add(0);
        }

        for (int truck : truck_weights) {
            while (!bridgeQueue.isEmpty()) {
                totalWeight -= bridgeQueue.poll(); // 다리에서 트럭을 하나 빼고

                time++; // 시간 증가

                if (totalWeight + truck <= weight) { // 새로운 트럭을 올릴 수 있으면
                    bridgeQueue.add(truck); // 다리에 트럭 추가
                    totalWeight += truck; // 다리 위의 무게 갱신
                    break;
                } else {
                    bridgeQueue.add(0); // 다리에 빈 공간 추가
                }
            }
        }

        // 모든 트럭이 다리를 건넜으므로 마지막 트럭이 다리를 완전히 건너는 시간을 더해줌
        time += bridge_length;
        return time;
    }
}
