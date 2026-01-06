package inflearn_allinone;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Part3. 필수 자료구조 > 3. 올바른 괄호쌍
 */
public class Part3Test3 {

    public static void main(String[] args) {

        // String s = "[[[[((}}";
        String s = "[[{{}}()()]]";

        System.out.println(Solution1(s));
    }

    public static int Solution1(String s) {

        int answer = 0;

        Deque<Character> stack = new ArrayDeque<>();

        for(char c : s.toCharArray()) {
            if((c == '(') || (c == '{') || (c == '[')) {
                stack.push(c);
            }else {
                if(stack.isEmpty()) {
                    return -1;
                }

                if(((stack.peek() == '(') && (c == ')')) ||
                    ((stack.peek() == '{') && (c == '}')) ||
                    ((stack.peek() == '[') && (c == ']'))
                ) {
                    stack.pop();
                    answer++;
                }else {
                    return -1;
                }
            }
        }


        return (stack.isEmpty() ? answer : -1);
    }
}
