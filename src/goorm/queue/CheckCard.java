package goorm.queue;

import java.io.*;
import java.util.*;

/**
 * [구름] LV2. 체크 카드 (큐)
 */
public class CheckCard {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int balance = Integer.parseInt(input[0]); // 최종 출력할 잔액
        int historySize = Integer.parseInt(input[1]);
        List<String[]> history = new ArrayList<>();
        for (int i = 0; i < historySize; i++) {
            history.add(br.readLine().split(" "));
        }
        // 대기열
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < historySize; i++) {
            String label = history.get(i)[0];
            int money = Integer.parseInt(history.get(i)[1]);

            if ("deposit".equals(label)) {
                balance += money;
                // 입금 후 바로 대기 목록 작업
                while (!q.isEmpty() && q.peek() <= balance) {
                    balance -= q.poll();
                }
            } else if ("pay".equals(label)) {
                if (balance >= money) {
                    balance -= money;
                }
            } else { // reservation
                if(!q.isEmpty() || balance < money) { // 대기열이 비어있지 않거나, 잔액보다 머니가 크면 대기열에 넣기
                    q.add(money);
                }else {
                    balance -= money;
                }
            }

        }

        System.out.println(balance);
    }
}
