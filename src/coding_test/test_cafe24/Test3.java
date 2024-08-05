package coding_test.test_cafe24;

import java.io.*;
import java.util.*;

public class Test3 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        List<Integer> results = new ArrayList<>(); // 출력할 결과

        for(int i=0; i<t; i++) {
            int bitLength = Integer.parseInt(br.readLine()); // 비트 자리수

            // 온도 별 비트 입력
            String low[] = br.readLine().split("-");
            String high[] = br.readLine().split("-");
            String middle[] = br.readLine().split("-");

            // 8비트->2진수 변환
            StringBuilder lowSb = new StringBuilder();
            StringBuilder highSb = new StringBuilder();
            StringBuilder middleSb = new StringBuilder();

            for(int j=0; j<low.length; j++) {
                lowSb.append(toBinaryString((byte)Integer.parseInt(low[j])));
                highSb.append(toBinaryString((byte)Integer.parseInt(high[j])));
                middleSb.append(toBinaryString((byte)Integer.parseInt(middle[j])));
            }

            int result = dfs(lowSb.toString(), highSb.toString(), middleSb.toString(), 0, 0);
            results.add(result);
        }

        for (int result : results) {
            System.out.println(result);
        }
    }

    public static int dfs(String low, String high, String middle, int depth, int result) {
        int cnt = 0;
        if(depth == low.length()) {
            return result;
        }else {
            // 현재 자리수 검사 : 하나라도 다른 경우 +1
            if(!(low.charAt(depth) == high.charAt(depth) && low.charAt(depth) == middle.charAt(depth)
                    &&  high.charAt(depth) == middle.charAt(depth)))  result++;
            cnt += dfs(low, high, middle, depth+1, result);
        }
        return cnt;
    }

    // 8비트의 이진 문자열 포맷팅
    public static String toBinaryString(byte number) {
        return String.format("%8s", Integer.toBinaryString(number & 0xFF)).replace(' ', '0');
    }
}
