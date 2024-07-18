package goorm.hash;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * [구름] LV2. 0커플 (해쉬)
 */
public class ZeroCouple {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Set <Integer> hs = new HashSet<>();
        for(int number : numbers) {
            // hs에 현재 number의 반대수가 있는지 체크
            int reverse = -number;
            if(hs.contains(reverse)) { // 있으면 hs에서 제거
                hs.remove(reverse);
            }else { // 없으면 hs에 넣기
                hs.add(number);
            }
        }

        int sum = hs.stream().mapToInt(Integer::intValue).sum();
        /* sum 계산 시 for문 사용할 경우
        int sum = 0;
        for (Integer num : hs) {
            sum += num.intValue();
        }
         */
        System.out.println(sum);
    }
}
