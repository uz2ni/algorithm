package programmers;

import java.util.Stack;

/*
    크레인 인형뽑기 게임
 */
public class test_64061 {

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        // moves의 값을 열로 하는 최상위 행의 값을 선택한다.
        for(int i=0; i<moves.length; i++) {

            int m = moves[i]-1;
            int size = board[0].length;

            for(int j=0; j<size; j++) {
                int data = board[j][m];
                if(data != 0) {
                    // 선택된 값과 스택의 top값을 비교하여, 같으면 pop하고 answer+1 / 다르면 push
                    if(stack.isEmpty()){
                        stack.push(data);
                    }else if(stack.peek() == data) {
                        stack.pop();
                        answer++;
                    }else {
                        stack.push(data);
                    }

                    break;
                }
            }
        }
        return answer;
    }
}
