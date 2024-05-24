package hanghae_study_2th;

import java.util.Stack;

/**
 * 24.5.23 (목)
 * [프로그래머스] LV2 코딩테스트>스택/큐 - 올바른 괄호
 *
 * 1. () 짝으로 잘 이루어져있는 문자열 true
 */
public class Day4_LV2_12909 {

    public static void main(String[] args) {
        System.out.println(solution2("())(()"));
    }

    public static boolean solution(String s) {

        // 문자를 하나씩 스택에 넣는다
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            // 마지막 넣은 문자와 대상 문자를 비교해서 괄호쌍()이면 넣은 문자는 pop
            if(!stack.isEmpty() && (stack.peek() == '(') && (s.charAt(i) == ')')) {
                stack.pop();
            }else { // 빈 스택이거나 괄호쌍이 아니면 push
                stack.push(s.charAt(i));
            }
        }

        // 스택에 아무것도 없으면 쌍이 다 이루어진것으로 판단하고 true
        return stack.isEmpty();
    }

    public static boolean solution2(String s) {

        boolean answer = true;

        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char str = s.charAt(i);
            if(str == '(') {
                stack.add(1);
            }else if(stack.empty()) {
                return false;
            }else {
                stack.pop();
            }
        }

        return answer;
    }
}
