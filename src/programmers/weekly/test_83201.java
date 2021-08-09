package programmers.weekly;

import java.util.Arrays;

public class test_83201 {
    public static void main(String[] args) {
        int[][] scores = {{70,49,90},{68,50,38},{73,31,100}};
        System.out.println(solution(scores));

    }
    public static String solution(int[][] scores) {
        String answer = "";
        long[] avgArr = new long[scores.length];

        // 본인이 준 본인의 점수가 유일한 최저/최대일 경우 계산에서 제외
        for(int i=0; i<scores.length; i++) {
            int[] myScore = new int[scores.length];
            long selfScore = scores[i][i];
            long total = 0;
            for (int j = 0; j < scores.length; j++) {
                myScore[j] = scores[j][i];
                total += scores[j][i];
            }
            Arrays.sort(myScore);
            // 유일한 최대/최소인 경우 본인 점수 제외
            long len = scores.length;
            if ((myScore[0] == selfScore && myScore[1] != selfScore)
                    || (myScore[myScore.length - 1] == selfScore && myScore[myScore.length - 2] != selfScore)) {
                total -= selfScore;
                len--;
            }
            // 평균 내기
            avgArr[i] = total/len;
        }
        // 학점 내기
        answer = getGrade(avgArr);

        return answer;
    }

    static public String getGrade(long[] average) {
        String grade = "";
        for(int i=0; i< average.length; i++) {
            if(90 <= average[i]) grade = grade + "A";
            else if(80 <= average[i] && average[i] < 90) grade = grade + "B";
            else if(70 <= average[i] && average[i] < 80) grade = grade + "C";
            else if(50 <= average[i] && average[i] < 70) grade = grade + "D";
            else grade = grade + "F";
        }

        return grade;
    }
}
