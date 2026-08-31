package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** 56. Merge Intervals **/
public class Merge_Intervals_56 {

    public static void main(String[] args) {
        int[][] intervals = {{8,10},{15,18},{1,3},{2,6}};
        int[][] result = merge(intervals);
        for(int i=0; i<result.length; i++) {
            System.out.println(result[i][0] + ", " + result[i][1]);
        }
    }

    public static int[][] merge(int[][] intervals) {
        // 1. intervals 오름차순(0->1) 정렬
        Arrays.sort(intervals, (a, b) -> {
           if(a[0] == b[0]) {
               return a[1]-b[1];
           }else {
               return a[0]-b[0];
           }
        });

        // 2. before 구간의 right >= after 구간의 left 이면 겹침
        List<int[]> answerList = new ArrayList<>();
        int[] before = intervals[0];

        int i = 1;
        while(i < intervals.length) {
            int[] after = intervals[i];

            if(before[1] >= after[0]) {
                // before 합쳐서 병합
                before = new int[]{before[0], Math.max(before[1], after[1])};
            }else {
                // before 리스트에 삽입
                answerList.add(before);
                // before은 다음 위치 저장
                before = after;
            }
            i++;
        }

        // 마지막 구간 저장
        answerList.add(before);

        int[][] answers = answerList.toArray(new int[answerList.size()][]);

        return answers;
    }
}
