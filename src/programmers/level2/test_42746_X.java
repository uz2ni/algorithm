package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

/*
    가장 큰 수
 */
public class test_42746_X {
    public static void main(String[] args) {
        String[] result = {"100","50", "150"};

        Arrays.sort(result, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
                //return ((o2 + o1).compareTo(o1 + o2));
            }
        });
        for(String r : result) {
            System.out.println(r);
        }

    }
}
