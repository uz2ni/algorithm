package goorm.stack;

import java.io.*;
import java.util.stream.Stream;

/**
 * [구름] LV2. 구름 다리(스택) - 미완료
 */
public class CloudBridge_X {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] heights = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cnt = 0; // 경우의 수
        for(int i=0; i<heights.length-1; i++) {
            int height = heights[i];
            for(int j=i+1; j<heights.length; j++) {
                int nextHeight = heights[j];
                if(height < nextHeight) {
                    break;
                }
                if(height == nextHeight) {
                    cnt++;
                    break;
                }
            }

        }

        System.out.println(cnt);
    }
}
