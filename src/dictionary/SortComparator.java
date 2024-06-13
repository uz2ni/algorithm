package dictionary;

import java.util.Arrays;
import java.util.Comparator;

public class SortComparator {

    public static void main(String[] args) {

        Career[] arr = new Career[3];
        arr[0] = new Career(10, "Elly");
        arr[1] = new Career(25, "Ace");
        arr[2] = new Career(50, "Chris");
        
        Comparator<Career> comp1 = new Comparator<Career>() {
            @Override
            public int compare(Career o1, Career o2) {
                return o1.age - o2.age;
            }
        };

        Comparator<Career> comp2 = new Comparator<Career>() {
            @Override
            public int compare(Career o1, Career o2) {
                return o2.age - o1.age;
            }
        };

        Comparator<Career> comp3 = new Comparator<Career>() {
            @Override
            public int compare(Career o1, Career o2) {
                return o1.name.compareTo(o2.name);
            }
        };

        Comparator<Career> comp4 = new Comparator<Career>() {
            @Override
            public int compare(Career o1, Career o2) {
                return o2.name.compareTo(o1.name);
            }
        };

        Arrays.sort(arr, comp1);
        System.out.print("나이 오름차순 > ");
        print(arr);

        Arrays.sort(arr, comp2);
        System.out.print("나이 내림차순 > ");
        print(arr);

        Arrays.sort(arr, comp3);
        System.out.print("이름 오름차순 > ");
        print(arr);

        Arrays.sort(arr, comp4);
        System.out.print("이름 내림차순 > ");
        print(arr);

        Arrays.sort(arr, (o1, o2) -> o1.age - o2.age);
        System.out.print("람다식 나이 오름차순 > ");
        print(arr);
    }

    static class Career {

        int age;
        String name;

        public Career(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    static void print(Career[] arr) {
        for(Career c : arr) {
            System.out.print(c.name + "(" + c.age + ") ");
        }
        System.out.println();
    }
}
