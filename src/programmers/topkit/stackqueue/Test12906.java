package programmers.topkit.stackqueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 스택/큐 > 같은 숫자는 싫어
 */
public class Test12906 {

    public static void main(String[] args) {

        int[] arr = {4,4,4,3,3};

        int[] answers = solution(arr);
        for(int i=0; i<answers.length; i++) {
            System.out.print(answers[i] + " ");
        }

    }

    /**
     * 큐 (구현은 O, 구지 불필요한 방식)
     */
    public static int[] solution(int[] arr) {
        int answers[];
        Queue<Integer> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for(int a : arr) {
            queue.offer(a);
        }

        while(!queue.isEmpty()) {
            int q = queue.poll();
            list.add(q);

            while(!queue.isEmpty() && (queue.peek()==q)) {
                queue.poll();
            }
        }

        answers = list.stream().mapToInt(Integer::intValue).toArray();

        return answers;
    }

    /**
     * 앞의 값 기준으로 넣는 방식
     */
    public static int[] solution2(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {
            if((i == 0) || (list.get(list.size()-1) != arr[i-1])) {
                list.add(arr[i]);
            }
        }

        int[] answers = list.stream().mapToInt(Integer::intValue).toArray();
        return answers;
    }
}
