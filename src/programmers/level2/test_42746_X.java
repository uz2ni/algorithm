package programmers.level2;

import java.util.ArrayList;
import java.util.List;

/*
    가장 큰 수
 */
public class test_42746_X {
    static List<Integer> list = new ArrayList();
    public static void main(String[] args) {
        int[] numbers = {3, 30, 34, 5, 9};
        System.out.println(solution(numbers));
    }
    static public String solution(int[] numbers) {
        int max;

        // 1. 주어진 정수로 경우의 수 List add
        int[] output = new int[numbers.length];
        boolean[] visited = new boolean[numbers.length];
        perm(numbers, output, visited, 0, numbers.length, numbers.length);

        // 3. 최대값 셋팅
        max = list.get(0);
        for(int i=1; i<list.size(); i++) {
            if(max<list.get(i)) max = list.get(i);
        }

        return String.valueOf(max);
    }

    // 순열 (순서를 지키면서 n 개중에서 r 개를 뽑는 경우)
    // 사용 예시: perm(arr, output, visited, 0, n, 3);
    static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            String str = "";
            for(int i=0; i<output.length; i++) {
               str = str + output[i];
            }
            //System.out.println(str);
            // 2. 문자열->숫자 변환 후 add
            list.add(Integer.parseInt(str));
            return;
        }

        for (int i=0; i<n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                //output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;
            }
        }
    }


}
