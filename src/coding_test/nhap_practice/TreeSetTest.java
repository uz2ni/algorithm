package coding_test.nhap_practice;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetTest {

    public static void main(String[] args) {

        // 정렬되어 저장되는 TreeSet
        Set<String> set = new TreeSet<>();
        set.add("banana");
        set.add("test");
        set.add("apple");

        for(String s : set) {
            System.out.println(s);
        }

        System.out.println("=======");

        Iterator it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("====TreeSet(오름차순)====");

        // 오름차순 정렬 TreeSet
        Set<String> set2 = new TreeSet<>(Collections.reverseOrder());
        set2.add("banana");
        set2.add("test");
        set2.add("apple");

        for(String s : set) {
            System.out.println(s);
        }

        System.out.println("====TreeSet(정렬 커스텀)====");

        // 오름차순 정렬 TreeSet
        Set<Fruit> set3 = new TreeSet<>((a,b) -> {
            if(a.price != b.price) return b.price - a.price;
            return a.name.compareTo(b.name);
        });
        set3.add(new Fruit("banana",1000));
        set3.add(new Fruit("test",6000));
        set3.add(new Fruit("apple",6000));

        for(Fruit f : set3) {
            System.out.println(f.name + ", " + f.price);
        }

    }

    public static class Fruit {
        String name;
        int price;

        public Fruit(String name, int price) {
            this.name = name;
            this.price = price;
        }
    }
}
