package programmers;

import java.util.LinkedList;

/*
    3진법 뒤집기
 */
public class test_68935 {
    public static void main(String[] args) {
        solution(125);
    }
    static public int solution(int n) {
        int answer = 0;
        LinkedList<Integer> list = new LinkedList<>();

        // n=45, 3진법=1200

        // 10진법 -> 3진법
        while(true) {
            if(n<3) { list.addFirst(n); break;}
            list.addFirst(n%3);
            n /= 3;
        }

        for(int i=0; i<list.size(); i++) {
            if(list.get(i) == 0) continue;
            answer = answer + (int)Math.pow(3, i) * list.get(i);
        }

        return answer;
    }
}
