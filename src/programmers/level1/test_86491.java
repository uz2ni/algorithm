package programmers.level1;

import java.util.Arrays;

/** 86491
 * 코딩테스트 연습 > 완전탐색 > 최소직사각형
 */
public class test_86491 {

    public static void main(String[] args) {

        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int result = solution(sizes);
        System.out.println(result);
    }

    // 참고 코드 (채점 성공)
    public static int solution(int[][] sizes) {

        // 초기화 주의 : 가로 세로 중 최대값이 가로여야 하므로, 단순히 sizes의 첫번째 값들을 넣으면 안된다.
        int widthMax = 0;
        int heightMax = 0;

        for(int i=0; i< sizes.length; i++) {
            // 가로,세로 중 더 큰값
            int width = Math.max(sizes[i][0], sizes[i][1]);
            int height = Math.min(sizes[i][0], sizes[i][1]);

            widthMax = Math.max(widthMax, width);
            heightMax = Math.max(heightMax, height);
        }

        return widthMax * heightMax;
    }


    // 내 코드 (채점 실패)
    public static int solutionX(int[][] sizes) {

        // 최소값 rows, cols 세팅
        int[] rows = new int[sizes.length];
        int[] cols = new int[sizes.length];
        for(int i=0; i<sizes.length; i++) {
            rows[i] = sizes[i][0];
            cols[i] = sizes[i][1];
        }
        Arrays.sort(rows);
        Arrays.sort(cols);

        for(int i=0; i<rows.length; i++) {
            for(int j=0; j<cols.length; j++) {
                if(!rowColCheck(sizes, rows[i], cols[j])) {
                    continue;
                }
                return rows[i] * cols[j];
            }
        }

        return -1;
    }

    private static boolean rowColCheck(int[][] sizes, int row, int col) {

        for(int i=0; i< sizes.length; i++) {
            int caseRow = sizes[i][0];
            int caseCol = sizes[i][1];

            if(caseRow <= row && caseCol <= col) {
                continue;
            }else if(caseRow <= col && caseCol <= row) {
                continue;
            }else {
                return false;
            }
        }

        return true;
    }
}
