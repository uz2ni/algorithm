package goorm.queue;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * [구름] LV2. 블록 게임 (내 풀이)
 */
public class BlockGame {

    public static class Block {
        int x;
        int y;
        int weight;
        public Block(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] where = br.readLine().split("");
        int[] weight = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Stack<Block> stack1 = new Stack();
        Stack<Block> stack2 = new Stack();
        int x = 0; // 현재 정점 x
        int y = 0; // 현재 정점 y
        int sum = 0; // 결과

        // 0, 0 넣기
        stack1.push(new Block(0,0,1));
//
        for(int i=0; i<n; i++) {
            boolean found = false; // false: 스택에 동일 좌표 없는 경우 / true: 있는 경우
            if("R".equals(where[i])) {
                y += 1;
            }else if("L".equals(where[i])) {
                y -= 1;
            }else if("U".equals(where[i])) {
                x -= 1;
            }else { // 'D'
                x += 1;
            }

            // 찾으면 동일 좌표까지 빼고, 스택2 비우기
            while(!stack1.isEmpty()) {
                // 스택1에서 빼면서 현재 좌표가 있는지 체크
                Block now = stack1.pop();
                if((now.x == x) && (now.y == y)) {
                    stack2.clear();
                    stack1.push(new Block(x, y, weight[i]));
                    found = true;
                    break;
                }else { // 없는 블럭이면 스택2에 넣기
                    stack2.push(now);
                }
            }
            // 스택1 비웠으면 스택2 -> 스택1 옮기기
            while(!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }

            // 현재 좌표 존재했다면, 스택1에 현재 좌표 넣기
            if(!found) {
                stack1.push(new Block(x, y, weight[i]));
            }

        }

        // 남은 스택 합산
        while(!stack1.isEmpty()) {
            sum += stack1.pop().weight;
        }

        System.out.println(sum);

    }


}
