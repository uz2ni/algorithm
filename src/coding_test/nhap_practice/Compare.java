package coding_test.nhap_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * N개의 과일이 있다.
 * 각 과일은 여러 개의 특징(예: 당도, 향, 색감 등)을 가진다.
 *
 * 각 과일마다 특징의 중요도(priority)가 다르게 주어진다.
 *
 * 각 과일을 자기 중요도 순서에 맞게 특징을 재배열한 후,
 * 가장 맛있는 과일부터 순서대로 정렬하여
 * 과일 번호를 반환하시오.
 */
public class Compare {
    public static void main(String[] args) {

        int[][] fruits = {
                {5, 3, 7},   // 1번 과일
                {4, 8, 2},   // 2번 과일
                {6, 1, 9}    // 3번 과일
        };

        int[][] priority = {
                {2, 1, 3},
                {1, 3, 2},
                {3, 1, 2}
        };

        for(int answer : solution(fruits,priority)) {
            System.out.print(answer + " ");
        }

    }

    public static int[] solution(int[][] fruits, int[][] priority) {
        int[] answer = new int[fruits.length];

        List<Fruit> fruitList = new ArrayList<>();

        for(int i=0; i<fruits.length; i++) {
            int number = i+1;
            // 과일 별 특징 내림차순 정렬
            int[] props = new int[fruits[i].length];
            for(int j=0; j<fruits.length; j++) {
                int idx = priority[i][j]-1;
                props[idx] = fruits[i][j];
            }

            fruitList.add(new Fruit(number, props));
        }

        // 과일 정렬
        Collections.sort(fruitList);

        for(int i=0; i<fruitList.size(); i++) {
            answer[i] = fruitList.get(i).number;
        }

        return answer;
    }

    public static class Fruit implements Comparable<Fruit> {
        private int number;
        private int[] props;

        public Fruit(int number, int[] props) {
            this.number = number;
            this.props = props.clone();
        }

        @Override
        public int compareTo(Fruit f) {
            // 리턴 양수면 교환
            for(int i=0; i<this.props.length; i++) {
                if(this.props[i] == f.props[i]) continue;
                else {
                    return f.props[i]-this.props[i];
                }
            }
            return 0;
        }
    }
}
