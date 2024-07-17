package goorm.binarysearch;

import java.io.*;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * [구름] LV2. 개미 집합의 지름
 */
class AntDiameter {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int[] arr = Stream.of(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);

        int begin = 0, end = 1;
        int maxAnts = 0;

        while(begin<n && end<n) {
            int length = arr[end] - arr[begin]; // 현재 지름
            int numOfAnts = end - begin + 1; // 현재 개미수

            if(length <= d) {
                maxAnts = (maxAnts < numOfAnts ? numOfAnts : maxAnts);
                end++;
            }else {
                begin++;
            }

        }

        System.out.println(n - maxAnts);
    }
}