package hanghae_study_2th;

import java.util.*;

/**
 * 24.5.27 (월)
 * [프로그래머스] LV2 코딩테스트>정렬 - H-Index
 **/
public class Day8_LV2_42747 {
    public static void main(String[] args) {
        int[] citiations = {3, 0, 6, 1, 5};
        System.out.println(solution(citiations));
    }

    public static int solution(int[] citations) {
        int cnt = 0; // 논문 몇편 이상인지 카운팅
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i< citations.length; i++) {
            pq.add(citations[i]);
        }

        for(int h=citations.length; h>=0; h--) { // h(답)은 논문 개수 이하여야 함. 논문 개수~0 까지 반복문 가능
            while(!pq.isEmpty() && h <= pq.peek()) { // h 이상인 경우의 논문만 큐에서 빼고 카운팅
                pq.poll();
                cnt++;
            }
            if(h <= cnt) { // h가 카운팅보다 작거나 같아지는 시점이 최대값이므로 리턴
                return h;
            }
        }
        return 0;
    }
}

/* 솔루션 2
import java.util.Arrays;
class Solution {
    public int solution(int[] citations) {
       int answer = 0;

        // 1. 정렬하기
        Arrays.sort(citations);

        // 2. 기준 둘 최대값 찾기
        int citLen = citations.length;
        int size = (citLen < citations[citLen-1]) ? citLen : citations[citLen-1];
        int[] memories = new int[size+1]; // 기록용
        int point = citations.length-1; // 가장 끝 인덱스로 초기화

        while(size > 0) {
            if(size < citations.length) memories[size] = memories[size+1];
            while(point >= 0) {
                if(citations[point] < size) break;
                memories[size]++;
                point--;
            }
            // 판단
            if(size > memories[size]) {
                size--;
                continue;
            } else {
                answer = size;
                break;
            }
        }

        return answer;
    }
}
 */