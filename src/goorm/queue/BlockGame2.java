package goorm.queue;

import java.io.*;
import java.util.*;

/**
 * [구름] LV2. 블록 게임 (오빠 풀이)
 */
public class BlockGame2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String strMove = br.readLine();
        String strNum[] = strMove.split(" ");

        Stack<Node> st = new Stack<>();

        // 초기화
        int x = 0;
        int y = 0;
        st.push(new Node(0,0,1));

        for(int i=0; i<n; i++) {
            char move = str.charAt(i);
            int num = Integer.parseInt(strNum[i]);

            if(move == 'R') {
                y += 1;
            }else if(move == 'L') {
                y -= 1;
            }else if(move == 'U') {
                x -= 1;
            }else { // 'D'
                x += 1;
            }

            // 놓여있는 블럭인지 확인
            checkVisited(x, y, st);
            st.push(new Node(x,y,num));
        }

        // 정답 계산
        int result = 0;
        while(!st.isEmpty()) {
            result += st.pop().num;
        }

        System.out.println(result);
    }

    public static void checkVisited(int x, int y, Stack<Node> st) {
        Stack<Node> st2 = new Stack<>();
        while(!st.isEmpty()) {
            Node n = st.pop();

            if(n.x == x && n.y == y) {
                // 방문한 적이 있는 곳이라면 현재까지 방문한것을 이미 다 제거했다
                return;
            }

            st2.add(n);
        }

        // 방문한 적이 없다면 원복 시킨다
        while(!st2.isEmpty()) {
            st.add(st2.pop());
        }
    }

    public static class Node{
        int x;
        int y;
        int num;

        public Node(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

}
