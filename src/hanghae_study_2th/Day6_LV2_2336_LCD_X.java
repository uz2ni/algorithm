package hanghae_study_2th;

import java.util.PriorityQueue;

/**
 * 24.5.25 (토) 6일차
 * [LeetCode] 미들러 - 2339
 */
public class Day6_LV2_2336_LCD_X {

    private PriorityQueue<Integer> pq;
    private int cursor = 1; // 가장 작은 정수 기록

    public Day6_LV2_2336_LCD_X() {
        pq = new PriorityQueue<>();
    }

    public int popSmallest() {
        if(pq.size() > 0) {
            return pq.poll();
        }
        return cursor++;
    }

    public void addBack(int num) {
        if(cursor > num && !pq.contains(num)) {
            pq.add(num);
        }
    }
}
