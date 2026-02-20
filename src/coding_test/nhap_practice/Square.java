package coding_test.nhap_practice;

import java.util.HashSet;
import java.util.Set;

/**
 * 정사각형 나머지 꼭지점 구하기
 * int[][] v : 꼭지점 3개
 */
public class Square {

    public static void main(String[] args) {
        int[][] v = {{1,4},{3,4},{3,10}};
        int[] result = solution(v);
        System.out.println(result[0] + ", " + result[1]);
    }

    public static int[] solution(int[][] v) {
        int[] answer = new int[2];

        Set<Integer> xSet = new HashSet<>();
        Set<Integer> ySet = new HashSet<>();

        for(int i=0; i<3; i++) {
            if(!xSet.add(v[i][0])) {
                xSet.remove(v[i][0]);
            }

            if(!ySet.add(v[i][1])) {
                ySet.remove(v[i][1]);
            }
        }

        answer[0] = xSet.iterator().next();
        answer[1] = ySet.iterator().next();

        return answer;
    }
}
