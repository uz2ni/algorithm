package test;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {

    public static void main(String[] args) {
        System.out.println("test");
        Career[] arr = new Career[2];
        arr[0] = new Career(10,5);
        arr[1] = new Career(3,7);

        Comparator<Career> comp = new Comparator<Career>() {
            @Override
            public int compare(Career o1, Career o2) {
                return o1.year - o2.year;
            }
        };

        Arrays.sort(arr); // year 기준 오름차순 정렬 (index) 1, 0
        for(Career career : arr) {
            System.out.println(career.year);
        }

    }

    static class Career implements Comparator<Career> {

        int age;	// 나이
        int year;	// 연차

        Career(int age, int year) {
            this.age = age;
            this.year = year;
        }

        @Override
        public int compare(Career o1, Career o2) {

            /* 1 */
            if(o1.year > o2.year) {
                return 1;
            }
            else if(o1.year == o2.year) {
                return 0;
            }
            else {
                return -1;
            }

            /* 2 */
            // return o1.year - o2.year;
        }

    }
}
