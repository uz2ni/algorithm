package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
    프린터
 */
public class test_42587 {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities,location));
    }
    public static int solution(int[] priorities, int location) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        List<Integer> queue = new LinkedList<>();
        List<Integer> queue_idx = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) {
            queue.add(priorities[i]);
            queue_idx.add(i);
        }

        while(!queue.isEmpty()) {
            int target = queue.get(0);
            int target_idx = queue_idx.get(0);

            // target보다 큰 값 있는지 판단
            boolean isOtherMax = false;
            for(int i=1; i<queue.size(); i++) {
                if(target < queue.get(i)) {
                    isOtherMax = true;
                    break;
                }
            }

            // 더 큰 값이 있으면 target 뒤로 보냄
            if(isOtherMax) {
                queue.add(target);
                queue_idx.add(target_idx);
            }else {
                list.add(target);
                if(location == target_idx) {
                    return list.size();
                }
            }
            queue.remove(0);
            queue_idx.remove(0);
        }
        return answer;
    }
}
