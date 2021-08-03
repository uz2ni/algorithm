package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    프린터
 */
public class test_42587_2 {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities,location));
    }

    public static int solution(int[] priorities, int location) {
        Queue<Printer> que = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            que.add(new Printer(priorities[i], i));
        }

        int cnt = 1;

        while(!que.isEmpty()) {
            boolean flag = false;
            Printer target = que.poll();

            for(Printer p : que) {
                if(target.priority < p.priority) { flag = true; break; }
            }

            if(flag) {
                que.add(target);
            }else {
                if(target.index == location) {
                    return cnt;
                }
                cnt++;
            }
        }
        return 0;
    }

    static class Printer {

        int priority;
        int index;

        Printer(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }
    }
}