package coding_test.linetech_2021;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class test01 {
    public static void main(String[] args) {
//        String[] records = {"P 300 6", "P 500 3", "S 1000 4", "P 600 2", "S 1200 1"};
//        String[] records = {"P 300 6", "P 500 3", "S 1000 4", "P 600 1", "S 1200 2"};
        String[] records = {"P 100 4", "P 300 9", "S 1000 7", "P 1000 8", "S 700 7", "S 700 3"};

        int[] answer = solution(records);

        System.out.println("===== 결과 =====");
        System.out.print(answer[0] + " " + answer[1]);
    }
    // P:구매, S:판매
    public static int[] solution(String[] records) {
        int[] result = new int[2];
        result[0] = fifo(records);
        result[1] = bifo(records);
        return result;
    }
    public static int fifo(String[] records) {
        Queue<Integer> q = new LinkedList<>();
        int result = 0;

        for(int i=0; i<records.length; i++) {
            // 1. split
            String[] record = records[i].split(" ");
            String ch = record[0]; // P or S
            int money = Integer.parseInt(record[1]);
            int size = Integer.parseInt(record[2]);

            // 2. 구매일 경우 q 에 저장
            if(ch.equals("P")) {
                System.out.println("구입");
                // 2-1. 상품 갯수만큼 저장
                for(int j=0; j<size; j++) {
                    q.add(money);
                }
            }else if(ch.equals("S")) {
                System.out.println("판매");
                // 2-2. 판매 갯수만큼 원가 계산
                for(int j=0; j<size; j++) {
                    result += q.poll();
                }
            }
        }
        return result;
    }
    public static int bifo(String[] records) {
        Stack<Integer> s = new Stack<>();
        int result = 0;
        for(int i=0; i<records.length; i++) {
            // 1. split
            String[] record = records[i].split(" ");
            String ch = record[0]; // P or S
            int money = Integer.parseInt(record[1]);
            int size = Integer.parseInt(record[2]);

            if(ch.equals("P")) {
                for(int j=0; j<size; j++) {
                    s.push(money);
                }
            }else if(ch.equals("S")) {
                for(int j=0; j<size; j++) {
                    result += s.pop();
                }
//                while(!s.isEmpty()) {
//                    s.pop();
//                }
            }
        }
        return result;
    }
}
