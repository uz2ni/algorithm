package coding_test.test_cafe24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputArr = br.readLine().split(" ");

        int n = Integer.parseInt(inputArr[0]);
        int t = Integer.parseInt(inputArr[1]);
        List<Integer> dice = new ArrayList<>();

        inputArr = br.readLine().split(" ");
        for(int i=0; i<inputArr.length; i++) {
            dice.add(i, Integer.parseInt(inputArr[i]));
        }

        // 최소와 최대값 구하기 위한 정렬
        Collections.sort(dice);

        // 최소값, 최대값 구하기
        int min = dice.get(0);
        int max = dice.get(n-1);

        // 주사위 던짐 횟수 개산
        int result1 = rolling(min, t);
        int result2 = rolling(max, t);

        System.out.println(result2 + " " + result1);
    }

    public static int rolling(int n, int t) {
        int count = 0;
        int plus = 0;
        while(true) {
            count++;
            plus += n;
            if(plus >= t) break;
        }

        return count;
    }
}
