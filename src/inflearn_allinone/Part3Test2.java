package inflearn_allinone;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Part3. 필수 자료구조 > 2. 올바른 소괄호쌍
 */
public class Part3Test2 {

    public static void main(String[] args) {

        // String s = "(())(((())";
        String s = "(((())))()(())";
        // String s = ")))))";

        int answer = Solution2(s);

        System.out.println(answer);
    }

    /**
     * Stack 사용
     */
    public static int Solution1(String s) {

        int answer = 0;

        Deque<Integer> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {

            if('(' == c) {          // '(' 인 경우 push
                stack.push(1);
            }else if(')' == c) {
                if(!stack.isEmpty()) { // ') 인 경우 스택 안비어있으면 pop, answer++
                    stack.pop();
                    answer++;
                }else {                   // ')' 인 경우 스택 비어있으면 return -1
                    return -1;
                }
            }

        }

        if(!stack.isEmpty()) {
            return -1;
        }

        return answer;
    }


    /**
     * int 개수로 처리
     */
    public static int Solution2(String s) {

        int answer = 0;
        int pointer = 0;

        for(char c : s.toCharArray()) {

            if('(' == c) {          // '(' 인 경우 push
                pointer++;
            }else if(')' == c) {
                if(pointer > 0) { // ') 인 경우 스택 안비어있으면 pop, answer++
                    pointer--;
                    answer++;
                }else {                   // ')' 인 경우 스택 비어있으면 return -1
                    return -1;
                }
            }
        }

        if(pointer > 0) {
            return -1;
        }

        return answer;
    }
}
