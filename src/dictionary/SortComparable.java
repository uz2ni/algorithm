package dictionary;

import java.util.Arrays;

public class SortComparable {

    public static void main(String[] args) {

        Career[] arr = new Career[3];
        arr[0] = new Career(10, "Elly");
        arr[1] = new Career(50, "Ace");
        arr[2] = new Career(25, "Chris");

        Arrays.sort(arr);
        print(arr);

    }

    static class Career implements Comparable<Career> {

        int age;
        String name;

        public Career(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Career o) {
            return this.age - o.age;
        }

    }

    static void print(Career[] arr) {
        for(Career c : arr) {
            System.out.print(c.name + "(" + c.age + ") ");
        }
        System.out.println();
    }
}
