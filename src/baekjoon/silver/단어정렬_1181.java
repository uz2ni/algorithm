package baekjoon.silver;

import java.util.*;

/**
 * <문제 설명>
 * 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
 *
 * 길이가 짧은 것부터
 * 길이가 같으면 사전 순으로
 * 단, 중복된 단어는 하나만 남기고 제거해야 한다.
 */
public class 단어정렬_1181 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            String s = sc.next();

            // list 넣을 때 contains 체크해서 없으면 넣기
            if(!list.contains(s)) {
                list.add(s);
            }

        }

        // 정렬 방법1
        Collections.sort(list, (s1, s2) -> {
            if(s1.length() != s2.length()) {
                return s1.length() - s2.length();
            }
            return s1.compareTo(s2);
        });

        // 정렬 방법2
//        Collections.sort(list, new Comparator<>(){
//
//            @Override
//            public int compare(String s1, String s2) {
//                // 길이 오름차순
//                if(s1.length() < s2.length()) {
//                    return -1;
//                }else if(s1.length() > s2.length()) {
//                    return 1;
//                }else {
//                    // 길이 같으면 사전순
//                    return s1.compareTo(s2);
//                }
//            }
//
//        });

        for(String s : list) {
            System.out.println(s);
        }

    }
}
