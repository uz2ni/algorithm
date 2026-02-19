package dictionary;

import java.util.Collections;
import java.util.Queue;
import java.util.PriorityQueue;

public class Pq {

    public static void main(String[] args) {

        // 1. 최소 힙
        Queue<Integer> pq = new PriorityQueue<>();

        pq.add(5);
        pq.add(3);
        pq.add(20);
        pq.add(10);
        pq.add(2);
        pq.add(100);

        pq.poll();
        pq.poll();

        while(!pq.isEmpty()) {
            // System.out.println(pq.peek());
            System.out.println(pq.poll());
        }

        System.out.println("========");

        // 2. 최대 힙
        Queue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        pq2.add(5);
        pq2.add(3);
        pq2.add(20);
        pq2.add(10);
        pq2.add(2);
        pq2.add(100);

        pq2.poll();
        pq2.poll();

        while(!pq2.isEmpty()) {
            // System.out.println(pq.peek());
            System.out.println(pq2.poll());
        }

        System.out.println("========");

        // 3. 커스텀 클래스
        Queue<Person> cq = new PriorityQueue<>();
        cq.add(new Person("가나디", 5));
        cq.add(new Person("고구미", 2));
        cq.add(new Person("유자몽", 35));
        cq.add(new Person("무지콩", 22));

        while(!cq.isEmpty()) {
            Person p = cq.poll();
            System.out.println(p.name + ", " + p.age);
        }
    }

    public static class Person implements Comparable<Person> {

        String name;
        int age;

        @Override
        public int compareTo(Person o) {
            // return this.age - o.age; // 나이 오름차순
            // return o.age - this.age; // 나이 내림차순
            // return this.name.compareTo(o.name); // 이름 오름차순
            return o.name.compareTo(this.name); // 이름 내림차순
        }


        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}
