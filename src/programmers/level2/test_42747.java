package programmers.level2;

import java.util.Arrays;

/*
    H-index (자체풀이성공, 다른풀이이해X)
 */
public class test_42747 {
    public static void main(String[] args) {
        int[] citations = {0, 0, 0, 0, 0};
        System.out.println(solution(citations));
    }
    public static int solution(int[] citations) {
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

    public static int solution2(int[] citations) {
        int answer = 0;

        // 0 1 3 5 6
        Arrays.sort(citations);

        // n편 중 h번 이상 인용된 논문이 h편 이상 일때 h의 최댓값이 h-index
        int h;
        for(int i=0; i<citations.length; i++){

            // i일때 가장 큰 h값(논문 편수)
            h = citations.length-i;

            // 논문 인용횟수가 h 이상인지 확인
            if(citations[i] >= h){
                answer = h;
                break;
            }
        }

        return answer;
    }


}
