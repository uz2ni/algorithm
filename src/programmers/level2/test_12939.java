package programmers.level2;

import java.util.*;

/*
    최댓값과 최솟값
 */
public class test_12939 {
    public static void main(String[] args) {
        String s = "-1 -1";
        System.out.println(solution(s));
    }
    static public String solution(String s) {
        // 1. s를 split 한다.
        String[] split = s.split(" ");

        // 2. 배열 원소를 리스트에 넣는다. (자동 정렬됨)
        List<Integer> ts = new ArrayList<>();
        for(int i=0; i<split.length; i++) {
            ts.add(Integer.parseInt(split[i]));
        }
        // 3. 정렬
        ts.sort(Comparator.naturalOrder());

        return ts.get(0) + " " + ts.get(ts.size()-1);
    }
}
